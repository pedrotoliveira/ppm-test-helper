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

import java.util.Objects;

/**
 * TestCase Matcher
 *
 * @author pedrotoliveira
 */
public final class TestCaseMatcherProvider implements TestCaseMatcher<Object> {

    private final Object value;
    private final StringBuilder descriptionBuilder;
    private final TestCaseAssertions<Object> asserts;

    public TestCaseMatcherProvider(Object value, String description, TestCaseAssertions<Object> asserts) {
        this.value = value;
        this.descriptionBuilder = new StringBuilder(description);
        this.asserts = asserts;
    }

    public String getDescription() {
        return descriptionBuilder.toString();
    }

    @Override
    public TestCaseMatcher<Object> is() {
        return this;
    }

    @Override
    public TestCaseMatcher<Object> as(String description) {
        descriptionBuilder.append("|").append(description);
        return this;
    }

    @Override
    public TestCaseMatcher<Object> should(String description) {
        return as(description);
    }

    @Override
    public TestCaseAssertions<Object> isEqual(Object expected) {
        asserts.assertThat(value).isEqualTo(expected);
        return asserts;
    }

    @Override
    public TestCaseAssertions<Object> isEqualTo(Object expected) {
        return isEqual(expected);
    }

    @Override
    public TestCaseAssertions<Object> shouldBeEqual(Object exected) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TestCaseAssertions<Object> shouldBe(Integer exected) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TestCaseAssertions<Object> shouldBe(Long exected) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TestCaseAssertions<Object> shouldBe(Float exected) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TestCaseAssertions<Object> contains(Object... elements) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TestCaseAssertions<Object> isTrue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TestCaseAssertions<Object> isFalse() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TestCaseAssertions<Object> isSameAs(Object expected) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.value);
        hash = 23 * hash + Objects.hashCode(this.descriptionBuilder);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TestCaseMatcherProvider other = (TestCaseMatcherProvider) obj;
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        if (!Objects.equals(this.descriptionBuilder, other.descriptionBuilder)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TestCaseMatcherProvider[" + "value=" + value + ", descriptionBuilder=" + descriptionBuilder + ']';
    }
}
