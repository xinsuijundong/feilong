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
package com.feilong.core.lang.reflect;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.feilong.core.lang.reflect.constructorutil.ConstructorUtilSuiteTests;
import com.feilong.core.lang.reflect.fieldutil.FieldUtilSuiteTests;
import com.feilong.core.lang.reflect.methodutil.MethodUtilSuiteTests;
import com.feilong.core.lang.reflect.typeutil.TypeUtilSuiteTests;

@RunWith(Suite.class)
@SuiteClasses({ //
                ConstructorUtilSuiteTests.class,
                FieldUtilSuiteTests.class,
                MethodUtilSuiteTests.class,
                TypeUtilSuiteTests.class,
        //
})
public class ReflectSuiteTests{

}
