package br.com.ppm.test.helper;

import org.hamcrest.Matcher;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Asserts Implementations
 *
 * @author pedrotoliveira
 */
public class AssertsImpl<ReturnType> implements Asserts<ReturnType> {

    /**
     * The test description
     */
    private final String description;
    private final ReturnObjectWrapper<ReturnType> returnObjectWrapper;
    private final Assert junitAssert;

    //I don't know if i need this... TODO: Check later.
    private final class JUnitAssert extends Assert {
    }

    public AssertsImpl(ReturnObjectWrapper<ReturnType> returnObjectWrapper, String description) {
        this.returnObjectWrapper = returnObjectWrapper;
        this.description = description;
        this.junitAssert = new JUnitAssert();
    }

    public String getDescription() {
        return description;
    }

    @Override
    public ReturnObjectWrapper<ReturnType> assertEqualToReturnField(String field, Object expected) {
        return returnObjectWrapper.assertEqualToReturnField(field, expected);
    }

    @Override
    public ReturnObjectWrapper<ReturnType> assertReturnFields(String field, Matcher<?> matcher, Object... additionalKeyMatcherPairs) {
        //FIXME: Invert Responsibility???
        return returnObjectWrapper.assertReturnFields(field, matcher, additionalKeyMatcherPairs);
    }

    @Override
    public ReturnObjectWrapper<ReturnType> assertEqualToReturnFields(String field, Object expected, Object... additionalKeyMatcherPairs) {
        //FIXME: Invert Responsibility???
        return returnObjectWrapper.assertEqualToReturnFields(field, expected, additionalKeyMatcherPairs);
    }

    @Override
    public ReturnObjectWrapper<ReturnType> resultIsEqualTo(ReturnType expected) {
        //FIXME: Invert Responsibility???
        return returnObjectWrapper.resultIsEqualTo(expected);
    }

    @Override
    public ReturnObjectWrapper<ReturnType> assertReturn(Matcher<? super ReturnType> matcher) {
        //FIXME: Invert Responsibility???
        return returnObjectWrapper.assertReturn(matcher);
    }

    @Override
    public ReturnObjectWrapper<ReturnType> assertReturnField(String field, Matcher<?> matcher) {
        //FIXME: Invert Responsibility???
        return returnObjectWrapper.assertReturnField(field, matcher);
    }

    @Override
    public ReturnObjectWrapper<ReturnType> assertEqualTo(ReturnType expected) {
        //FIXME: Invert Responsibility???
        return returnObjectWrapper.assertEqualTo(expected);
    }

    @Override
    public Asserts<ReturnType> assertThat(ReturnType methodCall, Matcher<? super ReturnType> matcher) {
        junitAssert.assertThat(description, methodCall, matcher);
        return this;
    }

    @Override
    public Asserts<ReturnType> assertTrue(boolean methodCall) {
        junitAssert.assertTrue(description, methodCall);
        return this;
    }

    @Override
    public Asserts<ReturnType> assertFalse(boolean methodCall) {
        junitAssert.assertFalse(description, methodCall);
        return this;
    }

    @Override
    public Asserts<ReturnType> assertEqualTo(ReturnType methodCall, Object expected) {
        junitAssert.assertThat(description, methodCall, equalTo(expected));
        return this;
    }
}
