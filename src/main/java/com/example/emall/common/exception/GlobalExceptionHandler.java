package com.example.emall.common.exception;

import com.example.emall.common.lang.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j  //日志输出
@RestControllerAdvice
public class GlobalExceptionHandler {


    //在AccountController里面检测user是否存在的异常
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = IllegalArgumentException.class)
    public Result handler(IllegalArgumentException e) {
        log.error ( "Assert异常--------", e );
        return Result.fail (  e.getMessage () );
    }

    //实体校验异常
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result handler(MethodArgumentNotValidException e) {
        log.error ( "实体校验异常--------", e );
        //只抛出一个异常就可以
        BindingResult bindingResult = e.getBindingResult ();
        //返回String[]类型,取第一个error
        ObjectError objectError = bindingResult.getAllErrors ().stream ().findFirst ().get ();
        return Result.fail ( objectError.getDefaultMessage () );
    }

    //返回给前端，表明是登陆不成功
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = ShiroException.class)
    public Result handler(ShiroException e) {
        log.error ( "登陆异常--------", e );
        return Result.fail ( 401, e.getMessage (), null );
    }

    //返回给前端，表明是异常
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public Result handler(RuntimeException e) {
        log.error ( "运行时异常--------", e );
        return Result.fail ( e.getMessage () );
    }
}
