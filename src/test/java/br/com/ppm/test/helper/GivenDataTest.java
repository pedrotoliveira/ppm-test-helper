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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * GivenData Unit Tests
 *
 * @author pedrotoliveira
 */
@RunWith(MockitoJUnitRunner.class)
public class GivenDataTest {

    @Mock
    private UserRepository userRepository;

    private RegisterService registerService;
    private User user;
    private GivenData<User> givenData;
    private String description;

    @Before
    public void setUp() {
        this.description = "Test Given Data";
        this.user = new User("123", "test", "test@gmail.com");
        this.registerService = new RegisterService(userRepository);
        this.givenData = new GivenData<>(user, description);
    }

    @Test
    public void testTest() {
        MethodInvoker<User> expected = new MethodInvoker(registerService, givenData, description);
        assertThat(givenData.test(registerService), equalTo(expected));
    }

    @Test
    public void testWhen() throws Exception {
        when(userRepository.save(user)).thenReturn(user);
        StubbingWrapper<User> when = givenData.when(registerService.register(user));
        assertThat(givenData, equalTo(when.then().returnValue(user)));
    }

    @Test
    public void testWrapResult() {
        when(userRepository.save(user)).thenReturn(user);
        ReturnObjectWrapper<User> expected = new ReturnObjectWrapper<>(user, description);
        assertThat(givenData.wrapResult(registerService.register(user)), equalTo(expected));
    }
}
