package br.com.ppm.test.helper;

import org.hamcrest.Matcher;

/**
 * The Class GivenTestData.
 *
 * @author pedrotoliveira
 */
public final class TestCase implements Given<Object>, Expectations, Assertions<Object> {

    private final String description;
    private final Assertions<Object> asserts;

    /**
     * Instantiates a new test case.
     *
     * @param description the description
     */
    public TestCase(String description) {
        this.asserts = new AssertionsProvider<>(description);
        this.description = description;
    }

    /**
     * Given Data.
     *
     * @param <D> the generic type
     * @param data the data
     * @return the given data
     */
    public <D> GivenData<D> given(D data) {
        return new GivenData<>(data, description);
    }

    /**
     * Given Data Parameters.
     *
     * @param data the data
     * @return the given data
     */
    public GivenData<Object[]> given(Object... data) {
        return new GivenData<>(data, description);
    }

    @Override
    public <T> StubbingWrapper<T> when(T methodCall) {
        return new Stubbing<>(methodCall);
    }

    @Override
    public <I> ReturnWrapper<I> wrapResult(I methodCall) {
        return new ReturnWrapper<>(methodCall, description);
    }

    @Override
    public MethodInvoker<Object> test(Object testInstance) {
        return new MethodInvoker<>(testInstance, new NoDataGiven(), description);
    }

    /**
     * Execute.
     *
     * @param <I> the generic type
     * @param testInstance the test instance
     * @return the instance
     */
    public <I> I execute(I testInstance) {
        return testInstance;
    }

    @Override
    public Assertions<Object> assertTrue(boolean methodCall) {
        return asserts.assertTrue(methodCall);
    }

    @Override
    public ReturnWrapper<Object> assertEqualTo(Object expected) {
        return asserts.assertEqualTo(expected);
    }

    @Override
    public ReturnWrapper<Object> resultIsEqualTo(Object expected) {
        return asserts.resultIsEqualTo(expected);
    }

    @Override
    public ReturnWrapper<Object> assertReturn(Matcher<? super Object> matcher) {
        return asserts.assertReturn(matcher);
    }

    @Override
    public ReturnWrapper<Object> assertReturnField(String field, Matcher<?> matcher) {
        return asserts.assertReturnField(field, matcher);
    }

    @Override
    public ReturnWrapper<Object> assertEqualToReturnField(String field, Object expected) {
        return asserts.assertEqualToReturnField(field, expected);
    }

    @Override
    public ReturnWrapper<Object> assertReturnFields(String field, Matcher<?> matcher, Object... additionalKeyMatcherPairs) {
        return asserts.assertReturnFields(field, matcher, additionalKeyMatcherPairs);
    }

    @Override
    public ReturnWrapper<Object> assertEqualToReturnFields(String field, Object expected, Object... additionalKeyMatcherPairs) {
        return asserts.assertEqualToReturnFields(field, expected, additionalKeyMatcherPairs);
    }

    @Override
    public Assertions<Object> assertThat(Object methodCall, Matcher<? super Object> matcher) {
        return asserts.assertThat(methodCall, matcher);
    }

    @Override
    public Assertions<Object> assertFalse(boolean methodCall) {
        return asserts.assertFalse(methodCall);
    }

    @Override
    public Assertions<Object> assertEqualTo(Object methodCall, Object expected) {
        return asserts.assertEqualTo(methodCall, expected);
    }
}
