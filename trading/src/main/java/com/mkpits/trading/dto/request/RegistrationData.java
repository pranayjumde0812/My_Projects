package com.mkpits.trading.dto.request;

import lombok.*;
@Data
public class RegistrationData {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
