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
public class TestCase implements Expectations {

	/** The description. */
	private final String description;
	/** The JUnit test */
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
	 * Given.
	 *
	 * @param <D> the generic type
	 * @param data the data
	 * @return the given data
	 */
	public <D> GivenData<D> given(D data) {
		return new GivenData<>(data, description);
	}

	/**
	 * Given.
	 *
	 * @param data the data
	 * @return the given data
	 */
	public GivenData<Object[]> given(Object... data) {
		return new GivenData<>(data, description);
	}
	
	@Override
	public <T> StubbingWrapper<T> when(T methodCall) throws Exception {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public TestCase expect(final WeExpect weExpect) throws Exception {
		weExpect.execution();
		return this;
	}

	@Override
	public <T> TestCase expect(final OngoingStubbing<T> ongoingStubbing) throws Exception {
		return this;
	}

	@Override
	public TestCase doExpectations(final WeExpect weExpect) throws Exception {
		return expect(weExpect);
	}

	@Override
	public TestCase expect(final StepChain chain) {
		chain.execute();
		return this;
	}

	@Override
	public TestCase doExpectations(final StepChain chain) {
		return expect(chain);
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

	/**
	 * Assert that.
	 *
	 * @param <I> the generic type
	 * @param methodCall the method call
	 * @param matcher the matcher
	 */
	public <I> void assertThat(I methodCall, Matcher<? super I> matcher) {
		Assert.assertThat(description + " Assertion Failed!", methodCall, matcher);
	}

	/**
	 * Assert equal to.
	 *
	 * @param <I> the generic type
	 * @param methodCall the method call
	 * @param expected the expected
	 */
	public <I> void assertEqualTo(I methodCall, Object expected) {
		this.assertThat(methodCall, org.hamcrest.CoreMatchers.equalTo(expected));
	}

	/**
	 * Assert true.
	 *
	 * @param <I> the generic type
	 * @param methodCall the method call
	 */
	public <I> void assertTrue(boolean methodCall)  {
		Assert.assertTrue(methodCall);
	}
}