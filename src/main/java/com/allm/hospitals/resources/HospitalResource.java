package com.allm.hospitals.resources;

import com.allm.hospitals.models.Hospital;
import com.allm.hospitals.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import java.util.List;

import static com.allm.hospitals.constants.HospitalsAPIConstants.MEDIA_JSON_UTF8;
import static com.allm.hospitals.constants.HospitalsAPIConstants.SC_OK;

@Controller
@Path("/hospitals")
public class HospitalResource {

    private final HospitalService hospitalService;

    @Autowired
    public HospitalResource(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GET
    @Produces(MEDIA_JSON_UTF8)
    public Response getHospitalsList(@QueryParam("page") int page, @QueryParam("limit") int limit) {
        List<Hospital> hospitalsList = hospitalService.getHospitals(page, limit);
        return Response.status(SC_OK).entity(hospitalsList).build();
    }
}
