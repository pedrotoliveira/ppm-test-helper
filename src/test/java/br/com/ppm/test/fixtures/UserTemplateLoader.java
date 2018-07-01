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
package br.com.ppm.test.fixtures;

import br.com.ppm.test.helper.FixtureTemplateLoader;
import br.com.ppm.test.model.Address;
import br.com.ppm.test.model.User;

/**
 * User Template Loader
 *
 * @author pedrotoliveira
 */
public class UserTemplateLoader implements FixtureTemplateLoader<User> {

    @Override
    public void load() {
        validTemplate(ruleBuilder()
                .add("id").randomUUID()
                .add("name").name()
                .add("email").email()
                .add("address").one(Address.class, VALID)
                .build());
    }
}
