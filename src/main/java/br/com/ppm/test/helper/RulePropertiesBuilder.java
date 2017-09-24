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

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.UUID;

import br.com.six2six.bfgex.Gender;
import br.com.six2six.fixturefactory.base.CalendarInterval;
import br.com.six2six.fixturefactory.base.Range;
import br.com.six2six.fixturefactory.base.Sequence;
import com.mdimension.jchronic.Options;

/**
 * Fixture Property Builder
 *
 * @author pedrotoliveira
 */
public final class RulePropertiesBuilder {

    private final RuleBuilder builder;
    private final String propertyKey;

    public RulePropertiesBuilder(RuleBuilder builder, String propertyKey) {
        this.builder = builder;
        this.propertyKey = propertyKey;
    }

    public RuleBuilder value(Object value) {
        return builder.add(propertyKey, value);
    }

    public RuleBuilder has(int quantity) {
        builder.add(propertyKey, builder.has(quantity));
        return builder;
    }

    public RuleBuilder randomUUID() {
        builder.add(propertyKey, UUID.randomUUID().toString());
        return builder;
    }

    public RuleBuilder one(Class<?> clazz, String label) {
        builder.add(propertyKey, builder.one(clazz, label));
        return builder;
    }

    public RuleBuilder random(Class<?> clazz, Object... dataset) {
        builder.add(propertyKey, builder.random(clazz, dataset));
        return builder;
    }

    public RuleBuilder random(Class<? extends BigDecimal> clazz, MathContext mc) {
        builder.add(propertyKey, builder.random(clazz, mc));
        return builder;
    }

    public RuleBuilder random(Object... dataset) {
        builder.add(propertyKey, builder.random(dataset));
        return builder;
    }

    public RuleBuilder random(Class<?> clazz, Range range) {
        builder.add(propertyKey, builder.random(clazz, range));
        return builder;
    }

    public RuleBuilder uniqueRandom(int minValue, int maxValue) {
        builder.add(propertyKey, builder.uniqueRandom(minValue, maxValue));
        return builder;
    }

    public RuleBuilder uniqueRandom(Object... dataset) {
        builder.add(propertyKey, builder.uniqueRandom(dataset));
        return builder;
    }

    public RuleBuilder uniqueRandom(Class<? extends Enum<?>> clazz) {
        builder.add(propertyKey, builder.uniqueRandom(clazz));
        return builder;
    }

    public RuleBuilder name() {
        builder.add(propertyKey, builder.name());
        return builder;
    }

    public RuleBuilder name(Gender gender) {
        builder.add(propertyKey, builder.name(gender));
        return builder;
    }

    public RuleBuilder firstName() {
        builder.add(propertyKey, builder.firstName());
        return builder;
    }

    public RuleBuilder firstName(Gender gender) {
        builder.add(propertyKey, builder.firstName(gender));
        return builder;
    }

    public RuleBuilder lastName() {
        builder.add(propertyKey, builder.lastName());
        return builder;
    }

    public RuleBuilder beforeDate(String source, SimpleDateFormat format) {
        builder.add(propertyKey, builder.beforeDate(source, format));
        return builder;
    }

    public RuleBuilder afterDate(String source, SimpleDateFormat format) {
        builder.add(propertyKey, builder.afterDate(source, format));
        return builder;
    }

    public RuleBuilder randomDate(String startDate, String endDate, DateFormat format) {
        builder.add(propertyKey, builder.randomDate(startDate, endDate, format));
        return builder;
    }

    public RuleBuilder regex(String regex) {
        builder.add(propertyKey, builder.regex(regex));
        return builder;
    }

    public RuleBuilder range(Number start, Number end) {
        if (start instanceof Integer) {
            builder.add(propertyKey, builder.range(start, end));
        } else {
            builder.add(propertyKey, builder.longRange(start, end));
        }
        return builder;
    }

    public RuleBuilder sequence(Sequence<?> sequence) {
        builder.add(propertyKey, builder.sequence(sequence));
        return builder;
    }

    public RuleBuilder sequence(Number startWith, int incrementBy) {
        builder.add(propertyKey, builder.sequence(startWith, incrementBy));
        return builder;
    }

    public RuleBuilder sequence(Class<? extends Number> clazz) {
        builder.add(propertyKey, builder.sequence(clazz));
        return builder;
    }

    public RuleBuilder sequenceDate(String base, CalendarInterval interval) {
        builder.add(propertyKey, builder.sequenceDate(base, interval));
        return builder;
    }

    public RuleBuilder sequenceDate(String base, DateFormat simpleDateFormat, CalendarInterval interval) {
        builder.add(propertyKey, builder.sequenceDate(base, simpleDateFormat, interval));
        return builder;
    }

    public RuleBuilder instant(String dateText) {
        builder.add(propertyKey, builder.instant(dateText));
        return builder;
    }

    public RuleBuilder instant(String dateText, Options options) {
        builder.add(propertyKey, builder.instant(dateText, options));
        return builder;
    }

    public RuleBuilder cnpj() {
        builder.add(propertyKey, builder.cnpj());
        return builder;
    }

    public RuleBuilder cnpj(boolean formatted) {
        builder.add(propertyKey, builder.cnpj(formatted));
        return builder;
    }

    public RuleBuilder increment(int interval) {
        builder.add(propertyKey, builder.increment(interval));
        return builder;
    }

    public RuleBuilder decrement(int interval) {
        builder.add(propertyKey, builder.decrement(interval));
        return builder;
    }

    public RuleBuilder email() {
        builder.add(propertyKey, Dummies.randomEmail());
        return builder;
    }

}
