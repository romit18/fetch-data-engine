package com.fetch.controllers;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.jmespath.ObjectMapperSingleton;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.util.Base64;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fetch.dto.UserLogins;
import com.fetch.dto.UserLoginDto;
import com.fetch.repository.UserLoginRepository;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class FetchController {

    @Inject
    private UserLoginRepository userLoginRepository;
    ObjectMapper objectMapper = ObjectMapperSingleton.getObjectMapper();
    final String ACCESS_KEY = "test";
    final String SECRET_KEY = "test";
    BasicAWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);

    private AmazonSQS sqsClient() {

        return AmazonSQSClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration("localhost.localstack.cloud:4566", Regions.US_EAST_1.getName()))
                .build();
    }

    @Get("/data")
    public List<UserLoginDto> getMessages() throws IOException {
        List<Message> messages = sqsClient().receiveMessage("000000000000/login-queue").getMessages();
        List<UserLoginDto> userDtos = new ArrayList<>();
        for(Message m: messages){
            userDtos.add(objectMapper.readValue(m.getBody(), UserLoginDto.class));
        }

        for(UserLoginDto userLoginDto: userDtos){
            UserLogins userLogin = UserLogins.builder().app_version(Integer.parseInt(userLoginDto.app_version().substring(0, 1))).userId(userLoginDto.user_id()).createDate(new Date()).maskedIp(Base64.encodeAsString(userLoginDto.ip().getBytes())).maskedDeviceId(Base64.encodeAsString(userLoginDto.ip().getBytes())).locale(userLoginDto.locale())
                    .deviceType(userLoginDto.device_type()).build();
            userLoginRepository.save(userLogin);
        }

        return userDtos;
    }
}