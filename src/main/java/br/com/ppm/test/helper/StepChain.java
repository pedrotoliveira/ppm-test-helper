package br.com.ppm.test.helper;

import java.util.LinkedList;
import java.util.List;

import org.mockito.stubbing.OngoingStubbing;


/**
 * The Class StepChain.
 *
 * @author pedrotoliveira
 */
public final class StepChain {

	/** The chain. */
	private final List<Step<?>> chain = new LinkedList<>();

	/**
	 * Instantiates a new step chain.
	 */
	private StepChain() {
	}
	
	/**
	 * Chain.
	 *
	 * @return the step chain
	 */
	public static StepChain chain() {
		return new StepChain();
	}

	/**
	 * Adds the.
	 *
	 * @param step the step
	 * @return the step chain
	 */
	public StepChain add(Step<?> step) {
		chain.add(step);
		return this;
	}
	
	/**
	 * Adds the.
	 *
	 * @param ongoingStubbing the ongoing stubbing
	 * @return the step chain
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public StepChain add(OngoingStubbing<?> ongoingStubbing) {
		chain.add(new Step(ongoingStubbing));
		return this;
	}

	/**
	 * Execute.
	 */
	public void execute() {
		for (Step<?> s : chain) {
			s.execute();
		}
	}
}
