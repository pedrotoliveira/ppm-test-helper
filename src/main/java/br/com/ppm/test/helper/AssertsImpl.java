package br.com.ppm.test.helper;

import org.hamcrest.Matcher;

/**
 * Asserts Implementations
 * 
 * @author pedrotoliveira
 */
public class AssertsImpl implements Asserts {

	@Override
	public <I> Asserts assertThat(I methodCall, Matcher<? super I> matcher) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Asserts assertTrue(boolean methodCall) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Asserts assertFalse(boolean methodCall) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public <I> Asserts assertEqualTo(I methodCall, Object expected) {
		throw new UnsupportedOperationException("Not supported yet.");
	}	
}
