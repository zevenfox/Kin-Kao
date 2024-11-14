package ku.kinkao.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class ErrorController {


    Logger logger = LoggerFactory.getLogger(ErrorController.class);


    @ExceptionHandler(Throwable.class)
    @ResponseStatus // you can specify specific status code here
    public String exception(final Throwable throwable, final Model model) {


        logger.error("Exception during execution", throwable);


        return "error";
    }
}
