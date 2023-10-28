package com.agileboot.flowable.utils;

import cn.hutool.core.util.ObjectUtil;
import com.agileboot.infrastructure.user.AuthenticationUtils;
import com.agileboot.infrastructure.user.web.SystemLoginUser;
import com.agileboot.flowable.common.constant.TaskConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * 工作流任务工具类
 *
 * @author konbai
 * @createTime 2022/4/24 12:42
 */
public class TaskUtils {

    public static String getUserId() {
        return String.valueOf(AuthenticationUtils.getSystemLoginUser().getUserId());
    }

    /**
     * 获取用户组信息
     *
     * @return candidateGroup
     */
    public static List<String> getCandidateGroup() {
        List<String> list = new ArrayList<>();
        SystemLoginUser user = AuthenticationUtils.getSystemLoginUser();
        if (ObjectUtil.isNotNull(user)) {

            if (user.getRoleId() != null) {
                list.add(TaskConstants.ROLE_GROUP_PREFIX + user.getRoleId());
            }
            if (ObjectUtil.isNotNull(user.getDeptId())) {
                list.add(TaskConstants.DEPT_GROUP_PREFIX + user.getDeptId());
            }
        }
        return list;
    }
}