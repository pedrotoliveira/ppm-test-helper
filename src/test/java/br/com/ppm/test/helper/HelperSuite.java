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

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author pedrotoliveira
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({br.com.ppm.test.helper.StepChainTest.class, br.com.ppm.test.helper.VerifyMockInteractionsTest.class, br.com.ppm.test.helper.TestCaseTest.class, br.com.ppm.test.helper.ReturnObjectWrapperTest.class, br.com.ppm.test.helper.GivenDataAndStubbingTest.class, br.com.ppm.test.helper.StepTest.class, br.com.ppm.test.helper.GivenDataTest.class, br.com.ppm.test.helper.MethodInvokerTest.class, br.com.ppm.test.helper.AssertsImplTest.class})
public class HelperSuite {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
