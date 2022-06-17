package com.mashibing.internalcommon.constant;

import lombok.Getter;

/**
 * @author Jason
 * @date 2022/6/16
 * hello ashen one
 */
public enum CommonStatusEnum {
    /**
     * 成功
     */
    SUCCESS(1,"success"),
    /**
     * 失败
     */
    FAIL(0,"fail");
    @Getter
    private int code;
    @Getter
    private String value;
    CommonStatusEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }
}
