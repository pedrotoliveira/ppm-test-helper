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

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static br.com.ppm.test.helper.CommonTemplateLabels.VALID;
import static org.junit.Assert.fail;

/**
 * MethodInvoker Unit Tests
 *
 * @author pedrotoliveira
 */
@RunWith(MockitoJUnitRunner.class)
public class MethodInvokerTest extends FixtureTestHelper {

    @Mock
    private UserRepository repository;
    private RegisterService service;

    private MethodInvoker<User> invoker;

    @BeforeClass
    public static void beforeAll() {
        setUpFixtures("br.com.ppm.test.fixtures");
    }

    @Before
    public void beforeTests() {
        User user = fixtureFrom(User.class).gimme(VALID);
        GivenData<User> data = new GivenData<>(user, "User Data");
        this.service = new RegisterService(repository);
        this.invoker = new MethodInvoker<>(service, data, "MethodInvokerTest");
    }

    @Test
    public void testMethod() throws Exception {

        fail("The test case is a prototype.");
    }

}
