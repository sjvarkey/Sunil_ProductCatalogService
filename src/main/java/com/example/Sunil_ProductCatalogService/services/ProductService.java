package com.example.Sunil_ProductCatalogService.services;

import com.example.Sunil_ProductCatalogService.clients.FakeStoreAPIClient;
import com.example.Sunil_ProductCatalogService.dtos.FakeStoreProductDto;
import com.example.Sunil_ProductCatalogService.dtos.ProductDto;
import com.example.Sunil_ProductCatalogService.models.Category;
import com.example.Sunil_ProductCatalogService.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fkps")
public class ProductService implements IProductService{

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;


    @Autowired
    private FakeStoreAPIClient fakeStoreAPIClient;

    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDto[] fakeStoreProductDtos =  restTemplate.getForEntity("https://fakestoreapi.com/products",FakeStoreProductDto[].class).getBody();

        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            products.add(from(fakeStoreProductDto));
        }
        return products;
    }

    public Product getProductById(Long id){
        FakeStoreProductDto fakeStoreProductDto= fakeStoreAPIClient.getProductById(id);
        if(fakeStoreProductDto != null){
            return from(fakeStoreProductDto);
        }

        return null;
    }


    public Product createProduct(Product product){
            //homework
        return product;
    }

    public Product replaceProduct(Long id, Product product){

        FakeStoreProductDto fakeStoreProductDto = from(product);

        FakeStoreProductDto fakeStoreProductDtoResponse =
                requestForEntity("https://fakestoreapi.com/products/{id}",HttpMethod.PUT,fakeStoreProductDto,FakeStoreProductDto.class,id).getBody();

        return from(fakeStoreProductDtoResponse);
    }

    //Important Revisit
    private <T> ResponseEntity<T> requestForEntity(String url, HttpMethod httpMethod, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    //Mapper
    private Product from(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setAmount(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }

    private FakeStoreProductDto from(Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setPrice(product.getAmount());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setImage(product.getImageUrl());
        if(product.getCategory() != null) {
            fakeStoreProductDto.setCategory(product.getCategory().getName());
        }

        return fakeStoreProductDto;
    }
}
