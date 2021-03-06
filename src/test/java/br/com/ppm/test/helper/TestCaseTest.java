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

import java.util.Collections;
import java.util.List;

import br.com.ppm.test.model.RegisterService;
import br.com.ppm.test.model.User;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

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
        setUpFixtures("br.com.ppm.test.fixtures");
    }

    @Test
    public void testGivenData() {
        User user = fixtureFrom(User.class).gimme(VALID);
        TestCase testCase = new TestCase("Test given data");
        GivenData<User> data = testCase.given(user);
        assertThat(data.getData()).as("When call given we have to return the same User").isSameAs(user);
    }

    @Test
    public void testGivenDataArray() {
        List<User> users = fixtureFrom(User.class).gimme(10, VALID);
        TestCase testCase = new TestCase("Test given array data");
        GivenData<Object[]> arrayData = testCase.given(users.toArray());
        for (Object returned : arrayData.getData()) {
            assertThat(returned).as("Check if returned is in given Users").isIn(users);
        }
    }

    @Test
    public void testWhen() throws Exception {
        RegisterService mockedService = Mockito.mock(RegisterService.class);

        TestCase testCase = new TestCase("Test method when");
        Stubbing<List<User>> whenFindAll = testCase.when(mockedService.findAll());
        assertThat(whenFindAll).as("Check if we create the stub")
                .isNotNull()
                .isInstanceOf(Stubbing.class);
        //Finalize the Stub Declaration.
        whenFindAll.then().returnValue(Collections.emptyList());
    }

    @Test
    public void testCall() throws Exception {
        User user = fixtureFrom(User.class).gimme(VALID);
        TestCase testCase = new TestCase("Test method test");
        testCase.call(user)
                .method("getId", String.class)
                .assertEqualTo(user.getId());
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
