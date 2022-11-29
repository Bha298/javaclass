package com.java.quary.api.controller;

import com.java.command.api.model.ProductRestModel;
import com.java.quary.api.quaries.GetProductQuaries;
import org.axonframework.messaging.responsetypes.ResponseType;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PrivateKey;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductQueryController {

    private QueryGateway queryGateway;

    public ProductQueryController(QueryGateway queryGateway ) {
        this.queryGateway=queryGateway;
    }

    @GetMapping
    public List<ProductRestModel> getAllProducts(){
        GetProductQuaries getProductQuaries=new GetProductQuaries();
        List<ProductRestModel> productRestModels=


        queryGateway.query(getProductQuaries, ResponseTypes.multipleInstancesOf(ProductRestModel.class)).join();
        return productRestModels;
    }
}
