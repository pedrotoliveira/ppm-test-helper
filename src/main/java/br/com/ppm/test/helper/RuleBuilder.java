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

import br.com.six2six.bfgex.Gender;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.base.CalendarInterval;
import br.com.six2six.fixturefactory.base.Interval;
import br.com.six2six.fixturefactory.base.Range;
import br.com.six2six.fixturefactory.base.Sequence;
import br.com.six2six.fixturefactory.function.AssociationFunction;
import br.com.six2six.fixturefactory.function.Chainable;
import br.com.six2six.fixturefactory.function.DateFunction;
import br.com.six2six.fixturefactory.function.Function;
import com.mdimension.jchronic.Options;

/**
 * A Fixture Factory Rule Builder
 *
 * @author pedrotoliveira
 */
public final class RuleBuilder implements FixtureRule {

    private final Rule rule;

    public RuleBuilder() {
        this.rule = new Rule();
    }

    public RuleBuilder(Rule rule) {
        this.rule = rule;
    }

    public RuleBuilder(Rule baseRule, Rule extendRule) {
        this.rule = new Rule(baseRule, extendRule);
    }

    @Override
    public RulePropertiesBuilder add(String property) {
        return new RulePropertiesBuilder(this, property);
    }

    @Override
    public RuleBuilder add(String property, Object value) {
        rule.add(property, value);
        return this;
    }

    void add(String property, Function function) {
        rule.add(property, function);
    }

    Chainable has(int quantity) {
        return rule.has(quantity);
    }

    AssociationFunction one(Class<?> clazz, String label) {
        return rule.one(clazz, label);
    }

    Function random(Class<?> clazz, Object... dataset) {
        return rule.random(clazz, dataset);
    }

    Function random(Class<? extends BigDecimal> clazz, MathContext mc) {
        return rule.random(clazz, mc);
    }

    Function random(Object... dataset) {
        return rule.random(dataset);
    }

    Function random(Class<?> clazz, Range range) {
        return rule.random(clazz, range);
    }

    Function uniqueRandom(int minValue, int maxValue) {
        return rule.uniqueRandom(minValue, maxValue);
    }

    Function uniqueRandom(Object... dataset) {
        return rule.uniqueRandom(dataset);
    }

    Function uniqueRandom(Class<? extends Enum<?>> clazz) {
        return rule.uniqueRandom(clazz);
    }

    Function name() {
        return rule.name();
    }

    Function name(Gender gender) {
        return rule.name(gender);
    }

    Function firstName() {
        return rule.firstName();
    }

    Function firstName(Gender gender) {
        return rule.firstName(gender);
    }

    Function lastName() {
        return rule.lastName();
    }

    Function beforeDate(String source, SimpleDateFormat format) {
        return rule.beforeDate(source, format);
    }

    Function afterDate(String source, SimpleDateFormat format) {
        return rule.afterDate(source, format);
    }

    Function randomDate(String startDate, String endDate, DateFormat format) {
        return rule.randomDate(startDate, endDate, format);
    }

    Function regex(String regex) {
        return rule.regex(regex);
    }

    Range range(Number start, Number end) {
        return rule.range(start, end);
    }

    Function sequence(Sequence<?> sequence) {
        return rule.sequence(sequence);
    }

    Function sequence(Number startWith, int incrementBy) {
        return rule.sequence(startWith, incrementBy);
    }

    Function sequence(Class<? extends Number> clazz) {
        return rule.sequence(clazz);
    }

    Function sequenceDate(String base, CalendarInterval interval) {
        return rule.sequenceDate(base, interval);
    }

    Function sequenceDate(String base, DateFormat simpleDateFormat, CalendarInterval interval) {
        return rule.sequenceDate(base, simpleDateFormat, interval);
    }

    DateFunction instant(String dateText) {
        return rule.instant(dateText);
    }

    Function instant(String dateText, Options options) {
        return rule.instant(dateText, options);
    }

    Function cnpj() {
        return rule.cnpj();
    }

    Function cnpj(boolean formatted) {
        return rule.cnpj(formatted);
    }

    Interval increment(int interval) {
        return rule.increment(interval);
    }

    Interval decrement(int interval) {
        return rule.decrement(interval);
    }

    @Override
    public final Rule build() {
        return rule;
    }
}
