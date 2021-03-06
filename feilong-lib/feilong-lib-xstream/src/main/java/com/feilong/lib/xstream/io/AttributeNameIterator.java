/*
 * Copyright (C) 2005 Joe Walnes.
 * Copyright (C) 2006, 2007, 2014 XStream Committers.
 * All rights reserved.
 *
 * The software in this package is published under the terms of the BSD
 * style license a copy of which has been included with this distribution in
 * the LICENSE.txt file.
 * 
 * Created on 24. April 2005 by Joe Walnes
 */
package com.feilong.lib.xstream.io;

import java.util.Iterator;

/**
 * Provide an iterator over the attribute names of the current node of a reader.
 *
 * @author Joe Walnes
 * @deprecated As of 1.4.8, it is an internal helper class only
 */
@Deprecated
public class AttributeNameIterator implements Iterator{

    private int                            current;

    private final int                      count;

    private final HierarchicalStreamReader reader;

    public AttributeNameIterator(HierarchicalStreamReader reader){
        this.reader = reader;
        count = reader.getAttributeCount();
    }

    @Override
    public boolean hasNext(){
        return current < count;
    }

    @Override
    public Object next(){
        return reader.getAttributeName(current++);
    }

    @Override
    public void remove(){
        throw new UnsupportedOperationException();
    }

}
