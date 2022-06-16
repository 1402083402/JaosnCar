package com.mashibing.apipassenger.service;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * @author Jason
 * @date 2022/6/16
 * hello ashen one
 */
@Service
public class VerificationCodeService {
    public  String generatorCode(String passengerPhone){

        String code="1111";
        System.out.println("passengerPhone:"+passengerPhone);
        //存入redis
        //返回值
        JSONObject result = new JSONObject();
        result.put("code",1);
        result.put("message","success");
        return result.toString();
    }
}
