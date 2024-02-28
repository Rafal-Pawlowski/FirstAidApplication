package com.xxx.firstaidapplication;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="emergency-call")
@Data
public class FirstAidConfiguration {

    private String name;

    @Value("${paging.pageSize:2}")
    private int pagingPageSize;

}
