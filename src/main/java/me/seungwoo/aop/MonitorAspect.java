package me.seungwoo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Leo.
 * User: ssw
 * Date: 2019-02-12
 * Time: 16:27
 */
@Slf4j
@Aspect
@Configuration
public class MonitorAspect {

    @Before("execution(* me.seungwoo.controller.*.* (..))")
    public void before() {
        log.info("[Aspect] before");
    }
}
