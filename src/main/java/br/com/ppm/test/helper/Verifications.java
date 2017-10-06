package br.com.ppm.test.helper;

import org.mockito.verification.VerificationMode;

/**
 * Group a InOrder verification Behavior of Mocks
 *
 * @author pedrotoliveira
 */
public interface Verifications {

    /**
     * Verifies certain behavior happened at least once / exact number of times / never. E.g:
     * <p>
     * <pre class="code"><code class="java">
     * verify(mock, times(5)).someMethod("was called five times");
     *
     * verify(mock, atLeast(2)).someMethod("was called at least two times");
     *
     * //you can use flexible argument matchers, e.g: verify(mock, atLeastOnce()).someMethod(<b>anyString()</b>);
     * </code></pre>
     * <b>times(1) is the default</b> and can be omitted
     * </p>
     * <p>
     * Arguments passed are compared using <code>equals()</code> method. Read about ArgumentCaptor
     * </p>
     *
     * @param <M> mock type.
     * @param mock to be verified
     * @param mode times(x), atLeastOnce() or never()
     * @return mock object itself ArgumentMatcher to find out other ways of matching asserting arguments passed.
     */
    <M> M verify(M mock, VerificationMode mode);

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
     * Arguments passed are compared using <code>equals()</code> method. Read about ArgumentCaptor or
     *
     * @param <M> to be verified
     * @param mock to be verified
     * <p>
     * @return mock object itself ArgumentMatcher to find out other ways of matching / asserting arguments passed.
     * <p>
     * Although it is possible to verify a stubbed invocation, usually <b>it's just redundant</b>. Let's say you've
     * stubbed <code>foo.bar()</code>. If your code cares what <code>foo.bar()</code> returns then something else
     * breaks(often before even <code>verify()</code> gets executed). If your code doesn't care what <code>get(0)</code>
     * returns then it should not be stubbed. Not convinced? See
     * <a href="http://monkeyisland.pl/2008/04/26/asking-and-telling">here</a>.
     * <p>
     * <p>
     * See examples in javadoc for Mockito class
     * <p>
     */
    <M> M verify(M mock);

    /**
     * Checks if any of given mocks has any unverified interaction.
     * <p>
     * You can use this method after you verified your mocks - to make sure that nothing else was invoked on your mocks.
     * <p>
     * See also Mockito#never() - it is more explicit and communicates the intent well.
     * <p>
     * Stubbed invocations (if called) are also treated as interactions.
     * <p>
     * A word of <b>warning</b>: Some users who did a lot of classic, expect-run-verify mocking tend to use
     * <code>verifyNoMoreInteractions()</code> very often, even in every test method.
     * <code>verifyNoMoreInteractions()</code> is not recommended to use in every test method.
     * <code>verifyNoMoreInteractions()</code> is a handy assertion from the interaction testing toolkit. Use it only
     * when it's relevant. Abusing it leads to overspecified, less maintainable tests. You can find further reading
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
     * See examples in javadoc for Mockito class
     * <p>
     * @param mocks to be verified
     */
    void verifyNoMoreInteractions(Object... mocks);

}
