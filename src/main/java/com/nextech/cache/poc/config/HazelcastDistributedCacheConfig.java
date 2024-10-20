package com.nextech.cache.poc.config;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "cache.implementation", name = "type", havingValue = "distributed")
public class HazelcastDistributedCacheConfig {

    @Bean
    public ClientConfig config() {

        ClientConfig clientConfig = new ClientConfig();
        clientConfig.setClusterName("dev");
        clientConfig.getNetworkConfig().addAddress("127.0.0.1:5701", "127.0.0.1:5702");

        return clientConfig;
    }

    @Bean
    public HazelcastInstance hazelcastInstance(ClientConfig hazelcastConfig) {
        return HazelcastClient.newHazelcastClient(hazelcastConfig);
    }
}
