package com.sofoste.controller;

import com.sofoste.model.ProductDisease;
import com.sofoste.service.ProductDiseaseService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/product-diseases")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductDiseaseController {

    @Inject
    ProductDiseaseService productDiseaseService;

    @POST
    public Response createProductDisease(ProductDisease productDisease) {
        ProductDisease created = productDiseaseService.saveProductDisease(productDisease);
        return Response.ok(created).status(Response.Status.CREATED).build();
    }

    @GET
    public Response getAllProductDiseases() {
        List<ProductDisease> productDiseases = productDiseaseService.findAllProductDiseases();
        return Response.ok(productDiseases).build();
    }

    @GET
    @Path("/{id}")
    public Response getProductDisease(@PathParam("id") Long id) {
        ProductDisease productDisease = productDiseaseService.findProductDiseaseById(id);
        if (productDisease != null) {
            return Response.ok(productDisease).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateProductDisease(@PathParam("id") Long id, ProductDisease productDisease) {
        ProductDisease updated = productDiseaseService.updateProductDisease(id, productDisease);
        if (updated != null) {
            return Response.ok(updated).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProductDisease(@PathParam("id") Long id) {
        productDiseaseService.deleteProductDisease(id);
        return Response.noContent().build();
    }
}
