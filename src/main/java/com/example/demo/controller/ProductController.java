package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/all")
    public List<Product> getAll(){
        return  productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id){
        return productService.getById(id);
    }

    @PostMapping("/edit/")
    public  void editProduct(@RequestBody Product product){
        productService.edit(product);
    }

}
