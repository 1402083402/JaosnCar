package com.mashibing.apipassenger.service;

import com.mashibing.apipassenger.remote.ServiceVerificationcodeClient;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.response.NumberCodeResponse;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Jason
 * @date 2022/6/16
 * hello ashen one
 */
@Service
public class VerificationCodeService {
    @Resource
    private ServiceVerificationcodeClient serviceVerificationcodeClient;

    public String generatorCode(String passengerPhone) {

        String code = "1111";
        System.out.println("passengerPhone:" + passengerPhone);
        ResponseResult<NumberCodeResponse> result = serviceVerificationcodeClient.getNumberCode(6);
        //拿到验证码
        Integer numberCode = result.getData().getNumberCode();
        System.out.println("拿到的code:"+numberCode);
        return numberCode.toString();
    }
}
