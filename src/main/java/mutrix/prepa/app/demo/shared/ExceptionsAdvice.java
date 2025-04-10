package mutrix.prepa.app.demo.shared;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionsAdvice {
    // Gestion des erreurs de type HttpMessageNotReadableException

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        ex.getBindingResult().getFieldErrors().forEach(System.out::println);
        final String error = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        return  AppResponse.trash("Erreur de validation " + error, 400);

    }

    // Gestion des erreurs de type HttpMessageNotReadableException

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex,
                                                                   WebRequest request) {
        return AppResponse.trash("Le corps de la requête est manquant ou mal formaté.", 400);
    }


    // Gestion des autres exceptions générales

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalExceptions(Exception ex, WebRequest request) {
        return AppResponse.trash(ex.getMessage(), 400);
    }

}
