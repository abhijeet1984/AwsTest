/**
 * 
 */
package com.learning.wipro;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * @author AB277176
 *
 */
@Path("/App")
public class RestService {
	
	@GET
	@Path("/Rest")
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHello(@QueryParam("name") String uName){
		return "Hello to User :"+uName ;
	}
	
	@GET
	@Path("/Select")
	@Produces(MediaType.TEXT_HTML)
	public String selectQuery(@QueryParam("search") String search) throws Exception{
		ConnectionMysqlPaas con = new ConnectionMysqlPaas();
		System.out.println("Going to fetch");
		String result = con.readDataBase();
		System.out.println("After fetching :"+result);
		return "<html> " + "<title>" + "Hello Jersey" + "</title>"
        + "<body><h1>" + "Output result" + "<table>"+result+"</table>"+"</body></h1>" + "</html> ";
	}
	
	@GET
	@Path("/SayHello")
	@Produces(MediaType.TEXT_HTML)
	 
	  public String sayHtmlHello() {
	    return "<html> " + "<title>" + "Hello Jersey" + "</title>"
	        + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
	  }
	
	@POST
	@Path("/AddUser")
	@Produces(MediaType.TEXT_HTML)
	
	public String addUser(@FormParam("fName") String firstName ,@FormParam("lName") String lastName ,@FormParam("gender") String gender,@FormParam("age") String age,@FormParam("email") String email){
		ConnectionMysqlPaas con = new ConnectionMysqlPaas();
		System.out.println("Going to add");
		
		int ageM = Integer.parseInt(age);
		con.writeUser(firstName, lastName, email, gender, ageM);
		return "<html> " + "<title>" + "Hello Jersey" + "</title>"
		        + "<body><h1>" + "User added Succesfully" + "</body></h1>" + "</html> ";
	}
}
