package org.acme.resteasy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@PreMatching
public class ExampleFilter implements ContainerRequestFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleFilter.class);

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        LOGGER.debug("ExampleFilter invoked");
    }
}
