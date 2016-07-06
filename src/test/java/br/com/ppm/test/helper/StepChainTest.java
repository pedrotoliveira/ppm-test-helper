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
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;

import static org.junit.Assert.*;

/**
 *
 * @author pedrotoliveira
 */
public class StepChainTest {
    
    public StepChainTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testChain() {
        System.out.println("chain");
        StepChain expResult = null;
        StepChain result = StepChain.chain();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAdd_Step() {
        System.out.println("add");
        Step step = null;
        StepChain instance = null;
        StepChain expResult = null;
        StepChain result = instance.add(step);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAdd_OngoingStubbing() {
        System.out.println("add");
        OngoingStubbing ongoingStubbing = null;
        StepChain instance = null;
        StepChain expResult = null;
        StepChain result = instance.add(ongoingStubbing);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testExecute() {
        System.out.println("execute");
        StepChain instance = null;
        instance.execute();
        fail("The test case is a prototype.");
    }
    
}
