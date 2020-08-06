package com.techatpark.javapractice.math;

import org.apache.commons.math3.stat.descriptive.rank.Percentile;

public final class Statistics {

    public static double getQuantile(double[] values, double p) {
        Percentile percentile = new Percentile();
        percentile.setData(values);
        percentile.setQuantile(p);
        return percentile.evaluate();
    }

}
