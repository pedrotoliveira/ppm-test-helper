package br.com.ppm.test.helper;


import org.mockito.stubbing.OngoingStubbing;


/**
 * The Class GivenData.
 *
 * @param <D> the generic type
 */
public class GivenData<D> implements Expectations {

	/** The description. */
	private final String description;
	
	/** The given data. */
	private final D givenData;

	/**
	 * Instantiates a new given data.
	 *
	 * @param givenData the given data
	 * @param description the description
	 */
	GivenData(final D givenData, final String description) {
		super();
		this.givenData = givenData;
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see br.com.uol.egw.util.test.Expectations#test(java.lang.Object)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public MethodInvoker<D> test(final Object testInstance) {
		return new MethodInvoker<>(testInstance, givenData);
	}

	/* (non-Javadoc)
	 * @see br.com.uol.egw.util.test.Expectations#when(org.mockito.stubbing.OngoingStubbing)
	 */
	@Override
	public <T> GivenData<D> when(final OngoingStubbing<T> ongoingStubbing) throws Exception {
		return this;
	}

	/* (non-Javadoc)
	 * @see br.com.uol.egw.util.test.Expectations#expect(br.com.uol.egw.util.test.WeExpect)
	 */
	@Override
	public GivenData<D> expect(final WeExpect weExpect) throws Exception {
		weExpect.execution();
		return this;
	}

	/* (non-Javadoc)
	 * @see br.com.uol.egw.util.test.Expectations#expect(org.mockito.stubbing.OngoingStubbing)
	 */
	@Override
	public <T> GivenData<D> expect(final OngoingStubbing<T> ongoingStubbing) throws Exception {
		return this;
	}

	/* (non-Javadoc)
	 * @see br.com.uol.egw.util.test.Expectations#doExpectations(br.com.uol.egw.util.test.WeExpect)
	 */
	@Override
	public GivenData<D> doExpectations(final WeExpect weExpect) throws Exception {
		return expect(weExpect);
	}

	/* (non-Javadoc)
	 * @see br.com.uol.egw.util.test.Expectations#expect(br.com.uol.egw.util.test.StepChain)
	 */
	@Override
	public GivenData<D> expect(final StepChain chain) {
		chain.execute();
		return this;
	}

	/* (non-Javadoc)
	 * @see br.com.uol.egw.util.test.Expectations#doExpectations(br.com.uol.egw.util.test.StepChain)
	 */
	@Override
	public GivenData<D> doExpectations(final StepChain chain) {
		return expect(chain);
	}

	/* (non-Javadoc)
	 * @see br.com.uol.egw.util.test.Expectations#testMethod(java.lang.Object)
	 */
	@Override
	public <I> ReturnObjectWrapper<I> testMethod(I methodCall) {
		return new ReturnObjectWrapper<>(methodCall);
	}
}
