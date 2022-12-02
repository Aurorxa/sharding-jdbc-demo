package com.github.shardingjdbcdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.shardingjdbcdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 许大仙
 * @version 1.0
 * @since 2022-12-02 14:51:29
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
