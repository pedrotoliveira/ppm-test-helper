package br.com.ppm.test.helper;

import org.hamcrest.Matcher;

/**
 * The TestCase
 *
 * @author pedrotoliveira
 */
public final class TestCase implements Given<Object>, Expectations, TestCaseAssertions<Object> {

    private final String description;
    private final TestCaseAssertions<Object> asserts;

    /**
     * Instantiates a new call case.
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

    /**
     * Test an Instance
     *
     * @param <I> the generic type
     * @param testInstance the call instance
     * @return the instance
     */
    public <I> I test(I testInstance) {
        return testInstance;
    }

    @Override
    public <T> Stubbing<T> when(T value) {
        return new StubbingProvider<>(value);
    }

    @Override
    public <I> ReturnWrapper<I> wrapResult(I value) {
        return new ReturnWrapper<>(value, description);
    }

    @Override
    public <I> MethodInvoker<I, Object> call(I testInstance) {
        return new MethodInvoker<>(description, testInstance);
    }

    @Override
    public TestCaseAssertions<Object> assertTrue(boolean value) {
        return asserts.assertTrue(value);
    }

    @Override
    public TestCaseAssertions<Object> assertThat(Object value, Matcher<? super Object> matcher) {
        return asserts.assertThat(value, matcher);
    }

    @Override
    public TestCaseAssertions<Object> assertFalse(boolean value) {
        return asserts.assertFalse(value);
    }

    @Override
    public TestCaseAssertions<Object> assertEqualTo(Object value, Object expected) {
        return asserts.assertEqualTo(value, expected);
    }

    @Override
    public TestCaseMatcher<Object> assertThat(Object value) {
        return new TestCaseMatcherProvider(value, description, asserts);
    }

    @Override
    public TestCaseMatcher<Object> itIs(Object value) {
        return new TestCaseMatcherProvider(value, description, asserts);
    }

    @Override
    public TestCaseMatcher<Object> itIs(String assertDescription, Object value) {
        String builder = description + "|" + assertDescription;
        return new TestCaseMatcherProvider(value, builder, asserts);
    }

    @Override
    public TestCaseMatcher<Object> it(TestCaseMatcher<Object> matcher) {
        return null;
    }

    @Override
    public TestCaseMatcher<Object> it(String assertDescription, TestCaseMatcher<Object> matcher) {
        return null;
    }

    @Override
    public <E extends Throwable> TestCaseMatcher<Object> shouldThrow(Object value, E exception) {
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
