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

package com.cloudera.nav.sdk.client.writer;

import com.cloudera.nav.sdk.model.entities.Entity;
import com.cloudera.nav.sdk.model.relations.Relation;
import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.Map;

/**
 * Thin wrapper for entities and relations. This class is used to store
 * a flat representation of entities and relations starting with
 * a particular Entity instance and following @MRelation annotations
 */
public class MClassWrapper {

  private final Map<String, Entity> entities;
  private final Map<String, Relation> relations;
  private boolean autocommit;

  public MClassWrapper() {
    this.entities = Maps.newHashMap();
    this.relations = Maps.newHashMap();
  }

  public Collection<Entity> getEntities() {
    return entities.values();
  }

  public boolean hasEntity(Entity en) {
    return entities.containsKey(en.getIdentity());
  }

  public void addEntity(Entity en) {
    entities.put(en.getIdentity(), en);
  }

  public Collection<Relation> getRelations() {
    return relations.values();
  }

  public void addRelation(Relation r) {
    relations.put(r.getIdentity(), r);
  }

  public void addRelations(Collection<Relation> relations) {
    for (Relation r : relations) {
      addRelation(r);
    }
  }

  public boolean isAutocommit() {
    return autocommit;
  }

  public void setAutocommit(boolean autocommit) {
    this.autocommit = autocommit;
  }
}