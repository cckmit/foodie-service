package com.foodie.portal.commons.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class EncryptUtilsTest {

    @Test
    public void getPassword() {
        System.out.println(EncryptUtils.getPassword("foodie_admin_123", "admin"));
    }
}
