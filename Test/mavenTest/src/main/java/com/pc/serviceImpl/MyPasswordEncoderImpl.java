package com.pc.serviceImpl;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.security.crypto.password.PasswordEncoder;
import sun.security.provider.MD5;
import sun.security.rsa.RSASignature;

/**
 * security用来实现对密码的加密解密
 * */
public class MyPasswordEncoderImpl implements PasswordEncoder {
    //加密salt
    private final static String SALT = "pance";

    @Override
    public String encode(CharSequence charSequence) {
        return null;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return true;
    }
}
