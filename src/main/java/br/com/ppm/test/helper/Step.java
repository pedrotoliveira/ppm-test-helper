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
public final class Step<T> implements WeExpect, OngoingStubbing<T> {
	
	/** The stub. */
	private final OngoingStubbing<T> stub;
	
	/** The values. */
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

	/* (non-Javadoc)
	 * @see br.com.uol.egw.util.test.WeExpect#execution()
	 */
	@Override
	public void execution() throws Exception {
		execute();
	}

	/* (non-Javadoc)
	 * @see org.mockito.stubbing.OngoingStubbing#thenReturn(java.lang.Object)
	 */
	@Override
	public OngoingStubbing<T> thenReturn(final T value) {
		return stub.thenReturn(value);
	}

	/* (non-Javadoc)
	 * @see org.mockito.stubbing.OngoingStubbing#thenReturn(java.lang.Object, java.lang.Object[])
	 */
	@Override
	@SuppressWarnings("unchecked")
	public OngoingStubbing<T> thenReturn(final T value, final T... values) {		
		return stub.thenReturn(value, this.values);
	}

	/* (non-Javadoc)
	 * @see org.mockito.stubbing.OngoingStubbing#thenThrow(java.lang.Throwable[])
	 */
	@Override
	public OngoingStubbing<T> thenThrow(final Throwable... throwables) {
		return stub.thenThrow(throwables);
	}

	/* (non-Javadoc)
	 * @see org.mockito.stubbing.OngoingStubbing#thenThrow(java.lang.Class[])
	 */
	@Override
	@SuppressWarnings("unchecked") 
	public OngoingStubbing<T> thenThrow(final Class<? extends Throwable>... throwableClasses) {
		return stub.thenThrow(throwableClasses);
	}

	/* (non-Javadoc)
	 * @see org.mockito.stubbing.OngoingStubbing#thenCallRealMethod()
	 */
	@Override
	public OngoingStubbing<T> thenCallRealMethod() {
		return thenCallRealMethod();
	}

	/* (non-Javadoc)
	 * @see org.mockito.stubbing.OngoingStubbing#thenAnswer(org.mockito.stubbing.Answer)
	 */
	@Override
	public OngoingStubbing<T> thenAnswer(Answer<?> answer) {		
		return stub.thenAnswer(answer);
	}

	/* (non-Javadoc)
	 * @see org.mockito.stubbing.OngoingStubbing#then(org.mockito.stubbing.Answer)
	 */
	@Override
	public OngoingStubbing<T> then(Answer<?> answer) {
		return (OngoingStubbing<T>) stub.then(answer);
	}

	/* (non-Javadoc)
	 * @see org.mockito.stubbing.OngoingStubbing#getMock()
	 */
	@Override
	public <M> M getMock() {		
		return stub.getMock();
	}
}
