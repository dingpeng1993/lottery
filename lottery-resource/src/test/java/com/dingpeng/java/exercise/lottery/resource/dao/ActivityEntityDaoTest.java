package com.dingpeng.java.exercise.lottery.resource.dao;

import com.dingpeng.java.exercise.lottery.common.utils.DateUtil;
import com.dingpeng.java.exercise.lottery.resource.config.MapperScannerConfig;
import com.dingpeng.java.exercise.lottery.resource.config.MybatisConfig;
import com.dingpeng.java.exercise.lottery.resource.config.TestConfig;
import com.dingpeng.java.exercise.lottery.resource.entity.ActivityEntity;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author dp
 * Date: 2019/2/26 20:04
 * Description: Junit 5 测试必须使用@ExtendWith(SpringExtension.class)启动spring
 * 自动回滚用 @Transactional
 *
 */
@SpringBootTest(classes = {TestConfig.class, MapperScannerConfig.class, MybatisConfig.class})
@ExtendWith(SpringExtension.class)
@DisplayName("活动activity表增删改操作测试")
class ActivityEntityDaoTest {

    @Resource
    private ActivityEntityDao activityEntityDao;

    /**
     * 类中每个测试方法运行之前运行
     */
    @BeforeEach
    void setUp()  {
    }

    @Test
    @DisplayName("插入一个活动测试")
    @Transactional
    void testInsertOne(){
        ActivityEntity activityEntity = createActivityEntity("新年大礼包抽奖活动","为了测试插入的活动Entity",
                "2018-12-31 00:00:00", "2019-06-31 24:00:00", 1);
        long rows = activityEntityDao.insertOne(activityEntity);
        Assertions.assertNotEquals(1L, activityEntity.getId());
        Assertions.assertEquals(1L,rows);
    }

    @ParameterizedTest
    @CsvSource({
            "2018-01-05 00:00:00",
            "2019-01-05 00:00:00",
            "2018-01-01 00:00:00",
    })
    void selectEffectiveActivity(String time) {
        List<ActivityEntity> activityEntities = activityEntityDao.selectEffectiveActivity(DateUtil.parseStringToDateTime(time));
        Assertions.assertTrue(activityEntities.size() > 0);
    }

    @ParameterizedTest
    @CsvSource({"1", "4"})
    void testUpdateSuccess(Long primaryId){
        ActivityEntity activityEntity = createActivityEntity("抽奖活动1","测试List",
                "2018-12-31 00:00:00", "2019-06-31 24:00:00", 0);
        activityEntity.setId(primaryId);
        long row = activityEntityDao.updateByPrimaryKey(activityEntity);
        Assertions.assertEquals(1L, row);
    }

    @Test
    @Transactional
    void insertList() {
        ActivityEntity activityEntity1 = createActivityEntity("抽奖活动1","测试List",
                "2018-12-31 00:00:00", "2019-06-31 24:00:00", 0);
        ActivityEntity activityEntity2 = createActivityEntity("抽奖活动2","测试List",
                "2017-12-31 00:00:00", "2018-06-31 24:00:00", 0);
        List<ActivityEntity> activityEntities = Lists.newArrayList();
        activityEntities.add(activityEntity1);
        activityEntities.add(activityEntity2);
        long rows = activityEntityDao.insertList(activityEntities);
        Assertions.assertEquals(2, rows);
     }

    private ActivityEntity createActivityEntity(String name, String description, String startTime, String endTime, int status) {
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setName(name);
        activityEntity.setDescription(description);
        activityEntity.setStartTime(DateUtil.parseStringToDateTime(startTime));
        activityEntity.setEndTime(DateUtil.parseStringToDateTime(endTime));
        activityEntity.setStatus(status);
        return activityEntity;
    }
}