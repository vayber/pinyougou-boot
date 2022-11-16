package com.vayber.pinyougou.config;

import com.vayber.pinyougou.bean.QiNiuUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(QiNiuUtil.class)
@ConditionalOnMissingBean(name = "qiniu")
@Configuration
public class QINiuConfig {
}
