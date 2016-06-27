package br.com.ppm.test.helper;

import org.mockito.InOrder;


/**
 * The Class Verify Mock Invocation.
 * <p>
 * @author pedrotoliveira
 */
public class VerifyMockInteractions {

	/** The in order. */
	private final InOrder inOrder;

	/**
	 * Construct a new VerifyMockInvocations
	 * <p>.
	 *
	 * @param verifications the verifications
	 */
	public VerifyMockInteractions(Verifications verifications) {
		this.inOrder = verifications.inOrder();
		verifications.verifyAll();
	}

	/**
	 * Verifies that no more interactions happened.
	 */
	public void verifyNoMoreInteractions() {
		this.inOrder.verifyNoMoreInteractions();
	}
}
