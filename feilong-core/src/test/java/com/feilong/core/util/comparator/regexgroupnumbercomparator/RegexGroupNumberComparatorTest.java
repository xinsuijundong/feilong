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
package com.feilong.core.util.comparator.regexgroupnumbercomparator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.feilong.core.util.comparator.RegexGroupNumberComparator;

/**
 * The Class RegexGroupNumberComparatorTest.
 *
 * @author <a href="https://github.com/ifeilong/feilong">feilong</a>
 * @since 1.10.7
 */
public class RegexGroupNumberComparatorTest{

    /**
     * Test regex group number comparator test.
     */
    @Test
    public void testRegexGroupNumberComparatorTest(){
        RegexGroupNumberComparator regexGroupNumberComparator = new RegexGroupNumberComparator(".*ppt-coreContent(\\d*).png");

        assertEquals(-1, regexGroupNumberComparator.compare("ppt-coreContent2.png", "ppt-coreContent13.png"));
    }

    //---------------------------------------------------------------

    @SuppressWarnings("unused")
    @Test(expected = NullPointerException.class)
    public void testRegexGroupNumberComparatorTestNull(){
        new RegexGroupNumberComparator(null);
    }

    /**
     * Test regex group number comparator test empty.
     */
    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void testRegexGroupNumberComparatorTestEmpty(){
        new RegexGroupNumberComparator("");
    }

    /**
     * Test regex group number comparator test blank.
     */
    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void testRegexGroupNumberComparatorTestBlank(){
        new RegexGroupNumberComparator(" ");
    }
}
