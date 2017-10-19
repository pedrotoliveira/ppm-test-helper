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
public class AssertionsProvider<ReturnType> implements Assertions<ReturnType> {

    private final AssertionsWrapper assertWrapper;
    private final ReturnWrapper<ReturnType> objectWrapper;
    private final String description;

    @SuppressWarnings("unchecked")
    public AssertionsProvider(String description) {
        this.assertWrapper = new AssertionsWrapper();
        this.objectWrapper = (ReturnWrapper<ReturnType>) new NullObjectWrapper(description);
        this.description = description;
    }

    public AssertionsProvider(ReturnWrapper<ReturnType> returnObjectWrapper, String description) {
        this.assertWrapper = new AssertionsWrapper();
        this.objectWrapper = returnObjectWrapper;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public ReturnWrapper<ReturnType> assertEqualToReturnField(String field, Object expected) {
        return objectWrapper.assertEqualToReturnField(field, expected);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ReturnWrapper<ReturnType> assertReturnFields(String fieldName, Matcher<?> matcher, Object... additionalKeyMatcherPairs) {
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
    public ReturnWrapper<ReturnType> assertEqualToReturnFields(Object... keyPairs) {
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
    public ReturnWrapper<ReturnType> resultIsEqualTo(ReturnType expected) {
        return objectWrapper.resultIsEqualTo(expected);
    }

    @Override
    public ReturnWrapper<ReturnType> assertReturn(Matcher<? super ReturnType> matcher) {
        return objectWrapper.assertReturn(matcher);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ReturnWrapper<ReturnType> assertReturnField(String field, Matcher<?> matcher) {
        Object valueToAssert = Reflections.getValueByNamespace(field, objectWrapper.getReturn()).get();
        assertWrapper.assertThat(description, (ReturnType) valueToAssert, (Matcher<? super Object>) matcher);
        return objectWrapper;
    }

    @Override
    public ReturnWrapper<ReturnType> assertEqualTo(ReturnType expected) {
        return objectWrapper.assertEqualTo(expected);
    }

    @Override
    public Assertions<ReturnType> assertThat(ReturnType methodCall, Matcher<? super ReturnType> matcher) {
        assertWrapper.assertThat(description, methodCall, matcher);
        return this;
    }

    @Override
    public Assertions<ReturnType> assertTrue(boolean methodCall) {
        assertWrapper.assertTrue(description, methodCall);
        return this;
    }

    @Override
    public Assertions<ReturnType> assertFalse(boolean methodCall) {
        assertWrapper.assertFalse(description, methodCall);
        return this;
    }

    @Override
    public Assertions<ReturnType> assertEqualTo(ReturnType methodCall, Object expected) {
        assertWrapper.assertThat(description, methodCall, equalTo(expected));
        return this;
    }

    @Override
    public TestCaseMatcher<ReturnType> assertThat(ReturnType methodCall) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TestCaseMatcher<ReturnType> it(ReturnType methodCall) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TestCaseMatcher<ReturnType> it(String assertDescription, ReturnType methodCall) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <E extends Throwable> TestCaseMatcher<ReturnType> shouldThrow(E exception, ReturnType methodCall) {
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
}
