package com.nextech.cache.poc.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "cache.implementation", name = "type", havingValue = "local", matchIfMissing = true)
public class HazelcastCacheConfig {

    @Bean
    public Config hazelcastConfig() {
        Config config = new Config();

        config.setInstanceName("hazelcast-instance");

        // Disable all cluster discovery mechanisms
        JoinConfig joinConfig = config.getNetworkConfig().getJoin();
        joinConfig.getMulticastConfig().setEnabled(false);  // Disable multicast
        joinConfig.getTcpIpConfig().setEnabled(false);      // Disable TCP/IP discovery
        joinConfig.getAwsConfig().setEnabled(false);        // Disable AWS discovery
        joinConfig.getKubernetesConfig().setEnabled(false); // Disable Kubernetes discovery
        joinConfig.getAutoDetectionConfig().setEnabled(false);

        return config;
    }

    @Bean
    public HazelcastInstance hazelcastInstance(Config hazelcastConfig) {
        return Hazelcast.newHazelcastInstance(hazelcastConfig);
    }
}
