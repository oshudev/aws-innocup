package com.aws.innocup.handler;

import com.aws.innocup.dto.ResponseParamDto;
import com.aws.innocup.enums.ResCode;
import com.aws.innocup.exception.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException e, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        HttpHeaders headers = new HttpHeaders();

        final ResponseParamDto param = new ResponseParamDto();
        param.setErrorInfo(e.getMessage());
        param.setCode(ResCode.RES_USER_NOT_FOUND.getCode());

        return handleExceptionInternal(e, param, headers, status, request);
    }
}
