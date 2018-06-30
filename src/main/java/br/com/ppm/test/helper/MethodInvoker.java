package br.com.ppm.test.helper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.Optional.empty;

/**
 * The Method Invoker Class
 *
 * @param <I> the type of Test Instance
 * @param <T> the type of Given Data to the Method Invoker
 * @author pedrotoliveira
 */
public final class MethodInvoker<I, T> {

    private final String description;
    private final I instance;
    private final GivenData<T> givenData;

    /**
     * Create a Method Invoker
     *
     * @param description  the test's description
     * @param testInstance the test instance
     */
    public MethodInvoker(String description, I testInstance) {
        this(description, testInstance, null);
    }

    /**
     * Create a Method Invoker
     *
     * @param description  the test's description
     * @param testInstance the test instance
     * @param givenData    given data
     */
    public MethodInvoker(String description, I testInstance, GivenData<T> givenData) {
        this.description = description;
        this.instance = testInstance;
        this.givenData = givenData;
    }

    public Optional<T> getParameters() {
        if (givenData != null && !(givenData.getData() instanceof NoData)) {
            return Optional.ofNullable(givenData.getData());
        }
        return empty();
    }

    /**
     * Invoke a Method in the test instance with the given name and the Expected return Type.
     *
     * @param <R>        type of the return type
     * @param methodName the method name
     * @param returnType the return type
     * @return the return object wrapper
     */
    public <R> ReturnWrapper<R> method(final String methodName, final Class<R> returnType) throws TestDefinitionException {
        R returnValue;
        if (getParameters().isPresent()) {
            T data = getParameters().get();
            if (data.getClass().isArray()) {
                returnValue = invokeMethodMultipleParameters(methodName, (Object[]) data, returnType);
            } else {
                returnValue = invokeMethodSingleParameter(methodName, data, returnType);
            }
        } else {
            returnValue = invokeMethodNoParameters(methodName, returnType);
        }
        return new ReturnWrapper<>(returnValue, description);
    }

    private <R> R invokeMethodNoParameters(String methodName, Class<R> returnType) {
        try {
            Method method = getMethodByGivenDataClass(methodName, null);
            return returnType.cast(method.invoke(instance));
        } catch (IllegalAccessException
                | IllegalArgumentException
                | InvocationTargetException
                | ClassCastException ex) {
            throw new TestDefinitionException("Fail on Invoke: " + methodName, ex);
        }
    }

    private <R> R invokeMethodSingleParameter(final String methodName, final T givenData, final Class<R> type) throws TestDefinitionException {
        try {
            Method method = getMethodByGivenDataClass(methodName, givenData.getClass());
            return type.cast(method.invoke(instance, givenData));
        } catch (IllegalAccessException
                | IllegalArgumentException
                | InvocationTargetException
                | ClassCastException ex) {
            throw new TestDefinitionException("Fail on Invoke: " + methodName, ex);
        }
    }

    private Method getMethodByGivenDataClass(final String methodName, final Class<?> type) {
        try {
            return (type == null)
                    ? instance.getClass().getMethod(methodName)
                    : instance.getClass().getMethod(methodName, type);
        } catch (NoSuchMethodException n) {
            if (type == null) {
                throw new TestDefinitionException("Fail on get Method: " + methodName, n);
            }
            return getMethodByGivenDataClass(methodName, type.getSuperclass());
        }
    }

    private <R> R invokeMethodMultipleParameters(String methodName, Object[] parametersData, final Class<R> type)
            throws TestDefinitionException {
        try {
            Method method = getMethodMultipleParameters(methodName, parametersData);
            int numbeOfParameters = method.getParameterTypes().length;
            switch (numbeOfParameters) {
                case 1:
                    return type.cast(method.invoke(instance, parametersData[0]));
                case 2:
                    return type.cast(method.invoke(instance, parametersData[0], parametersData[1]));
                case 3:
                    return type.cast(method.invoke(instance, parametersData[0], parametersData[1], parametersData[2]));
                case 4:
                    return type.cast(method.invoke(instance, parametersData[0], parametersData[1], parametersData[2],
                            parametersData[3]));
                case 5:
                    return type.cast(method.invoke(instance, parametersData[0], parametersData[1], parametersData[2],
                            parametersData[3], parametersData[4]));
                default:
                    throw new IllegalStateException("Test method have too many parameters. Plese verify your design!");
            }
        } catch (IllegalAccessException
                | IllegalArgumentException
                | InvocationTargetException
                | ClassCastException ex) {
            throw new TestDefinitionException("Fail on Invoke: " + methodName, ex);
        }
    }

    private Method getMethodMultipleParameters(String methodName, Object[] parametersData)
            throws TestDefinitionException {
        try {
            List<Class<?>> parameterTypes = new ArrayList<>();
            for (Object o : parametersData) {
                parameterTypes.add(o.getClass());
            }
            return instance.getClass().getMethod(methodName, parameterTypes.toArray(new Class<?>[0]));
        } catch (NoSuchMethodException | SecurityException ex) {
            throw new TestDefinitionException("Fail on get Method: " + methodName, ex);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.instance);
        hash = 89 * hash + Objects.hashCode(this.givenData);
        return hash;
    }

    @Override
    @SuppressWarnings("PMD.SimplifyBooleanReturns")
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
        final MethodInvoker<?, ?> other = (MethodInvoker<?, ?>) obj;
        if (!Objects.equals(this.instance, other.instance)) {
            return false;
        }
        return Objects.equals(this.givenData, other.givenData);
    }

    @Override
    public String toString() {
        return "MethodInvoker[" + "testInstance=" + instance + ", givenData=" + givenData + ']';
    }
}
