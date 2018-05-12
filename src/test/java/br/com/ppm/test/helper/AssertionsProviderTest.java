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

import br.com.ppm.test.model.User;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static br.com.ppm.test.helper.CommonTemplateLabels.VALID;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for AssertionsProvider
 *
 * @author pedrotoliveira
 */
public class AssertionsProviderTest extends FixtureTestHelper {

    private AssertionsProvider<User> assertProvider;
    private User user;
    private ReturnWrapper<User> objectWrapper;
    private final String description = "AssertsImplTest";

    @BeforeClass
    public static void beforeAll() {
        setUpFixtures("br.com.ppm.test.fixtures");
    }

    @Before
    public void beforeEach() {
        this.user = fixtureFrom(User.class).gimme(VALID);
        this.objectWrapper = new ReturnWrapper<>(user, user.getName());
        this.assertProvider = new AssertionsProvider<>(objectWrapper, description);
    }

    @Test
    public void testAssertThat() {
        assertProvider.assertThat(user, equalTo(new User(user)));
    }

    @Test
    public void testAssertTrue() {
        assertProvider.assertTrue(true);
    }

    @Test
    public void testAssertFalse() {
        assertProvider.assertFalse(false);
    }

    @Test
    public void testAssertEqualTo() {
        assertProvider.assertEqualTo(user, new User(user));
    }

    @Test
    @SuppressWarnings("PMD.JUnitTestContainsTooManyAsserts")
    public void testGetDescription() {
        assertThat("Description should be ".concat(description), assertProvider.getDescription(), equalTo(description));
    }

    @Test
    public void testAssertEqualToReturnField() {
        assertProvider.assertEqualToReturnField("name", user.getName());
    }

    @Test
    public void testAssertReturnFields() {
        assertProvider.assertReturnFields("id", equalTo(user.getId()), "email", equalTo(user.getEmail()));
    }

    @Test
    public void testAssertEqualToReturnFields() {
        assertProvider.assertEqualToReturnFields("name", user.getName(), "id", user.getId());
    }

    @Test
    public void testResultIsEqualTo() {
        assertProvider.resultIsEqualTo(new User(user));
    }

    @Test
    public void testAssertReturn() {
        assertProvider.assertReturn(equalTo(new User(user)));
    }

    @Test
    public void testAssertReturnField() {
        assertProvider.assertReturnField("address", equalTo(user.getAddress()));
    }

    @Test
    @SuppressWarnings("PMD.JUnitTestContainsTooManyAsserts")
    public void testCompareObjectWrapper() {
        ReturnWrapper<User> returnWrapper = assertProvider.assertEqualTo(user);
        assertThat("ReturnWrapper Should be Equal", returnWrapper, equalTo(objectWrapper));
    }

    @Test
    public void testAssertThatTestCaseMatecher() {
        assertProvider.assertThat(user).isEqual(new User(user));
    }
}
