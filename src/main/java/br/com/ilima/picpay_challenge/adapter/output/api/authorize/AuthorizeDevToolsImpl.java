package br.com.ilima.picpay_challenge.adapter.output.api.authorize;

import br.com.ilima.picpay_challenge.adapter.configuration.PropertiesConfiguration;
import br.com.ilima.picpay_challenge.adapter.exception.InfrastructureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

@Service
public class AuthorizeDevToolsImpl implements Authorize{

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizeDevToolsImpl.class);

    private final PropertiesConfiguration propertiesConfiguration;
    private final RestTemplate restTemplate;
    public AuthorizeDevToolsImpl(PropertiesConfiguration propertiesConfiguration, RestTemplate restTemplate) {
        this.propertiesConfiguration = propertiesConfiguration;
        this.restTemplate = restTemplate;
    }

    @Override
    public void execute() {
        try{

            LOGGER.info("Builder URL transfer");
            String URIProperties = propertiesConfiguration.getURIAuthorize();
            URL URL = new URI(URIProperties).toURL();
            LOGGER.info("Start Request Authorize");
            var response = restTemplate.getForObject(Objects.requireNonNull(URL.toString()), ResponseAuthentication.class);
            LOGGER.info("Request Authorize Success");
        }catch (RestClientException | URISyntaxException | MalformedURLException e){
            LOGGER.error("Request Authorize Fail");
            throw new InfrastructureException("Request authorized error");
        }
    }
}
