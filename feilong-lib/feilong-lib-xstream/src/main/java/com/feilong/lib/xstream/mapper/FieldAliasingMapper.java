/*
 * Copyright (C) 2005 Joe Walnes.
 * Copyright (C) 2006, 2007, 2008, 2009, 2013, 2014, 2016 XStream Committers.
 * All rights reserved.
 *
 * The software in this package is published under the terms of the BSD
 * style license a copy of which has been included with this distribution in
 * the LICENSE.txt file.
 * 
 * Created on 09. April 2005 by Joe Walnes
 */
package com.feilong.lib.xstream.mapper;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import com.feilong.lib.xstream.core.util.FastField;

/**
 * Mapper that allows a field of a specific class to be replaced with a shorter alias.
 *
 * @author Joe Walnes
 */
public class FieldAliasingMapper extends MapperWrapper{

    protected final Map                 fieldToAliasMap = new HashMap();

    protected final Map                 aliasToFieldMap = new HashMap();

    private final ElementIgnoringMapper elementIgnoringMapper;

    public FieldAliasingMapper(Mapper wrapped){
        super(wrapped);
        elementIgnoringMapper = (ElementIgnoringMapper) lookupMapperOfType(ElementIgnoringMapper.class);
    }

    public void addFieldAlias(String alias,Class type,String fieldName){
        fieldToAliasMap.put(key(type, fieldName), alias);
        aliasToFieldMap.put(key(type, alias), fieldName);
    }

    /**
     * @deprecated As of 1.4.9 use {@link ElementIgnoringMapper#addElementsToIgnore(Pattern)}.
     */
    @Deprecated
    public void addFieldsToIgnore(final Pattern pattern){
        if (elementIgnoringMapper != null){
            elementIgnoringMapper.addElementsToIgnore(pattern);
        }
    }

    /**
     * @deprecated As of 1.4.9 use {@link ElementIgnoringMapper#omitField(Class, String)}.
     */
    @Deprecated
    public void omitField(Class definedIn,String fieldName){
        if (elementIgnoringMapper != null){
            elementIgnoringMapper.omitField(definedIn, fieldName);
        }
    }

    private Object key(Class type,String name){
        return new FastField(type, name);
    }

    @Override
    public String serializedMember(Class type,String memberName){
        String alias = getMember(type, memberName, fieldToAliasMap);
        if (alias == null){
            return super.serializedMember(type, memberName);
        }else{
            return alias;
        }
    }

    @Override
    public String realMember(Class type,String serialized){
        String real = getMember(type, serialized, aliasToFieldMap);
        if (real == null){
            return super.realMember(type, serialized);
        }else{
            return real;
        }
    }

    private String getMember(Class type,String name,Map map){
        String member = null;
        for (Class declaringType = type; member == null && declaringType != Object.class
                        && declaringType != null; declaringType = declaringType.getSuperclass()){
            member = (String) map.get(key(declaringType, name));
        }
        return member;
    }
}
