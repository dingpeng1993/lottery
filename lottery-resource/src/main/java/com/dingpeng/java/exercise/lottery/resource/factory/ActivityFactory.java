package com.dingpeng.java.exercise.lottery.resource.factory;

import com.dingpeng.java.exercise.lottery.domain.model.Activity;
import com.dingpeng.java.exercise.lottery.resource.entity.ActivityEntity;


/**
 * @author dp
 * Date: 2019/2/25 10:25
 * Description: TODO
 */
public class ActivityFactory {

    public static ActivityEntity transfer(Activity activity) {
        if (activity == null) {
            return null;
        }
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setName(activity.getName());
        activityEntity.setDescription(activity.getDescription());
        activityEntity.setStartTime(activity.getStartTime());
        activityEntity.setEndTime(activity.getEndTime());
        activityEntity.setStatus(activity.getStatus());
        return activityEntity;
    }
}
