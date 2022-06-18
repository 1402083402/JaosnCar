package com.mashibing.apipassenger.controller;
import com.mashibing.apipassenger.service.VerificationCodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author Jason
 * @date 2022/6/16
 * hello ashen one
 */
@RestController
public class VerificationCodeController {
    @Resource
    private VerificationCodeService verificationCodeService;

    /**
     * 发验证码
     * @param verificationCodeDTO
     * @return
     */
    @GetMapping("/verification-code")
    public ResponseResult verificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO){
        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        return verificationCodeService.generatorCode(passengerPhone);
    }

    /**
     * 验证验证码
     * @return
     */
    @PostMapping("/verification-code-check")
    public ResponseResult check(@RequestBody Verific verificationCodeDTO){
        String verificationCode = verificationCodeDTO.getVerificationCode();
        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        verificationCodeService.checkCode(passengerPhone,verificationCode);
    }

}
