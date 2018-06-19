package it.nextre.academy.realspring.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class ResponseHelper {

    public static final String FATAL_ERROR = "500";

    public ResponseEntity<Object> ok(Object o) {
        return (ResponseEntity.ok().body(o));
    }

    public ResponseEntity<Object> badRequest(String error_code, String description) {
        String body = "Error code: " + error_code + "\nError: " + description;
        return (ResponseEntity.badRequest().body(body));
    }

    public ResponseEntity<Object> badRequest(String description) {
        return this.badRequest(HttpStatus.BAD_REQUEST.toString(), description);
    }

    public ResponseEntity<Object> fatalError(String description) {
        return (this.fatalError(ResponseHelper.FATAL_ERROR, description));
    }

    public ResponseEntity<Object> fatalError(String error_code, String description) {
        String body = "Error code: " + error_code + "\nError: " + description;
        return (ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body));
    }


}//end class
