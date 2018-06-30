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
package br.com.ppm.test.example;

import java.util.ArrayList;
import java.util.List;

import br.com.ppm.test.helper.*;
import br.com.ppm.test.model.RegisterService;
import br.com.ppm.test.model.User;
import br.com.ppm.test.model.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Sample Syntax Example
 *
 * @author pedrotoliveira
 */
@RunWith(MockitoJUnitRunner.class)
public class GivenDataAndStubbingSyntaxTest extends FluentTestHelper {

    @Mock
    private UserRepository repository;

    private RegisterService service;

    @Before
    public void setUp() {
        this.service = new RegisterService(repository);
    }

    @Test
    public void testSyntaxWithGivenData() throws Exception {
        User userToRegister = new User(null, "pedro", "pedro@test.com");
        User registeredUser = new User("1", "pedro", "pedro@test.com");

        testCase("Register - Success")
                .given(userToRegister)
                .when(repository.save(userToRegister)).then().returnValue(registeredUser)
                .call(service).method("register", User.class)
                .assertEqualTo(registeredUser)
                .verify(repository).save(userToRegister);
    }

    @Test
    public void testSyntaxNoData() throws Exception {
        List<User> allUsers = new ArrayList<>();
        allUsers.add(new User("1", "pedro", "pedro@test.com"));
        testCase("Find All - Success")
                .when(repository.findAll()).then().returnValue(allUsers)
                .call(service).method("findAll", List.class)
                .assertEqualTo(allUsers);
    }
}
