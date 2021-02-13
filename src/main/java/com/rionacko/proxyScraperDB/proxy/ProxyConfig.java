package com.rionacko.proxyScraperDB.proxy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProxyConfig {
    ProxyScraper proxyScraper = new ProxyScraper();

    @Bean
    CommandLineRunner commandLineRunner(
            ProxyRepository repository){
        return args ->{
            repository.saveAll(proxyScraper.proxyList());

        };
    }

}
