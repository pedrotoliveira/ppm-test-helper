package br.com.ppm.test.helper;

import org.hamcrest.Matcher;

/**
 * Assertions Operations
 *
 * @author pedrotoliveira
 */
public interface Assertions<Return> extends TestCaseAssertions<Return> {

    /**
     * Assert the return object equal to a object.
     *
     * @param expected the expected object value.
     * @return the return object wrapper.
     */
    ReturnWrapper<Return> assertEqualTo(Return expected);

    /**
     * Assert the result of method execution object equal to a object.
     *
     * @param expected the expected object value.
     * @return the return object wrapper.
     */
    ReturnWrapper<Return> resultIsEqualTo(Return expected);

    /**
     * Assert the return object to the selected matcher.
     *
     * @param matcher a Matcher <code>org.hamcrest.Matcher</code>
     * @return the return object wrapper
     * @see org.hamcrest.CoreMatchers
     * @see org.hamcrest.MatcherAssert
     */
    ReturnWrapper<Return> assertReturn(Matcher<? super Return> matcher);

    /**
     * Assert a field of return object to a matcher.<br/>
     *
     * Assertions a field of the object, example: <code>assertReturnField("field1", equalTo("one"));</code>
     *
     * @param fieldName the field name
     * @param matcher a Matcher <code>org.hamcrest.Matcher</code>
     * @return the return object wrapper
     * @see org.hamcrest.CoreMatchers
     * @see org.hamcrest.MatcherAssert
     */
    ReturnWrapper<Return> assertReturnField(String fieldName, Matcher<?> matcher);

    /**
     * Assert a field of the return object equal to the expected object.<br/>
     *
     * Assertions the fields of the object, example: <code>assertEqualToReturnField("field1", "one");</code>
     *
     * @param fieldName the field name
     * @param expected the expected object to assert
     * @return the return object wrapper
     */
    ReturnWrapper<Return> assertEqualToReturnField(String fieldName, Object expected);

    /**
     * Assert returnObject fields.<br/>
     *
     * Assertions the fields of the object,
     * <code>example: assertReturnFields("field1", equalTo("one"), "field2", equalTo("two"));</code>
     *
     * @param field the field
     * @param matcher a Matcher <code>org.hamcrest.Matcher</code>
     * @param additionalKeyMatcherPairs the additional key matcher pairs
     * @return the return object wrapper
     * @see org.hamcrest.CoreMatchers
     * @see org.hamcrest.MatcherAssert
     */
    ReturnWrapper<Return> assertReturnFields(String field, Matcher<?> matcher, Object... additionalKeyMatcherPairs);

    /**
     * Assert equalTo returnObject fields.<br/>
     *
     * Assertions the fields of the object,
     * <code> example: assertEqualToReturnFields("field1", "one", "field2", "two");</code>
     *
     * @param keyPairs fields and values to match
     * @return the return object wrapper
     */
    ReturnWrapper<Return> assertEqualToReturnFields(Object... keyPairs);

    /**
     * Assertions that <code>actual</code> satisfies the condition specified by <code>matcher</code>. If not, an
     * {@link AssertionError} is thrown with the reason and information about the matcher and failing value. Example:
     *
     * <pre>
     *   assertThat(&quot;Help! Integers don't work&quot;, 0, is(1)); // fails:
     *     // failure message:
     *     // Help! Integers don't work
     *     // expected: is &lt;1&gt;
     *     // got value: &lt;0&gt;
     *   assertThat(&quot;Zero is one&quot;, 0, is(not(1))) // passes
     * </pre>
     *
     * <code>org.hamcrest.Matcher</code> does not currently document the meaning of its type parameter <code>T</code>.
     * This method assumes that a matcher typed as <code>Matcher&lt;T&gt;</code> can be meaningfully applied only to
     * values that could be assigned to a variable of type <code>T</code>.
     *
     * @param value a method call that return a type of Return, defined in interface Type.
     * @param matcher a Matcher <code>org.hamcrest.Matcher</code>
     * @return a Assertions<Return> Implementation
     * @see org.hamcrest.CoreMatchers
     * @see org.hamcrest.MatcherAssert
     */
    @Override
    Assertions<Return> assertThat(Return value, Matcher<? super Return> matcher);

    /**
     * Assert True.
     *
     * @param value the method call
     * @return Assertions
     */
    @Override
    Assertions<Return> assertTrue(boolean value);

    /**
     * Assert False.
     *
     * @param value
     * @return Assertions
     */
    @Override
    Assertions<Return> assertFalse(boolean value);

    /**
     * Assert equal to.
     *
     * @param value the method call
     * @param expected the expected
     * @return Assertions
     */
    @Override
    Assertions<Return> assertEqualTo(Return value, Object expected);
}
