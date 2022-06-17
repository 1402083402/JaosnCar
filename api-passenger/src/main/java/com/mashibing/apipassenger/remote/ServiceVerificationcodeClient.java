package com.mashibing.apipassenger.remote;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.response.NumberCodeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Jason
 * @date 2022/6/17
 * hello ashen one
 */
@FeignClient("service-verificationcode")
public interface ServiceVerificationcodeClient {
    @GetMapping("/numberCode/6")
    ResponseResult<NumberCodeResponse> getNumberCode();
}
