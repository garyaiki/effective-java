package cxf.rest;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

public class Order {

	@GET
	public Order getOrder(@PathParam("orderId") String orderId) {
		return null;
	}
	
	@PUT
	public Order updateOrder(@PathParam("orderId") String orderId, Order order) {
	  return null;
    }
}
