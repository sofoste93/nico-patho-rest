package com.sofoste.controller;

import com.sofoste.model.Product;
import com.sofoste.service.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {

    @Inject
    ProductService productService;

    @POST
    public Response createProduct(Product product) {
        Product created = productService.saveProduct(product);
        return Response.ok(created).status(Response.Status.CREATED).build();
    }

    @GET
    public Response getAllProducts() {
        List<Product> products = productService.findAllProducts();
        if (products != null && !products.isEmpty()) {
            return Response.ok(products).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getProduct(@PathParam("id") Long id) {
        Product product = productService.findProductById(id);
        if (product != null) {
            return Response.ok(product).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateProduct(@PathParam("id") Long id, Product product) {
        Product updated = productService.updateProduct(id, product);
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") Long id) {
        productService.deleteProduct(id);
        return Response.noContent().build();
    }
}
