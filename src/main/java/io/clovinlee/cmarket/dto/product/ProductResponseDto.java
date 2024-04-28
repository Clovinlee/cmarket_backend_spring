package io.clovinlee.cmarket.dto.product;

import java.util.List;

import io.clovinlee.cmarket.dto.PaginationDto;
import io.clovinlee.cmarket.model.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {
    private PaginationDto pagination;
    private List<ProductModel> products;
}
