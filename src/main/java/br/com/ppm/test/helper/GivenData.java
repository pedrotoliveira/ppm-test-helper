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

/**
 * The Class GivenData.
 *
 * @param <D> the generic type - Given Data
 */
public class GivenData<D> implements Expectations {

    /**
     * The Test description.
     */
    private final String description;
    /**
     * The given data.
     */
    private final D givenData;

    /**
     * Instantiates a new given data.
     *
     * @param givenData the given data
     * @param description the description
     */
    public GivenData(final D givenData, final String description) {
        super();
        this.givenData = givenData;
        this.description = description;
    }

    @Override
    public MethodInvoker<D> test(final Object testInstance) {
        return new MethodInvoker<D>(testInstance, givenData, description);
    }

    @Override
    public <T> StubbingWrapper<T> when(final T methodCall) {
        return new GivenDataAndStubbing<D, T>(this, methodCall);
    }

    @Override
    public <I> ReturnObjectWrapper<I> wrapResult(I methodCall) {
        return new ReturnObjectWrapper<>(methodCall, description);
    }
}
