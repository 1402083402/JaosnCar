package com.mashibing.apipassenger.controller;

import com.mashibing.apipassenger.rquest.VerificationCodeDTO;
import com.mashibing.apipassenger.service.VerificationCodeService;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping("/verification-code")
    public String verificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO){
        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        return verificationCodeService.generatorCode(passengerPhone);
    }

}
