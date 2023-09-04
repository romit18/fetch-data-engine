package com.fetch.dto;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Entity;

import io.micronaut.core.annotation.Introspected;
import jakarta.persistence.Id;
import lombok.Builder;

import java.util.Date;

@Entity
@Builder
@Introspected
@Serdeable
public record UserLogins(@Id
                        String userId,
                                String deviceType,
                                String maskedIp,
                                String maskedDeviceId,
                                String locale,
                                int app_version,
                                Date createDate) {

}

