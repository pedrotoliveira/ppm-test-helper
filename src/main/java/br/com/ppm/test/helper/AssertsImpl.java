package br.com.ppm.test.helper;

import java.util.Objects;

import br.com.ppm.test.util.ReflectionUtil;

import org.hamcrest.Matcher;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Asserts Implementations
 *
 * @author pedrotoliveira
 */
public class AssertsImpl<ReturnType> implements Asserts<ReturnType> {

    private final AssertWrapper assertWrapper;
    private final ReturnWrapper<ReturnType> objectWrapper;
    private final String description;

    public AssertsImpl(ReturnWrapper<ReturnType> returnObjectWrapper, String description) {
        this.assertWrapper = new AssertWrapper();
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
    public ReturnWrapper<ReturnType> assertReturnFields(String field, Matcher<?> matcher, Object... additionalKeyMatcherPairs) {
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
        return objectWrapper;
    }

    @Override
    public ReturnWrapper<ReturnType> assertEqualToReturnFields(String field, Object expected, Object... additionalKeyMatcherPairs) {
        assertReturnFields(field, equalTo(expected), additionalKeyMatcherPairs);
        return objectWrapper;
    }

    @Override
    public ReturnWrapper<ReturnType> resultIsEqualTo(ReturnType expected) {
        //FIXME: Invert Responsibility???
        return objectWrapper.resultIsEqualTo(expected);
    }

    @Override
    public ReturnWrapper<ReturnType> assertReturn(Matcher<? super ReturnType> matcher) {
        //FIXME: Invert Responsibility???
        return objectWrapper.assertReturn(matcher);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ReturnWrapper<ReturnType> assertReturnField(String field, Matcher<?> matcher) {
        Object valueToAssert = ReflectionUtil.getByFieldName(field, objectWrapper.getReturn());
        assertWrapper.assertThat(description, (ReturnType) valueToAssert, (Matcher<? super Object>) matcher);
        return objectWrapper;
    }

    @Override
    public ReturnWrapper<ReturnType> assertEqualTo(ReturnType expected) {
        //FIXME: Invert Responsibility???
        return objectWrapper.assertEqualTo(expected);
    }

    @Override
    public Asserts<ReturnType> assertThat(ReturnType methodCall, Matcher<? super ReturnType> matcher) {
        assertWrapper.assertThat(description, methodCall, matcher);
        return this;
    }

    @Override
    public Asserts<ReturnType> assertTrue(boolean methodCall) {
        assertWrapper.assertTrue(description, methodCall);
        return this;
    }

    @Override
    public Asserts<ReturnType> assertFalse(boolean methodCall) {
        assertWrapper.assertFalse(description, methodCall);
        return this;
    }

    @Override
    public Asserts<ReturnType> assertEqualTo(ReturnType methodCall, Object expected) {
        assertWrapper.assertThat(description, methodCall, equalTo(expected));
        return this;
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
        final AssertsImpl<?> other = (AssertsImpl<?>) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
}
