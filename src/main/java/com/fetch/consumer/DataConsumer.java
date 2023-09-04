//package com.fetch.consumer;
//
//import com.fetch.sqs.SqsClientFactory;
//import io.micronaut.jms.annotations.JMSListener;
//import io.micronaut.jms.annotations.Queue;
//import io.micronaut.messaging.annotation.MessageBody;
//import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;
//
//import static io.micronaut.jms.sqs.configuration.SqsConfiguration.CONNECTION_FACTORY_BEAN_NAME;
//
//@JMSListener(CONNECTION_FACTORY_BEAN_NAME)
//public class DataConsumer {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(DataConsumer.class);
//
//
//
//    @Queue(value = "/000000000000/login-queue", concurrency = "1-3")
//    public void receive(@MessageBody String body) {
//        LOGGER.info("Message has been consumed. Message body: {}", body);
//    }
//
//}