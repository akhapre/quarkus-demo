package org.acme.resteasy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class ExampleResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleResource.class);
    @Inject
    FibonacciSequenceService fibonacciSequenceService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("fibonacci/{size}")
    public String fibonacci(@PathParam("size") int lengthOfFibonacciSequence) {
        LOGGER.debug("Request for /fibonacci/" + lengthOfFibonacciSequence + " received.");
        List<Integer> sequenceWithNNumbers = fibonacciSequenceService.getSequenceWithNNumbers(lengthOfFibonacciSequence);
        StringBuilder sb = new StringBuilder();
        sequenceWithNNumbers.stream().forEach(n -> sb.append("," + n));
        LOGGER.debug("Responding to /fibonacci/" + lengthOfFibonacciSequence + " received.");
        return sb.toString();
    }
}