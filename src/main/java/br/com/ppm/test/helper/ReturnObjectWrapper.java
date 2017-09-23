package br.com.ppm.test.helper;

import java.util.Objects;

import br.com.ppm.test.util.ReflectionUtil;

import org.hamcrest.Matcher;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.times;

/**
 * The Class ReturnObjectWrapper.
 *
 * @param <ReturnType> the generic type of method return
 */
public class ReturnObjectWrapper<ReturnType> implements Asserts<ReturnType>, Verifications {

    private final ReturnType returnObject;
    private final Asserts<ReturnType> asserts;

    /**
     * Instantiates a new return object wrapper.
     *
     * @param returnObject the return object
     */
    protected ReturnObjectWrapper(ReturnType returnObject, String description) {
        this.returnObject = returnObject;
        this.asserts = new AssertsImpl<>(this, description, new JUnitAssertWrapper());
    }

    @Override
    public ReturnObjectWrapper<ReturnType> assertEqualTo(ReturnType expected) {
        asserts.assertThat(returnObject, equalTo(expected));
        return this;
    }

    @Override
    public ReturnObjectWrapper<ReturnType> resultIsEqualTo(ReturnType expected) {
        return assertEqualTo(expected);
    }

    @Override
    public ReturnObjectWrapper<ReturnType> assertReturn(Matcher<? super ReturnType> matcher) {
        asserts.assertThat(returnObject, matcher);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ReturnObjectWrapper<ReturnType> assertReturnField(String field, Matcher<?> matcher) {
        final Object valueToAssert = ReflectionUtil.getByFieldName(field, returnObject);
        asserts.assertThat((ReturnType) valueToAssert, (Matcher<? super Object>) matcher);
        return this;
    }

    @Override
    public ReturnObjectWrapper<ReturnType> assertEqualToReturnField(String field, Object expected) {
        assertReturnField(field, equalTo(expected));
        return this;
    }

    @Override
    public ReturnObjectWrapper<ReturnType> assertReturnFields(String field, Matcher<?> matcher, Object... additionalKeyMatcherPairs) {
        assertReturnField(field, matcher);
        if (additionalKeyMatcherPairs.length >= 2) {
            String f = (String) additionalKeyMatcherPairs[0];
            @SuppressWarnings("unchecked")
            Matcher<? super Object> m = (Matcher<? super Object>) additionalKeyMatcherPairs[1];

            if (additionalKeyMatcherPairs.length > 2) {
                Object[] matchersPairs = new Object[additionalKeyMatcherPairs.length - 2];
                System.arraycopy(additionalKeyMatcherPairs, 2, matchersPairs, 0, additionalKeyMatcherPairs.length - 2);
                return assertReturnFields(f, m, matchersPairs);
            } else {
                return assertReturnFields(f, m);
            }
        }
        return this;
    }

    @Override
    public ReturnObjectWrapper<ReturnType> assertEqualToReturnFields(String field, Object expected, Object... additionalKeyMatcherPairs) {
        return assertReturnFields(field, equalTo(expected), additionalKeyMatcherPairs);
    }

    @Override
    public Asserts<ReturnType> assertThat(ReturnType methodCall, Matcher<? super ReturnType> matcher) {
        return asserts.assertThat(methodCall, matcher);
    }

    @Override
    public Asserts<ReturnType> assertTrue(boolean methodCall) {
        return asserts.assertTrue(methodCall);
    }

    @Override
    public Asserts<ReturnType> assertFalse(boolean methodCall) {
        return asserts.assertFalse(methodCall);
    }

    @Override
    public Asserts<ReturnType> assertEqualTo(ReturnType methodCall, Object expected) {
        return asserts.assertEqualTo(methodCall, expected);
    }

    @Override
    public <M> M verify(M mock, VerificationMode mode) {
        return Mockito.verify(mock, mode);
    }

    @Override
    public <M> M verify(M mock) {
        return Mockito.verify(mock, times(1));
    }

    @Override
    public void verifyNoMoreInteractions(Object... mocks) {
        Mockito.verifyNoMoreInteractions(mocks);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.returnObject);
        hash = 31 * hash + Objects.hashCode(this.asserts);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReturnObjectWrapper<?> other = (ReturnObjectWrapper<?>) obj;
        if (!Objects.equals(this.returnObject, other.returnObject)) {
            return false;
        }
        if (!Objects.equals(this.asserts, other.asserts)) {
            return false;
        }
        return true;
    }
}
