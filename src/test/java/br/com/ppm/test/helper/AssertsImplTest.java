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

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Unit tests for AssertsImpl
 * @author pedrotoliveira
 */
public class AssertsImplTest {
    
    private AssertsImpl asserts;

    @Before
    public void setUp() {
        this.asserts = new AssertsImpl("AssertsImplTest");
    }
    
    @Test
    public void testAssertThat() {
        asserts.assertThat("Some method return", equalTo("Some method return"));
    }

    @Test
    public void testAssertTrue() {
        asserts.assertTrue(true);
    }

    @Test
    public void testAssertFalse() {
        asserts.assertFalse(false);
    }

    @Test
    public void testAssertEqualTo() {
        asserts.assertEqualTo("Some method return", "Some method return");
    }
    
}
