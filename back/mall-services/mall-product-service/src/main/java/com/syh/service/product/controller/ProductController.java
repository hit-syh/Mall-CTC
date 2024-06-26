package com.syh.service.product.controller;

import com.alibaba.fastjson.JSON;
import com.syh.common.common.Result;
import com.syh.common.order.pojos.OrderProduct;
import com.syh.common.product.dtos.NormalProductDto;
import com.syh.common.product.dtos.ProductListDto;
import com.syh.service.product.service.ProductCategoryService;
import com.syh.service.product.service.ProductOverviewService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    @Autowired
    ProductCategoryService productCategoryService;
    @Autowired
    ProductOverviewService productOverviewService;
    @GetMapping("/categoryList")
    public Result categoryList(){
        return productCategoryService.categoryList();
    }
    @GetMapping("/productList")
    public Result productList(ProductListDto dto){
        return productOverviewService.productList(dto);
    }
    @GetMapping("/productInfo")
    public Result productInfo(Long productId){
        return productOverviewService.productInfo(productId);
    }
    @Autowired
    HttpServletRequest httpServletRequest;
    @PostMapping(value = "/add")
    public Result normalProductAdd(@RequestParam String productInfo, @RequestPart MultipartFile[] imageList){
        NormalProductDto normalProductDto = JSON.parseObject(productInfo, NormalProductDto.class);
        return productOverviewService.normalProductAdd(normalProductDto,imageList);
    }
    @PostMapping("/reduceStock")
    Result<List<OrderProduct>> reduceStock(@RequestBody List<OrderProduct> orderProducts){
        return productOverviewService.reduceStock(orderProducts);
    }
    @PostMapping("/recoverStock")
    Result<List<OrderProduct>> recoverStock(@RequestBody List<OrderProduct> orderProducts){
        return productOverviewService.recoverStock(orderProducts);
    }
}
