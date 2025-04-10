package mutrix.prepa.app.demo.shared;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.ResponseEntity;

import java.util.Objects;


@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppResponse<T> {
 
    private boolean status;
    private String error;
    private Integer statusCode;
    private T data;

    public static <T>  ResponseEntity<?> trash(String error, Integer statusCode) {
        AppResponse<T> response = new AppResponse<T>();
        response.setError(error);
        response.setStatusCode(Objects.requireNonNullElse(statusCode, 400));
        response.setStatus(false);
        return  ResponseEntity.status(Objects.requireNonNullElse(statusCode, 400)).body(response);
    }

    public static <T> ResponseEntity<?> ok(T object,Integer statusCode) {
        AppResponse<T>  response = new AppResponse<T>( );
        response.setStatus(true);
        response.setStatusCode(Objects.requireNonNullElse(statusCode, 200));
        response.setData(object);
        return ResponseEntity.status(Objects.requireNonNullElse(statusCode, 200)).body(response);
    }

}
