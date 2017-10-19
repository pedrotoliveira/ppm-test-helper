package br.com.ppm.test.helper;

import java.util.Arrays;
import java.util.Objects;

import org.mockito.stubbing.Answer;

/**
 * GivenData and Stubs.
 *
 * @author pedrotoliveira
 */
public final class GivenDataAndStubbing<GivenDataType, ReturnType> implements Stubbing<ReturnType> {

    private final GivenData<GivenDataType> givenData;
    private final Stubbing<ReturnType> stub;
    private ReturnType[] values;

    public GivenDataAndStubbing(GivenData<GivenDataType> givenData, Stubbing<ReturnType> stub) {
        this.givenData = givenData;
        this.stub = stub;
    }

    public GivenDataAndStubbing(Stubbing<ReturnType> stub) {
        this(null, stub);
    }

    public GivenDataAndStubbing(GivenData<GivenDataType> givenData, ReturnType methodCall) {
        this(givenData, new StubbingProvider<>(methodCall));
    }

    protected GivenData<GivenDataType> getGivenData() {
        return givenData;
    }

    protected Stubbing<ReturnType> getStub() {
        return stub;
    }

    public GivenData<GivenDataType> returnValue(ReturnType value) {
        stub.thenReturn(value);
        return getGivenData();
    }

    public GivenData<GivenDataType> willReturn(ReturnType value) {
        return returnValue(value);
    }

    @Override
    public Stubbing<ReturnType> thenReturn(final ReturnType value) {
        return stub.thenReturn(value);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Stubbing<ReturnType> thenReturn(final ReturnType value, final ReturnType... values) {
        return stub.thenReturn(value, this.values);
    }

    @Override
    public Stubbing<ReturnType> thenThrow(final Throwable... throwables) {
        return stub.thenThrow(throwables);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Stubbing<ReturnType> thenThrow(final Class<? extends Throwable>... throwableClasses) {
        return stub.thenThrow(throwableClasses);
    }

    @Override
    public Stubbing<ReturnType> thenAnswer(final Answer<?> answer) {
        return stub.thenAnswer(answer);
    }

    @Override
    public Stubbing<ReturnType> then(Answer<?> answer) {
        return thenAnswer(answer);
    }

    @Override
    public <M> M getMock() {
        return stub.getMock();
    }

    @Override
    @SuppressWarnings("unchecked")
    public GivenDataAndStubbing<GivenDataType, ReturnType> then() {
        return this;
    }

    @Override
    public <T> Stubbing<T> when(T methodCall) {
        return new GivenDataAndStubbing<>(givenData, methodCall);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.givenData);
        hash = 79 * hash + Objects.hashCode(this.stub);
        hash = 79 * hash + Arrays.deepHashCode(this.values);
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
        final GivenDataAndStubbing<?, ?> other = (GivenDataAndStubbing<?, ?>) obj;
        if (!Objects.equals(this.givenData, other.givenData)) {
            return false;
        }
        if (!Objects.equals(this.stub, other.stub)) {
            return false;
        }
        if (!Arrays.deepEquals(this.values, other.values)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GivenDataAndStubbing["
                + "givenData=" + givenData
                + ", stub=" + stub
                + ", values=" + values + ']';
    }
}
