package cxf.rest;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/*
 * @QueryParam extract the value of a ? parameter and injects it into a resource
 * For example /monstersforhire/daikaiju?id=jonas daikaiju is injected into type jonas into id
 */
@Path("/monstersforhire/")
public class MonsterService {

	@POST
	@Path("/{ type} ")
	public void updateMonster(@PathParam("type") String type,@QueryParam("id") String id) {
		
	}
	
	/*
	 * matrix parameters
	 * /monstersforhire/japan;type=daikaiju/flying;wingspan=40
	 */
	@POST
	public void updateMonster2(@MatrixParam("type") String type,@MatrixParam("id") String id) {
		
	}@DefaultValue("42")
	
	@POST // optional paramaters can have a default value which will be injected into resource
	public void updateMonster3(@MatrixParam("type") String type,@MatrixParam("id") 
	@DefaultValue("42") String id) {
		
	}
}
