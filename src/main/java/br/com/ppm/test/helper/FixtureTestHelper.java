package br.com.ppm.test.helper;

import java.lang.invoke.MethodHandles;

import br.com.six2six.fixturefactory.base.Range;
import br.com.six2six.fixturefactory.function.impl.RandomFunction;
import br.com.six2six.fixturefactory.function.impl.RegexFunction;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

/**
 * Fixture Test Helper
 *
 * @author pedrotoliveira
 */
public abstract class FixtureTestHelper implements FixtureTest {

    public static void setUpFixtures() {
        Class<?> currentClass = MethodHandles.lookup().lookupClass();
        FixtureFactoryLoader.loadTemplates(currentClass.getPackage().getName());
    }

    public static void setUpFixtures(String templatePackage) {
        FixtureFactoryLoader.loadTemplates(templatePackage);
    }

    @Override
    public int randomInt(int start, int end) {
        return new RandomFunction(Integer.class, new Range(start, end)).generateValue();
    }

    @Override
    public String regexValue(String pattern) {
        return new RegexFunction(pattern).generateValue();
    }

    @Override
    public String randomEmail(String username) {
        return Dummies.randomEmailBy(username);
    }
}
