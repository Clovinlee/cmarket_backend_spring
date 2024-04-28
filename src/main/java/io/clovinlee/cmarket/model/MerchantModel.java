package io.clovinlee.cmarket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "merchants")
public record MerchantModel(
                @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id,
                @NotNull String name,
                Integer level,
                String color) {

}
