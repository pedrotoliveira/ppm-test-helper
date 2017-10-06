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
import org.hamcrest.MatcherAssert;
import org.junit.Assert;

/**
 * Encapsulates Many Static Assert Functions.
 *
 * @author pedrotoliveira
 */
public class AssertionsWrapper {

    public AssertionsWrapper() {
    }

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
     * @param reason additional information about the error
     * @param <T> the static type accepted by the matcher (this can flag obvious compile-time problems such as
     * {@code assertThat(1, is("a"))}
     * @param actual the computed value being compared
     * @param matcher an expression, built of {@link Matcher}s, specifying allowed values
     * @see org.hamcrest.CoreMatchers
     * @see org.hamcrest.MatcherAssert
     */
    public <T> void assertThat(String reason, T actual,
            Matcher<? super T> matcher) {
        MatcherAssert.assertThat(reason, actual, matcher);
    }

    /**
     * Asserts that a condition is true. If it isn't it throws an {@link AssertionError} with the given message.
     *
     * @param message the identifying message for the {@link AssertionError} (<code>null</code> okay)
     * @param condition condition to be checked
     */
    public void assertTrue(String message, boolean condition) {
        Assert.assertTrue(message, condition);
    }

    /**
     * Asserts that a condition is false. If it isn't it throws an {@link AssertionError} with the given message.
     *
     * @param message the identifying message for the {@link AssertionError} (<code>null</code> okay)
     * @param condition condition to be checked
     */
    public void assertFalse(String message, boolean condition) {
        Assert.assertFalse(message, condition);
    }
}
