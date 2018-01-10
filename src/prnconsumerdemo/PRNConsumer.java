/*
 * @(#)PRNConsumer.java  1.0  Dec 29, 2017
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

import java.util.Arrays;
import kafka.utils.ShutdownableThread;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * Receives messages from producer through Kafka, and
 * process it.
 *
 * @author Bojan Nokovic
 * @version 1.0 Dec. 29, 2017 Created.
 */
public class PRNConsumer extends Thread {

    private KafkaConsumer<String, String> consumer;
    private static String topic = SubscribersUtils.TOPIC;

    public PRNConsumer() {
        Properties props = new Properties();

        props.put("bootstrap.servers", "172.31.19.227:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumer = new KafkaConsumer<>(props);
        //this.topic = topic;
    }

    public void run() {
        //consumer.subscribe(Arrays.asList("randomnumbers"));
        consumer.subscribe(Arrays.asList(topic));

        // Show initial score
        ScoreKeeper gsc = new ScoreKeeper();   
        gsc.ShowScore();                       
        // 
        ResultAnalyzer analyze = new ResultAnalyzer();

        while (true) {
            
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("Received message: (" + record.key() + ", " + record.value() + ") at offset " + record.offset());
                String value = record.value();
                if(!value.isEmpty())
                    analyze.AnalyzeRecord(record.value());
            }

//            System.out.println("Test of consumer");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(PRNConsumer.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }
}
