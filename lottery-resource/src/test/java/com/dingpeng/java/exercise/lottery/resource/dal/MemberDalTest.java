package com.dingpeng.java.exercise.lottery.resource.dal;

import com.dingpeng.java.exercise.lottery.resource.entity.MemberEntity;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @author dp
 * Date: 2019/3/13 16:43
 * Description: TODO
 */
public class MemberDalTest {

    @Test
    void testOptional(){
        MemberEntity memberEntity = new MemberEntity();
        Optional.of(memberEntity).orElse(print());
    }

    private MemberEntity print() {
        System.out.println("我被调用了");
        return null;
    }
}
