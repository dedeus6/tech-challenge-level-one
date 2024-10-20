package br.com.fiap.fastfood.core.port.out.exception.handler;

import br.com.fiap.fastfood.core.port.out.response.ErrorResponse;
import br.com.fiap.fastfood.core.port.out.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class ExceptionAdevice {

    private static final Logger log = LoggerFactory.getLogger(ExceptionAdevice.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleApiException(WebRequest request, Exception ex) {
        String message = ex.getMessage();
        String uri = request.getDescription(false);
        return new ResponseEntity<>(ErrorResponse.builder()
                .path(uri != null ? uri.substring(4) : null)
                .message(message)
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")))
                .httpCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .httpDescription(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleApiException(WebRequest request, BusinessException ex) {
        String message = ex.getMessage();
        String uri = request.getDescription(false);
        return new ResponseEntity<>(ErrorResponse.builder()
                .path(uri != null ? uri.substring(4) : null)
                .message(message)
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")))
                .httpCode(ex.getStatus().value())
                .httpDescription(ex.getStatus().getReasonPhrase())
                .build(), ex.getStatus());
    }
}
