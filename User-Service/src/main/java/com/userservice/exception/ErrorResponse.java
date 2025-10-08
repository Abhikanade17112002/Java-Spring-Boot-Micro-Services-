package com.userservice.exception;


import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class ErrorResponse {
    private String message ;
    private HttpStatus status ;
    private LocalDateTime localDateTime ;
}
