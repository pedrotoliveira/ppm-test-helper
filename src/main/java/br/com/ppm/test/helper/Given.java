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
 * Interface Given Data
 *
 * @author pedrotoliveira
 */
interface Given<DataType> {

    /**
     * Test an Instance and return the Method Invoker.
     *
     * @param testInstance instance object to be tested
     * @return a MethodInvoker without parameters
     */
    <I> MethodInvoker<I, DataType> call(final I testInstance);

    /**
     * Test an Instance and return the Method Invoker.
     *
     * @param testInstance instance object to be tested
     * @return a MethodInvoker without parameters
     */
    default <I> MethodInvoker<I, DataType> invoke(final I testInstance) {
        return call(testInstance);
    }
}
