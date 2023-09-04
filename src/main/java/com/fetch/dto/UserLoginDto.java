package com.fetch.dto;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Id;

@Serdeable
public record UserLoginDto(@Id String user_id, String device_type, String ip, String device_id, String locale, String app_version) {
}
