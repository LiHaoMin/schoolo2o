package com.lihaomin.schoolo2o.util;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;

public class CloudUploadUtil {
    private static final String SECRET_ID = "AKIDLUP6bshhFXZKq6wpIWUChxxjGXZLr66q";
    private static final String SECRET_KEY = "czA6r43nHWVEiwve7KOFrFPK0GH3Zpqc";

    public static boolean upload(){
        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials(SECRET_ID, SECRET_KEY);
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region("ap-chongqing"));
        // 3 生成cos客户端
        COSClient cosclient = new COSClient(cred, clientConfig);
        // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
        String bucketName = "mybucket-1251668577";
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,"","");
        return false;
    }

}
