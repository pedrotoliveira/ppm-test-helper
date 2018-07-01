package br.com.ppm.test.helper;

/**
 * The Interface Expectations.
 */
public interface Expectations {

    /**
     * When some mock method call
     *
     * @param value a value
     * @return the expectations
     * @throws Exception the exception
     */
    <T> Stubbing<T> when(final T value) throws Exception;

    /**
     * Wrap a result of a method call.
     *
     * @param value the method call
     * @return the return object wrapper
     */
    <I> ReturnWrapper<I> wrapResult(I value);
}
