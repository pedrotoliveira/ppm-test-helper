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

    /**
     * The test description
     */
    private final String description;
    private final Assert junitAssert;

    public AssertsImpl(String description) {
        this.description = description;
        this.junitAssert = new JUnitAssert();
    }

    private final class JUnitAssert extends Assert {
    }

    public String getDescription() {
        return description;
    }

    @Override
    public <I> Asserts assertThat(I methodCall, Matcher<? super I> matcher) {
        junitAssert.assertThat(description, methodCall, matcher);
        return this;
    }

    @Override
    public Asserts assertTrue(boolean methodCall) {
        junitAssert.assertTrue(description, methodCall);
        return this;
    }

    @Override
    public Asserts assertFalse(boolean methodCall) {
        junitAssert.assertFalse(description, methodCall);
        return this;
    }

    @Override
    public <I> Asserts assertEqualTo(I methodCall, Object expected) {
        junitAssert.assertThat(description, methodCall, equalTo(expected));
        return this;
    }

}
