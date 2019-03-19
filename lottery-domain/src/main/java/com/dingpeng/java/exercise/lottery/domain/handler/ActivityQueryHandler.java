package com.dingpeng.java.exercise.lottery.domain.handler;

import com.dingpeng.java.exercise.lottery.domain.model.Activity;
import org.springframework.stereotype.Service;

/**
 * @author dp
 * Date: 2019/3/13 18:14
 * Description: TODO
 */
@Service
public class ActivityQueryHandler {

    public Activity getActivity(Long activityId) {
        return new Activity();
    }
}
