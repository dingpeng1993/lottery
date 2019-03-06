package com.dingpeng.java.exercise.lottery.biz.flow;

import com.dingpeng.java.exercise.lottery.biz.transfer.ActivityTransfer;
import com.dingpeng.java.exercise.lottery.common.request.SaveActivityRequest;
import com.dingpeng.java.exercise.lottery.domain.model.Activity;
import com.dingpeng.java.exercise.lottery.domain.service.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author dp
 * Date: 2019/2/20 16:03
 * Description:
 */

@Slf4j
@Service
public class ActivityFlow {

    @Resource
    private ActivityService activityService;

    public Long doSave(SaveActivityRequest activityRequest) {
        //业务检查
        checkSave(activityRequest);
        // 创建活动
        Activity activity = ActivityTransfer.transfer(activityRequest);
        //保存活动
        return activityService.saveActivity(activity);
    }

    private void checkSave(SaveActivityRequest activityRequest) {
    }


}
