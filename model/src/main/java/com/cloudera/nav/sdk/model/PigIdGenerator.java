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

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

import org.apache.commons.configuration.MapConfiguration;

public class PigIdGenerator {

  @VisibleForTesting
  public static final String PIG_SCRIPT_ID_PROP = "pig.script.id";
  @VisibleForTesting
  public static final String PIG_LOGICAL_PLAN_HASH_PROP = "pig.logicalPlan.hash";

  /**
   * Generate the correct operation id based on the job name and the
   * job configurations
   *
   * @param jobName Yarn application name or MR job name
   * @param jobConf
   * @return
   */
  public static String generateNewOperationId(String jobName,
                                              MapConfiguration jobConf) {
    Preconditions.checkArgument(jobConf.containsKey(PIG_LOGICAL_PLAN_HASH_PROP),
        "Could not find " + PIG_LOGICAL_PLAN_HASH_PROP +
            " in job configurations");
    String logicalPlanHash = jobConf.getString(PIG_LOGICAL_PLAN_HASH_PROP);
    return MD5IdGenerator.generateIdentity(jobName, logicalPlanHash);
  }

  /**
   * Create a valid PigOperationExecution identity from the pig job
   * configurations
   *
   * @param jobConf
   * @return
   */
  public static String generateExecutionId(MapConfiguration jobConf) {
    Preconditions.checkArgument(jobConf.containsKey(PIG_SCRIPT_ID_PROP),
        "Could not find " + PIG_SCRIPT_ID_PROP + " in job configurations");
    return MD5IdGenerator.generateIdentity(jobConf.getString(
        PIG_SCRIPT_ID_PROP));
  }
}
