/*
 * Copyright 2006-2008 Web Cohesion
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codehaus.enunciate.modules.rest;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.Map;

/**
 * JAXB error view for JSON operation requests.
 *
 * @author Ryan Heaton
 */
public class JaxbJsonExceptionHandler extends JaxbXmlExceptionHandler {

  private final JsonSerializationMethod serializationMethod;
  
  public JaxbJsonExceptionHandler(Map<String, String> ns2prefix, JsonSerializationMethod serializationMethod) {
    super(ns2prefix);
    this.serializationMethod = serializationMethod;
  }

  @Override
  protected JaxbXmlView newJaxbView(final Class errorType, RESTOperation operation) {
    return new JaxbJsonView(operation, getNamespaces2Prefixes()) {
      @Override
      protected Marshaller newMarshaller() throws JAXBException {
        return JAXBContext.newInstance(errorType).createMarshaller();
      }
    };
  }
}