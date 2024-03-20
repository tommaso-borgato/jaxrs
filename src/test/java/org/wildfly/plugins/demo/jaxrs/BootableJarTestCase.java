package org.wildfly.plugins.demo.jaxrs;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Response;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunAsClient
@ExtendWith(ArquillianExtension.class)
public class BootableJarTestCase {

	@Test
	public void testHelloEndpoint() {
		try (Client client = ClientBuilder.newClient()) {
			Response response = client
					.target(URI.create("http://127.0.0.1:8080/"))
					.path("/hello")
					.request()
					.get();

			assertEquals(200, response.getStatus());
			assertEquals("Hello from WildFly bootable jar!", response.readEntity(String.class));

		}
	}
}
