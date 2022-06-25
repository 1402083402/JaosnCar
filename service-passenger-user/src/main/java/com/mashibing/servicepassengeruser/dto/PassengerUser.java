package com.mashibing.servicepassengeruser.dto;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * @author Jason
 * @date 2022/6/17
 * hello ashen one
 */
@Data
public class PassengerUser {
    private Long id;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
    private String passengerPhone;
    private String passengerName;
    private byte passengerGender;
    private byte state;
}
