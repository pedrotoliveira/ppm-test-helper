package br.com.ppm.test.helper;

import java.util.Objects;

import br.com.ppm.commons.ToStringBuilder;

import org.hamcrest.Matcher;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.times;

/**
 * The Class ReturnWrapper.
 *
 * @param <Return> the generic type of method return
 */
public class ReturnWrapper<Return> implements Assertions<Return>, Verifications {

    private final Return returnObject;
    private final Assertions<Return> asserts;

    /**
     * Instantiates a new return object wrapper.
     *
     * @param returnObject the return object
     */
    public ReturnWrapper(final Return returnObject, final String description) {
        this.returnObject = returnObject;
        this.asserts = new AssertionsProvider<>(this, description);
    }

    public Return getReturn() {
        return returnObject;
    }

    public Return getResult() {
        return returnObject;
    }

    @Override
    public ReturnWrapper<Return> assertEqualTo(Return expected) {
        asserts.assertThat(returnObject, equalTo(expected));
        return this;
    }

    @Override
    public ReturnWrapper<Return> resultIsEqualTo(Return expected) {
        return assertEqualTo(expected);
    }

    @Override
    public ReturnWrapper<Return> assertReturn(Matcher<? super Return> matcher) {
        asserts.assertThat(returnObject, matcher);
        return this;
    }

    @Override
    public ReturnWrapper<Return> assertReturnField(String fieldName, Matcher<?> matcher) {
        return asserts.assertReturnField(fieldName, matcher);
    }

    @Override
    public ReturnWrapper<Return> assertEqualToReturnField(String field, Object expected) {
        return asserts.assertEqualToReturnField(field, expected);
    }

    @Override
    public ReturnWrapper<Return> assertReturnFields(String field, Matcher<?> matcher, Object... additionalKeyMatcherPairs) {
        return asserts.assertReturnFields(field, matcher, additionalKeyMatcherPairs);
    }

    @Override
    public ReturnWrapper<Return> assertEqualToReturnFields(Object... keyPairs) {
        return asserts.assertEqualToReturnFields(keyPairs);
    }

    @Override
    public Assertions<Return> assertThat(Return value, Matcher<? super Return> matcher) {
        return asserts.assertThat(value, matcher);
    }

    @Override
    public Assertions<Return> assertTrue(boolean value) {
        return asserts.assertTrue(value);
    }

    @Override
    public Assertions<Return> assertFalse(boolean value) {
        return asserts.assertFalse(value);
    }

    @Override
    public Assertions<Return> assertEqualTo(Return value, Object expected) {
        return asserts.assertEqualTo(value, expected);
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
    public TestCaseMatcher<Return> assertThat(Return value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TestCaseMatcher<Return> itIs(Return value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TestCaseMatcher<Return> itIs(String assertDescription, Return value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TestCaseMatcher<Return> it(TestCaseMatcher<Return> matcher) {
        return matcher;
    }

    @Override
    public TestCaseMatcher<Return> it(String assertDescription, TestCaseMatcher<Return> matcher) {
        matcher.as(assertDescription);
        return matcher;
    }

    @Override
    public <E extends Throwable> TestCaseMatcher<Return> shouldThrow(Return value, E exception) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <E extends Throwable> ExceptionMatcher<E> a(Class<E> exception) throws E {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <E extends Throwable> ExceptionMatcher<E> itThrow(Class<E> exception) throws E {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.returnObject);
        hash = 43 * hash + Objects.hashCode(this.asserts);
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
