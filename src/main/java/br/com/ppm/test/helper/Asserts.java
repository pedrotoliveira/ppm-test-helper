package br.com.ppm.test.helper;

import org.hamcrest.Matcher;
import org.junit.Assert;

/**
 * Asserts Operations
 *
 * @author pedrotoliveira
 */
public interface Asserts {

	/**
	 * Assert that.
	 *
	 * @param <I> the generic type
	 * @param methodCall the method call
	 * @param matcher the matcher
	 */
	<I> Asserts assertThat(I methodCall, Matcher<? super I> matcher);

	/**
	 * Assert True.
	 *
	 * @param methodCall the method call
	 */
	Asserts assertTrue(boolean methodCall);
	
	/**
	 * Assert False.
	 * 
	 * @param methodCall
	 * @return 
	 */
	Asserts assertFalse(boolean methodCall);

	/**
	 * Assert equal to.
	 *
	 * @param <I> the generic type
	 * @param methodCall the method call
	 * @param expected the expected
	 */
	<I> Asserts assertEqualTo(I methodCall, Object expected);
}
