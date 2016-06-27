package br.com.ppm.test.helper;

import org.apache.log4j.Logger;
import org.mockito.InOrder;
import org.mockito.Mockito;

/**
 * The Class FluentTestHelper.
 * <p>
 * @author pedrotoliveira
 */
public abstract class FluentTestHelper implements FluentTest {

	/** The logger. */
	private final Logger logger = Logger.getLogger(this.getClass());
	/**
	 * The debug mode.
	 */
	private boolean debugMode = false;

	@Override
	public TestCase testCase() {
		return new TestCase(this, this.getClass().getSimpleName(), logger);
	}

	@Override
	public TestCase testCase(String description) {
		return new TestCase(this, description, logger);
	}

	@Override
	public <T> T and(T andData) {
		return andData;
	}

	@Override
	public <T> T with(T withData) {
		return withData;
	}

	@Override
	public <R> Class<R> withReturn(Class<R> returnType) {
		return returnType;
	}

	public void setDebugMode(boolean debugTest) {
		this.debugMode = debugTest;
	}

	/**
	 * Verify Mock Invocations inOrder.
	 * <p>
	 *
	 * @param verifications implementation for all mock invoke verifications.
	 * <p>
	 * @return the verify mock interactions
	 */
	public VerifyMockInteractions inOrder(Verifications verifications) {
		return new VerifyMockInteractions(verifications);
	}

	/**
	 * Delegates to Mockito.inOrder.
	 * <p>
	 * @see Mockito.inOrder.
	 * @param mocks
	 * <p>
	 * @return
	 */
	public InOrder inOrder(Object... mocks) {
		return Mockito.inOrder(mocks);
	}
}
