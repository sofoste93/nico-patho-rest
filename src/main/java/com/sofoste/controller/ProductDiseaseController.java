package com.sofoste.controller;

import com.sofoste.model.ProductDisease;
import com.sofoste.service.ProductDiseaseService;
import com.sofoste.service.ProductService;
import com.sofoste.service.DiseaseService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.util.List;

@Path("/product-diseases")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductDiseaseController {

    @Inject
    ProductDiseaseService productDiseaseService;

    @Inject
    ProductService productService;

    @Inject
    DiseaseService diseaseService;

    private static final Logger LOG = Logger.getLogger(ProductDiseaseController.class.getName());

    @POST
    @Path("/initialize")
    public Response initializeData() {
        LOG.info("Initializing product-disease data");

        ProductDisease pd1 = new ProductDisease();
        pd1.setProduct(productService.findProductById(1L));
        pd1.setDisease(diseaseService.findDiseaseById(1L));
        pd1.setRiskLevel("High");
        productDiseaseService.saveProductDisease(pd1);

        ProductDisease pd2 = new ProductDisease();
        pd2.setProduct(productService.findProductById(1L));
        pd2.setDisease(diseaseService.findDiseaseById(2L));
        pd2.setRiskLevel("Moderate");
        productDiseaseService.saveProductDisease(pd2);

        ProductDisease pd3 = new ProductDisease();
        pd3.setProduct(productService.findProductById(1L));
        pd3.setDisease(diseaseService.findDiseaseById(3L));
        pd3.setRiskLevel("High");
        productDiseaseService.saveProductDisease(pd3);

        ProductDisease pd4 = new ProductDisease();
        pd4.setProduct(productService.findProductById(2L));
        pd4.setDisease(diseaseService.findDiseaseById(1L));
        pd4.setRiskLevel("Moderate");
        productDiseaseService.saveProductDisease(pd4);

        ProductDisease pd5 = new ProductDisease();
        pd5.setProduct(productService.findProductById(2L));
        pd5.setDisease(diseaseService.findDiseaseById(2L));
        pd5.setRiskLevel("Low");
        productDiseaseService.saveProductDisease(pd5);

        // ...

        return Response.ok().build();
    }

    @POST
    public Response createProductDisease(ProductDisease productDisease) {
        LOG.infof("Creating product-disease: %s", productDisease);
        ProductDisease created = productDiseaseService.saveProductDisease(productDisease);
        return Response.ok(created).status(Response.Status.CREATED).build();
    }

    @GET
    public Response getAllProductDiseases(@QueryParam("productId") Long productId, @QueryParam("diseaseId") Long diseaseId) {
        LOG.info("Retrieving all product-diseases");
        List<ProductDisease> productDiseases;
        if (productId != null) {
            productDiseases = productDiseaseService.findByProductId(productId);
        } else if (diseaseId != null) {
            productDiseases = productDiseaseService.findByDiseaseId(diseaseId);
        } else {
            productDiseases = productDiseaseService.findAllProductDiseases();
        }
        if (productDiseases != null && !productDiseases.isEmpty()) {
            return Response.ok(productDiseases).build();
        } else {
            LOG.error("No product-diseases found");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getProductDisease(@PathParam("id") Long id) {
        LOG.infof("Retrieving product-disease with ID: %d", id);
        ProductDisease productDisease = productDiseaseService.findProductDiseaseById(id);
        if (productDisease != null) {
            return Response.ok(productDisease).build();
        } else {
            LOG.errorf("Product-disease not found with ID: %d", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateProductDisease(@PathParam("id") Long id, ProductDisease productDisease) {
        LOG.infof("Updating product-disease with ID: %d", id);
        ProductDisease updated = productDiseaseService.updateProductDisease(id, productDisease);
        if (updated != null) {
            return Response.ok(updated).build();
        } else {
            LOG.errorf("Failed to update product-disease with ID: %d", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProductDisease(@PathParam("id") Long id) {
        LOG.infof("Deleting product-disease with ID: %d", id);
        try {
            productDiseaseService.deleteProductDisease(id);
            return Response.noContent().build();
        } catch (Exception e) {
            LOG.errorf("Failed to delete product-disease with ID: %d", id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
