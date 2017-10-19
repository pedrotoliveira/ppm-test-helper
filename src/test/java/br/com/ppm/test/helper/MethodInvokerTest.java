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

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static br.com.ppm.test.helper.CommonTemplateLabels.VALID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * MethodInvoker Unit Tests
 *
 * @author pedrotoliveira
 */
@RunWith(MockitoJUnitRunner.class)
public class MethodInvokerTest extends FluentTestHelper {

    @Mock
    private UserRepository repository;

    private RegisterService service;
    private MethodInvoker<User> invoker;
    private GivenData<User> givenData;

    @BeforeClass
    public static void beforeAll() {
        setUpFixtures("br.com.ppm.test.fixtures");
    }

    @Before
    public void beforeTests() {
        User user = fixtureFrom(User.class).gimme(VALID);
        this.givenData = new GivenData<>(user, "User Data");
        this.service = new RegisterService(repository);
        this.invoker = new MethodInvoker<>(service, givenData, "MethodInvokerTest");
    }

    @Test
    public void testInvokeRegisterOnUserService() throws Exception {
        User expected = givenData.getData();
        //We Expect a repository Call
        when(repository.save(givenData.getData())).thenReturn(expected);

        User current = invoker.method("register", User.class).getResult();
        assertThat(current).isEqualTo(expected);

        verify(repository).save(expected);
    }

    @Test
    public void testGivenDataNotChange() throws Exception {
        assertThat(invoker.getGivenData()).isSameAs(givenData.getData());
    }

}
