package com.aliyun.oss.model;

import java.io.Serializable;

/**
 *
 * @Title: FileBase64
 * @Package com.bc.jiangbei.o2o.portal.model
 * @Description: 文件bese64信息实体
 * @author cy.wang@i-vpoints.com
 * @date 2018年8月1日 上午10:15:40
 * @version V1.0
 *
 */
public class FileBase64 implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 文件base64字符串
     */
    private String base64;

    /**
     * 路径 或 模块名
     */
    private String path;

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
