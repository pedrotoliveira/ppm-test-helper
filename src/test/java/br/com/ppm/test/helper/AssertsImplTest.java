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
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for AssertsImpl
 *
 * @author pedrotoliveira
 */
public class AssertsImplTest {

    private AssertsImpl asserts;    
    private User user;
    
    @Before
    public void setUp() {
        this.user = new User("123", "test", "test@gmail.com");
    }

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
        String description = "testAssertEqualToReturnField";
        ReturnObjectWrapper returnObjectWrapper = new ReturnObjectWrapper(user, description);
        this.asserts = new AssertsImpl(returnObjectWrapper, description);
        assertThat(asserts.assertEqualToReturnField("name", "test"), equalTo(returnObjectWrapper));
    }

    @Test
    public void testAssertReturnFields() {        
        String description = "testAssertReturnFields";
        ReturnObjectWrapper returnObjectWrapper = new ReturnObjectWrapper(user, description);
        this.asserts = new AssertsImpl(returnObjectWrapper, description);
        assertThat(asserts.assertReturnFields("name", equalTo("test"), "id", equalTo("123")), equalTo(returnObjectWrapper));
    }

    @Test
    @Ignore("FIXME: Bug on Method: assertEqualToReturnFields")
    public void testAssertEqualToReturnFields() {        
        String description = "testAssertEqualToReturnFields";
        ReturnObjectWrapper returnObjectWrapper = new ReturnObjectWrapper(user, description);
        this.asserts = new AssertsImpl(returnObjectWrapper, description);
        assertThat(asserts.assertEqualToReturnFields("name", "test", "id", "123"), equalTo(returnObjectWrapper));
    }

    @Test
    public void testResultIsEqualTo() {        
        User expected = new User("123", "test", "test@gmail.com");
        String description = "testResultIsEqualTo";
        ReturnObjectWrapper returnObjectWrapper = new ReturnObjectWrapper(user, description);
        this.asserts = new AssertsImpl(returnObjectWrapper, description);
        assertThat(asserts.resultIsEqualTo(expected), equalTo(returnObjectWrapper));
    }

    @Test
    public void testAssertReturn() {        
        User expected = new User("123", "test", "test@gmail.com");
        String description = "testAssertReturn";
        ReturnObjectWrapper returnObjectWrapper = new ReturnObjectWrapper(user, description);
        this.asserts = new AssertsImpl(returnObjectWrapper, description);
        assertThat(asserts.assertReturn(equalTo(expected)), equalTo(returnObjectWrapper));
    }

    @Test
    public void testAssertReturnField() {        
        String description = "testAssertReturnField";
        ReturnObjectWrapper returnObjectWrapper = new ReturnObjectWrapper(user, description);
        this.asserts = new AssertsImpl(returnObjectWrapper, description);
        assertThat(asserts.assertReturnField("name", equalTo("test")), equalTo(returnObjectWrapper));
    }

    @Test
    public void testAssertEqualTo_GenericType() {        
        User expected = new User("123", "test", "test@gmail.com");
        String description = "testAssertEqualTo_GenericType";
        ReturnObjectWrapper returnObjectWrapper = new ReturnObjectWrapper(user, description);
        this.asserts = new AssertsImpl(returnObjectWrapper, description);
        assertThat(asserts.assertEqualTo(expected), equalTo(returnObjectWrapper));
    }
}
