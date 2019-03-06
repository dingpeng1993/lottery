package com.dingpeng.java.exercise.lottery.domain.service;

import com.dingpeng.java.exercise.lottery.domain.model.Activity;
import com.dingpeng.java.exercise.lottery.domain.repository.ActivityRepository;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author dp
 * Date: 2019/2/25 10:04
 * Description: TODO
 */

@Service
public class ActivityService {
    
    @Resource
    private ActivityRepository activityRepository;
    
    public Long saveActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public Long updateActivity(Activity activity){
        return 1L;
    }
}
