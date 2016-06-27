package br.com.ppm.test.helper;

import br.com.six2six.fixturefactory.base.Range;
import br.com.six2six.fixturefactory.function.impl.RandomFunction;
import br.com.six2six.fixturefactory.function.impl.RegexFunction;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import java.lang.invoke.MethodHandles;
import org.junit.BeforeClass;

/**
 * Fixture Test Helper
 *
 * @author pedrotoliveira
 */
public abstract class FixtureTestHelper implements FixtureTest {

	@BeforeClass
	public static void setUpFixtures() {
		Class<?> currentClass = MethodHandles.lookup().lookupClass();
		FixtureFactoryLoader.loadTemplates(currentClass.getPackage().getName());
	}

	public int randomInt(int start, int end) {
		return new RandomFunction(Integer.class, new Range(start, end)).generateValue();
	}

	public String regexValue(String pattern) {
		return new RegexFunction(pattern).generateValue();
	}
}
