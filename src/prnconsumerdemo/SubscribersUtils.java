/*
 * @(#) SubscribersUtils.java  1.0  Dec 29, 2017
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

public class SubscribersUtils {

    public static final int RANDOM_NUMBER_RANGE = 65536; // 0 - 65536

    // 0 < Seed < 99 
    public static int SEED_MIN = 1;
    public static int SEED_MAX = 98;

    // Publisher properties
    public static final String TOPIC = "randomnumbers";
    public static final String KAFKA_SERVER_URL = "172.31.19.227";
    public static final int KAFKA_SERVER_PORT = 9092;
    public static final int KAFKA_PRODUCER_BUFFER_SIZE = 33554432;
    public static final int CONNECTION_TIMEOUT = 60000;
    public static final String CLIENT_ID = "";

    // Constructor
    private SubscribersUtils() {
    }
}
