package com.socialmedia.pub.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
    USER_UPDATE("user:update"),
    USER_CREATE("user:create"),
    USER_REMOVE("user:remove"),
    USER_PAY("user:pay"),
    USER_LIKE("user:like");

    @Getter
    private final String permission;
}
