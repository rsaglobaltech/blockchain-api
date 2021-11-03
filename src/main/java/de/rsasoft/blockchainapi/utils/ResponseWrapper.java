package de.rsasoft.blockchainapi.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseWrapper<T> {

    private boolean ok;
    private String message;
    private T data;

    public ResponseEntity<ResponseWrapper<T>> createResponse(HttpStatus httpStatus){
        return new ResponseEntity<>(this,httpStatus);
    }
}
