package com.vayber.pinyougou.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

//订单
@Repository
@TableName("orders")
@Data
public class Orders {
    @TableId(type = IdType.AUTO)
    Integer id;
    String productName;
    Integer counts;
    String price;
    Integer customerId;

//    String customerName;
    Integer isPayment;              //是否支付    1       2

    //String isPayments;          //是否支付   未支付  已支付

    String creationDate;
    String modifyDate;
    String totalPrice;
    String consignee;   //收货人
    String phone;       //联系电话
    String address;     //地址


}
