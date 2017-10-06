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
import br.com.ppm.test.samples.model.Address;

/**
 * Address Template Loader
 *
 * @author pedrotoliveira
 */
public class AddressTemplateLoader implements FixtureTemplateLoader<Address> {

    @Override
    public void load() {
        validTemplate(ruleBuilder()
                .add("street").random("Paulista Avenue", "Ibirapuera Avenue")
                .add("city").value("Sao Paulo")
                .add("number").range(1, 2000)
                .add("state").value("SP")
                .add("zipcode").random("06608000", "17720000")
                .add("country").value("Brazil")
                .build());
    }

}
