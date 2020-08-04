package com.ld.advice;

import com.ld.enums.exception.ErrorCode;
import com.ld.enums.exception.MyException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import java.util.Set;


/**
 * @program: material_manage
 * @description:
 * @author LD
 * @since 2020-08-04 13:41
 **/

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    ModelAndView hand(Throwable ex){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("message",ex.getMessage());
        return modelAndView;
    }

    /**数据验证异常拦截*/
    @ExceptionHandler(ValidationException.class)
    public ModelAndView handle(ValidationException exception) {
        /*if(exception instanceof ConstraintViolationException){

            ConstraintViolationException exs = (ConstraintViolationException) exception;
            Set<ConstraintViolation<?>> violations = exs.getConstraintViolations();
            for (ConstraintViolation<?> item : violations) {
                System.out.println(item.getMessage());
            }
        }*/
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("message","参数无效");
        return modelAndView;
    }

    /*@ExceptionHandler(Exception.class)
    Object handle(Throwable ex, Model model, HttpServletRequest request, HttpServletResponse response){
        String contentType = request.getContentType();

        if (contentType!=null&& "application/json".equals(contentType)){
            ResultDTO resultDTO;
            if(ex instanceof MyException){
                resultDTO = ResultDTO.error((MyException) ex);
            }else {
                resultDTO=ResultDTO.errorOf(2000,"未知错误");
            }

            try {
                //接口错误写入json返回
                response.setContentType("application/json");
                response.setStatus(200);
                response.setCharacterEncoding("utf-8");
                PrintWriter writer = response.getWriter();
                writer.write(JSON.toJSONString(resultDTO));
                writer.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            //不反回页面
            return null;
        }
        else {
            //非接口错误跳转页面
            if (ex instanceof MyException) {
                model.addAttribute("message", ex.getMessage());
            } else {
                model.addAttribute("message", ErrorCode.ERROR);
            }

            return new ModelAndView("error");
        }

    }*/
}
