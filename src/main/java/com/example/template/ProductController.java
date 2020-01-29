package com.example.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    // 하위 호환성을 유지하기 위해 
    // "/item/{productId}"와 "/product/{productId}" API 둘다 사용 가능하도록
    // Source Code 수정
    
    @GetMapping("/item/{productId}")
    Product itemStockCheck(@PathVariable(value = "productId") Long productId) {

        System.out.println("itemStockCheck call");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return  this.productService.getProductById(productId);
    }
    
    @GetMapping("/product/{productId}")
    Product productStockCheck(@PathVariable(value = "productId") Long productId) {

        System.out.println("productStockCheck call");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return  this.productService.getProductById(productId);
    }

    @PostMapping("/product")
    Product productInsert(@RequestBody String data) {
        System.out.println(data);
        return this.productService.save(data);
    }
}
