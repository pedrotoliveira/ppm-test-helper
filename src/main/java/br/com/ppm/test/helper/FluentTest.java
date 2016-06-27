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

	/**
	 * And add Data
	 *
	 * @param <T> the generic type
	 * @param andData the and data
	 * @return the testCase
	 */
	<T> T and(T andData);

	/**
	 * With Data
	 *
	 * @param <T> the generic type
	 * @param withData the with data
	 * @return the t
	 */
	<T> T with(T withData);

	/**
	 * With return.
	 *
	 * @param <R> the generic type
	 * @param returnType the return type
	 * @return the class
	 */
	<R> Class<R> withReturn(Class<R> returnType);

}
