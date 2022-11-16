package com.vayber.pinyougou.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

//商品类型
@Repository
@TableName("protype")
@Data
public class ProType {
    @TableId(type = IdType.AUTO)
    Integer id;
    String name;

}
