package com.foodie.portal.commons.utils;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.junit.Test;

import static org.junit.Assert.*;

public class EncryptUtilsTest {

    @Test
    public void getPassword() {

        System.out.println(EncryptUtils.getPassword("1114595662", "1114595662@qq.com"));

        System.out.println(EncryptUtils.getPassword("1748429524", "1748429524@qq.com"));

        String pwd = "EbfYkitulv73I2p0mXI50JMXoaxZTKJ7";


        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        //加密配置
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        config.setAlgorithm("PBEWithMD5AndDES");
        //自己在用的时候更改此密码
        config.setPassword("EbfYkitulv73I2p0mXI50JMXoaxZTKJ7");
        //应用配置
        encryptor.setConfig(config);
        String ciphertext="IBjIOLt7v0tapxkJ0lDLIa4jnnEQjq07";
        //解密
        String plaintext=encryptor.decrypt(ciphertext);
        System.out.println(ciphertext + " : " + plaintext);

    }
}
