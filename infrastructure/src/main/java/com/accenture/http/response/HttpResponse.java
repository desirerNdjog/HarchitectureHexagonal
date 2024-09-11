package com.accenture.http.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Map;

/**
 * @Project Calculatrice
 * @Author desire.junior.ndjog
 * @Date Created 9/9/2024
 */

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
public class HttpResponse {
    private int codeStatus;
    private String message;
    private HttpStatus httpStatus;
    private Map<?, ?> datas;
}
