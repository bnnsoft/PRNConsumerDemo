/*
 * @(#)PRNConsumerDemo.java  1.0  Dec 29, 2017
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
 * Main class 
 *
 * @author Bojan Nokovic
 * @version 1.0 Dec. 29, 2017 Created.
 */
public class PRNConsumerDemo {

    public static void main(String[] args) {
        PRNConsumer ckf = new PRNConsumer();
        ckf.start();
    }

}
