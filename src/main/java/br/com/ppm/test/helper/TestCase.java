package br.com.ppm.test.helper;

import org.apache.log4j.Logger;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.mockito.stubbing.OngoingStubbing;

/**
 * The Class GivenTestData.
 *
 * @author pedrotoliveira
 */
public class TestCase implements Given, Expectations, Asserts {

    private final String description;
    private final FluentTest test;

    /**
     * Instantiates a new test case.
     *
     * @param test the testCase
     * @param description the description
     * @param logger the logger
     */
    public TestCase(FluentTest test, String description, Logger logger) {
        this.test = test;
        this.description = description;
        logger.info("Start test: " + description);
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
    public <I> I test(I testInstance) {
        return testInstance;
    }

    @Override
    public <I> ReturnObjectWrapper<I> wrapResult(I methodCall) {
        return new ReturnObjectWrapper<>(methodCall);
    }

    /**
     * Execute.
     *
     * @param <I> the generic type
     * @param testInstance the test instance
     * @return the instance
     */
    public <I> I execute(I testInstance) {
        return test(testInstance);
    }

    @Override
    public Asserts assertTrue(boolean methodCall) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <I> Asserts assertThat(I methodCall, Matcher<? super I> matcher) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Asserts assertFalse(boolean methodCall) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <I> Asserts assertEqualTo(I methodCall, Object expected) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
