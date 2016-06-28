package br.com.ppm.test.helper;

/**
 * The Interface FluentTest.
 *
 * @author pedrotoliveira
 */
public interface FluentTest {

	/**
	 * testCase.
	 *
	 * @return the testCase
	 */
	TestCase testCase();

	/**
	 * testCase.
	 *
	 * @param description the description
	 *
	 * @return the testCase
	 */
	TestCase testCase(final String description);
}
