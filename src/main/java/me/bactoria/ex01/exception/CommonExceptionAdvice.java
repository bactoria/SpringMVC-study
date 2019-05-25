package me.bactoria.ex01.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@ControllerAdvice
public class CommonExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public String except(Exception exception, Model model) {
        log.error("Exception..." + exception.getMessage());
        model.addAttribute("exception", exception);
        log.error(model.toString());
        return "errorpage";
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle_404(NoHandlerFoundException exception) {
        log.error("NOT FOUND EXCEPTION");
        return "error404";
    }
}
