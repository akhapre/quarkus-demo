package org.acme.resteasy;

import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.models.parameters.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class FibonacciSequenceService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FibonacciSequenceService.class);

    @Counted(name = "FibonacciSequenceServiceCallCounter")
    @Timed(name = "FibonacciSequenceServiceAverageTime")
    List<Integer> getSequenceWithNNumbers(int n) {
        if(n == 100) {
            LOGGER.debug("100 number of Fibonacci sequence are being calculated.");
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        List<Integer> returnValue = new ArrayList<>();
        if (n == 0) {
        } else if (n == 1) {
            returnValue.add(0);
        } else if (n == 2) {
            returnValue.add(0);
            returnValue.add(1);
        } else {
            //returnValue.add(0);
            //returnValue.add(1);
            fibonacci(returnValue, 0, 1, n-2);
        }
        return returnValue;
    }

    private void fibonacci(List<Integer> fibonacciSequenceList,  int previousNumber2, int previousNumber1, int moreNumbersNeeded) {
        if (moreNumbersNeeded > 0) {
            int newNumber = previousNumber2 + previousNumber1;
            fibonacciSequenceList.add(newNumber);
            fibonacci(fibonacciSequenceList, previousNumber1, newNumber,  moreNumbersNeeded -1);
        } else {
            return;
        }
    }
}
