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

import br.com.ppm.test.samples.model.RegisterService;
import br.com.ppm.test.samples.model.User;
import br.com.ppm.test.samples.model.UserRepository;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

import static org.hamcrest.CoreMatchers.equalTo;
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
        this.givenDataAndStubbing = new GivenDataAndStubbing(givenData, registerService.register(user));
    }

    @Test
    public void testReturnValue() {
        assertThat(givenDataAndStubbing.returnValue(user), equalTo(givenData));
    }

    @Test
    public void testWillReturn() {
        assertThat(givenDataAndStubbing.willReturn(user), equalTo(givenData));
    }

    @Test
    public void testThenReturnGenericType() {
        assertThat(givenDataAndStubbing.thenReturn(user), new IsInstanceOf(OngoingStubbing.class));
    }

    @Test
    public void testThenReturnMultipleGenericTypes() {
        assertThat(givenDataAndStubbing.thenReturn(user, user), new IsInstanceOf(OngoingStubbing.class));
    }

    @Test
    public void testThenThrow() {
        assertThat(givenDataAndStubbing.thenThrow(new RuntimeException("ERROR")), new IsInstanceOf(OngoingStubbing.class));
    }

    @Test
    public void testThenThrowClasses() {
        assertThat(givenDataAndStubbing.thenThrow(RuntimeException.class), new IsInstanceOf(OngoingStubbing.class));
    }

    @Test(expected = UnsupportedOperationException.class)
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
    public void testGetMock() {
        assertThat(givenDataAndStubbing.getMock(), new IsInstanceOf(user.getClass()));
    }

    @Test
    public void testThen_0args() {
        System.out.println("then");
        //fail("The test case is a prototype.");
    }

    @Test
    public void testWhen() {
        System.out.println("when");
        //fail("The test case is a prototype.");
    }

}
