package com.example.PVSSpringBoot.ProductTest;


import com.example.PVSSpringBoot.ControllerPackage.ProductController;
import com.example.PVSSpringBoot.Entities.Product;
import com.example.PVSSpringBoot.services.ProductManagementService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



//TODO: tests don't run here and I don't know WHY (p.s.:could be security)
@WebMvcTest(ProductController.class)
public class ProductsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductManagementService service;

<<<<<<< HEAD
    //smoke test
=======
>>>>>>> b6ee88146414874a7d00d51c8072ca0a820084f2
    @Test
    void test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/hello")).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello"));
    }

    //happy cases
    //ask for a product by id

    @Test
    void testAskForID() throws Exception {
        Product p = Product.builder()
                .id(1L)
                .productName("Pname")
                .brandName("Bname")
                .price(10f)
                .build();
        Mockito.when(service.findById(1L)).thenReturn(p);
        mockMvc.perform(MockMvcRequestBuilders.get("/products/id=1"))
                .andDo(MockMvcResultHandlers.print())
<<<<<<< HEAD
                .andExpect(MockMvcResultMatchers.content().json("{id:1,productName:Pname,brandName:Bname,price:10.0,targetAnimal:null,imageLink:null}"));
        Mockito.verify(service, Mockito.times(1)).findById(1L);
    }

    //ask for all products

    @Test
    void testAskForAll() throws Exception {
        Product p = Product.builder()
                .id(1L)
                .productName("Pname")
                .brandName("Bname")
                .price(10f)
                .build();
        Mockito.when(service.findById(1L)).thenReturn(p);
        mockMvc.perform(MockMvcRequestBuilders.get("/products/all"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().json("[{id:1,productName:Pname,brandName:Bname,price:10.0,targetAnimal:null,imageLink:null}]"));
=======
                .andExpect(MockMvcResultMatchers.content().json("{id:1,productName:Pname,brandName:Bname,price:10.0}"));
>>>>>>> b6ee88146414874a7d00d51c8072ca0a820084f2
        Mockito.verify(service, Mockito.times(1)).findById(1L);
    }

    //ask for a product by name
    @Test
    void testAskForName() throws Exception {
        Product p = Product.builder()
                .id(1L)
                .productName("Pname")
                .brandName("Bname")
                .price(10f)
                .build();
        List<Product> list = Collections.singletonList(p);
        Mockito.when(service.searchForProduct("Pname")).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/products/name=Pname"))
                .andDo(MockMvcResultHandlers.print())
<<<<<<< HEAD
                .andExpect(MockMvcResultMatchers.content().json("[{id:1,productName:Pname,brandName:Bname,price:10.0,targetAnimal:null,imageLink:null}]"));
=======
                .andExpect(MockMvcResultMatchers.content().json("[{id:1,productName:Pname,brandName:Bname,price:10.0}]"));
>>>>>>> b6ee88146414874a7d00d51c8072ca0a820084f2
        Mockito.verify(service, Mockito.times(1)).searchForProduct("Pname");
    }
    //ask for a product by price
    @Test
    void testAskForPrice() throws Exception {
        Product p = Product.builder()
                .id(1L)
                .productName("Pname")
                .brandName("Bname")
                .price(10f)
                .build();
        List<Product> list = Collections.singletonList(p);
        Mockito.when(service.searchForPrice(10f)).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/products/price<=10"))
                .andDo(MockMvcResultHandlers.print())
<<<<<<< HEAD
                .andExpect(MockMvcResultMatchers.content().json("[{id:1,productName:Pname,brandName:Bname,price:10.0,targetAnimal:null,imageLink:null}]"));
=======
                .andExpect(MockMvcResultMatchers.content().json("[{id:1,productName:Pname,brandName:Bname,price:10.0}]"));
>>>>>>> b6ee88146414874a7d00d51c8072ca0a820084f2
        Mockito.verify(service, Mockito.times(1)).searchForPrice(10f);
    }

    //ask for a product by brand
    @Test
    void testAskForBrand() throws Exception {
        Product p = Product.builder()
                .id(1L)
                .productName("Pname")
                .brandName("Bname")
                .price(10f)
                .build();
        List<Product> list = Collections.singletonList(p);
        Mockito.when(service.searchForBrand("Bname")).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/products/brand/Bname"))
                .andDo(MockMvcResultHandlers.print())
<<<<<<< HEAD
                .andExpect(MockMvcResultMatchers.content().json("[{id:1,productName:Pname,brandName:Bname,price:10.0,targetAnimal:null,imageLink:null}]"));
        Mockito.verify(service, Mockito.times(1)).searchForProduct("Bname");
    }
    //add product
    //FIXME:can't test post
=======
                .andExpect(MockMvcResultMatchers.content().json("[{id:1,productName:Pname,brandName:Bname,price:10.0}]"));
        Mockito.verify(service, Mockito.times(1)).searchForProduct("Bname");
    }
    //add product
    //can't test post
>>>>>>> b6ee88146414874a7d00d51c8072ca0a820084f2
    @Test
    void testAddingProduct() throws Exception {
        Product body = new Product();
        Mockito.when(service.addNewProduct(body)).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.post("/products/add")
                        .content("{productName:Pname,brandName:Bname,price:10.0}"))
                .andExpect(MockMvcResultMatchers.content().string("product added"));
        Mockito.verify(service, Mockito.times(1)).addNewProduct(body);
    }
<<<<<<< HEAD
    //delete product
    @Test
    void testDeleteProduct() throws Exception {
        Mockito.when(service.delete(1L)).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.delete("/products/id=1"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.content().string("deletion done"));
        Mockito.verify(service, Mockito.times(1)).delete(1L);
    }
    @Test
    void testDeleteNonExistant() throws Exception {
        Mockito.when(service.delete(1L)).thenReturn(false);
        mockMvc.perform(MockMvcRequestBuilders.delete("/products/id=1"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.content().string("deletion failed"));
        Mockito.verify(service, Mockito.times(1)).delete(1L);
    }
=======
    //TODO: complete remaining tests
    //delete product
    //bad cases
>>>>>>> b6ee88146414874a7d00d51c8072ca0a820084f2

}