package com.sofoste.controller;

import com.sofoste.model.Firm;
import com.sofoste.service.FirmService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/firms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FirmController {

    @Inject
    FirmService firmService;

    @POST
    public Response createFirm(Firm firm) {
        Firm created = firmService.saveFirm(firm);
        return Response.ok(created).status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    public Response getFirm(@PathParam("id") Long id) {
        Firm firm = firmService.findFirmById(id);
        if (firm != null) {
            return Response.ok(firm).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateFirm(@PathParam("id") Long id, Firm firm) {
        Firm updated = firmService.updateFirm(id, firm);
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteFirm(@PathParam("id") Long id) {
        firmService.deleteFirm(id);
        return Response.noContent().build();
    }
}
