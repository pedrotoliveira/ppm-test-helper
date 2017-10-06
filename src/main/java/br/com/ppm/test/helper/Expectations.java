package br.com.ppm.test.helper;

/**
 * The Interface Expectations.
 */
public interface Expectations {

    /**
     * When some mock method call
     *
     * @param methodCall a methodCall
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
