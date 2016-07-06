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
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;

import static org.junit.Assert.*;

/**
 *
 * @author pedrotoliveira
 */
public class StepTest {
    
    public StepTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testExecute() {
        System.out.println("execute");
        Step instance = null;
        instance.execute();
        fail("The test case is a prototype.");
    }

    @Test
    public void testExecution() throws Exception {
        System.out.println("execution");
        Object[] mocks = null;
        Step instance = null;
        instance.execution(mocks);
        fail("The test case is a prototype.");
    }

    @Test
    public void testThenReturn_GenericType() {
        System.out.println("thenReturn");
        Object value = null;
        Step instance = null;
        OngoingStubbing expResult = null;
        OngoingStubbing result = instance.thenReturn(value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testThenReturn_GenericType_GenericType() {
        System.out.println("thenReturn");
        Object value = null;
        Object[] values = null;
        Step instance = null;
        OngoingStubbing expResult = null;
        OngoingStubbing result = instance.thenReturn(value, values);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testThenThrow_ThrowableArr() {
        System.out.println("thenThrow");
        Throwable[] throwables = null;
        Step instance = null;
        OngoingStubbing expResult = null;
        OngoingStubbing result = instance.thenThrow(throwables);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testThenThrow_ClassArr() {
        System.out.println("thenThrow");
        Class[] throwableClasses = null;
        Step instance = null;
        OngoingStubbing expResult = null;
        OngoingStubbing result = instance.thenThrow(throwableClasses);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testThenCallRealMethod() {
        System.out.println("thenCallRealMethod");
        Step instance = null;
        OngoingStubbing expResult = null;
        OngoingStubbing result = instance.thenCallRealMethod();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testThenAnswer() {
        System.out.println("thenAnswer");
        Answer answer = null;
        Step instance = null;
        OngoingStubbing expResult = null;
        OngoingStubbing result = instance.thenAnswer(answer);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testThen_Answer() {
        System.out.println("then");
        Answer answer = null;
        Step instance = null;
        OngoingStubbing expResult = null;
        OngoingStubbing result = instance.then(answer);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetMock() {
        System.out.println("getMock");
        Step instance = null;
        Object expResult = null;
        Object result = instance.getMock();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testThen_0args() {
        System.out.println("then");
        Step instance = null;
        GivenDataAndStubbing expResult = null;
        GivenDataAndStubbing result = instance.then();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
