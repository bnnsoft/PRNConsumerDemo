/*
 * @(#) Record.java  1.0  Dec 29, 2017
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

/**
 * Record holds: random number, guesses, seed and time stamp
 *
 * @author Bojan Nokovic
 * @version 1.0 Dec. 29, 2017 Created.
 */
public class Record {

    long generatedNumber;
    long guesses[] = new long[3];
    long seed;
    long timestamp;

    // Constructor
    void Record() {
        generatedNumber = 1;
        for(int i = 0; i < 3; i++)
            guesses [i] = 0;
        seed = timestamp = 0;
    }

    public void SetRecord(long x, long y[], long seed, long timestamp) {
        generatedNumber = x;
        guesses = y; // ?
        this.seed = seed;
        this.timestamp = timestamp;
    }

    public void SetRecord(long x, long seed, long timestamp) {
        generatedNumber = x;
        this.seed = seed;
        this.timestamp = timestamp;
    }

    public long getGeneratedRandomNumber() {
        return generatedNumber;
    }

    public long getSeed() {
        return seed;
    }

    public long getTS() {
        return timestamp;
    }

    public long[] getGuesses() {
        return guesses;
    }

    @Override
    public String toString() {
        String result;

        result = Long.toString(generatedNumber) + ", "
                + Long.toString(guesses[0]) + ", "
                + Long.toString(guesses[1]) + ", "
                + Long.toString(guesses[2]) + ", "
                + Long.toString(seed) + ", "
                + Long.toString(timestamp) + ";\n";

        return result;
    }
}
