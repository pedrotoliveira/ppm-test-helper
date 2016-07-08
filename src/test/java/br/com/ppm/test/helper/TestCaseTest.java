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

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author pedrotoliveira
 */
public class TestCaseTest {
    
    public TestCaseTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGiven_GenericType() {
        System.out.println("given");
        Object data = null;
        TestCase instance = null;
        GivenData expResult = null;
        GivenData result = instance.given(data);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGiven_ObjectArr() {
        System.out.println("given");
        Object[] data = null;
        TestCase instance = null;
        GivenData expResult = null;
        GivenData result = instance.given(data);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testWhen() throws Exception {
        System.out.println("when");
        Object methodCall = null;
        TestCase instance = null;
        StubbingWrapper expResult = null;
        StubbingWrapper result = instance.when(methodCall);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testTest() {
        System.out.println("test");
        Object testInstance = null;
        TestCase instance = null;
        Object expResult = null;
        Object result = instance.test(testInstance);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testWrapResult() {
        System.out.println("wrapResult");
        Object methodCall = null;
        TestCase instance = null;
        ReturnObjectWrapper expResult = null;
        ReturnObjectWrapper result = instance.wrapResult(methodCall);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testExecute() {
        System.out.println("execute");
        Object testInstance = null;
        TestCase instance = null;
        Object expResult = null;
        Object result = instance.execute(testInstance);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAssertTrue() {
        System.out.println("assertTrue");
        boolean methodCall = false;
        TestCase instance = null;
        Asserts expResult = null;
        Asserts result = instance.assertTrue(methodCall);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAssertThat() {
        System.out.println("assertThat");
        Object methodCall = null;
        Matcher matcher = null;
        TestCase instance = null;
        Asserts expResult = null;
        Asserts result = instance.assertThat(methodCall, matcher);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAssertFalse() {
        System.out.println("assertFalse");
        boolean methodCall = false;
        TestCase instance = null;
        Asserts expResult = null;
        Asserts result = instance.assertFalse(methodCall);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAssertEqualTo() {
        System.out.println("assertEqualTo");
        Object methodCall = null;
        Object expected = null;
        TestCase instance = null;
        Asserts expResult = null;
        Asserts result = instance.assertEqualTo(methodCall, expected);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
