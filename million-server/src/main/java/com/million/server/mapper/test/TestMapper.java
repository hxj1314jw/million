package com.million.server.mapper.test;

import com.million.dto.test.UserInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2018/1/15.
 */
@Repository
public interface TestMapper extends Mapper<UserInfo> {

    List<UserInfo> listUser();
}
