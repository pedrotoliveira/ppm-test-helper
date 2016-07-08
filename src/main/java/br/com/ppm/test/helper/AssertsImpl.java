package br.com.ppm.test.helper;

import org.hamcrest.Matcher;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Asserts Implementations
 * 
 * @author pedrotoliveira
 */
public class AssertsImpl implements Asserts {

    private final Assert junitAssert;

    public AssertsImpl() {
        this.junitAssert = new JUnitAssert();
    }
    
    private final class JUnitAssert extends Assert {
    }
    
	@Override
	public <I> Asserts assertThat(I methodCall, Matcher<? super I> matcher) {
        junitAssert.assertThat(methodCall, matcher);
		return this;
	}

	@Override
	public Asserts assertTrue(boolean methodCall) {
		junitAssert.assertTrue(methodCall);
        return this;
	}

	@Override
	public Asserts assertFalse(boolean methodCall) {
		junitAssert.assertFalse(methodCall);
        return this;
	}

	@Override
	public <I> Asserts assertEqualTo(I methodCall, Object expected) {
		junitAssert.assertThat(methodCall, equalTo(expected));
        return this;
	}	
}
