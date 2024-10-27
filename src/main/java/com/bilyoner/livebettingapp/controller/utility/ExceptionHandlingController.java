package com.bilyoner.livebettingapp.controller.utility;

import com.bilyoner.livebettingapp.model.exception.BaseResponse;
import com.bilyoner.livebettingapp.model.exception.BusinessException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.bilyoner.livebettingapp.model.exception.BaseResponse.BaseResponseBuilder.aBaseResponse;

@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<BaseResponse> exceptionControl(RuntimeException ex) {
        BaseResponse baseResponse = aBaseResponse()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(baseResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<BaseResponse> businessExceptionControl(BusinessException ex) {
        BaseResponse baseResponse = aBaseResponse()
                .status(HttpStatus.BAD_REQUEST.name())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
    }

}