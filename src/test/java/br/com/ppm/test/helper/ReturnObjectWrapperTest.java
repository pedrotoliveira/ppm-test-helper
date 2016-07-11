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
import org.mockito.verification.VerificationMode;

import static org.junit.Assert.*;

/**
 *
 * @author pedrotoliveira
 */
public class ReturnObjectWrapperTest {
    
    public ReturnObjectWrapperTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAssertThat() {
        System.out.println("assertThat");
        Object methodCall = null;
        Matcher matcher = null;
        ReturnObjectWrapper instance = null;
        Asserts expResult = null;
        Asserts result = instance.assertThat(methodCall, matcher);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAssertTrue() {
        System.out.println("assertTrue");
        boolean methodCall = false;
        ReturnObjectWrapper instance = null;
        Asserts expResult = null;
        Asserts result = instance.assertTrue(methodCall);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAssertFalse() {
        System.out.println("assertFalse");
        boolean methodCall = false;
        ReturnObjectWrapper instance = null;
        Asserts expResult = null;
        Asserts result = instance.assertFalse(methodCall);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAssertEqualTo_GenericType_Object() {
        System.out.println("assertEqualTo");
        Object methodCall = null;
        Object expected = null;
        ReturnObjectWrapper instance = null;
        Asserts expResult = null;
        Asserts result = instance.assertEqualTo(methodCall, expected);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAssertEqualTo_GenericType() {
        System.out.println("assertEqualTo");
        Object expected = null;
        ReturnObjectWrapper instance = null;
        ReturnObjectWrapper expResult = null;
        ReturnObjectWrapper result = instance.assertEqualTo(expected);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testResultIsEqualTo() {
        System.out.println("resultIsEqualTo");
        Object expected = null;
        ReturnObjectWrapper instance = null;
        ReturnObjectWrapper expResult = null;
        ReturnObjectWrapper result = instance.resultIsEqualTo(expected);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAssertReturn() {
        System.out.println("assertReturn");
        Matcher matcher = null;
        ReturnObjectWrapper instance = null;
        ReturnObjectWrapper expResult = null;
        ReturnObjectWrapper result = instance.assertReturn(matcher);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAssertReturnField() {
        System.out.println("assertReturnField");
        String field = "";
        Matcher matcher = null;
        ReturnObjectWrapper instance = null;
        ReturnObjectWrapper expResult = null;
        ReturnObjectWrapper result = instance.assertReturnField(field, matcher);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAssertEqualToReturnField() {
        System.out.println("assertEqualToReturnField");
        String field = "";
        Object expected = null;
        ReturnObjectWrapper instance = null;
        ReturnObjectWrapper expResult = null;
        ReturnObjectWrapper result = instance.assertEqualToReturnField(field, expected);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAssertReturnFields() {
        System.out.println("assertReturnFields");
        String field = "";
        Matcher matcher = null;
        Object[] additionalKeyMatcherPairs = null;
        ReturnObjectWrapper instance = null;
        ReturnObjectWrapper expResult = null;
        ReturnObjectWrapper result = instance.assertReturnFields(field, matcher, additionalKeyMatcherPairs);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAssertEqualToReturnFields() {
        System.out.println("assertEqualToReturnFields");
        String field = "";
        Object expected = null;
        Object[] additionalKeyMatcherPairs = null;
        ReturnObjectWrapper instance = null;
        ReturnObjectWrapper expResult = null;
        ReturnObjectWrapper result = instance.assertEqualToReturnFields(field, expected, additionalKeyMatcherPairs);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testVerify_GenericType_VerificationMode() {
        System.out.println("verify");
        Object mock = null;
        VerificationMode mode = null;
        ReturnObjectWrapper instance = null;
        Object expResult = null;
        Object result = instance.verify(mock, mode);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testVerify_GenericType() {
        System.out.println("verify");
        Object mock = null;
        ReturnObjectWrapper instance = null;
        Object expResult = null;
        Object result = instance.verify(mock);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testVerifyNoMoreInteractions() {
        System.out.println("verifyNoMoreInteractions");
        Object[] mocks = null;
        ReturnObjectWrapper instance = null;
        instance.verifyNoMoreInteractions(mocks);
        fail("The test case is a prototype.");
    }
    
}
