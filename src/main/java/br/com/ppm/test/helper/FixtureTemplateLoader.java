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

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import static org.assertj.core.util.Arrays.isNullOrEmpty;

/**
 *
 * @author pedrotoliveira
 */
public interface FixtureTemplateLoader<T> extends CommonTemplateLabels {

    default RuleBuilder ruleBuilder() {
        return new RuleBuilder();
    }

    default ParameterizedType extractParameterizedType() {
        Type[] genericInterfaces = getClass().getGenericInterfaces();
        if (isNullOrEmpty(genericInterfaces)) {
            throw new IllegalStateException("Can't find Generic Interfaces");
        }
        for (Type type : genericInterfaces) {
            if (type instanceof ParameterizedTypeImpl) {
                return (ParameterizedTypeImpl) type;
            }
        }
        throw new IllegalStateException("Can't find a ParameterizedType");
    }

    default Class<?> extractTypeArgumentClass() {
        ParameterizedType parameterizedType = extractParameterizedType();
        if (isNullOrEmpty(parameterizedType.getActualTypeArguments())) {
            throw new IllegalStateException("Can't find Type Arguments");
        }
        return (Class<?>) parameterizedType.getActualTypeArguments()[0];
    }

    default void validTemplate(Rule rule) {
        Class<?> typeClass = extractTypeArgumentClass();
        Fixture.of(typeClass).addTemplate(VALID, rule);
    }

    default void invalidTemplate(Rule rule) {
        Class<?> typeClass = extractTypeArgumentClass();
        Fixture.of(typeClass).addTemplate(INVALID, rule);
    }
}
