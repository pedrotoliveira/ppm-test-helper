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

import br.com.six2six.fixturefactory.function.impl.NameFunction;
import br.com.six2six.fixturefactory.function.impl.RandomFunction;

/**
 * Common Test Dummies
 *
 * @author pedrotoliveira
 */
public final class Dummies {

    private static final String[] DOMAINS = {
        "google.com",
        "ppm.com.br",
        "github.io",
        "gov.br",
        "sonatype.org",
        "spring.io"
    };

    public static String randomEmail() {
        String name = new NameFunction().generateValue();
        return name.trim().toLowerCase().replaceAll(" ", ".").concat("@").concat(random(DOMAINS));
    }

    public static String randomEmailBy(String username) {
        Objects.requireNonNull(username, "username can not be null.");
        return username.concat("@").concat(random(DOMAINS));
    }

    public static String random(String[] dataset) {
        return new RandomFunction(dataset).generateValue();
    }

}
