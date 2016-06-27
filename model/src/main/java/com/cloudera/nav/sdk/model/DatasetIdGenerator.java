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

package com.cloudera.nav.sdk.model;

public class DatasetIdGenerator {

  public static final String delimiter = "/";

  public static String datasetId(String parentId, String namespace,
                                 String datasetName) {
    return MD5IdGenerator.generateIdentity(parentId, "%NAMESPACE%", namespace,
        "%DATASET%", datasetName);
  }

  public static String fieldId(String parentId, String fieldName) {
    return MD5IdGenerator.generateIdentity(parentId, "%FIELD%", fieldName);
  }

  public static String fieldIdFromPath(String parentId, String fieldPath) {
    String nestedFieldId = parentId;
    for (String s : fieldPath.split(delimiter)) {
      nestedFieldId = DatasetIdGenerator.fieldId(nestedFieldId, s);
    }
    return nestedFieldId;
  }
}
