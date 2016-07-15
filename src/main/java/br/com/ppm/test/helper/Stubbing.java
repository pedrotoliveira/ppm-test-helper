/*
 * Copyright 2016 Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.ppm.test.helper;

import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;

/**
 *
 * @author pedrotoliveira
 */
public class Stubbing<ReturnType> implements StubbingWrapper<ReturnType> {
        
	private final OngoingStubbing<ReturnType> stub;
    private ReturnType[] values;

    public Stubbing(ReturnType methodCall) {
        this.stub = Mockito.when(methodCall);
    }

    @Override
    public OngoingStubbing<ReturnType> thenReturn(final ReturnType value) {
        return stub.thenReturn(value);
    }

    @Override
    @SuppressWarnings("unchecked")
    public OngoingStubbing<ReturnType> thenReturn(final ReturnType value, final ReturnType... values) {
        return stub.thenReturn(value, this.values);
    }

    @Override
    public OngoingStubbing<ReturnType> thenThrow(final Throwable... throwables) {
        return stub.thenThrow(throwables);
    }

    @Override
    @SuppressWarnings("unchecked")
    public OngoingStubbing<ReturnType> thenThrow(final Class<? extends Throwable>... throwableClasses) {
        return stub.thenThrow(throwableClasses);
    }

    @Override
    public OngoingStubbing<ReturnType> thenAnswer(Answer<?> answer) {
        return stub.thenAnswer(answer);
    }

    @Override
    public OngoingStubbing<ReturnType> then(Answer<?> answer) {
        return (OngoingStubbing<ReturnType>) stub.then(answer);
    }

    @Override
    public <M> M getMock() {
        return stub.getMock();
    }    

    @Override
    public <T> StubbingWrapper<T> when(T methodCall) {
        return new Stubbing<>(methodCall);
    }

    @Override
    public <D> GivenDataAndStubbing<D, ReturnType> then() {
        return new GivenDataAndStubbing<>(new NoDataGiven(), this);
    }

    @Override
    public OngoingStubbing<ReturnType> thenCallRealMethod() {        
        //TODO: Study utility of this method.
        throw new UnsupportedOperationException("I have no reason for use this method.");
    }
}