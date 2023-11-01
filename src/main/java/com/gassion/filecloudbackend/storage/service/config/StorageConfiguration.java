package com.gassion.filecloudbackend.storage.service.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfiguration {

    @Value("${minio.user_id}")
    private String user;

    @Value("${minio.secret_key}")
    private String secret;

    @Value("${minio.endpoint}")
    private String endpoint;

    @Bean
    public MinioClient getClient() {
        return MinioClient.builder()
            .endpoint(endpoint)
            .credentials(user, secret)
            .build();
    }

}
