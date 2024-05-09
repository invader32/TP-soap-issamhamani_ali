package amoa.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.xml.ws.Endpoint;

public class ServicePublisher {
    private static Logger logger = LoggerFactory.getLogger(ServicePublisher.class);

    public static void main(String[] args) {
        logger.info("Starting server");
        Endpoint.publish("http://localhost:2020/webservices/ProductsManager", new ProductsManagerImpl());
        logger.info("Server started");
    }
}
