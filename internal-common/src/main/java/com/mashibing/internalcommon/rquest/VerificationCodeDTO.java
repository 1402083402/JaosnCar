package com.mashibing.internalcommon.rquest;

import lombok.Data;

/**
 * @author Jason
 * @date 2022/6/16
 * hello ashen one
 */
@Data
public class VerificationCodeDTO {
    private String passengerPhone;
    private String verificationCode;
}