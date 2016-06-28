package br.com.ppm.test.helper;

/**
 * GivenData and Stubs.
 * 
 * @author pedrotoliveira
 */
public class GivenDataAndStubbing<D, T> {
	
	private final GivenData<D> givenData;
	private final StubbingWrapper<T> stub;

	public GivenDataAndStubbing(GivenData<D> givenData, StubbingWrapper<T> stub) {
		this.givenData = givenData;
		this.stub = stub;
	}

	protected GivenData<D> getGivenData() {
		return givenData;
	}

	protected StubbingWrapper<T> getStub() {
		return stub;
	}
	
	public GivenData<D> expectReturn(T value) {
		stub.thenReturn(value);
		return getGivenData();
	}
}
