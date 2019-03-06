package com.dingpeng.java.exercise.lottery.domain.repository;

import com.dingpeng.java.exercise.lottery.domain.model.Activity; /**
 * @author dp
 * Date: 2019/2/25 10:07
 * Description: TODO
 */
public interface ActivityRepository {

    /**
     * 存储活动到数据库，返回活动Id
     * @param activity
     * @return
     */
    Long save(Activity activity);
}
