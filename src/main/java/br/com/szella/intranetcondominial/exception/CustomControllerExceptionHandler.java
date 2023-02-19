package br.com.szella.intranetcondominial.exception;

import br.com.szella.intranetcondominial.modal.response.ErroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomControllerExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DBException.class)
    protected ResponseEntity<ErroResponse> handleDBException(Exception e) {
        return retornaErroResponse(e, HttpStatus.NOT_FOUND);
    }


    private static ResponseEntity<ErroResponse> retornaErroResponse(Exception e, HttpStatus httpStatus) {
        return ResponseEntity
                .status(httpStatus)
                .body(
                        ErroResponse.builder()
                                .mensagem(e.getMessage())
                                .build()
                );
    }
}
