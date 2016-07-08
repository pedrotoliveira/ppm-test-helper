package br.com.ppm.test.helper;

import org.hamcrest.Matcher;

/**
 * Asserts Operations
 *
 * @author pedrotoliveira
 */
public interface Asserts<ReturnType> {

    /**
     * Assert the return object equal to a object.
     *
     * @param expected the expected object value.
     * @return the return object wrapper.
     */
    ReturnObjectWrapper<ReturnType> assertEqualTo(ReturnType expected);

    /**
     * Assert the result of method execution object equal to a object.
     *
     * @param expected the expected object value.
     * @return the return object wrapper.
     */
    ReturnObjectWrapper<ReturnType> resultIsEqualTo(ReturnType expected);

    /**
     * Assert the return object to the selected matcher.
     * <p/>
     * @param matcher a macther
     * <p/>
     * @return the return object wrapper
     */
    ReturnObjectWrapper<ReturnType> assertReturn(Matcher<? super ReturnType> matcher);

    /**
     * Assert a field of return object to a matcher.
     * <p/>
     * Asserts a field of the object, example: assertReturnField("field1", equalTo("one"));
     * <p/>
     * @param field the field
     * @param matcher a macther
     * <p/>
     * @return the return object wrapper
     */
    ReturnObjectWrapper<ReturnType> assertReturnField(String field, Matcher<?> matcher);

    /**
     * Assert a field of the return object equal to the expected object.
     * <p/>
     * Asserts the fields of the object, example: assertEqualToReturnField("field1", "one");
     * <p/>
     * @param field the field
     * @param expected the expected object to assert
     * <p>
     * @return the return object wrapper
     */
    ReturnObjectWrapper<ReturnType> assertEqualToReturnField(String field, Object expected);

    /**
     * Assert returnObject fields.
     * <p/>
     * Asserts the fields of the object, example: assertReturnFields("field1", equalTo("one"),
     * "field2", equalTo("two"));
     * <p/>
     * @param field the field
     * @param matcher the matcher
     * @param additionalKeyMatcherPairs the additional key matcher pairs
     * <p/>
     * @return the return object wrapper
     */
    ReturnObjectWrapper<ReturnType> assertReturnFields(String field, Matcher<?> matcher, Object... additionalKeyMatcherPairs);

    /**
     * Assert equalTo returnObject fields.
     * <p/>
     * Asserts the fields of the object, example: assertEqualToReturnFields("field1", "one",
     * "field2", "two");
     * <p/>
     * @param field the field
     * @param expected the object to match
     * @param additionalKeyMatcherPairs the additional key matcher pairs
     * <p/>
     * @return the return object wrapper
     */
    ReturnObjectWrapper<ReturnType> assertEqualToReturnFields(String field, Object expected, Object... additionalKeyMatcherPairs);

    /**
     * Assert that.
     *
     * @param <ReturnType> the generic type
     * @param methodCall the method call
     * @param matcher the matcher
     */
    Asserts<ReturnType> assertThat(ReturnType methodCall, Matcher<? super ReturnType> matcher);

    /**
     * Assert True.
     *
     * @param methodCall the method call
     */
    Asserts<ReturnType> assertTrue(boolean methodCall);

    /**
     * Assert False.
     *
     * @param methodCall
     * @return
     */
    Asserts<ReturnType> assertFalse(boolean methodCall);

    /**
     * Assert equal to.
     *
     * @param <I> the generic type
     * @param methodCall the method call
     * @param expected the expected
     */
    Asserts<ReturnType> assertEqualTo(ReturnType methodCall, Object expected);
}
