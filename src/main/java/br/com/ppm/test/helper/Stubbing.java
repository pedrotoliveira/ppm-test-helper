package br.com.ppm.test.helper;

import org.mockito.stubbing.Answer;

/**
 * The Stubbing Interface
 *
 * @author pedrotoliveira
 */
public interface Stubbing<ReturnType> {

    <ReturnType> Stubbing<ReturnType> when(ReturnType value);

    <D> GivenDataAndStubbing<D, ReturnType> then();

    Stubbing<ReturnType> thenReturn(ReturnType value);

    @SuppressWarnings("unchecked")
    Stubbing<ReturnType> thenReturn(ReturnType value, ReturnType... values);

    Stubbing<ReturnType> thenThrow(Throwable... throwables);

    @SuppressWarnings("unchecked")
    Stubbing<ReturnType> thenThrow(Class<? extends Throwable>... throwableClasses);

    Stubbing<ReturnType> thenAnswer(Answer<?> answer);

    Stubbing<ReturnType> then(Answer<?> answer);

    <M> M getMock();
}
