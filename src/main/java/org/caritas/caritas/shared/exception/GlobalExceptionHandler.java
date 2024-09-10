package org.caritas.caritas.shared.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.caritas.caritas.item.domain.exception.ExceedsProjectRequestException;
import org.caritas.caritas.shared.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private GlobalExceptionHandler() {
    }

    @ExceptionHandler({
            Exception.class,
            MethodArgumentTypeMismatchException.class,
            MethodArgumentNotValidException.class,
            ResourceNotFoundException.class,
    })
    public ResponseEntity<ApiError> handleException(Exception exception, HttpServletRequest request,
            HttpServletResponse response) {
        LocalDateTime timestamp = LocalDateTime.now();

        if (exception instanceof MethodArgumentTypeMismatchException methodArgumentTypeMismatchException) {
            return this.methodArgumentTypeMismatchException(methodArgumentTypeMismatchException, request, timestamp);
        } else if (exception instanceof MethodArgumentNotValidException methodArgumentNotValidException) {
            return this.methodArgumentNotValidException(methodArgumentNotValidException, request, timestamp);
        } else if (exception instanceof ResourceNotFoundException resourceNotFoundException) {
            return this.resourceNotFoundException(resourceNotFoundException, request, timestamp);
        } else if (exception instanceof ExceedsProjectRequestException exceedsProjectRequestException) {
            return this.exceedsProjectRequestException(exceedsProjectRequestException, request, timestamp);
        } else {
            return this.genericResponse(exception, request, timestamp);
        }

    }

    public ResponseEntity<ApiError> methodArgumentNotValidException(MethodArgumentNotValidException exception,
            HttpServletRequest request,
            LocalDateTime timestamp) {

        int httpStatus = HttpStatus.BAD_REQUEST.value();

        List<ObjectError> errors = exception.getAllErrors();
        List<String> details = errors.stream().map(error -> {

            if (error instanceof FieldError fieldError) {
                return fieldError.getField() + ": " + fieldError.getDefaultMessage();
            }

            return error.getDefaultMessage();

        }).toList();

        ApiError apiError = new ApiError(
                httpStatus,
                request.getRequestURL().toString(),
                request.getMethod(),
                "La peticion contiene informacion invalida o incompleta, por favor verifica y vuelve a probar",
                exception.getMessage(),
                timestamp,
                details);

        return ResponseEntity.status(httpStatus).body(apiError);

    }

    public ResponseEntity<ApiError> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception,
            HttpServletRequest request,
            LocalDateTime timestamp) {

        int httpStatus = HttpStatus.BAD_REQUEST.value();
        Object valueRejected = exception.getValue();
        String propertyName = exception.getName();

        ApiError apiError = new ApiError(
                httpStatus,
                request.getRequestURL().toString(),
                request.getMethod(),
                "Peticion invalida: El valor enviado '" + valueRejected + "', no es el tipo de dato esperado para el "
                        + propertyName,
                exception.getMessage(),
                timestamp,
                null);

        return ResponseEntity.status(httpStatus).body(apiError);

    }

    private ResponseEntity<ApiError> resourceNotFoundException(ResourceNotFoundException exception,
            HttpServletRequest request,
            LocalDateTime timestamp) {

        int httpStatus = HttpStatus.NOT_FOUND.value();

        ApiError apiError = new ApiError(
                httpStatus,
                request.getRequestURL().toString(),
                request.getMethod(),
                "Item no encontrado",
                exception.getMessage(),
                timestamp,
                null);

        return ResponseEntity.status(httpStatus).body(apiError);

    }

    private ResponseEntity<ApiError> genericResponse(Exception exception, HttpServletRequest request,
            LocalDateTime timestamp) {

        int httpStatus = HttpStatus.INTERNAL_SERVER_ERROR.value();

        ApiError apiError = new ApiError(
                httpStatus,
                request.getRequestURL().toString(),
                request.getMethod(),
                "Ha ocurrido un error con el servidor intente mas tarde",
                exception.getMessage(),
                timestamp,
                null);

        return ResponseEntity.status(httpStatus).body(apiError);

    }

    private ResponseEntity<ApiError> exceedsProjectRequestException(ExceedsProjectRequestException exception,
            HttpServletRequest request,
            LocalDateTime timestamp) {

        int httpStatus = HttpStatus.UNPROCESSABLE_ENTITY.value();

        ApiError apiError = new ApiError(
                httpStatus,
                request.getRequestURL().toString(),
                request.getMethod(),
                "Se ha excedido el valor maximo del solicitado en el proyecto",
                exception.getMessage(),
                timestamp,
                null);

        return ResponseEntity.status(httpStatus).body(apiError);

    }
}
