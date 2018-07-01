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
import br.com.ppm.test.model.UserRepository;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static br.com.ppm.test.helper.CommonTemplateLabels.VALID;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 *
 * @author pedrotoliveira
 */
@SuppressWarnings("PMD.TooManyStaticImports")
@RunWith(MockitoJUnitRunner.class)
public class GivenDataAndStubbingTest extends FixtureTestHelper {

    @Mock
    private UserRepository userRepository;
    private User user;
    private GivenData<User> givenData;
    private String description;

    @BeforeClass
    public static void beforeAll() {
        setUpFixtures("br.com.ppm.test.fixtures");
    }

    @Before
    public void beforeEach() {
        this.description = "Test Given And Stubbing";
        this.user = fixtureFrom(User.class).gimme(VALID);
        this.givenData = new GivenData<>(user, description);
    }

    @Test
    public void testReturnValue() {
        GivenDataAndStubbing<User, User> givenDataAndStub = new GivenDataAndStubbing<>(givenData, userRepository.save(user));
        assertThat("Should be equal to given data",
                givenDataAndStub.returnValue(user), equalTo(givenData));
    }

    @Test
    public void testWillReturn() {
        GivenDataAndStubbing<User, User> givenDataAndStub = new GivenDataAndStubbing<>(givenData, userRepository.save(user));
        assertThat("Should be equal to given data",
                givenDataAndStub.willReturn(user), equalTo(givenData));
    }

    @Test
    public void testThenReturn() {
        GivenDataAndStubbing<User, User> givenDataAndStub = new GivenDataAndStubbing<>(givenData, userRepository.save(user));
        assertThat("thenReturn describe return a Instance of Stubbing",
                givenDataAndStub.thenReturn(user), instanceOf(Stubbing.class));
    }

    @Test
    public void testThenReturnMultipleTypes() {
        GivenDataAndStubbing<User, User> givenDataAndStub = new GivenDataAndStubbing<>(givenData, userRepository.save(user));
        assertThat("thenReturn describe return a Instance of Stubbing",
                givenDataAndStub.thenReturn(user, user), instanceOf(Stubbing.class));
    }

    @Test
    public void testThenThrow() {
        GivenDataAndStubbing<User, User> givenDataAndStub = new GivenDataAndStubbing<>(givenData, userRepository.save(user));
        assertThat("thenThrow describe return a Instance of Stubbing",
                givenDataAndStub.thenThrow(new RuntimeException("ERROR")), instanceOf(Stubbing.class));
    }

    @Test
    public void testThenThrowMultipleCalls() {
        GivenDataAndStubbing<User, User> givenDataAndStub = new GivenDataAndStubbing<>(givenData, userRepository.save(user));
        assertThat("thenThrow with multiple exceptions describe return a Instance of Stubbing",
                givenDataAndStub.thenThrow(new RuntimeException("ERROR1"), new RuntimeException("ERROR2")),
                instanceOf(Stubbing.class));
    }

    @Test
    public void testThenAnswer() {
        GivenDataAndStubbing<User, User> givenDataAndStub = new GivenDataAndStubbing<>(givenData, userRepository.save(user));
        Stubbing<User> stubbing = givenDataAndStub.thenAnswer((answer) -> {
            return this.user;
        });
        assertNotNull("Expect a Stubbing Instance", stubbing);
    }

    @Test
    public void testWhen() {
        Stubbing<User> stubbing = new GivenDataAndStubbing<>(givenData, userRepository.save(user))
                .thenReturn(user)
                .when(userRepository.save(user))
                .thenReturn(user);
        assertNotNull("Expect a Stubbing Instance", stubbing);
    }

}
