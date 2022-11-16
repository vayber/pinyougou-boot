package com.vayber.pinyougou.service.proType;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vayber.pinyougou.bean.ProType;
import com.vayber.pinyougou.mapper.ProTypeMapper;
import org.springframework.stereotype.Service;

@Service
public class ProTypeServiceImpl extends ServiceImpl<ProTypeMapper, ProType> implements ProTypeService {
}
