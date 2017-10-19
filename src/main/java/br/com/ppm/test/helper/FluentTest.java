package br.com.ppm.test.helper;

/**
 * The Interface FluentTest.
 *
 * @author pedrotoliveira
 */
public interface FluentTest {

    /**
     * Start a new TestCase with given description
     *
     * @param description the description
     *
     * @return the testCase
     */
    TestCase testCase(final String description);

    /**
     * Start a new TestCase with given description
     *
     * @param description
     * @return
     */
    TestCase describe(final String description);
}
