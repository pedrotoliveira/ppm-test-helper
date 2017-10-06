package br.com.ppm.test.helper;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.ObjectFactory;

/**
 * Expose Fixture Methods for Default Object Creation.
 *
 * @author pedrotoliveira
 */
public interface FixtureTest {

    /**
     * Generate a String based on regex pattern.
     *
     * @param pattern a pattern
     * @return a String
     */
    String regexValue(String pattern);

    /**
     * Generate a randomInt on the specified range.
     *
     * @param start integer start range
     * @param end integer end range
     * @return a number
     */
    int randomInt(int start, int end);

    /**
     * Generate a Random Email
     *
     * @param username an username
     * @return a Valid Email String
     */
    String randomEmail(String username);

    /**
     * Create a Fixture from given class
     *
     * @param clazz a class
     * @return Fixture Factory ObjectFactory
     * @see ObjectFactory
     */
    default ObjectFactory fixtureFrom(Class<?> clazz) {
        return Fixture.from(clazz);
    }
}
