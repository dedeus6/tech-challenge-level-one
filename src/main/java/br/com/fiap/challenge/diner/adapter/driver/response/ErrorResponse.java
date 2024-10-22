package br.com.fiap.challenge.diner.adapter.driver.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private int httpCode;
    private String httpDescription;
    private String message;
    private String path;
    private String timestamp;
    private List<ErrorField> fields;
}
