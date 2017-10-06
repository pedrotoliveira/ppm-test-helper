package br.com.ppm.test.helper;

/**
 * The Interface Expectations.
 */
public interface Expectations {

	/**
	 * When some mock method call
     	 *
	 * @param <T> the generic type
	 * @param ongoingStubbing the ongoing stubbing
	 * @return the expectations
	 * @throws Exception the exception
	 */
	<T> StubbingWrapper<T> when(final T methodCall) throws Exception;

    /**
   	 * Wrap a result of a method call.
	 *
	 * @param methodCall the method call
	 * @return the return object wrapper
	 */
	<I> ReturnWrapper<I> wrapResult(I methodCall);
}
