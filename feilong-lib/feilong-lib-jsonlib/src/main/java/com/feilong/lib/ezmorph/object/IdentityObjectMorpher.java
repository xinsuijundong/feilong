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

package com.feilong.lib.ezmorph.object;

import com.feilong.lib.ezmorph.ObjectMorpher;

/**
 * Morpher that performs no conversion.<br>
 * This morpher is a singleton.
 * 
 * @author <a href="mailto:aalmiray@users.sourceforge.net">Andres Almiray</a>
 */
public final class IdentityObjectMorpher implements ObjectMorpher{

    /** The Constant INSTANCE. */
    public static final IdentityObjectMorpher INSTANCE = new IdentityObjectMorpher();

    //---------------------------------------------------------------

    /**
     * Instantiates a new identity object morpher.
     */
    private IdentityObjectMorpher(){
    }

    //---------------------------------------------------------------

    /**
     * Equals.
     *
     * @param obj
     *            the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj){
        return INSTANCE == obj;
    }

    //---------------------------------------------------------------

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode(){
        return 42 + getClass().hashCode();
    }

    //---------------------------------------------------------------

    /**
     * Morph.
     *
     * @param value
     *            the value
     * @return the object
     */
    @Override
    public Object morph(Object value){
        return value;
    }

    //---------------------------------------------------------------

    /**
     * Morphs to.
     *
     * @return the class
     */
    @Override
    public Class<?> morphsTo(){
        return Object.class;
    }

    //---------------------------------------------------------------

    /**
     * Supports.
     *
     * @param clazz
     *            the clazz
     * @return true, if successful
     */
    @Override
    public boolean supports(Class<?> clazz){
        return true;
    }
}