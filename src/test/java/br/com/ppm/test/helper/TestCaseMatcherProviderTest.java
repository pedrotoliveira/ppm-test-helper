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

import br.com.ppm.test.model.User;

import org.junit.BeforeClass;
import org.junit.Test;

import static br.com.ppm.test.helper.CommonTemplateLabels.VALID;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests of class TestCaseMatcherProvider
 *
 * @author pedrotoliveira
 */
public class TestCaseMatcherProviderTest extends FixtureTestHelper {

    @BeforeClass
    public static void beforeAll() {
        setUpFixtures("br.com.ppm.test.fixtures");
    }

    /**
     * Test of as method, of class TestCaseMatcherProvider.
     */
    @Test
    public void testAs() {
        User user = fixtureFrom(User.class).gimme(VALID);
        TestCaseMatcherProvider matcher = new TestCaseMatcherProvider(user, "test", null);
        matcher.as("As something");
        assertThat(matcher.getDescription()).isEqualTo("test|As something");
    }

    /**
     * Test of should method, of class TestCaseMatcherProvider.
     */
    @Test
    public void testShould() {
        User user = fixtureFrom(User.class).gimme(VALID);
        TestCaseMatcherProvider matcher = new TestCaseMatcherProvider(user, "test", null);
        matcher.as("Should be something");
        assertThat(matcher.getDescription()).isEqualTo("test|Should be something");
    }

    /**
     * Test of isEqual method, of class TestCaseMatcherProvider.
     */
    @Test
    public void testIsEqual() {
    }

    /**
     * Test of isEqualTo method, of class TestCaseMatcherProvider.
     */
    @Test
    public void testIsEqualTo() {
    }

    /**
     * Test of shouldBeEqual method, of class TestCaseMatcherProvider.
     */
    @Test
    public void testShouldBeEqual() {
    }

    /**
     * Test of shouldBe method, of class TestCaseMatcherProvider.
     */
    @Test
    public void testShouldBe_Integer() {
    }

    /**
     * Test of shouldBe method, of class TestCaseMatcherProvider.
     */
    @Test
    public void testShouldBe_Long() {
    }

    /**
     * Test of shouldBe method, of class TestCaseMatcherProvider.
     */
    @Test
    public void testShouldBe_Float() {
    }

    /**
     * Test of contains method, of class TestCaseMatcherProvider.
     */
    @Test
    public void testContains() {
    }

    /**
     * Test of isTrue method, of class TestCaseMatcherProvider.
     */
    @Test
    public void testIsTrue() {
    }

    /**
     * Test of isFalse method, of class TestCaseMatcherProvider.
     */
    @Test
    public void testIsFalse() {
    }

    /**
     * Test of isSameAs method, of class TestCaseMatcherProvider.
     */
    @Test
    public void testIsSameAs() {
    }

}
