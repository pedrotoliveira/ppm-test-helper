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

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

/**
 *
 * @author pedrotoliveira
 */
public interface FixtureTemplateLoader<T> extends CommonTemplateLabels {

    default RuleBuilder ruleBuilder() {
        return new RuleBuilder();
    }

    default void validTemplate(Rule rule) {
        Fixture.of(this.getClass().getTypeParameters()[0].getClass()).addTemplate(VALID, rule);
    }

    default void invalidTemplate(Rule rule) {
        Fixture.of(this.getClass().getTypeParameters()[0].getClass()).addTemplate(INVALID, rule);
    }
}