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

package com.cloudera.nav.sdk.model.relations;

import static org.junit.Assert.assertEquals;

import com.cloudera.nav.sdk.model.MD5IdGenerator;
import com.cloudera.nav.sdk.model.SourceType;
import com.google.common.collect.ImmutableList;

import org.junit.*;

public class RelationIdGeneratorTest {

  RelationIdGenerator idGenerator;

  @Before
  public void setUp() {
    idGenerator = new RelationIdGenerator();
  }

  @Test
  public void testGenerateRelationIdentity() {
    String id = idGenerator.generateRelationIdentity(
        ImmutableList.of("ep1", "ep11"), SourceType.SDK,
        ImmutableList.of("ep2", "ep21"), SourceType.PIG,
        RelationType.DATA_FLOW, "test");
    Assert.assertEquals(MD5IdGenerator.generateIdentity("test",
        RelationType.DATA_FLOW.name(),
        "ep1,ep11", SourceType.SDK.name(),
        "ep2,ep21", SourceType.PIG.name()), id);
  }

  @Test
  public void testSorted() {
    String result = idGenerator.generateRelationIdentity(
        ImmutableList.of("ep11", "ep1"), SourceType.SDK,
        ImmutableList.of("ep21", "ep2"), SourceType.PIG,
        RelationType.DATA_FLOW, "test");
    String expected = idGenerator.generateRelationIdentity(
        ImmutableList.of("ep1", "ep11"), SourceType.SDK,
        ImmutableList.of("ep2", "ep21"), SourceType.PIG,
        RelationType.DATA_FLOW, "test");
    assertEquals(expected, result);
  }
}
