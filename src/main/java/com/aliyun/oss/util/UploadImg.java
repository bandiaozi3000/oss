package com.aliyun.oss.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.conf.OssConfig;
import com.aliyun.oss.model.FileBase64;
import com.aliyun.oss.model.OSSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class UploadImg {

    @Autowired
    private  OssConfig ossConfig;

    public void upload(){
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = ossConfig.getEndpoint();
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = ossConfig.getAccessKeyId();
        String accessKeySecret = ossConfig.getSecretAccessKey();
        String bucketName = ossConfig.getBucketName();

// 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

// 上传字符串。
        String content = "Hello OSS";
        ossClient.putObject(bucketName, "hello1", new ByteArrayInputStream(content.getBytes()));

// 关闭OSSClient。
        ossClient.shutdown();
    }

    public void delete(){
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = ossConfig.getEndpoint();
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = ossConfig.getAccessKeyId();
        String accessKeySecret = ossConfig.getSecretAccessKey();
        String bucketName = ossConfig.getBucketName();

// 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

// 上传字符串。

        ossClient.deleteObject(bucketName, "img");

// 关闭OSSClient。
        ossClient.shutdown();
    }

    public void load() throws IOException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = ossConfig.getEndpoint();
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId =  ossConfig.getAccessKeyId();
        String accessKeySecret = ossConfig.getSecretAccessKey();
        String bucketName = ossConfig.getBucketName();
        String objectName = "hello1";

// 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

// 调用ossClient.getObject返回一个OSSObject实例，该实例包含文件内容及文件元信息。
        OSSObject ossObject = ossClient.getObject(bucketName, objectName);
// 调用ossObject.getObjectContent获取文件输入流，可读取此输入流获取其内容。
        InputStream content = ossObject.getObjectContent();
        if (content != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(content));
            while (true) {
                String line = reader.readLine();
                if (line == null){
                    break;
                }
                System.out.println("\n" + line);
            }
            // 数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。
            content.close();
        }

// 关闭OSSClient。
        ossClient.shutdown();
    }

    public void uploadImg(FileBase64 file ){
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = ossConfig.getEndpoint();
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = ossConfig.getAccessKeyId();
        String accessKeySecret = ossConfig.getSecretAccessKey();
        String bucketName = ossConfig.getBucketName();

// 创建OSSClient实例。

        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

// 上传字符串。
        ossClient.putObject(bucketName, "img/img.jpg", Base64Util.baseToInputStream(file.getBase64()));

// 关闭OSSClient。
        ossClient.shutdown();
    }
}
