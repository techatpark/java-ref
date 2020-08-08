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
        c.assign("input", new double[]{ 1.0, 2.0, 3.0, 4.0, 5.0 });
        System.out.println(c.eval("customMean(input)"));

        // System.out.println(Statistics.getQuantile(new double[]{3,3,4,5},0.005));
    }
}