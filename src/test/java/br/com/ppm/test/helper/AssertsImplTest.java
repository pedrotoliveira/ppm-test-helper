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

import br.com.ppm.test.samples.model.User;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Unit tests for AssertsImpl
 * @author pedrotoliveira
 */
public class AssertsImplTest {
    
    private AssertsImpl asserts;
    
    @Test
    public void testAssertThat() {
        this.asserts = new AssertsImpl(null, "AssertsImplTest");
        asserts.assertThat("Some method return", equalTo("Some method return"));
    }

    @Test
    public void testAssertTrue() {
        this.asserts = new AssertsImpl(null, "AssertsImplTest");
        asserts.assertTrue(true);
    }

    @Test
    public void testAssertFalse() {
        this.asserts = new AssertsImpl(null, "AssertsImplTest");
        asserts.assertFalse(false);
    }

    @Test
    public void testAssertEqualTo() {
        this.asserts = new AssertsImpl(null, "AssertsImplTest");
        asserts.assertEqualTo("Some method return", "Some method return");
    }

    @Test
    public void testGetDescription() {
        this.asserts = new AssertsImpl(null, "AssertsImplTest");
        assertThat(asserts.getDescription(), equalTo("AssertsImplTest"));
    }

    @Test
    public void testAssertEqualToReturnField() {
        User user = new User("123", "test", "test@gmail.com");
        String description = "testAssertEqualToReturnField";
        ReturnObjectWrapper returnObjectWrapper = new ReturnObjectWrapper(user, description);
        this.asserts = new AssertsImpl(returnObjectWrapper, description);        
        assertThat(asserts.assertEqualToReturnField("name", "test"), equalTo(returnObjectWrapper));
    }

    @Test
    public void testAssertReturnFields() {
        User user = new User("123", "test", "test@gmail.com");
        String description = "testAssertReturnFields";
        ReturnObjectWrapper returnObjectWrapper = new ReturnObjectWrapper(user, description);
        this.asserts = new AssertsImpl(returnObjectWrapper, description);
        assertThat(asserts.assertReturnFields("name", equalTo("test"), "id", equalTo("123")), equalTo(returnObjectWrapper));
    }

    @Test
    public void testAssertEqualToReturnFields() {
        User user = new User("123", "test", "test@gmail.com");
        String description = "testAssertEqualToReturnFields";
        ReturnObjectWrapper returnObjectWrapper = new ReturnObjectWrapper(user, description);
        this.asserts = new AssertsImpl(returnObjectWrapper, description);
        assertThat(asserts.assertEqualToReturnFields("name", "test", "id", "123"), equalTo(returnObjectWrapper));
    }

    @Test
    public void testResultIsEqualTo() {
        System.out.println("resultIsEqualTo");
        Object expected = null;
        AssertsImpl instance = null;
        ReturnObjectWrapper expResult = null;
        ReturnObjectWrapper result = instance.resultIsEqualTo(expected);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAssertReturn() {
        System.out.println("assertReturn");
        Matcher matcher = null;
        AssertsImpl instance = null;
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
        AssertsImpl instance = null;
        ReturnObjectWrapper expResult = null;
        ReturnObjectWrapper result = instance.assertReturnField(field, matcher);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAssertEqualTo_GenericType() {
        System.out.println("assertEqualTo");
        Object expected = null;
        AssertsImpl instance = null;
        ReturnObjectWrapper expResult = null;
        ReturnObjectWrapper result = instance.assertEqualTo(expected);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAssertEqualTo_GenericType_Object() {
        System.out.println("assertEqualTo");
        Object methodCall = null;
        Object expected = null;
        AssertsImpl instance = null;
        Asserts expResult = null;
        Asserts result = instance.assertEqualTo(methodCall, expected);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
