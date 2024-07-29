package com.myfolder.myfolder.config.exceptions;

import com.myfolder.myfolder.config.exceptions.dto.ExceptionResponseDto;
import com.myfolder.myfolder.domain.exceptions.DomainValidationException;
import com.myfolder.myfolder.domain.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerFilter {
    @ExceptionHandler
    public ResponseEntity<ExceptionResponseDto> notFoundException(NotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponseDto(exception.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponseDto> domainExceptionFilter(DomainValidationException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDto(exception.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<String> serverException(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }
}
