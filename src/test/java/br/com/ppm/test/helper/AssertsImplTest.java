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
 * Unit tests for AssertionsProvider
 *
 * @author pedrotoliveira
 */
public class AssertsImplTest {

    private AssertionsProvider<User> asserts;
    private User user;
    private ReturnWrapper<User> objectWrapper;
    private final String description = "AssertsImplTest";

    @Before
    public void setUp() {
        this.user = new User("123", "test", "test@gmail.com");
        this.objectWrapper = new ReturnWrapper<>(user, "An User");
        this.asserts = new AssertionsProvider<>(objectWrapper, description);
    }


    @Test
    public void testAssertThat() {
        User expected = new User("123", "test", "test@gmail.com");
        asserts.assertThat(user, equalTo(expected));
    }

    @Test
    public void testAssertTrue() {
        asserts.assertTrue(true);
    }

    @Test
    public void testAssertFalse() {
        asserts.assertFalse(false);
    }

    @Test
    public void testAssertEqualTo() {
        User expected = new User("123", "test", "test@gmail.com");
        asserts.assertEqualTo(user, expected);
    }

    @Test
    public void testGetDescription() {
        assertThat(asserts.getDescription(), equalTo("AssertsImplTest"));
    }

    @Test
    public void testAssertEqualToReturnField() {
        assertThat(asserts.assertEqualToReturnField("name", "test"), equalTo(objectWrapper));
    }

    @Test
    public void testAssertReturnFields() {
        assertThat(asserts.assertReturnFields("name", equalTo("test"), "id", equalTo("123")), equalTo(objectWrapper));
    }

    @Test
    @Ignore("FIXME: Bug on Method: assertEqualToReturnFields")
    public void testAssertEqualToReturnFields() {
        assertThat(asserts.assertEqualToReturnFields("name", "test", "id", "123"), equalTo(objectWrapper));
    }

    @Test
    public void testResultIsEqualTo() {
        User expected = new User("123", "test", "test@gmail.com");
        assertThat(asserts.resultIsEqualTo(expected), equalTo(objectWrapper));
    }

    @Test
    public void testAssertReturn() {
        User expected = new User("123", "test", "test@gmail.com");
        assertThat(asserts.assertReturn(equalTo(expected)), equalTo(objectWrapper));
    }

    @Test
    public void testAssertReturnField() {
        assertThat(asserts.assertReturnField("name", equalTo("test")), equalTo(objectWrapper));
    }

    @Test
    public void testAssertEqualTo_GenericType() {
        User expected = new User("123", "test", "test@gmail.com");
        assertThat(asserts.assertEqualTo(expected), equalTo(objectWrapper));
    }
}
