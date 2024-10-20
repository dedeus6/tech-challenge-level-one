package br.com.fiap.fastfood.core.port.out.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private int httpCode;
    private String httpDescription;
    private String message;
    private String path;
    private String timestamp;
}
