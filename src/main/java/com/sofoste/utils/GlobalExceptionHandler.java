package com.sofoste.utils;

import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception e) {
        return Response.status(Response.Status.BAD_REQUEST)
                       .entity("Error: " + e.getMessage())
                       .type(MediaType.APPLICATION_JSON)
                       .build();
    }
}
