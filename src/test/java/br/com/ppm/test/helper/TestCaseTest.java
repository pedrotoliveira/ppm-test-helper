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

import java.util.List;

import br.com.ppm.test.samples.model.User;

import org.junit.BeforeClass;
import org.junit.Test;

import static br.com.ppm.test.helper.CommonTemplateLabels.VALID;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit Test for TestCase
 *
 * @author pedrotoliveira
 */
public class TestCaseTest extends FixtureTestHelper {

    @BeforeClass
    public static void beforeAll() {
        FixtureTestHelper.setUpFixtures("br.com.ppm.test.fixtures");
    }

    @Test
    public void testGivenData() {
        User user = fixtureFrom(User.class).gimme(VALID);
        TestCase test = new TestCase("test given data");
        GivenData<User> givenData = test.given(user);
        assertThat(givenData.getData()).isSameAs(user);
    }

    @Test
    public void testGivenDataArray() {
        List<User> users = fixtureFrom(User.class).gimme(10, VALID);
        TestCase test = new TestCase("test given array data");
        GivenData<Object[]> givenData = test.given(users.toArray());
        //assertThat(givenData.getData()).isSameAs(user);
    }

    @Test
    public void testWhen() throws Exception {
    }

    @Test
    public void testTest() {
    }

    @Test
    public void testWrapResult() {
    }

    @Test
    public void testExecute() {
    }

    @Test
    public void testAssertTrue() {
    }

    @Test
    public void testAssertThat() {
    }

    @Test
    public void testAssertFalse() {
    }

    @Test
    public void testAssertEqualTo() {
    }

}
