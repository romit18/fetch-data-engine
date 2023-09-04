package com.fetch.etl;

import com.fetch.controllers.FetchController;
import io.micronaut.scheduling.annotation.Scheduled;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.io.IOException;

@Singleton
public class ETLProcess {

    @Inject
    FetchController fetchController;

    @Scheduled(fixedDelay = "10s")
    void executeEveryTen() throws IOException {
        fetchController.getMessages();
    }
}