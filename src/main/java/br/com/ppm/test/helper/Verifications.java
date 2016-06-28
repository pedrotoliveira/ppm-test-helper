package br.com.ppm.test.helper;

import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

/**
 * Group a InOrder verification Behavior of Mocks
 *
 * @author pedrotoliveira
 */
public abstract class Verifications {

	/** The in order. */
	private final InOrder inOrder;

	/**
	 * Instantiates a new verifications.
	 * <p>
	 * @param mocks the mocks
	 */
	public Verifications(Object... mocks) {
		this.inOrder = Mockito.inOrder(mocks);
	}

	/**
	 * Gets the in order.
	 * <p>
	 * @return the in order
	 */
	protected final InOrder inOrder() {
		return inOrder;
	}

	/**
	 * Verify a method invocation inOrder of call.
	 * <p>
	 * @param <T>
	 * @param mock <p>
	 * @return
	 */
	protected final <T> T verify(T mock) {
		return inOrder.verify(mock);
	}

	/**
	 * Verifies interaction in order. E.g:
	 * <p>
	 * <pre class="code"><code class="java">
	 * InOrder inOrder = inOrder(firstMock, secondMock);
	 * <p>
	 * inOrder.verify(firstMock, times(2)).someMethod("was called first two times"); inOrder.verify(secondMock,
	 * atLeastOnce()).someMethod("was called second at least once");
	 * </code></pre>
	 * <p>
	 * See examples in javadoc for {@link Mockito} class
	 * <p>
	 * @param mock to be verified
	 * @param mode for example times(x) or atLeastOnce()
	 * <p>
	 * @return mock object itself
	 */
	protected final <T> T verify(T mock, VerificationMode mode) {
		return inOrder.verify(mock, mode);
	}

	/**
	 * Do all Verifications for a InOrder.
	 */
	public abstract void verifyAll();
}
