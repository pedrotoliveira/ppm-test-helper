package br.com.ppm.test.helper;

import org.mockito.Mockito;

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
	void execution(Object... mocks) throws Exception;
}
