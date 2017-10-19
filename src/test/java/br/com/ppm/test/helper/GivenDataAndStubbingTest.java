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

import br.com.ppm.test.model.RegisterService;
import br.com.ppm.test.model.User;
import br.com.ppm.test.model.UserRepository;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 *
 * @author pedrotoliveira
 */
@SuppressWarnings("PMD.TooManyStaticImports")
@RunWith(MockitoJUnitRunner.class)
public class GivenDataAndStubbingTest {

    @Mock
    private UserRepository userRepository;

    private RegisterService registerService;
    private User user;
    private GivenData<User> givenData;
    private String description;

    private GivenDataAndStubbing<User, User> givenDataAndStubbing;

    @Before
    public void setUp() {
        this.description = "Test Given  And Stubbing";
        this.user = new User("123", "test", "test@gmail.com");
        this.givenData = new GivenData<>(user, description);
        when(userRepository.save(user)).thenReturn(user);
        this.registerService = new RegisterService(userRepository);
        this.givenDataAndStubbing = new GivenDataAndStubbing<>(givenData, registerService.register(user));
    }

    @Test
    public void testReturnValue() {
        assertThat("Should be equal to given data", givenDataAndStubbing.returnValue(user), equalTo(givenData));
    }

    @Test
    public void testWillReturn() {
        assertThat("Should be equal to given data", givenDataAndStubbing.willReturn(user), equalTo(givenData));
    }

    @Test
    public void testThenReturn() {
        assertThat("thenReturn should return a Instance of OngoingStubbing",
                givenDataAndStubbing.thenReturn(user), instanceOf(OngoingStubbing.class));
    }

    @Test
    public void testThenReturnMultipleTypes() {
        assertThat("thenReturn should return a Instance of OngoingStubbing",
                givenDataAndStubbing.thenReturn(user, user), instanceOf(OngoingStubbing.class));
    }

    @Test
    public void testThenThrow() {
        assertThat("thenThrow should return a Instance of OngoingStubbing",
                givenDataAndStubbing.thenThrow(new RuntimeException("ERROR")), instanceOf(OngoingStubbing.class));
    }

    @Test
    @Ignore("To Fix")
    public void testThenThrowClasses() {
        assertThat(givenDataAndStubbing.thenThrow(RuntimeException.class), new IsInstanceOf(OngoingStubbing.class));
    }

    @Test(expected = UnsupportedOperationException.class)
    @Ignore("To Fix")
    public void testThenCallRealMethod() {
        givenDataAndStubbing.thenCallRealMethod();
    }

    @Test
    public void testThenAnswer() {
        OngoingStubbing<User> stubbing = givenDataAndStubbing.thenAnswer((answer) -> {
            return this.user;
        });
        assertNotNull(stubbing);
    }

    @Test
    @Ignore("To Fix")
    public void testGetMock() {
        assertThat(givenDataAndStubbing.getMock(), new IsInstanceOf(user.getClass()));
    }

    @Test
    @Ignore("To Fix")
    public void testWhen() {
        System.out.println("when");
    }

}
