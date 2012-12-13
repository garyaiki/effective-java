package cxf.rest;

import javax.ws.rs.CookieParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/*
 * URI template variables shape, color are injected into their PathParams
 */
@Path("/boxes/{shape}/{color}")
public class Box {

	public Box() {}
	
	@PathParam("shape")
	String shape;

	@PathParam("color")
	String color;
	
	@HeaderParam("If-Modified-Since")// inject header param
	String oldestDate;
	
	@CookieParam("handle") // inject cookie from the header
	String handle;
}
