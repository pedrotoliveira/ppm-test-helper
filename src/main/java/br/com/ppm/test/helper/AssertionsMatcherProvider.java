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
public final class AssertionsMatcherProvider<Return> implements TestCaseMatcher<Return> {

    private final Return value;
    private final StringBuilder descriptionBuilder;
    private final Assertions<Return> assertions;

    public AssertionsMatcherProvider(Return value, String description, Assertions<Return> assertions) {
        this.value = value;
        this.descriptionBuilder = new StringBuilder(description);
        this.assertions = assertions;
    }

    @Override
    public TestCaseMatcher<Return> is() {
        return this;
    }

    @Override
    public TestCaseMatcher<Return> as(String description) {
        this.descriptionBuilder.append("|").append(description);
        return this;
    }

    @Override
    public TestCaseMatcher<Return> should(String description) {
        return as(description);
    }

    @Override
    public TestCaseAssertions<Return> isEqual(Return expected) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TestCaseAssertions<Return> isEqualTo(Return expected) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TestCaseAssertions<Return> shouldBeEqual(Return exected) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TestCaseAssertions<Return> shouldBe(Integer exected) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TestCaseAssertions<Return> shouldBe(Long exected) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TestCaseAssertions<Return> shouldBe(Float exected) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TestCaseAssertions<Return> contains(Object... elements) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TestCaseAssertions<Return> isTrue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TestCaseAssertions<Return> isFalse() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TestCaseAssertions<Return> isSameAs(Object expected) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
