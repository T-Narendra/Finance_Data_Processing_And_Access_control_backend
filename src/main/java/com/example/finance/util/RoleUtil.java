package com.example.finance.util;

public class RoleUtil {

    public static void checkAdmin(String role) {
        if (!"ADMIN".equals(role)) {
            throw new RuntimeException("Access Denied: Admin only");
        }
    }

    public static void checkAnalystOrAdmin(String role) {
        if (!role.equals("ADMIN") && !role.equals("ANALYST")) {
            throw new RuntimeException("Access Denied");
        }
    }

    public static void checkAllRoles(String role) {
        if (!role.equals("ADMIN") && !role.equals("ANALYST") && !role.equals("VIEWER")) {
            throw new RuntimeException("Invalid Role");
        }
    }
}
