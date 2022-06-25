package com.mashibing.apipassenger.service;

import com.mashibing.apipassenger.remote.ServicePassengerUserClient;
import com.mashibing.apipassenger.remote.ServiceVerificationcodeClient;
import com.mashibing.internalcommon.constant.CommonStatusEnum;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.response.NumberCodeResponse;
import com.mashibing.internalcommon.response.TokenResponse;
import com.mashibing.internalcommon.rquest.VerificationCodeDTO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ServicePassengerUserClient servicePassengerUserClient;

    public ResponseResult generatorCode(String passengerPhone) {
        ResponseResult<NumberCodeResponse> result = serviceVerificationcodeClient.getNumberCode(6);
        //拿到验证码
        Integer numberCode = result.getData().getNumberCode();
        //构建key
        String codeKey = generatorKeyByPhone(passengerPhone);
        //存入redis,设置过期时间
        stringRedisTemplate.opsForValue().set(codeKey, numberCode + "", 2, TimeUnit.MINUTES);
        //将短信发送到手机上

        return ResponseResult.success();
    }

    public ResponseResult checkCode(String passengerPhone, String verificationCode) {
        //根据手机号从redis中读取验证码

        //生成key
        String key = generatorKeyByPhone(passengerPhone);
        //根据key获取value
        String codeRedis = stringRedisTemplate.opsForValue().get(key);
        //校验验证码
        if (StringUtils.isBlank(codeRedis)) {
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(), CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
        }
        if (!verificationCode.trim().equals(codeRedis.trim())) {
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(), CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
        }
        //判断原来是否有用户并进行对应的处理
        VerificationCodeDTO verificationCodeDTO = new VerificationCodeDTO();
        verificationCodeDTO.setPassengerPhone(passengerPhone);
        servicePassengerUserClient.loginOrRegister(verificationCodeDTO);
        //颁发令牌

        //响应
        TokenResponse tokenResponse=new TokenResponse();
        tokenResponse.setToken("token value");
        return ResponseResult.success();
    }

    public String generatorKeyByPhone(String passengerPhone) {
        return verificationCodePrefix + passengerPhone;
    }

}
