package com.application.JWT.config;

public enum Role {
    ROLE_SYSADMIN(0),
    ROLE_CUSTOM_ADMIN(1),
    ROLE_CUSTOM_USER(2),
    ROLE_TENANT_ADMIN(3),
    ROLE_TENANT_USER(4);
    private final int value;

    Role(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public static Role fromByteValue(byte roleValue) {
        for (Role role : Role.values()) {
            if (role.getValue() == roleValue) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid role value: " + roleValue);
    }
}
