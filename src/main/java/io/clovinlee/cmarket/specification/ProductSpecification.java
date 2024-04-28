package io.clovinlee.cmarket.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import io.clovinlee.cmarket.model.ProductModel;
import jakarta.persistence.criteria.Predicate;

public class ProductSpecification {

    public static Specification<ProductModel> SearchName(String[] name) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (name != null) {
                for (String s : name) {
                    predicates.add(builder.like(builder.lower(root.get("name")), "%" + s + "%"));
                }
            }

            return builder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

    public static Specification<ProductModel> SearchRarity(Integer[] rarity) {
        return (root, query, builder) -> {
            if (rarity == null) {
                return null;
            }

            List<Integer> rarityList = new ArrayList<>();
            for (Integer i : rarity) {
                rarityList.add(i);
            }

            return root.join("rarity").get("id").in(rarityList);
        };
    }

    public static Specification<ProductModel> SearchMerchant(Integer[] merchant) {
        return (root, query, builder) -> {
            if (merchant == null) {
                return null;
            }
            return root.get("merchants").get("id").in((Object[]) merchant);
        };
    }

}
