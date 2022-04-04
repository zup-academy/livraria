package error;

import com.zupedu.livraria.autor.AutorInexistenteException;
import com.zupedu.livraria.categoria.CategoriaInexistenteException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleDatabaseErrors(RuntimeException e, WebRequest request) {

        logger.error("Catching an unhandled database exception thrown by a controller: " + e.getLocalizedMessage(), e);

        Map<String, Object> body = Map.of(
                "status", 500,
                "error", "Internal Server Error",
                "path", request.getDescription(false).replace("uri=", ""),
                "timestamp", LocalDateTime.now(),
                "message", "Ocorreu um erro interno. Por favor contate o administrador."
        );
        return ResponseEntity
                .internalServerError().body(body);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({
            CategoriaInexistenteException.class, AutorInexistenteException.class})
    public ResponseEntity<?> handleDatabaseErrorsRequest(RuntimeException e, WebRequest request) {

        logger.error(": " + e.getLocalizedMessage(), e);

        Map<String, Object> body = Map.of(
                "status", 422,
                "error", e.getCause(),
                "path", request.getDescription(false).replace("uri=", ""),
                "timestamp", LocalDateTime.now(),
                "message", e.getMessage()
        );
        return ResponseEntity.unprocessableEntity().body(body);
    }
}
