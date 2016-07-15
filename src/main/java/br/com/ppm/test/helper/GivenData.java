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

import java.util.Objects;

/**
 * The Class GivenData.
 *
 * @param <DataType> the generic type - Given Data
 */
public class GivenData<DataType> implements Expectations {

    /**
     * The Test description.
     */
    private final String description;
    /**
     * The given data.
     */
    private final DataType data;

    /**
     * Instantiates a new given data.
     *
     * @param data the given data
     * @param description the description
     */
    public GivenData(final DataType data, final String description) {
        super();
        this.data = data;
        this.description = description;
    }

    @Override
    public MethodInvoker<DataType> test(final Object testInstance) {
        return new MethodInvoker<DataType>(testInstance, this, description);
    }

    @Override
    public <ReturnType> StubbingWrapper<ReturnType> when(final ReturnType methodCall) {
        return new GivenDataAndStubbing<DataType, ReturnType>(this, methodCall);
    }

    @Override
    public <ReturnType> ReturnObjectWrapper<ReturnType> wrapResult(final ReturnType methodCall) {
        return new ReturnObjectWrapper<>(methodCall, description);
    }

    public String getDescription() {
        return description;
    }

    public DataType getData() {
        return data;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.description);
        hash = 71 * hash + Objects.hashCode(this.data);
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
        final GivenData<?> other = (GivenData<?>) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GivenData [" + "description=" + description + ", data=" + data + ']';
    }
}
