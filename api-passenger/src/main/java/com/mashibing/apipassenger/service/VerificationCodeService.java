package com.mashibing.apipassenger.service;

import com.mashibing.apipassenger.remote.ServiceVerificationcodeClient;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.response.NumberCodeResponse;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author Jason
 * @date 2022/6/16
 * hello ashen one
 */
@Service
public class VerificationCodeService {
    @Resource
    private ServiceVerificationcodeClient serviceVerificationcodeClient;
    /**
     * 乘客验证码前缀
     */
    private String verificationCodePrefix = "passenger-verification-code-";
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public ResponseResult generatorCode(String passengerPhone) {
        ResponseResult<NumberCodeResponse> result = serviceVerificationcodeClient.getNumberCode(6);
        //拿到验证码
        Integer numberCode = result.getData().getNumberCode();
        //构建key
        String codeKey = verificationCodePrefix + passengerPhone;
        //存入redis,设置过期时间
        stringRedisTemplate.opsForValue().set(codeKey, numberCode + "", 2, TimeUnit.MINUTES);
        //将短信发送到手机上

        return ResponseResult.success();
    }
}
