package com.vayber.pinyougou.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

//顾客
@Repository
@TableName("customer")
@Data
public class Customer {
    @TableId(type = IdType.AUTO)
    Integer id;

    String customerName;

    String email;

    String emailPwd;

}
