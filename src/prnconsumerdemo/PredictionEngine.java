/*
 * @(#)PredictionEngine.java  1.0  Dec 29, 2017
 *
 * Copyright (c) 2017 Bojan Nokovic
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of the
 * Bojan Nokovic. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with the Bojan Nokovic.
 */
package prnconsumerdemo;

import java.util.Random;

/**
 * Simple Prediction Engine. It has 1/6 chance to 
 * find random number.
 *
 * @author Bojan Nokovic
 * @version 1.0 Dec. 29, 2017 Created.
 */
public class PredictionEngine {

    // Constructor
    PredictionEngine() {
    }

    /**
     * Simple predict engine demo
     *
     * We assume that we know six random number generating algorithms, but we do
     * not know which one is used
     *
     * @param seed
     * @param timestamp
     * @return long PERandomNumber
     */
    public long PredictNumber(long seed, long timestamp) {

        // Returns a uniformly distributed int value between 1 and 6
        int generator = (int) (Math.random() * (7 - 1)) + 1;

        long PERandomNumber;

        switch (generator) {
            case 1:
                PERandomNumber = (long) seed * seed;
                break;
            case 2:
                PERandomNumber = (long) 1 << seed;
                break;
            case 3:
                PERandomNumber = (long) timestamp - seed;
                break;
            case 4:
                PERandomNumber = (long) timestamp + seed;
                break;
            case 5:
                PERandomNumber = (long) seed << 5;
                break;
            case 6:
                PERandomNumber = (long) seed << 8;
                break;
            default:
                PERandomNumber = -1;
                break;
        }
        return PERandomNumber;
    }
}
