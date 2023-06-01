package com.solution.demo.exception.handler;

import com.solution.demo.exception.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class HandlerExceptionController {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler({ NotFoundException.class})
    @ResponseBody
    public CustomExceptionDetails notFoundRequest(HttpServletRequest request, Exception exception) {
        return new CustomExceptionDetails(exception, request.getRequestURI());
    }

    @ResponseStatus(CONFLICT)
    @ExceptionHandler({
            AlreadyExistsException.class
    })
    @ResponseBody
    public CustomExceptionDetails elementAlreadyExists(HttpServletRequest request, Exception exception) {
        return new CustomExceptionDetails(exception, request.getRequestURI());
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({ArithmeticException.class,
            MissingRequestHeaderException.class,
            RequestRejectedException.class,
            MethodArgumentNotValidException.class,
            NullPointerException.class,
            IllegalArgumentException.class,
            IndexOutOfBoundsException.class,
            BadCredentialsException.class
    })
    @ResponseBody
    public CustomExceptionDetails badRequest(HttpServletRequest request, Exception exception) {
        return new CustomExceptionDetails(exception, request.getRequestURI());
    }

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ Exception.class,
            UnableToUpdateEntityException.class,
            UnableToDeleteEntityException.class
    })
    @ResponseBody
    public CustomExceptionDetails fatalErrorUnexpectedException(HttpServletRequest request, Exception exception) {
        return new CustomExceptionDetails(exception, request.getRequestURI());
    }
}
