package com.vayber.pinyougou.bean;


import com.google.gson.Gson;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


@ConfigurationProperties(prefix = "qiniu")
@Data
public class QiNiuUtil {
     String accessKey;
     String secretKey;
     String bucket;


     public String upload(MultipartFile file, String key){
          key = file.hashCode()+key;
          Configuration  cfg = new Configuration(Region.xinjiapo()) ;
          UploadManager uploadManager = new UploadManager(cfg);
          Auth auth = Auth.create(accessKey, secretKey);
          String upToken = auth.uploadToken(bucket);

          //把文件转化为字节数组
          InputStream is = null;
          ByteArrayOutputStream bos = null;

          try {
               is = file.getInputStream();
               bos = new ByteArrayOutputStream();
               byte[] b = new byte[1024];
               int len = -1;
               while ((len = is.read(b)) != -1){
                    bos.write(b, 0, len);
               }
               byte[] uploadBytes = bos.toByteArray();
               Response response = uploadManager.put(uploadBytes, key, upToken);
               DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

               return putRet.key;

          } catch (IOException e) {
               e.printStackTrace();
               return null;
          }

     }

     
}
