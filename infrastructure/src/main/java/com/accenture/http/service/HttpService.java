package com.accenture.http.service;

import com.accenture.http.response.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @Project Calculatrice
 * @Author desire.junior.ndjog
 * @Date Created 9/9/2024
 */
public class HttpService {

    private HttpService(){}

    public static ResponseEntity<HttpResponse> responseSuccess (Map<?, ?> data){
        return ResponseEntity.ok().body(HttpResponse.builder()
                .codeStatus(HttpStatus.OK.value())
                .message("retreive data")
                .httpStatus(HttpStatus.OK)
                .datas(data)
                .build()
        );
    }

    public static ResponseEntity<HttpResponse> responseOkSuccess (){
        return ResponseEntity.ok().body(HttpResponse.builder()
                .codeStatus(HttpStatus.OK.value())
                .message("created")
                .httpStatus(HttpStatus.OK)
                .build()
        );
    }

    public static ResponseEntity<HttpResponse> responseNotFound (){
        return ResponseEntity.ok().body(HttpResponse.builder()
                .codeStatus(HttpStatus.NOT_FOUND.value())
                .message("not found")
                .httpStatus(HttpStatus.NOT_FOUND)
                .build()
        );
    }

    public static ResponseEntity<HttpResponse> responseInternalServerError (String msg){
        return ResponseEntity.ok().body(HttpResponse.builder()
                .codeStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(msg)
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .build()
        );
    }
}
