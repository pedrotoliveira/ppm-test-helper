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
public interface TestCaseMatcher<Return> {

    /**
     * Is
     *
     * @return return the TestCaseMatcher instance
     */
    TestCaseMatcher<Return> is();

    /**
     * Add a Description to this matcher
     *
     * @param description to be included
     * @return TestCaseMatcher
     */
    TestCaseMatcher<Return> as(String description);

    /**
     * Add a Description to this matcher
     *
     * @param description to be included
     * @return TestCaseMatcher
     */
    TestCaseMatcher<Return> describe(String description);

    /**
     * <p>
     * Assert that the actual object is equal to the given one by comparing actual's properties/fields with other's not
     * null properties/fields only (including inherited ones).
     * </p>
     * <p>
     * It means that if an actual field is not null and the corresponding field in other is null, this field will be
     * ignored in comparison, but the opposite will make assertion fail (null field in actual, not null in other) as the
     * field is used in the performed comparison and the values differ. Note that comparison is not recursive, if one of
     * the field is an Object, itIs will be compared to the other field using its equals method.
     * </p>
     *
     * @param expected expected Object
     * @return TestCaseAssertions
     * @see org.assertj.core.api.AbstractObjectAssert#isEqualToIgnoringNullFields(java.lang.Object)
     */
    TestCaseAssertions<Return> isEqual(Return expected);

    /**
     * Assert the expected Object is equalTo
     *
     * @param expected expected Object
     * @return TestCaseAssertions
     * @see org.hamcrest.CoreMatchers#equalTo(java.lang.Object)
     */
    TestCaseAssertions<Return> isEqualTo(Return expected);

    /**
     * Assert the expected Object is equalTo
     *
     * @param expected expected Object
     * @return TestCaseAssertions
     * @see org.hamcrest.CoreMatchers#equalTo(java.lang.Object)
     */
    TestCaseAssertions<Return> shouldBeEqual(Return expected);

    /**
     * Assert the expected Integer is equalTo
     *
     * @param expected expected Integer
     * @return TestCaseAssertions
     * @see org.hamcrest.CoreMatchers#equalTo(java.lang.Object)
     */
    TestCaseAssertions<Return> shouldBe(Integer expected);

    /**
     * Assert the expected Long is equalTo
     *
     * @param expected expected Integer
     * @return TestCaseAssertions
     * @see org.hamcrest.CoreMatchers#equalTo(java.lang.Object)
     */
    TestCaseAssertions<Return> shouldBe(Long expected);

    /**
     * Assert the expected Float is equalTo
     *
     * @param expected expected Integer
     * @return TestCaseAssertions
     * @see org.hamcrest.CoreMatchers#equalTo(java.lang.Object)
     */
    TestCaseAssertions<Return> shouldBe(Float expected);

    /**
     * Assert if the Collection contains the given elements with the same values
     *
     * @param elements collection elements
     * @return TestCaseAssertions
     */
    TestCaseAssertions<Return> contains(Object... elements);

    /**
     * Assert True
     *
     * @return TestCaseAssertions
     */
    TestCaseAssertions<Return> isTrue();

    /**
     * Assert False
     *
     * @return TestCaseAssertions
     */
    TestCaseAssertions<Return> isFalse();

    /**
     * Assert if the object is the same instance.
     *
     * @param expected expected Object
     * @return TestCaseAssertions
     */
    TestCaseAssertions<Return> isSameAs(Object expected);

}
