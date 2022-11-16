package com.vayber.pinyougou.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

//商品
@Repository
@TableName("product")
@Data
public class Product {
    @TableId(type = IdType.AUTO)
    Integer id;
    String name;
    String model;
    String price;
    String description;
    Integer proTypeId;
    String img;

    //String typeName;

}
