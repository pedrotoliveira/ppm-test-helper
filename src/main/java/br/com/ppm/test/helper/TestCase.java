package br.com.ppm.test.helper;

import org.hamcrest.Matcher;

/**
 * The Class GivenTestData.
 *
 * @author pedrotoliveira
 */
public final class TestCase implements Given<Object>, Expectations, TestCaseAssertions<Object> {

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
     * Given Data Parameter
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
     * Call Test Instance
     *
     * @param <I> the generic type
     * @param testInstance the test instance
     * @return the instance
     */
    public <I> I call(I testInstance) {
        return testInstance;
    }

    @Override
    public TestCaseAssertions<Object> assertTrue(boolean methodCall) {
        return asserts.assertTrue(methodCall);
    }

    @Override
    public TestCaseAssertions<Object> assertThat(Object methodCall, Matcher<? super Object> matcher) {
        return asserts.assertThat(methodCall, matcher);
    }

    @Override
    public TestCaseAssertions<Object> assertFalse(boolean methodCall) {
        return asserts.assertFalse(methodCall);
    }

    @Override
    public TestCaseAssertions<Object> assertEqualTo(Object methodCall, Object expected) {
        return asserts.assertEqualTo(methodCall, expected);
    }

    @Override
    public TestCaseMatcher<Object> assertThat(Object methodCall) {
        return new TestCaseMatcherProvider(methodCall, description, asserts);
    }

    @Override
    public TestCaseMatcher<Object> it(Object methodCall) {
        return new TestCaseMatcherProvider(methodCall, description, asserts);
    }

    @Override
    public TestCaseMatcher<Object> it(String assertDescription, Object methodCall) {
        String builder = description + "|" + assertDescription;
        return new TestCaseMatcherProvider(methodCall, builder, asserts);
    }

    @Override
    public <E extends Throwable> TestCaseMatcher<Object> shouldThrow(E exception, Object methodCall) {
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
}
