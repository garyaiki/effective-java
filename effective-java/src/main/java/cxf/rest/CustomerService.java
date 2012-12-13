package cxf.rest;
/* A root resource class
 * @Path is the entry point to a service's resource tree 
 * @Path can also be a sub-resource relative to the entry point 
 * @Get is the get method implementation
 */
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
@Path("/customerservice") // root uri
public class CustomerService {
	
	/*
	 * root resource must have a public constructor
	 */
	public CustomerService() { // 
	}
	
	/*
	 * resource method must be public
	 * Http response code is 204 when returning anything other than null
	 * code is 200 when returning null or a void method
	 * id should be a unique sub-resource
	 */
	@GET 
	public Customer getCustomer(@QueryParam("id") String id) {
		return null;

	}
	
	@DELETE
	public Response deleteCustomer(@QueryParam("id") String id) {
		return null;
		
	}
	
	@PUT
	public Response updateCustomer(Customer customer) {
		return null;
		
	}
	
	@POST
	public Response addCustomer(Customer customer) {
		return null;
	}
	
	/*
	 * get sub resource relative path to root
	 * "orderId should be unique sub-resource mapped from resource URI to annotated parameter
	 */
	@Path("/orders/{orderId}/") 
	@GET
	public Order getOrder(@PathParam("orderId") String orderId) {
		return null;
	}
	
	@Path("/orders/{orderId}/")
	@PUT
    public Order updateOrder(@PathParam("orderId") String orderId, Order order) {
    	return null;
    }
	
	@Path("/orders/")
	@POST
	public Order newOrder(Order order) {
		return null;
	}
	
	/*
	 * sub-resource locator does not have an http verb it returns a sub-resource instance
	 * that can handle the request
	 */
	@Path("/orders/{orderId}/")
	public Order processOrder(@PathParam("orderId") String orderId) {
		return null;
	}
	
	@POST // post form fields
	public boolean updatePost(@FormParam("title") String title,@FormParam("tags") String tags,
			@FormParam("body") String post) {
		return false;
	}
}
