package com.emo.until;

public class qiniu {
    public String File(){
        String accessKey = "IQLnVOyL7DpSBh_5lvTuE63jDN1Bs2Nva7euUTOb";
        String secretKey = "HJbirNIE6USLheZR8aiw5_jvV2zmVtMdDErgpyTF";
        String bucket = "liuyang23";

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        System.out.println(upToken);
        return upToken;
    }
}
