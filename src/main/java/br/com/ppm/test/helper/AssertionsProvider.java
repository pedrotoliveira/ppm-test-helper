package br.com.ppm.test.helper;

import java.util.Arrays;
import java.util.Objects;

import br.com.ppm.commons.Reflections;

import org.hamcrest.Matcher;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Assertions Implementations
 *
 * @author pedrotoliveira
 */
public class AssertionsProvider<Return> implements Assertions<Return> {

    private final AssertionsWrapper assertWrapper;
    private final ReturnWrapper<Return> objectWrapper;
    private final String description;

    @SuppressWarnings("unchecked")
    public AssertionsProvider(String description) {
        this.assertWrapper = new AssertionsWrapper();
        this.objectWrapper = (ReturnWrapper<Return>) new NullObjectWrapper(description);
        this.description = description;
    }

    public AssertionsProvider(ReturnWrapper<Return> returnObjectWrapper, String description) {
        this.assertWrapper = new AssertionsWrapper();
        this.objectWrapper = returnObjectWrapper;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public ReturnWrapper<Return> assertEqualToReturnField(String field, Object expected) {
        return objectWrapper.assertEqualToReturnField(field, expected);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ReturnWrapper<Return> assertReturnFields(String fieldName, Matcher<?> matcher, Object... additionalKeyMatcherPairs) {
        assertReturnField(fieldName, matcher);
        if (additionalKeyMatcherPairs.length >= 2) {
            String field = String.class.cast(additionalKeyMatcherPairs[0]);
            Matcher<? super Object> aMatcher = (Matcher<? super Object>) additionalKeyMatcherPairs[1];
            if (additionalKeyMatcherPairs.length > 2) {
                Object[] matchersPairs = new Object[additionalKeyMatcherPairs.length - 2];
                System.arraycopy(additionalKeyMatcherPairs, 2, matchersPairs, 0, additionalKeyMatcherPairs.length - 2);
                return assertReturnFields(field, aMatcher, matchersPairs);
            } else {
                return assertReturnFields(field, aMatcher);
            }
        }
        return objectWrapper;
    }

    @Override
    public ReturnWrapper<Return> assertEqualToReturnFields(Object... keyPairs) {
        if (keyPairs.length >= 2) {
            String field = String.class.cast(keyPairs[0]);
            Matcher<Object> matcher = equalTo(keyPairs[1]);
            assertReturnField(field, matcher);
            if (keyPairs.length > 2) {
                Object[] newKeyPairs = new Object[keyPairs.length - 2];
                System.arraycopy(keyPairs, 2, newKeyPairs, 0, keyPairs.length - 2);
                return assertEqualToReturnFields(newKeyPairs);
            }
        } else {
            throw new AssertionError("Invalid Values to Assert [" + Arrays.deepToString(keyPairs) + "]");
        }
        return objectWrapper;
    }

    @Override
    public ReturnWrapper<Return> resultIsEqualTo(Return expected) {
        return objectWrapper.resultIsEqualTo(expected);
    }

    @Override
    public ReturnWrapper<Return> assertReturn(Matcher<? super Return> matcher) {
        return objectWrapper.assertReturn(matcher);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ReturnWrapper<Return> assertReturnField(String field, Matcher<?> matcher) {
        Object valueToAssert = Reflections.getValueByNamespace(field, objectWrapper.getReturn()).get();
        assertWrapper.assertThat(description, (Return) valueToAssert, (Matcher<? super Object>) matcher);
        return objectWrapper;
    }

    @Override
    public ReturnWrapper<Return> assertEqualTo(Return expected) {
        return objectWrapper.assertEqualTo(expected);
    }

    @Override
    public Assertions<Return> assertThat(Return value, Matcher<? super Return> matcher) {
        assertWrapper.assertThat(description, value, matcher);
        return this;
    }

    @Override
    public Assertions<Return> assertTrue(boolean value) {
        assertWrapper.assertTrue(description, value);
        return this;
    }

    @Override
    public Assertions<Return> assertFalse(boolean value) {
        assertWrapper.assertFalse(description, value);
        return this;
    }

    @Override
    public Assertions<Return> assertEqualTo(Return value, Object expected) {
        assertWrapper.assertThat(description, value, equalTo(expected));
        return this;
    }

    @Override
    public TestCaseMatcher<Return> assertThat(Return value) {
        return new AssertionsMatcherProvider<>(value, description, this);
    }

    @Override
    public TestCaseMatcher<Return> it(Return value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TestCaseMatcher<Return> it(String assertDescription, Return value) {
        throw new UnsupportedOperationException("Not supported yet.");
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
        hash = 47 * hash + Objects.hashCode(this.description);
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
        final AssertionsProvider<?> other = (AssertionsProvider<?>) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AssertionsProvider[" + "assertWrapper=" + assertWrapper + ", objectWrapper=" + objectWrapper + ", description=" + description + ']';
    }

}
