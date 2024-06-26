package com.syh.service.product.service;

import com.syh.common.common.Result;
import com.syh.common.order.pojos.OrderProduct;
import com.syh.common.product.dtos.NormalProductDto;
import com.syh.common.product.dtos.ProductListDto;
import com.syh.common.product.pojos.ProductOverview;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
* @author shiyu
* @description 针对表【product_overview(商品概括表)】的数据库操作Service
* @createDate 2024-03-15 19:29:01
*/
public interface ProductOverviewService extends IService<ProductOverview> {

    Result productList(ProductListDto dto);

    Result productInfo(Long productId);

    Result normalProductAdd(NormalProductDto dto, MultipartFile[] imageList);

    Result<List<OrderProduct>> reduceStock(List<OrderProduct> orderProducts);

    Result<List<OrderProduct>> recoverStock(List<OrderProduct> orderProducts);
}
