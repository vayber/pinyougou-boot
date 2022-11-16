package com.vayber.pinyougou.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

//管理员
@Repository
@Data
@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
    Integer id;
    String userName;
    String password;


}
