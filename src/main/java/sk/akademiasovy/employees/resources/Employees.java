package sk.akademiasovy.employees.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import sk.akademiasovy.employees.db.MySQL;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/employees")
public class Employees {

    @POST
    @Path("/salary")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmp(Emp emplo)
    {
        String salary = new MySQL().getEmp(emplo.name);
            return salary;
    }
    public static class Emp
    {
        @JsonProperty("name")
        public String name ;
    }
}