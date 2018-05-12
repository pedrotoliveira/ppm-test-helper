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
public class StubbingProvider<ReturnType> implements Stubbing<ReturnType> {

	private final OngoingStubbing<ReturnType> stub;

    public StubbingProvider(ReturnType value) {
        this.stub = Mockito.when(value);
    }

    @Override
    public Stubbing<ReturnType> thenReturn(final ReturnType value) {
        stub.thenReturn(value);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Stubbing<ReturnType> thenReturn(final ReturnType value, final ReturnType... values) {
        stub.thenReturn(value, values);
        return this;
    }

    @Override
    public Stubbing<ReturnType> thenThrow(final Throwable... throwables) {
        stub.thenThrow(throwables);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Stubbing<ReturnType> thenThrow(final Class<? extends Throwable>... throwableClasses) {
        stub.thenThrow(throwableClasses);
        return this;
    }

    @Override
    public Stubbing<ReturnType> thenAnswer(Answer<?> answer) {
        stub.thenAnswer(answer);
        return this;
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
    public <T> Stubbing<T> when(T value) {
        return new StubbingProvider<>(value);
    }

    @Override
    public <D> GivenDataAndStubbing<D, ReturnType> then() {
        return new GivenDataAndStubbing<>(this);
    }
}
