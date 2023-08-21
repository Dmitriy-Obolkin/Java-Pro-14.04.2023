package ua.ithillel.jaxrs;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.io.IOException;
import java.net.URI;


public class Main {
    public static final String BASE_URI = "http://localhost:8080/";

    public static void main(String[] args) throws IOException {

        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.packages("ua.ithillel.jaxrs");

        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), resourceConfig);

        server.start();

        System.out.printf("Jersey app started with endpoints available at "
                + "%s%nHit Ctrl-C to stop it...%n", BASE_URI);
        System.in.read();
        server.stop();
    }
}

