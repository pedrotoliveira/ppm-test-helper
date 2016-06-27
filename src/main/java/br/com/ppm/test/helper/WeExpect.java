package br.com.ppm.test.helper;


/**
 * What kind of Excution We Expect?.
 *
 * @author pedrotoliveira
 */
@FunctionalInterface
public interface WeExpect {

	/**
	 * Execution.
	 *
	 * @throws Exception the exception
	 */
	void execution() throws Exception;
}
