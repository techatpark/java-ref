package com.techatpark.javapractice.math;

import org.junit.jupiter.api.Test;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest {

    @Test
    void getQuantile() throws REngineException, REXPMismatchException {

            RConnection c = new RConnection();
            c.assign("input", new int[] { 1, 2, 3, 4, 5 });
            System.out.println(c.eval("customMean(input)").asDouble());

        // System.out.println(Statistics.getQuantile(new double[]{3,3,4,5},0.005));
    }
}