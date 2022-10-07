package com.practice.demo.endpoint;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Endpoint(id = "custom")
/* use @EndpointWebExtension(endpoint = HealthEndPoint.class) for this
 * to be able to use with web flux, jersey as well as spring mvc
 * @EndpointJmxExtension to be used with jmx
 * @ServletEndPoint to expose a servlet as an endpoint
 * @ControllerEndpoint and @RestControllerEndpoint for spring mvc specific*/
@Component
public class CustomActuatorEndpoint {

	//userName here is the query string parameter
	@ReadOperation
	public Object customEndPoint(
			/* use @Selector here to get userName from path variable */
			String userName) {
		Map<String, String> map = new HashMap<>();
		map.put("key", "value");
		map.put("userName", userName);
		return map;
	}
}
