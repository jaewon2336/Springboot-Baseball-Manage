package site.metacoding.baseballmanage.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;
import site.metacoding.baseballmanage.handler.ex.CustomApiException;
import site.metacoding.baseballmanage.handler.ex.CustomException;
import site.metacoding.baseballmanage.util.Script;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomApiException.class)
    public ResponseEntity<?> apiException(Exception e) { // fetch 요청 시 발동 -> json 응답
        log.error("에러 발생 : " + e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> htmlException(Exception e) { // 일반적인 Get(a태그), Post(form태그) 요청 -> html 응답
        log.error("에러 발생 : " + e.getMessage());
        return new ResponseEntity<>(Script.back(e.getMessage()), HttpStatus.BAD_REQUEST); // 400
    }
}