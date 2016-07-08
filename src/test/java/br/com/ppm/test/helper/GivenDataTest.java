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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pedrotoliveira
 */
public class GivenDataTest {
    
    public GivenDataTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testTest() {
        System.out.println("test");
        Object testInstance = null;
        GivenData instance = null;
        MethodInvoker expResult = null;
        MethodInvoker result = instance.test(testInstance);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testWhen() throws Exception {
        System.out.println("when");
        Object methodCall = null;
        GivenData instance = null;
        StubbingWrapper expResult = null;
        StubbingWrapper result = instance.when(methodCall);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testWrapResult() {
        System.out.println("wrapResult");
        Object methodCall = null;
        GivenData instance = null;
        ReturnObjectWrapper expResult = null;
        ReturnObjectWrapper result = instance.wrapResult(methodCall);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}
