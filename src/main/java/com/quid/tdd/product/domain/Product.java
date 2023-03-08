package com.quid.tdd.product.domain;

import org.springframework.util.Assert;

public class Product {

    private Long id;
    private final String name;
    private final int price;
    private final DiscoundPolicy policy;

    private Product(String name, int price, DiscoundPolicy policy) {
        Assert.hasText(name, "상품명은 필수입니다.");
        Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
        Assert.notNull(policy, "할인 정책은 필수입니다.");
        this.name = name;
        this.price = price;
        this.policy = policy;
    }

    public static Product create(String name, int price, DiscoundPolicy policy) {
        return new Product(name, price, policy);
    }

    public void assignId(Long seq) {
        this.id = seq;
    }

    public Long getId() {
        return id;
    }
}
