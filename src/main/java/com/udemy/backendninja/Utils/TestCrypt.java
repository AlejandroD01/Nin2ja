
package com.udemy.backendninja.Utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestCrypt {

    public static void main(String[] args) {
        BCryptPasswordEncoder bcpe= new BCryptPasswordEncoder();
        System.out.println(bcpe.encode("user"));    
    }
    
}
