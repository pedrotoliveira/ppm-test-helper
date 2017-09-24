package br.com.ppm.test.helper;

import java.util.Objects;

import br.com.ppm.test.util.ReflectionUtil;

import org.hamcrest.Matcher;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.times;

/**
 * The Class ReturnWrapper.
 *
 * @param <ReturnType> the generic type of method return
 */
public class ReturnWrapper<ReturnType> implements Asserts<ReturnType>, Verifications {

    private final ReturnType returnObject;
    private final Asserts<ReturnType> asserts;

    /**
     * Instantiates a new return object wrapper.
     *
     * @param returnObject the return object
     */
    protected ReturnWrapper(ReturnType returnObject, String description) {
        this.returnObject = returnObject;
        this.asserts = new AssertsImpl<>(this, description);
    }

    public ReturnType getReturn() {
        return returnObject;
    }

    public ReturnType getResult() {
        return returnObject;
    }

    @Override
    public ReturnWrapper<ReturnType> assertEqualTo(ReturnType expected) {
        asserts.assertThat(returnObject, equalTo(expected));
        return this;
    }

    @Override
    public ReturnWrapper<ReturnType> resultIsEqualTo(ReturnType expected) {
        return assertEqualTo(expected);
    }

    @Override
    public ReturnWrapper<ReturnType> assertReturn(Matcher<? super ReturnType> matcher) {
        asserts.assertThat(returnObject, matcher);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ReturnWrapper<ReturnType> assertReturnField(String field, Matcher<?> matcher) {
        final Object valueToAssert = ReflectionUtil.getByFieldName(field, returnObject);
        asserts.assertThat((ReturnType) valueToAssert, (Matcher<? super Object>) matcher);
        return this;
    }

    @Override
    public ReturnWrapper<ReturnType> assertEqualToReturnField(String field, Object expected) {
        assertReturnField(field, equalTo(expected));
        return this;
    }

    @Override
    public ReturnWrapper<ReturnType> assertReturnFields(String field, Matcher<?> matcher, Object... additionalKeyMatcherPairs) {
        return asserts.assertReturnFields(field, matcher, additionalKeyMatcherPairs);
    }

    @Override
    public ReturnWrapper<ReturnType> assertEqualToReturnFields(String field, Object expected, Object... additionalKeyMatcherPairs) {
        return asserts.assertEqualToReturnFields(field, expected, additionalKeyMatcherPairs);
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
        final ReturnWrapper<?> other = (ReturnWrapper<?>) obj;
        if (!Objects.equals(this.returnObject, other.returnObject)) {
            return false;
        }
        if (!Objects.equals(this.asserts, other.asserts)) {
            return false;
        }
        return true;
    }
}
