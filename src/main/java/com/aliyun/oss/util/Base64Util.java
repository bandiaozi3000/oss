package com.aliyun.oss.util;

import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 *
 * @Title: Base64Util
 * @Package com.bc.jiangbei.o2o.portal.util
 * @Description: base64工具类
 * @author cy.wang@i-vpoints.com
 * @date 2018年8月1日 上午10:21:22
 * @version V1.0
 *
 */
public class Base64Util {

    final static String base64Prefix = "base64,";

    public static InputStream baseToInputStream(String base64string) {
        if (base64string.indexOf(base64Prefix) > 0) {
            base64string = base64string.substring(base64string.indexOf(base64Prefix) + base64Prefix.length());
        }
        ByteArrayInputStream stream = null;
        try {
            Base64 decoder = new Base64();
            byte[] bytes1 = decoder.decode(base64string);
            stream = new ByteArrayInputStream(bytes1);
        } catch (Exception e) {
        }
        return stream;
    }
}
