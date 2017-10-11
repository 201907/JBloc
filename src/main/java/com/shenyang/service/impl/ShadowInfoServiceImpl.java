package com.shenyang.service.impl;

import com.shenyang.bean.ShadowInfo;
import com.shenyang.dao.ShadowInfoMapper;
import com.shenyang.service.ShadowInfoService;
import com.shenyang.utils.Base64Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShadowInfoServiceImpl implements ShadowInfoService {
    @Autowired
    private ShadowInfoMapper shadowInfoMapper;
    private Logger logger = LogManager.getLogger(ShadowInfoServiceImpl.class);
    /**
     * 返回shadowsocks二维码字符串
     *
     * @return
     */
    @Override
    public String getShadowsocksEncryCode() {
        ShadowInfo shadowInfo = shadowInfoMapper.selectByPrimaryKey(1);
        String str = shadowInfo.getEncryptMethod() + ":"
                + shadowInfo.getPassword() + "@" +
                shadowInfo.getIp() + ":" + shadowInfo.getPort();
        logger.info(str);
        return "ss://" + Base64Util.encodeStr(str);
    }
}
