package br.com.ppm.test.helper;

import org.mockito.InOrder;
import org.mockito.Mockito;

/**
 * The Class FluentTestHelper.
 * <p>
 * @author pedrotoliveira
 */
public abstract class FluentTestHelper extends FixtureTestHelper implements FluentTest {

    @Override
    public TestCase testCase(String description) {
        return new TestCase(description);
    }

    @Override
    public TestCase describe(String description) {
        return testCase(description);
    }

    /**
     * Delegates to Mockito#inOrder.
     *
     * @param mocks
     * @return InOrder
     */
    public InOrder inOrder(Object... mocks) {
        return Mockito.inOrder(mocks);
    }
}
