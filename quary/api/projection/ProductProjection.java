package com.java.quary.api.projection;

import com.java.command.api.data.Product;
import com.java.command.api.data.ProductRep;
import com.java.command.api.data.ProductRepository;
import com.java.command.api.model.ProductRestModel;
import com.java.quary.api.quaries.GetProductQuaries;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductProjection {

    private ProductRepository productRep;

    public ProductProjection (ProductRep productRep){
        this.productRep=productRep;
    }
    @QueryHandler
    public List<ProductRestModel>handle(GetProductQuaries getProductQuaries){
        List<Product> products=productRep.findAll();
        List<ProductRestModel> productRestModels=
                products.stream()
                        .map(product -> ProductRestModel
                                .builder()
                                .quantity(product.getQuantity())
                                .price(product.getPrice())
                                .name(product.getName())
                                .build())
                        .collect(Collectors.toList());

        return productRestModels;
    }
}
