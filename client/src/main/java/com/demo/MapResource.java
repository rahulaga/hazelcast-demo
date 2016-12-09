package com.demo;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Path("/map")
@Component
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class MapResource {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private HazelcastService hzService;

	@POST
	@Path("/{key}")
	public Response put(@PathParam("key") String key, MapBody body) {
		hzService.put(key, body);
		return Response.status(Status.OK).build();
	}

	@GET
	@Path("/{key}")
	public MapBody getByKey(@PathParam("key") String key) {
		logger.info("getting by key:" + key);
		MapBody body = hzService.get(key);
		return body;
	}
	
	@GET
	@Path("/poll/{key}")
	public MapBody getPoll(@PathParam("key") String key) {
		logger.info("get POLL by key:" + key);
		MapBody body = hzService.get(key);
		return body;
	}
}
