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

/**
 *
 * @author pedrotoliveira
 */
public final class TestCaseMatcherProvider implements TestCaseMatcher<Object> {

    private final Object value;
    private final StringBuilder descriptionBuilder;
    private final Assertions<Object> assertions;

    public TestCaseMatcherProvider(Object value, String description, Assertions<Object> assertions) {
        this.value = value;
        this.descriptionBuilder = new StringBuilder(description);
        this.assertions = assertions;
    }

    public String getDescription() {
        return descriptionBuilder.toString();
    }

    @Override
    public TestCaseMatcher<Object> as(String description) {
        this.descriptionBuilder.append("|").append(description);
        return this;
    }

    @Override
    public TestCaseMatcher<Object> should(String description) {
        return as(description);
    }

    @Override
    public TestCaseAssertions<Object> isEqual(Object expected) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TestCaseAssertions<Object> isEqualTo(Object expected) {
        throw new UnsupportedOperationException("Not supported yet.");
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

}
