package br.com.ppm.test.helper;

/**
 * The Interface Expectations.
 */
public interface Expectations {

	/**
	 * When.
	 *
	 * @param <T> the generic type
	 * @param ongoingStubbing the ongoing stubbing
	 * @return the expectations
	 * @throws Exception the exception
	 */
	<T> StubbingWrapper<T> when(final T methodCall) throws Exception;

	/**
	 * Test.
	 *
	 * @param <I> the generic type
	 * @param testInstance the test instance
	 * @return the i
	 */
	<I> I test(I testInstance);

	/**
	 * Wrap a result of a method call.
	 *
	 * @param methodCall the method call
	 * @return the return object wrapper
	 */
	<I> ReturnWrapper<I> wrapResult(I methodCall);
}
