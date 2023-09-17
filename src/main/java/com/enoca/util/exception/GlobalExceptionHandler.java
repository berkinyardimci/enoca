package com.enoca.util.exception;

import com.enoca.util.GenericResponse;
import com.enoca.util.constant.ErrorMessage;
import com.enoca.util.interceptor.RequestInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.PropertyValueException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<GenericResponse<?>> handlePropertyValueException(PropertyValueException ex){
        String message = ex.getMessage();
        if (message.contains("not-null property")) {

            String[] arr = message.split(":");
            String[] packages = arr[1].split("\\.");
            String fieldName = packages[packages.length - 1];
            String errorMessage = fieldName + ErrorMessage.MISSING_FIELD;
            return getGenericResponse(errorMessage,HttpStatus.BAD_REQUEST);
        }

        return getGenericResponse("Sistemsel Bir hata", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<GenericResponse<?>> handlePSQLException(DataIntegrityViolationException ex){
        String message = ex.getMessage();
        if (message.contains("unique constraint")) {
            String errorMessage =  ErrorMessage.DUPLICATE_KEY;
            return getGenericResponse(errorMessage,HttpStatus.BAD_REQUEST);
        }

        if (message.contains("value too long")) {
            String errorMessage = ErrorMessage.LONG_VALUE;
            return getGenericResponse(errorMessage,HttpStatus.BAD_REQUEST);
        }
        if (message.contains("not-null property")) {
            String errorMessage = ErrorMessage.NOT_NULL_PROPERTY;
            return getGenericResponse(errorMessage,HttpStatus.BAD_REQUEST);
        }

        return getGenericResponse("Sistemsel Bir hata", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity<GenericResponse<?>> handleCompanyNotFoundException(CompanyNotFoundException ex){
        String message = ex.getExMessage();
        return getGenericResponse(message, HttpStatus.NOT_FOUND);
    }

    private Map<Object, Object> createErrorMap(){
        HttpServletRequest currentRequest = RequestInterceptor.getCurrentRequest();
        Map<Object, Object> errorMap = new HashMap<>();

        if(Objects.nonNull(currentRequest)){
            errorMap.put("HTTP Method", currentRequest.getMethod());
            errorMap.put("Endpoint", currentRequest.getHttpServletMapping().getPattern());
            errorMap.put("HTTP URI", currentRequest.getRequestURI());
            errorMap.put("HTTP URL", currentRequest.getRequestURL());
        }
        return errorMap;
    }

    private ResponseEntity<GenericResponse<?>> getGenericResponse(String ex, HttpStatus httpStatus){
        Map<Object, Object> errorMap = createErrorMap();
        GenericResponse<?> res =new GenericResponse(
                httpStatus,
                httpStatus.value(),
                ex,
                LocalDateTime.now(),
                errorMap
        );
        return ResponseEntity.status(httpStatus).body(res);
    }


}
