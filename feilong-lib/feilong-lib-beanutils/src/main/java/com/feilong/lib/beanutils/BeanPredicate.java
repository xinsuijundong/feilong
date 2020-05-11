/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.feilong.lib.beanutils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.collections4.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Predicate implementation that applies the given <code>Predicate</code>
 * to the result of calling the given property getter.
 * </p>
 *
 * @version $Id$
 * @deprecated by feilong use com.feilong.core.util.predicate.BeanPredicate
 */
@Deprecated
public class BeanPredicate implements Predicate{

    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(BeanPredicate.class);

    //---------------------------------------------------------------

    /** Name of the property whose value will be predicated */
    private String              propertyName;

    /** <code>Predicate</code> to be applied to the property value */
    private Predicate           predicate;

    /**
     * Constructs a <code>BeanPredicate</code> that applies the given
     * <code>Predicate</code> to the named property value.
     * 
     * @param propertyName
     *            the name of the property whose value is to be predicated,
     *            not null
     * @param predicate
     *            the <code>Predicate</code> to be applied,
     *            not null
     */
    public BeanPredicate(final String propertyName, final Predicate predicate){
        this.propertyName = propertyName;
        this.predicate = predicate;
    }

    /**
     * Evaluates the given object by applying the {@link #getPredicate()}
     * to a property value named by {@link #getPropertyName()}.
     *
     * @param object
     *            The object being evaluated
     * @return the result of the predicate evaluation
     * @throws IllegalArgumentException
     *             when the property cannot be evaluated
     */
    @Override
    public boolean evaluate(final Object object){

        boolean evaluation = false;

        try{
            final Object propValue = PropertyUtils.getProperty(object, propertyName);
            evaluation = predicate.evaluate(propValue);
        }catch (final IllegalArgumentException e){
            final String errorMsg = "Problem during evaluation.";
            LOGGER.error("ERROR: " + errorMsg, e);
            throw e;
        }catch (final IllegalAccessException e){
            final String errorMsg = "Unable to access the property provided.";
            LOGGER.error(errorMsg, e);
            throw new IllegalArgumentException(errorMsg);
        }catch (final InvocationTargetException e){
            final String errorMsg = "Exception occurred in property's getter";
            LOGGER.error(errorMsg, e);
            throw new IllegalArgumentException(errorMsg);
        }catch (final NoSuchMethodException e){
            final String errorMsg = "Property not found.";
            LOGGER.error(errorMsg, e);
            throw new IllegalArgumentException(errorMsg);
        }

        return evaluation;
    }

    /**
     * Gets the name of the property whose value is to be predicated.
     * in the evaluation.
     * 
     * @return the property name, not null
     */
    public String getPropertyName(){
        return propertyName;
    }

    /**
     * Sets the name of the property whose value is to be predicated.
     * 
     * @param propertyName
     *            the name of the property whose value is to be predicated,
     *            not null
     */
    public void setPropertyName(final String propertyName){
        this.propertyName = propertyName;
    }

    /**
     * Gets the <code>Predicate</code> to be applied to the value of the named property
     * during {@link #evaluate}.
     * 
     * @return <code>Predicate</code>, not null
     */
    public Predicate getPredicate(){
        return predicate;
    }

    /**
     * Sets the <code>Predicate</code> to be applied to the value of the named property
     * during {@link #evaluate(Object)}.
     * 
     * @param predicate
     *            <code>Predicate</code>, not null
     */
    public void setPredicate(final Predicate predicate){
        this.predicate = predicate;
    }

}
