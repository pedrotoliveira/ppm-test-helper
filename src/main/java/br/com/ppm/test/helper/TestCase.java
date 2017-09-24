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
    public <I> ReturnWrapper<I> wrapResult(I methodCall) {
        return new ReturnWrapper<>(methodCall, description);
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
    public ReturnWrapper assertEqualTo(Object expected) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReturnWrapper resultIsEqualTo(Object expected) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReturnWrapper assertReturn(Matcher matcher) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReturnWrapper assertReturnField(String field, Matcher matcher) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Asserts assertThat(Object methodCall, Matcher matcher) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Asserts assertFalse(boolean methodCall) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Asserts assertEqualTo(Object methodCall, Object expected) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReturnWrapper assertEqualToReturnField(String field, Object expected) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReturnWrapper assertReturnFields(String field, Matcher matcher, Object... additionalKeyMatcherPairs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReturnWrapper assertEqualToReturnFields(String field, Object expected, Object... additionalKeyMatcherPairs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
