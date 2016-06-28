package br.com.ppm.test.helper;

import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;

/**
 * Just a Test Step.
 *
 * @param <T> the generic type
 * @author pedrotoliveira
 */
public final class Step<T> implements WeExpect, StubbingWrapper<T> {

	/**
	 * The stub.
	 */
	private final OngoingStubbing<T> stub;

	/**
	 * The values.
	 */
	private T[] values;

	/**
	 * Instantiates a new step.
	 *
	 * @param methodCall the method call
	 */
	public Step(T methodCall) {
		this.stub = Mockito.when(methodCall);
	}

	/**
	 * Instantiates a new step.
	 *
	 * @param ongoingStubbing the ongoing stubbing
	 */
	public Step(final OngoingStubbing<T> ongoingStubbing) {
		this.stub = ongoingStubbing;
	}

	/**
	 * Execute.
	 */
	public void execute() {
		//Actually Do Nothing...
	}

	@Override
	public void execution(Object... mocks) throws Exception {
		execute();
	}

	@Override
	public OngoingStubbing<T> thenReturn(final T value) {
		return stub.thenReturn(value);
	}

	@Override
	@SuppressWarnings("unchecked")
	public OngoingStubbing<T> thenReturn(final T value, final T... values) {
		return stub.thenReturn(value, this.values);
	}

	@Override
	public OngoingStubbing<T> thenThrow(final Throwable... throwables) {
		return stub.thenThrow(throwables);
	}

	@Override
	@SuppressWarnings("unchecked")
	public OngoingStubbing<T> thenThrow(final Class<? extends Throwable>... throwableClasses) {
		return stub.thenThrow(throwableClasses);
	}

	@Override
	public OngoingStubbing<T> thenCallRealMethod() {
		return thenCallRealMethod();
	}

	@Override
	public OngoingStubbing<T> thenAnswer(Answer<?> answer) {
		return stub.thenAnswer(answer);
	}

	@Override
	public OngoingStubbing<T> then(Answer<?> answer) {
		return (OngoingStubbing<T>) stub.then(answer);
	}

	@Override
	public <M> M getMock() {
		return stub.getMock();
	}

	@Override
	public <D> GivenDataAndStubbing<D, T> then() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
