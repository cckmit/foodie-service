package com.foodie.portal.encryptor;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EncryptorTest {

    @Autowired
    private StringEncryptor encryptor;

    @Test
    public void getPass() {
        String name = encryptor.encrypt("root");
        System.out.println(name+" ----------------");
        String encryptMail = encryptor.encrypt("foodie_123");
        System.out.println("mail: " + encryptMail);
        System.out.println("mail decrypt: " + encryptor.decrypt(encryptMail));
        Assert.assertTrue(name.length() > 0);
    }

    @Test
    public void decrypt() {
        System.out.println(encryptor.decrypt("WVkiUXePgoljkmdvOkWUPg=="));
    }
}
