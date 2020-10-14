//package com.mqxu.contentcenter.auth;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
///**
// * @description: 全局异常处理
// * @author: mq_xu
// * @create: 2020-10-13 19:56
// **/
//@RestControllerAdvice
//@Slf4j
//public class GlobalExceptionErrorHandler {
//    @ExceptionHandler(SecurityException.class)
//    public ResponseEntity<ErrorBody> error(SecurityException e) {
//        log.warn("发生SecurityException异常", e);
//        return new ResponseEntity<>(
//                ErrorBody.builder()
//                        .body(e.getMessage())
//                        .status(HttpStatus.UNAUTHORIZED.value())
//                        .build(),
//                HttpStatus.UNAUTHORIZED
//        );
//    }
//}
//
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//class ErrorBody {
//    private String body;
//    private int status;
//}