package com.vayber.pinyougou.service.payInfo;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vayber.pinyougou.bean.PayInfo;
import com.vayber.pinyougou.mapper.PayInfoMapper;
import org.springframework.stereotype.Service;

@Service
public class PayInfoServiceImpl extends ServiceImpl<PayInfoMapper, PayInfo> implements PayInfoService {

}
