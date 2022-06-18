package com.mashibing.servicepassengeruser.service;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.servicepassengeruser.dto.PassengerUser;
import com.mashibing.servicepassengeruser.mapper.PassengerUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author Jason
 * @date 2022/6/17
 * hello ashen one
 */
@Service
public class UserService {
    @Resource
    private PassengerUserMapper passengerUserMapper;
    @Resource
    private UserService userService;
    public ResponseResult loginOrRegister(String passengerPhone)
    {
        HashMap<String, Object> map = new HashMap<>();
        map.put("passenger_phone",passengerPhone);
        List<PassengerUser> passengerUsers = passengerUserMapper.selectByMap(map);
        return ResponseResult.success();
    }
}
