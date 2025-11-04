package com.example.employee_management.config;

public class SimplePasswordEncoder {

    public String encode(String rawPassword) {
        // Mã hóa đơn giản: đảo chuỗi + thêm tiền tố (chỉ để demo)
        return "ENC-" + new StringBuilder(rawPassword).reverse().toString();
    }

    public boolean matches(String rawPassword, String encodedPassword) {
        return encode(rawPassword).equals(encodedPassword);
    }
}
