package br.com.mscliente.config.exceptions.lib;

import br.com.mscliente.config.exceptions.CpfCadastradoException;
import br.com.mscliente.config.exceptions.CpfNaoEncontradoException;
import br.com.mscliente.config.exceptions.EmailCadastradoException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CpfNaoEncontradoException.class)
    public ResponseEntity<PadraoException> handleCpfNaoEncontradoException(CpfNaoEncontradoException cpfNaoEncontradoException) {
        PadraoException padraoException = new PadraoException(HttpStatus.NOT_FOUND,
        "Cliente não encontrado.",
        "Informe um CPF válido.",
        Arrays.asList(cpfNaoEncontradoException.getMessage()));
        return new ResponseEntity<>(padraoException, padraoException.getStatus());
    }

    @ExceptionHandler(CpfCadastradoException.class)
    public ResponseEntity<PadraoException> handleCpfCadastradoException(CpfCadastradoException cpfCadastradoException) {
        PadraoException padraoException = new PadraoException(HttpStatus.UNPROCESSABLE_ENTITY,
                "Documento já cadastrado",
                "Faça uma busca por CPF para localizar o cadastro.",
                Arrays.asList(cpfCadastradoException.getMessage()));
        return new ResponseEntity<>(padraoException, padraoException.getStatus());
    }

    @ExceptionHandler(EmailCadastradoException.class)
    public ResponseEntity<PadraoException> handleEmailCadastradoException(EmailCadastradoException emailCadastradoException) {
        PadraoException padraoException = new PadraoException(HttpStatus.UNPROCESSABLE_ENTITY,
        "Email já cadastrado",
        "Faça uma busca por CPF para localizar o cadastro.",
        Arrays.asList(emailCadastradoException.getMessage()));
        return new ResponseEntity<>(padraoException, padraoException.getStatus());
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        List<FieldErrorObject> errors = getErrors(ex);
        FieldErrorResponse fieldErrorResponse = getErrorResponse(ex, status, errors);
        return new ResponseEntity<>(fieldErrorResponse, status);
    }
    private FieldErrorResponse getErrorResponse(MethodArgumentNotValidException ex,
                                                HttpStatus status,
                                                List<FieldErrorObject> errors) {
        return new FieldErrorResponse("Requisição possui campos inválidos",
                status.value(),
                status.getReasonPhrase(),
                ex.getBindingResult().getObjectName(),
                errors);
    }
    private List<FieldErrorObject> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new FieldErrorObject(
                    error.getDefaultMessage(),
                    error.getField(),
                    error.getRejectedValue()))
                .collect(Collectors.toList());
    }

}