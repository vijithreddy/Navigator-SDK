/*
 * Copyright (c) 2015 Cloudera, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cloudera.nav.sdk.client.writer.serde;

import com.cloudera.nav.sdk.client.writer.registry.MClassRegistry;
import com.cloudera.nav.sdk.client.writer.registry.MPropertyEntry;
import com.cloudera.nav.sdk.model.annotations.MClass;
import com.cloudera.nav.sdk.model.annotations.MProperty;
import com.cloudera.nav.sdk.model.entities.Entity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.google.common.collect.Maps;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections.MapUtils;

/**
 * JSON serializer for Entity instances. It writes managed custom properties
 * with their specified value types, into a 'customProperties' map attribute.
 * Remaining MProperty's are written as key-value pairs.
 * We also automatically add internalType and metaClassName attributes needed
 * by the server to map the meta-model
 */
public class EntityV9Serializer extends EntitySerializer {
  public EntityV9Serializer(MClassRegistry registry) {
    super(registry);
  }

  @Override
  protected void writeProperties(Entity t, JsonGenerator jg) throws IOException {
    Map<String, Map<String, Object>> customProperties = Maps.newHashMap();
    for (MPropertyEntry p : registry.getProperties(t.getClass())) {
      MProperty ann = p.getAnnotation();
      if (ann.register()) {
        addCustom(customProperties, p, t);
      } else {
        Object v = p.getValue(t);
        if (v != null) {
          jg.writeObjectField(p.getAttribute(), p.getValue(t));
        }
      }
    }
    String modelName = t.getClass().getAnnotation(MClass.class).model();
    jg.writeStringField("internalType", modelName);

    jg.writeStringField("metaClassName", modelName);
    if (MapUtils.isNotEmpty(customProperties)) {
      jg.writeObjectField("customProperties", customProperties);
    }
  }

  private void addCustom(Map<String, Map<String, Object>> customProperties,
                         MPropertyEntry prop, Entity t) {
    String namespace = registry.getNamespace();
    Map<String, Object> propMap = customProperties.get(namespace);
    if (propMap == null) {
      propMap = Maps.newHashMap();
      customProperties.put(namespace, propMap);
    }
    propMap.put(prop.getAttribute(), prop.getValue(t));
  }
}
