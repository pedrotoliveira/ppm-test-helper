package br.com.ppm.test.helper;

import br.com.ppm.test.util.ReflectionUtil;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.times;

/**
 * The Class ReturnObjectWrapper.
 *
 * @param <I> the generic type
 */
public class ReturnObjectWrapper<I> implements Asserts {

	/**
	 * The return object.
	 */
	private final I returnObject;

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

	/**
	 * Instantiates a new return object wrapper.
	 *
	 * @param returnObject the return object
	 */
	ReturnObjectWrapper(I returnObject) {
		this.returnObject = returnObject;
	}

	/**
	 * Assert the return object equal to a object.
	 *
	 * @param expected the expected object value.
	 * @return the return object wrapper.
	 */
	public ReturnObjectWrapper<I> assertEqualTo(I expected) {
		Assert.assertThat(returnObject, equalTo(expected));
		return this;
	}

	/**
	 * Assert the result of method execution object equal to a object.
	 *
	 * @param expected the expected object value.
	 * @return the return object wrapper.
	 */
	public ReturnObjectWrapper<I> resultIsEqualTo(I expected) {
		return assertEqualTo(expected);
	}

	/**
	 * Assert the return object to the selected matcher.
	 * <p/>
	 * @param matcher a macther
	 * <p/>
	 * @return the return object wrapper
	 */
	public ReturnObjectWrapper<I> assertReturn(Matcher<? super I> matcher) {
		Assert.assertThat(returnObject, matcher);
		return this;
	}

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
	@SuppressWarnings("unchecked")
	public ReturnObjectWrapper<I> assertReturnField(String field, Matcher<?> matcher) {
		Object valueToAssert = ReflectionUtil.getByFieldName(field, returnObject);
		Assert.assertThat(valueToAssert, (Matcher<? super Object>) matcher);
		return this;
	}

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
	@SuppressWarnings("unchecked")
	public ReturnObjectWrapper<I> assertEqualToReturnField(String field, Object expected) {
		assertReturnField(field, equalTo(expected));
		return this;
	}

	/**
	 * Assert returnObject fields.
	 * <p/>
	 * Asserts the fields of the object, example: assertReturnFields("field1", equalTo("one"), "field2", equalTo("two"));
	 * <p/>
	 * @param field the field
	 * @param matcher the matcher
	 * @param additionalKeyMatcherPairs the additional key matcher pairs
	 * <p/>
	 * @return the return object wrapper
	 */
	public ReturnObjectWrapper<I> assertReturnFields(String field, Matcher<?> matcher, Object... additionalKeyMatcherPairs) {
		assertReturnField(field, matcher);

		if (additionalKeyMatcherPairs.length >= 2) {
			String f = (String) additionalKeyMatcherPairs[0];
			@SuppressWarnings("unchecked")
			Matcher<? super Object> m = (Matcher<? super Object>) additionalKeyMatcherPairs[1];

			if (additionalKeyMatcherPairs.length > 2) {
				Object[] matchersPairs = new Object[additionalKeyMatcherPairs.length - 2];
				System.arraycopy(additionalKeyMatcherPairs, 2, matchersPairs, 0, additionalKeyMatcherPairs.length - 2);
				return assertReturnFields(f, m, matchersPairs);
			} else {
				return assertReturnFields(f, m);
			}
		}

		return this;
	}

	/**
	 * Assert equalTo returnObject fields.
	 * <p/>
	 * Asserts the fields of the object, example: assertEqualToReturnFields("field1", "one", "field2", "two");
	 * <p/>
	 * @param field the field
	 * @param expected the object to match
	 * @param additionalKeyMatcherPairs the additional key matcher pairs
	 * <p/>
	 * @return the return object wrapper
	 */
	public ReturnObjectWrapper<I> assertEqualToReturnFields(String field, Object expected, Object... additionalKeyMatcherPairs) {
		return assertEqualToReturnFields(field, equalTo(expected), additionalKeyMatcherPairs);
	}

	/**
	 * Verify Mock Invocations inOrder.
	 * <p>
	 *
	 * @param verifications implementation for all mock invoke verifications.
	 * <p>
	 * @return the verify mock interactions
	 */
	public VerifyMockInteractions inOrder(Verifications verifications) {
		return new VerifyMockInteractions(verifications);
	}

	/**
	 * Verifies certain behavior happened at least once / exact number of times / never. E.g:
	 * <pre class="code"><code class="java">
	 * verify(mock, times(5)).someMethod("was called five times");
	 * <p>
	 * verify(mock, atLeast(2)).someMethod("was called at least two times");
	 * <p>
	 * //you can use flexible argument matchers, e.g: verify(mock, atLeastOnce()).someMethod(<b>anyString()</b>);
	 * </code></pre>
	 * <p>
	 * <b>times(1) is the default</b> and can be omitted
	 * <p>
	 * Arguments passed are compared using <code>equals()</code> method. Read about {@link ArgumentCaptor} or
	 *
	 * @param <M> mock type.
	 * @param mock to be verified
	 * @param mode times(x), atLeastOnce() or never()
	 * <p>
	 * @return mock object itself {@link ArgumentMatcher} to find out other ways of matching / asserting arguments passed.
	 * <p>
	 */
	public <M> M verify(M mock, VerificationMode mode) {
		return Mockito.verify(mock, mode);
	}

	/**
	 * Verifies certain behavior <b>happened once</b>.
	 * <p>
	 * Alias to <code>verify(mock, times(1))</code> E.g:
	 * <pre class="code"><code class="java">
	 * verify(mock).someMethod("some arg");
	 * </code></pre> Above is equivalent to:
	 * <pre class="code"><code class="java">
	 * verify(mock, times(1)).someMethod("some arg");
	 * </code></pre>
	 * <p>
	 * Arguments passed are compared using <code>equals()</code> method. Read about {@link ArgumentCaptor} or
	 *
	 * @param <M> to be verified
	 * @param mock to be verified
	 * <p>
	 * @return mock object itself {@link ArgumentMatcher} to find out other ways of matching / asserting arguments passed.
	 * <p>
	 * Although it is possible to verify a stubbed invocation, usually <b>it's just redundant</b>. Let's say you've stubbed
	 * <code>foo.bar()</code>. If your code cares what <code>foo.bar()</code> returns then something else breaks(often before even
	 * <code>verify()</code> gets executed). If your code doesn't care what <code>get(0)</code> returns then it should not be
	 * stubbed. Not convinced? See <a href="http://monkeyisland.pl/2008/04/26/asking-and-telling">here</a>.
	 * <p>
	 * <p>
	 * See examples in javadoc for {@link Mockito} class
	 * <p>
	 */
	public <M> M verify(M mock) {
		return Mockito.verify(mock, times(1));
	}

	/**
	 * Checks if any of given mocks has any unverified interaction.
	 * <p>
	 * You can use this method after you verified your mocks - to make sure that nothing else was invoked on your mocks.
	 * <p>
	 * See also {@link Mockito#never()} - it is more explicit and communicates the intent well.
	 * <p>
	 * Stubbed invocations (if called) are also treated as interactions.
	 * <p>
	 * A word of <b>warning</b>: Some users who did a lot of classic, expect-run-verify mocking tend to use
	 * <code>verifyNoMoreInteractions()</code> very often, even in every test method. <code>verifyNoMoreInteractions()</code> is
	 * not recommended to use in every test method. <code>verifyNoMoreInteractions()</code> is a handy assertion from the
	 * interaction testing toolkit. Use it only when it's relevant. Abusing it leads to overspecified, less maintainable tests.
	 * You can find further reading
	 * <a href="http://monkeyisland.pl/2008/07/12/should-i-worry-about-the-unexpected/">here</a>.
	 * <p>
	 * This method will also detect unverified invocations that occurred before the test method, for example: in
	 * <code>setUp()</code>, <code>&#064;Before</code> method or in constructor. Consider writing nice code that makes
	 * interactions only in test methods.
	 * <p>
	 * <p>
	 * Example:
	 * <p>
	 * <pre class="code"><code class="java">
	 * //interactions mock.doSomething(); mock.doSomethingUnexpected();
	 * <p>
	 * //verification verify(mock).doSomething();
	 * <p>
	 * //following will fail because 'doSomethingUnexpected()' is unexpected verifyNoMoreInteractions(mock);
	 * <p>
	 * </code></pre>
	 * <p>
	 * See examples in javadoc for {@link Mockito} class
	 * <p>
	 * @param mocks to be verified
	 */
	public void verifyNoMoreInteractions(Object... mocks) {
		Mockito.verifyNoMoreInteractions(mocks);
	}
}
