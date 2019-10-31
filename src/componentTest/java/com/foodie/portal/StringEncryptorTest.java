package com.foodie.portal;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StringEncryptorTest {

    @Autowired
    private StringEncryptor stringEncryptor;


    @Test
    public void test() {

        System.out.println(stringEncryptor.decrypt("3XCbRyXpOqxgOeXYs89tQ1QmbpLRiGwg"));
    }

}
