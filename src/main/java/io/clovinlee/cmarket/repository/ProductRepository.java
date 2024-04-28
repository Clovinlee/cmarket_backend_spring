package io.clovinlee.cmarket.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import io.clovinlee.cmarket.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long>, JpaSpecificationExecutor<ProductModel> {
    // NOTE CHRIS :
    // Coalesce return first not null value in array
    // [null,1,2] -> return 1

    Page<ProductModel> findAll(Pageable page);

    // working with coalesce, need to add (...) to param after "IN"
    // @Query(value = "SELECT DISTINCT(p.*) FROM products p LEFT JOIN
    // products_merchants pm ON p.id = pm.id_product WHERE (LOWER(p.name) ~ :name)
    // AND (COALESCE(:rarity) IS NULL OR p.id_rarity IN (:rarity)) AND
    // (COALESCE(:merchant) IS NULL OR pm.id_merchant IN (:merchant)) ORDER BY p.id
    // ASC", nativeQuery = true)
    // Page<ProductModel> findProducts(@Param("name") String name,
    // @Param("rarity") Integer[] rarity,
    // @Param("merchant") Integer[] merchant,
    // Pageable pageable);

}
