package com.sofoste.controller;

import com.sofoste.model.Disease;
import com.sofoste.service.DiseaseService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.util.List;

@Path("/diseases")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DiseaseController {

    @Inject
    DiseaseService diseaseService;

    private static final Logger LOG = Logger.getLogger(DiseaseController.class.getName());

    @POST
    public Response createDisease(Disease disease) {
        LOG.infof("Creating disease: %s", disease.getName());
        Disease created = diseaseService.saveDisease(disease);
        return Response.ok(created).status(Response.Status.CREATED).build();
    }

    @GET
    public Response getAllDiseases() {
        LOG.info("Retrieving all diseases");
        List<Disease> diseases = diseaseService.findAllDiseases();
        if (diseases != null && !diseases.isEmpty()) {
            return Response.ok(diseases).build();
        } else {
            LOG.error("No diseases found");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getDisease(@PathParam("id") Long id) {
        LOG.infof("Retrieving disease with ID: %d", id);
        Disease disease = diseaseService.findDiseaseById(id);
        if (disease != null) {
            return Response.ok(disease).build();
        } else {
            LOG.errorf("Disease not found with ID: %d", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateDisease(@PathParam("id") Long id, Disease disease) {
        LOG.infof("Updating disease with ID: %d", id);
        Disease updated = diseaseService.updateDisease(id, disease);
        if (updated != null) {
            return Response.ok(updated).build();
        } else {
            LOG.errorf("Failed to update disease with ID: %d", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDisease(@PathParam("id") Long id) {
        LOG.infof("Deleting disease with ID: %d", id);
        try {
            diseaseService.deleteDisease(id);
            return Response.noContent().build();
        } catch (Exception e) {
            LOG.errorf("Failed to delete disease with ID: %d", id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
