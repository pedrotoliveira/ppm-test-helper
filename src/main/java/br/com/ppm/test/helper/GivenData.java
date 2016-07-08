package br.com.ppm.test.helper;

import org.mockito.stubbing.OngoingStubbing;

/**
 * The Class GivenData.
 *
 * @param <D> the generic type
 */
public class GivenData<D> implements Expectations {

	/**
	 * The description.
	 */
	private final String description;
	/**
	 * The given data.
	 */
	private final D givenData;

	/**
	 * Instantiates a new given data.
	 *
	 * @param givenData the given data
	 * @param description the description
	 */
	public GivenData(final D givenData, final String description) {
		super();
		this.givenData = givenData;
		this.description = description;
	}

	@Override
	public MethodInvoker<D> test(final Object testInstance) {
		return new MethodInvoker<D>(testInstance, givenData);
	}

	@Override
	public <T> StubbingWrapper<T> when(final T methodCall) {
		return new GivenDataAndStubbing<D, T>(this, methodCall);
	}

	@Override
	public <I> ReturnObjectWrapper<I> wrapResult(I methodCall) {
		return new ReturnObjectWrapper<>(methodCall);
	}
}
