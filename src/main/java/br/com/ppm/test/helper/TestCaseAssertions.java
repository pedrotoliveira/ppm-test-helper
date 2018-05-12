/*
 * Copyright (c) - PPM Sistemas de Informacao LTDA, Todos os direitos reservados
 *
 * Este arquivo e uma propriedade confidencial da PPM Sistemas de Informacao LTDA.
 * Nenhuma parte do mesmo pode ser copiada, reproduzida, impressa ou transmitida
 * por qualquer meio sem autorizacao expressa e por escrito de um representante
 * legal da PPM Sistemas de Informacao LTDA.
 *
 * All rights reserved
 *
 * This file is a confidential property of PPM Sistemas de Informacao LTDA.
 * No part of this file may be reproduced or copied in any form or by any means
 * without written permisson from an authorized person from PPM Sistemas de Informacao
 * LTDA.
 *
 */
package br.com.ppm.test.helper;

import org.hamcrest.Matcher;

/**
 * Assertions Operations
 *
 * @author pedrotoliveira
 */
public interface TestCaseAssertions<Return> {

    /**
     * Assert True.
     *
     * @param value the method call
     * @return TestCaseAssertions
     */
    TestCaseAssertions<Return> assertTrue(boolean value);

    /**
     * Assert False.
     *
     * @param value
     * @return Assertions
     */
    TestCaseAssertions<Return> assertFalse(boolean value);

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
    TestCaseAssertions<Return> assertThat(Return value, Matcher<? super Return> matcher);

    /**
     * Assert equal to expected object
     *
     * @param value the method call
     * @param expected the expected object
     * @return Assertions
     */
    TestCaseAssertions<Return> assertEqualTo(Return value, Object expected);

    /**
     * Create a TestCaseMatcher to assert return of method call
     *
     * @param value the method call
     * @return TestCaseMatcherProvider
     */
    TestCaseMatcher<Return> assertThat(Return value);

    /**
     * Create a TestCaseMatcher to assert return of method call
     *
     * @param value the method call
     * @return TestCaseMatcherProvider
     */
    TestCaseMatcher<Return> it(Return value);

    /**
     * Create a TestCaseMatcher with given description to assert return of method call
     *
     * @param value the method call
     * @return TestCaseMatcherProvider
     */
    TestCaseMatcher<Return> it(String assertDescription, Return value);

    /**
     * Create a TestCaseMatcher and to match the given exception
     *
     * @param <E> Exception
     * @param value the value
     * @param exception given Exception
     * @return TestCaseMatcher
     */
    <E extends Throwable> TestCaseMatcher<Return> shouldThrow(Return value, E exception);

    /**
     * Match an exception
     *
     * @param exception the Exception class
     * @return ExceptionMatcher
     * @throws E
     */
    <E extends Throwable> ExceptionMatcher<E> a(Class<E> exception) throws E;

    /**
     * Match an exception
     *
     * @param Class<E> the Exception class
     * @return ExceptionMatcher
     * @throws E
     */
    <E extends Throwable> ExceptionMatcher<E> itThrow(Class<E> exception) throws E;

}
