package br.com.ppm.test.helper;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
 * The Method Invoker Class
 *
 * @param <D> the type of Given Data to the Method Invoker
 * @author pedrotoliveira
 */
public class MethodInvoker<D> {

	/** The test instance. */
	private final Object testInstance;
	/** The given data. */
	private final D givenData;

	/**
	 * Instantiates a new method invoker.
	 *
	 * @param testInstance the test instance
	 * @param givenData the given data
	 */
	MethodInvoker(final Object testInstance, final D givenData) {
		this.testInstance = testInstance;
		this.givenData = givenData;
	}

	/**
	 * Method.
	 *
	 * @param <R> the generic type
	 * @param methodName the method name
	 * @param returnType the return type
	 * @return the return object wrapper
	 * @throws Exception the exception
	 */
	@SuppressWarnings(value = "unchecked")
	public <R> ReturnObjectWrapper<R> method(final String methodName, Class<R> returnType) throws Exception {
		return (givenData.getClass().isArray())
				? new ReturnObjectWrapper<>((R) invokeMethodMultipleParameters(methodName, (Object[]) givenData))
				: new ReturnObjectWrapper<>((R) invokeMethodSingleParameter(methodName, givenData));
	}

	/**
	 * Invoke method single parameter.
	 *
	 * @param methodName the method name
	 * @param givenData the given data
	 * @return the object
	 * @throws Exception the exception
	 */
	private Object invokeMethodSingleParameter(String methodName, D givenData) throws Exception {
		Method method = getMethodByGivenDataClass(methodName, givenData.getClass());
		return method.invoke(testInstance, givenData);
	}

	/**
	 * Gets the method by given data class.
	 *
	 * @param methodName the method name
	 * @param type the type
	 * @return the method by given data class
	 * @throws Exception the exception
	 */
	private Method getMethodByGivenDataClass(final String methodName, final Class<?> type) throws Exception {
		try {
			return (type == null)
					? testInstance.getClass().getMethod(methodName)
					: testInstance.getClass().getMethod(methodName, type);
		} catch (NoSuchMethodException n) {
			return getMethodByGivenDataClass(methodName, type.getSuperclass());
		}
	}

	/**
	 * Invoke method multiple parameters.
	 *
	 * @param methodName the method name
	 * @param parametersData the parameters data
	 * @return the object
	 * @throws Exception the exception
	 */
	private Object invokeMethodMultipleParameters(String methodName, Object[] parametersData) throws Exception {
		Method method = getMethodMultipleParameters(methodName, parametersData);
		int numbeOfParameters = method.getParameterTypes().length;
		switch (numbeOfParameters) {
			case 1:
				return method.invoke(testInstance, parametersData[0]);
			case 2:
				return method.invoke(testInstance, parametersData[0], parametersData[1]);
			case 3:
				return method.invoke(testInstance, parametersData[0], parametersData[1], parametersData[2]);
			case 4:
				return method.invoke(testInstance, parametersData[0], parametersData[1], parametersData[2], parametersData[3]);
			case 5:
				return method.invoke(testInstance, parametersData[0], parametersData[1], parametersData[2], parametersData[3],
						parametersData[4]);
			case 6:
				return method.invoke(testInstance, parametersData[0], parametersData[1], parametersData[2], parametersData[3],
						parametersData[4], parametersData[5]);
			case 7:
				return method.invoke(testInstance, parametersData[0], parametersData[1], parametersData[2], parametersData[3],
						parametersData[4], parametersData[5], parametersData[6]);
			case 8:
				return method.invoke(testInstance, parametersData[0], parametersData[1], parametersData[2], parametersData[3],
						parametersData[4], parametersData[5], parametersData[6], parametersData[7]);
			case 9:
				return method.invoke(testInstance, parametersData[0], parametersData[1], parametersData[2], parametersData[3],
						parametersData[4], parametersData[5], parametersData[6], parametersData[7], parametersData[8]);
			case 10:
				return method.invoke(testInstance, parametersData[0], parametersData[1], parametersData[2], parametersData[3],
						parametersData[4], parametersData[5], parametersData[6], parametersData[7], parametersData[8],
						parametersData[9]);
			default:
				throw new IllegalStateException("Test method have to many parameters. Plese verify your design!");
		}
	}

	/**
	 * Gets the method multiple parameters.
	 *
	 * @param methodName the method name
	 * @param parametersData the parameters data
	 * @return the method multiple parameters
	 * @throws Exception the exception
	 */
	private Method getMethodMultipleParameters(String methodName, Object[] parametersData) throws Exception {
		List<Class<?>> parameterTypes = new ArrayList<>();
		for (Object o : parametersData) {
			parameterTypes.add(o.getClass());
		}
		return testInstance.getClass().getMethod(methodName, parameterTypes.toArray(new Class<?>[parameterTypes.size()]));
	}
}
