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
package com.feilong.coreextension.awt;

import org.junit.Test;

public class DesktopUtilNullTest{

    @Test(expected = NullPointerException.class)
    public void testDesktopUtilNullTestNull(){
        DesktopUtil.browse(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDesktopUtilNullTestEmpty(){
        DesktopUtil.browse("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDesktopUtilNullTestBlank(){
        DesktopUtil.browse(" ");
    }

    //---------------------------------------------------------------
    @Test(expected = NullPointerException.class)
    public void testEditDesktopUtilNullTestNull(){
        DesktopUtil.edit(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEditUtilNullTestEmpty(){
        DesktopUtil.edit("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEditUtilNullTestBlank(){
        DesktopUtil.edit(" ");
    }

    //---------------------------------------------------------------
    @Test(expected = NullPointerException.class)
    public void testMailDesktopUtilNullTestNull(){
        DesktopUtil.mail(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMailUtilNullTestEmpty(){
        DesktopUtil.mail("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMailUtilNullTestBlank(){
        DesktopUtil.mail(" ");
    }

    //---------------------------------------------------------------
    @Test(expected = NullPointerException.class)
    public void testOpenDesktopUtilNullTestNull(){
        DesktopUtil.open(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOpenUtilNullTestEmpty(){
        DesktopUtil.open("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOpenUtilNullTestBlank(){
        DesktopUtil.open(" ");
    }

    //---------------------------------------------------------------
    @Test(expected = NullPointerException.class)
    public void testPrintDesktopUtilNullTestNull(){
        DesktopUtil.print(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrintUtilNullTestEmpty(){
        DesktopUtil.print("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrintUtilNullTestBlank(){
        DesktopUtil.print(" ");
    }

}
