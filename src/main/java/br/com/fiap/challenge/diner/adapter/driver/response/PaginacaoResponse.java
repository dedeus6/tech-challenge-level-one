package br.com.fiap.challenge.diner.adapter.driver.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class PaginacaoResponse<T> {

    private Boolean hasNext;
    private Boolean hasPrevious;
    private Integer pageNumber;
    private Integer pageSize;
    private List<T> items;

    public PaginacaoResponse convertToResponse(Page<T> lista) {
        this.hasNext = lista.getContent().size() >= lista.getPageable().getPageSize();
        this.hasPrevious = lista.getNumber() > 0;
        this.pageNumber = lista.getNumber() + 1;
        this.pageSize = lista.getPageable().getPageSize();
        this.items = lista.getContent();
        return this;
    }
}
