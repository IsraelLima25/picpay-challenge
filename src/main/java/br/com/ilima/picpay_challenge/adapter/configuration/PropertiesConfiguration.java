package br.com.ilima.picpay_challenge.adapter.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesConfiguration {

    @Value("${uri.authorize}")
    private String URIAuthorize;

    public String getURIAuthorize() {
        return URIAuthorize;
    }
}
