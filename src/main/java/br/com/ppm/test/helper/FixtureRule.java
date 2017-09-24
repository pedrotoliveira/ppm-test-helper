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

import br.com.six2six.fixturefactory.Rule;

/**
 * Extracted Interface based on public methods of FF's Rule class.
 *
 * @author pedrotoliveira
 * @see br.com.six2six.fixturefactory.Rule
 * @see
 * <a href="https://github.com/six2six/fixture-factory/blob/master/src/main/java/br/com/six2six/fixturefactory/Rule.java">Github's
 * FixtureFactory</a>
 */
public interface FixtureRule {

    RulePropertiesBuilder add(String property);

    RuleBuilder add(String property, Object value);

    Rule build();

}
