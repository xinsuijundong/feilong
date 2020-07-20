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
package com.feilong.namespace.parser;

import org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser;
import org.w3c.dom.Element;

import com.feilong.net.wxwork.bot.DefaultWxworkBot;

/**
 * 用来构造 {@link com.feilong.net.wxwork.bot.DefaultWxworkBot}.
 * 
 * <b>使用:</b>
 * 
 * <pre class="code">
 * {@code 
    <feilong:wxworkBot id="wxworkBot" key="*****"/>
   }
 * 
 * </pre>
 * 
 * 
 * </blockquote>
 *
 * @author <a href="https://github.com/ifeilong/feilong">feilong</a>
 * 
 * @since 3.0.9
 */
public class WxworkBotBeanDefinitionParser extends AbstractSimpleBeanDefinitionParser{

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser#getBeanClass(org.w3c.dom.Element)
     */
    @Override
    protected Class<?> getBeanClass(Element element){
        return DefaultWxworkBot.class;
    }

}