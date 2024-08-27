package com.github.nschlechter.showlist.server.dal;

public class TestConstantHelper {

    public static String DUMMY_USER = "dummyUser";
    public static String DUMMY_PASSWORD = "dummyPassword";

    public String getEmail(String username) {
        return username + "@domain.com";
    }
}
