package com.example.diplom.aspects;

import com.example.diplom.dto.ModelDTO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Component
@Slf4j
public class ModelAspect {

    @After(value = "execution(* com.example.diplom.controllers.ModelController.getPageGenerationPage())")
    public void getItemsPage(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        log.info("Пользователь  открыл страницу генерации модели");
    }

    @AfterReturning(value = "execution(* com.example.diplom.controllers.ModelController.generatePage())")
    public void after(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        ModelDTO model = (ModelDTO) args[0];
        log.info("Новая модель"+model+"создана");
    }
}
