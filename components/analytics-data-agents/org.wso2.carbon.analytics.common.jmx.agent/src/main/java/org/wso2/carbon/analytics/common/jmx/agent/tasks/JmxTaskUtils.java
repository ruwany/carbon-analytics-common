/*
*  Copyright (c) WSO2 Inc. (http://wso2.com) All Rights Reserved.

  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing,
*  software distributed under the License is distributed on an
*  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*  KIND, either express or implied.  See the License for the
*  specific language governing permissions and limitations
*  under the License.
*
*/

package org.wso2.carbon.analytics.common.jmx.agent.tasks;

import org.wso2.carbon.analytics.common.jmx.agent.JmxConstant;
import org.wso2.carbon.analytics.common.jmx.agent.profiles.Profile;
import org.wso2.carbon.ntask.core.TaskInfo;
import org.wso2.carbon.ntask.core.TaskInfo.TriggerInfo;

import java.util.HashMap;
import java.util.Map;

public class JmxTaskUtils {

    public static TaskInfo convert(Profile profile) {
        TriggerInfo triggerInfo = new TriggerInfo();

        triggerInfo.setCronExpression(profile.getCronExpression());

        Map<String, String> props = new HashMap<String, String>(1);
        props.put(JmxConstant.JMX_PROFILE_NAME, profile.getName());

        return new TaskInfo(profile.getName(), JmxTask.class.getName(), props, triggerInfo);
    }
}
