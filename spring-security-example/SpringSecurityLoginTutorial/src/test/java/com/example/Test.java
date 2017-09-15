package com.example;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author <a href="mailto:huanhuan.zhan@ptmind.com">詹欢欢</a>
 * @since 2017/4/23 - 21:31
 */
public class Test {

    public static void main(String[] args) {
        int t = 0;
        String password = "123456";
        System.out.println(password + " -> ");
        for (t = 1; t <= 10; t++) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(password);
            System.out.println(hashedPassword);
        }

        password = "MIKE123";
        System.out.println(password + " -> ");
        for (t = 1; t <= 10; t++) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(password);
            System.out.println(hashedPassword);
        }
    }
}
