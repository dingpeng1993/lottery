package com.dingpeng.java.exercise.lottery.resource.factory;


import com.dingpeng.java.exercise.lottery.domain.model.BaseConstraint;
import com.dingpeng.java.exercise.lottery.resource.entity.ConstraintEntity;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author dp
 * Date: 2019/2/25 15:28
 * Description: TODO
 */
public class ConstraintFactory {
    public static List<ConstraintEntity> transfer(List<BaseConstraint> constraintList) {
        if (constraintList == null) {
            return Lists.newArrayList();
        }
        return constraintList.stream().filter(Objects::nonNull).map(ConstraintFactory::transfer).collect(Collectors.toList());
    }

    public static ConstraintEntity transfer(BaseConstraint constraint){
        ConstraintEntity constraintEntity = new ConstraintEntity();
        if (constraint == null) {
            return constraintEntity;
        }
        constraintEntity.setConstraintKey(constraint.getKey());
        constraintEntity.setConstraintValue(constraint.getValue());
        constraintEntity.setName(constraint.getName());
        constraintEntity.setType(constraint.getType());
        return constraintEntity;
    }
}
