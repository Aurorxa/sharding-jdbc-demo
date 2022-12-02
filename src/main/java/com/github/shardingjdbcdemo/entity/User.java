package com.github.shardingjdbcdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 许大仙
 * @version 1.0
 * @since 2022-12-02 14:46:32
 */
@TableName("`t_user`")
@Data
public class User {

    @TableId(type= IdType.AUTO)
    private Integer id;

    private String uname;
}
