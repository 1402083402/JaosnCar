package com.mashibing.serviceverificationcode;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.response.NumberCodeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jason
 * @date 2022/6/16
 * hello ashen one
 */
@RestController
public class NumberCodeController {
    @GetMapping("/numberCode/{size}")
    public ResponseResult numberCode(@PathVariable("size") int size)
    {
        //根据size生成验证码
        int code = (int) ((Math.random() * 9 + 1) * Math.pow(10, size - 1));
        NumberCodeResponse response = new NumberCodeResponse();
        response.setNumberCode(code);
        System.out.println("产生的验证码"+code);
        return ResponseResult.success(response);
    }
}
