package br.com.ppm.test.helper;

/**
 * Expose Fixture Methods for Default Object Creation.
 *
 * @author pedrotoliveira
 */
public interface FixtureTest {

	/**
	 * Generate a String based on regex pattern.
	 *
	 * @param pattern a pattern
	 * @return a String
	 */
	String regexValue(String pattern);

	/**
	 * Generate a randomInt on the specified range.
	 *
	 * @param start integer start range
	 * @param end integer end range
	 * @return a number
	 */
	int randomInt(int start, int end);
}
