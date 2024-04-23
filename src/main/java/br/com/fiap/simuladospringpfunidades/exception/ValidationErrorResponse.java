package br.com.fiap.simuladospringpfunidades.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class ValidationErrorResponse {

    private int status;
    private String message;
    private String endpoint;
    private List<ValidationError> errors = new ArrayList<>();

    public void addValidationError(String field, String message) {
        ValidationError error = new ValidationError( field, message );
        errors.add( error );
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ValidationError {
        private String field;
        private String message;
    }
}
