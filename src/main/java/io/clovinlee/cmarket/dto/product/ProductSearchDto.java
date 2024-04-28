package io.clovinlee.cmarket.dto.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductSearchDto {
    private String name = "";
    private String rarity = "";
    private String merchant = "";
    private int page = 1;
    private int pagesize = 5;

    ProductSearchDto(String name, String rarity, String merchant, String page, String pagesize) {
        this.name = name;
        this.rarity = rarity;
        this.merchant = merchant;
        this.page = Integer.parseInt(page);
        this.pagesize = Integer.parseInt(pagesize);
    }

    public String getName() {
        return this.name.toLowerCase();
    }

    public int getPage() {
        return page - 1;
    }
}
