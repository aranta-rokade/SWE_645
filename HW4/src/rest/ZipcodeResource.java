package rest;

import java.util.Hashtable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

@Path("/zipcodes")
public class ZipcodeResource {
		
	@GET
	@Path("{zipcode}")
	@Produces(MediaType.TEXT_PLAIN)	
	public String getCityState (@PathParam("zipcode") int zipcode) {
		return getAll().get(zipcode);
	}
	
	public Hashtable<Integer, String> getAll(){
		Hashtable<Integer, String> mapping = new Hashtable<Integer, String>();
		mapping.put(22312, "Alexandria-VA");
		mapping.put(22030, "Fairfax-VA");
		mapping.put(22301, "Tysons Corner-MD");
		mapping.put(20148, "Ashburn-VA");
		return mapping;
	}
}
