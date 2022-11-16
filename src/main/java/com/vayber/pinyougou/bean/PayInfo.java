package com.vayber.pinyougou.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

//支付信息
@Repository
@TableName("payinfo")
@Data
public class PayInfo {
    @TableId(type = IdType.AUTO)
    Integer id;
    String type;
    String name;
    String number;
    String billAddress;
    String expiryDate;
    Integer customerId;

}
