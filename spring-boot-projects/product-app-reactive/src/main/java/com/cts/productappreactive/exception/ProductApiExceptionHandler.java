package com.cts.productappreactive.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductApiExceptionHandler {

    @ExceptionHandler
    public ProblemDetail handleResourceNotFoundException(ResourceNotFoundException ex){
        ProblemDetail errorDetails = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        errorDetails.setDetail(ex.getMessage());
        return errorDetails;
    }

}
