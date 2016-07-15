package br.com.ppm.test.helper;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The Method Invoker Class
 *
 * @param <GivenDataType> the type of Given Data to the Method Invoker
 * @author pedrotoliveira
 */
public class MethodInvoker<GivenDataType> {

    /**
     * The test description
     */
    private final String description;
    private final Object testInstance;
    private final GivenData<GivenDataType> givenData;

    /**
     * Instantiates a new method invoker.
     *
     * @param testInstance the test instance
     * @param a givenData the given data
     */
    MethodInvoker(final Object testInstance, final GivenData<GivenDataType> givenData, final String description) {
        this.testInstance = testInstance;
        this.givenData = givenData;
        this.description = description;
    }

    /**
     * Method.
     *
     * @param <ReturnType> the generic type
     * @param methodName the method name
     * @param returnType the return type
     * @return the return object wrapper
     */
    @SuppressWarnings(value = "unchecked")
    public <ReturnType> ReturnObjectWrapper<ReturnType> method(final String methodName, Class<ReturnType> returnType) {
        try {
            GivenDataType data = givenData.getData();
            return (data.getClass().isArray())
                    ? new ReturnObjectWrapper<>((ReturnType) invokeMethodMultipleParameters(methodName, (Object[]) data), description)
                    : new ReturnObjectWrapper<>((ReturnType) invokeMethodSingleParameter(methodName, data), description);
        } catch (Exception ex) {
            //FIXME: handle exception.
            throw new RuntimeException(ex);
        }
    }

    /**
     * Invoke method single parameter.
     *
     * @param methodName the method name
     * @param givenData the given data
     * @return the object
     * @throws Exception the exception
     */
    private Object invokeMethodSingleParameter(String methodName, GivenDataType givenData) throws Exception {
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
                throw new IllegalStateException("Test method have too many parameters. Plese verify your design!");
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.description);
        hash = 71 * hash + Objects.hashCode(this.testInstance.getClass());
        hash = 71 * hash + Objects.hashCode(this.givenData);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MethodInvoker<?> other = (MethodInvoker<?>) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.testInstance.getClass(), other.testInstance.getClass())) {
            return false;
        }
        if (!Objects.equals(this.givenData, other.givenData)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MethodInvoker["
                + "description=" + description
                + ", testInstance=" + testInstance
                + ", givenData=" + givenData + ']';
    }
}
