/*
 * Copyright 2017 Jin Kwon &lt;onacit at gmail.com&gt;.
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
package com.github.jinahya.openfire.xml.bind;

import com.github.jinahya.openfire.persistence.OfMapped;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import org.testng.annotations.Test;

/**
 * Test cases for JAXB.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class JaxbTest {

    @Test
    public static void context() throws JAXBException {
        final JAXBContext context = JAXBContext.newInstance(
                OfMapped.class.getPackage().getName());
    }

    @Test
    public static void schema() throws JAXBException, IOException {
        final JAXBContext context = JAXBContext.newInstance(
                OfMapped.class.getPackage().getName());
        context.generateSchema(new SchemaOutputResolver() {
            @Override
            public Result createOutput(final String namespaceUri,
                                       final String suggestedFileName)
                    throws IOException {
                return new StreamResult(System.out) {
                    @Override
                    public String getSystemId() {
                        return "openfire-bind.xsd";
                    }
                };
            }
        });
    }
}