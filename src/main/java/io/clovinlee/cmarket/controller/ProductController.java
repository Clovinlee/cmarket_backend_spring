package io.clovinlee.cmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.clovinlee.cmarket.repository.ProductRepository;
import io.clovinlee.cmarket.service.ProductService;
import io.clovinlee.cmarket.dto.product.ProductResponseDto;
import io.clovinlee.cmarket.dto.product.ProductSearchDto;
import io.clovinlee.cmarket.exception.RecordNotFoundException;
import io.clovinlee.cmarket.model.ProductModel;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@RestController
@RequestMapping("api/products")
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private final ProductRepository productRepository;
    private final ProductService productService;

    ProductController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = { "", "/" })
    ProductResponseDto getProducts(ProductSearchDto body) {
        Pageable pageable = PageRequest.of(body.getPage(), body.getPagesize(), Sort.by(Sort.Direction.ASC, "id"));

        Integer[] rarityParam = null;
        if (!body.getRarity().equals("")) {
            String[] raritySplit = body.getRarity().split(",");
            rarityParam = new Integer[raritySplit.length];

            for (int i = 0; i < raritySplit.length; i++) {
                rarityParam[i] = Integer.parseInt(raritySplit[i]);
            }
        }

        Integer[] merchantParam = null;
        if (!body.getMerchant().equals("")) {
            String[] merchantSplit = body.getMerchant().split(",");
            merchantParam = new Integer[merchantSplit.length];

            for (int i = 0; i < merchantSplit.length; i++) {
                merchantParam[i] = Integer.parseInt(merchantSplit[i]);
            }
        }

        String[] nameParam = null;
        if (!body.getName().equals("")) {
            nameParam = body.getName().split(" ");
        }

        return productService.searchProduct(pageable, nameParam, rarityParam, merchantParam);
    }

    // @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{idslug}")
    ResponseEntity<ProductModel> getProductsBySlug(@PathVariable("idslug") String idslug) {
        String[] parts = idslug.split("-");
        if (parts.length < 2) {
            throw new RecordNotFoundException("Product with id " + idslug + " not found");
        }

        Long id;
        try {
            id = Long.parseLong(parts[0]);
        } catch (Exception e) {
            throw new RecordNotFoundException("Product with id " + idslug + " not found");
        }

        final String slugJoined = String.join(" ", Arrays.copyOfRange(parts, 1, parts.length)).toLowerCase();

        // Service Layer
        Optional<ProductModel> productResult = productService.getProductByIdSlug(id, slugJoined);

        if (productResult.isPresent()) {
            return ResponseEntity.ok().body(productResult.get());
        }

        throw new RecordNotFoundException("Product with id " + id + " not found");
    }

    @GetMapping("/test")
    String test() {
        return "Ping Success";
    }
}
