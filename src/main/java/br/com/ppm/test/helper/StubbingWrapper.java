package br.com.ppm.test.helper;

import org.mockito.stubbing.OngoingStubbing;

/**
 * The Stubbing Wrapper Interface
 * 
 * @author pedrotoliveira
 */
public interface StubbingWrapper<T> extends OngoingStubbing<T> {
	
	<T> StubbingWrapper<T> when(T methodCall);
	
    <D> GivenDataAndStubbing<D, T> then();
}
