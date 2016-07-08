package br.com.ppm.test.helper;

import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;

/**
 * GivenData and Stubs.
 *
 * @author pedrotoliveira
 */
public final class GivenDataAndStubbing<D, T> implements StubbingWrapper<T> {

    private final GivenData<D> givenData;
    private final StubbingWrapper<T> stub;
    private T[] values;

    public GivenDataAndStubbing(GivenData<D> givenData, T methodCall) {
        this(givenData, new Stubbing<>(methodCall));
    }

    public GivenDataAndStubbing(GivenData<D> givenData, StubbingWrapper<T> stub) {
        this.givenData = givenData;
        this.stub = stub;
    }

    protected GivenData<D> getGivenData() {
        return givenData;
    }

    protected StubbingWrapper<T> getStub() {
        return stub;
    }

    public GivenData<D> returnValue(T value) {
        stub.thenReturn(value);
        return getGivenData();
    }
    
    public GivenData willReturn(T value) {
        return returnValue(value);
    }

    @Override
    public OngoingStubbing<T> thenReturn(final T value) {
        return stub.thenReturn(value);
    }

    @Override
    @SuppressWarnings("unchecked")
    public OngoingStubbing<T> thenReturn(final T value, final T... values) {
        return stub.thenReturn(value, this.values);
    }

    @Override
    public OngoingStubbing<T> thenThrow(final Throwable... throwables) {
        return stub.thenThrow(throwables);
    }

    @Override
    @SuppressWarnings("unchecked")
    public OngoingStubbing<T> thenThrow(final Class<? extends Throwable>... throwableClasses) {
        return stub.thenThrow(throwableClasses);
    }

    @Override
    public OngoingStubbing<T> thenCallRealMethod() {
        return thenCallRealMethod();
    }

    @Override
    public OngoingStubbing<T> thenAnswer(Answer<?> answer) {
        return stub.thenAnswer(answer);
    }

    @Override
    public OngoingStubbing<T> then(Answer<?> answer) {
        return (OngoingStubbing<T>) stub.then(answer);
    }

    @Override
    public <M> M getMock() {
        return stub.getMock();
    }

    @Override
    public GivenDataAndStubbing<D, T> then() {
        return this;
    }

    @Override
    public <T> StubbingWrapper<T> when(T methodCall) {
        return new GivenDataAndStubbing<>(givenData, methodCall);
    }
}
