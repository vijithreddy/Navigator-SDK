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
import com.cloudera.nav.sdk.model.relations.Relation;

public class RelationSerializer extends MClassSerializer<Relation> {
  public RelationSerializer(MClassRegistry registry) {
    super(Relation.class, registry);
  }
}
