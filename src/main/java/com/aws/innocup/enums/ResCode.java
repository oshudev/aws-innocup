package com.aws.innocup.enums;

public enum ResCode {

    RES_OK(200),
    RES_REQUEST_PARAM_ERROR(400),
    RES_USER_ALREADY_EXISTS(400),
    RES_CONTENT_TYPE_ERROR(400),
    RES_APPKEY_ERROR(400),
    RES_UNAUTHORIZED_ERROR(401),
    RES_USER_NOT_FOUND(404),
    RES_REQUEST_METHOD_ERROR(405),
    RES_REACH_LIMIT(429),
    RES_UNKNOWN(500);

    public final int code;

    ResCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
