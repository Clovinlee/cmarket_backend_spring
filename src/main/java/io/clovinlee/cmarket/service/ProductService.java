package io.clovinlee.cmarket.service;

import org.springframework.stereotype.Service;

import io.clovinlee.cmarket.dto.PaginationDto;
import io.clovinlee.cmarket.dto.product.ProductResponseDto;
import io.clovinlee.cmarket.model.ProductModel;
import io.clovinlee.cmarket.repository.ProductRepository;
import io.clovinlee.cmarket.specification.ProductSpecification;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDto searchProduct(Pageable page, String[] name, Integer[] rarity, Integer[] merchant) {
        Specification<ProductModel> spec = ProductSpecification.SearchName(name);
        if (rarity != null) {
            spec = spec.and(ProductSpecification.SearchRarity(rarity));
        }

        if (merchant != null) {
            spec = spec.and(ProductSpecification.SearchMerchant(merchant));
        }

        Page<ProductModel> pageResult = productRepository.findAll(
                spec, page);
        // +1 on pagination because of offset. (page start in 0 instead of 1)
        PaginationDto pagination = new PaginationDto(pageResult.getNumber() + 1, pageResult.getSize(),
                pageResult.getTotalPages());

        ProductResponseDto response = new ProductResponseDto();
        response.setPagination(pagination);
        response.setProducts(pageResult.getContent());

        return response;
    }

    public Optional<ProductModel> getProductByIdSlug(Long id, String slugName) {

        Optional<ProductModel> productResult = productRepository.findById(id)
                .filter(product -> product.getName().toLowerCase().equals(slugName));

        return productResult;
    }
}
