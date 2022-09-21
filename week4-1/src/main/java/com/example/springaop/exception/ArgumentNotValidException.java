package com.example.springaop.exception;


import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ArgumentNotValidException extends RuntimeException {
    private final BindingResult bindingResult;
    public ArgumentNotValidException(BindingResult bindingResult1){
        this.bindingResult = bindingResult1;
    }
}
