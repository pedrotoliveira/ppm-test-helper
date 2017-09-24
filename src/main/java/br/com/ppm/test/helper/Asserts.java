package br.com.ppm.test.helper;

import org.hamcrest.Matcher;

/**
 * Asserts Operations
 *
 * @author pedrotoliveira
 */
public interface Asserts<Return> {

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
     * Asserts a field of the object, example: <code>assertReturnField("field1", equalTo("one"));</code>
     *
     * @param field the field name
     * @param matcher a Matcher <code>org.hamcrest.Matcher</code>
     * @return the return object wrapper
     * @see org.hamcrest.CoreMatchers
     * @see org.hamcrest.MatcherAssert
     */
    ReturnWrapper<Return> assertReturnField(String field, Matcher<?> matcher);

    /**
     * Assert a field of the return object equal to the expected object.<br/>
     *
     * Asserts the fields of the object, example: <code>assertEqualToReturnField("field1", "one");</code>
     *
     * @param field the field
     * @param expected the expected object to assert
     * @return the return object wrapper
     */
    ReturnWrapper<Return> assertEqualToReturnField(String field, Object expected);

    /**
     * Assert returnObject fields.<br/>
     *
     * Asserts the fields of the object,
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
     * Asserts the fields of the object,
     * <code> example: assertEqualToReturnFields("field1", "one", "field2", "two");</code>
     *
     * @param field the field
     * @param expected the object to match
     * @param additionalKeyMatcherPairs the additional key matcher pairs
     * @return the return object wrapper
     */
    ReturnWrapper<Return> assertEqualToReturnFields(String field, Object expected, Object... additionalKeyMatcherPairs);

    /**
     * Asserts that <code>actual</code> satisfies the condition specified by <code>matcher</code>. If not, an
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
     * @param methodCall a method call that return a type of Return, defined in interface Type.
     * @param matcher a Matcher <code>org.hamcrest.Matcher</code>
     * @return a Asserts<Return> Implementation
     * @see org.hamcrest.CoreMatchers
     * @see org.hamcrest.MatcherAssert
     */
    Asserts<Return> assertThat(Return methodCall, Matcher<? super Return> matcher);

    /**
     * Assert True.
     *
     * @param methodCall the method call
     */
    Asserts<Return> assertTrue(boolean methodCall);

    /**
     * Assert False.
     *
     * @param methodCall
     * @return
     */
    Asserts<Return> assertFalse(boolean methodCall);

    /**
     * Assert equal to.
     *
     * @param <I> the generic type
     * @param methodCall the method call
     * @param expected the expected
     */
    Asserts<Return> assertEqualTo(Return methodCall, Object expected);
}
