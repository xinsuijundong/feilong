/*
 * Copyright (C) 2008 feilong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feilong.core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.feilong.lib.collection4.CollectionUtils;
import com.feilong.lib.lang3.StringUtils;
import com.feilong.store.member.User;

import static com.feilong.core.Validator.isNullOrEmpty;

/**
 * The Class ValidatorTest.
 *
 * @author <a href="https://github.com/ifeilong/feilong">feilong</a>
 * @since 1.0.7
 */
public class ValidatorTest{

    /**
     * Test is null or empty.
     */
    @Test
    public void testIsNullOrEmpty(){
        int[] i = {};
        assertEquals(true, CollectionUtils.sizeIsEmpty(i));
        assertEquals(true, isNullOrEmpty(i));

        User[] users = {};
        assertEquals(true, isNullOrEmpty(users));
    }

    /**
     * Test is null or empty 1.
     */
    @Test
    public void testIsNullOrEmpty1(){
        assertEquals(true, StringUtils.isBlank(new StringBuilder("  ")));
        assertEquals(true, isNullOrEmpty(new StringBuilder("  ")));
    }

}
