package com.viki3d.spring.cloud.configuration.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The client module, reading configuration from the server module.
 *
 * @author Victor Kirov
 */
@SpringBootApplication
@RestController
public class ConfigurationClient {

  private final Logger logger = LoggerFactory.getLogger(ConfigurationClient.class);

  @Autowired 
  private Environment env;

  /**
   * Reading the value of the property 'myprop1' from server configuration. Server configuration 
   * could reside either:
   *   <ul>
   *     <li>
   *       property file<br/>
   *       /src/main/resources/native/spring-cloud-config-client-dev.properties<br/>
   *       value = myval1-file-property
   *     </li>
   *   </ul>
   *   OR
   *   <ul>
   *     <li>
   *       git-repo<br/>
   *       https://github.com/viki3d/spring-cloud-configuration/tree/main/configuration
   *           /spring-cloud-config-client-dev.properties<br/>
   *       value = myval1-gitrepo-property
   *     </li>
   *   </ul>
   *   
   * <p><a href="http://localhost:8080/">test link</a></p>
   *
   * @return The value, associated with 'myprop1' property.
   */
  @RequestMapping("/")
  public String home() {
    // Why this local constant is written in camelCase, instead UPPER_SNAKE_CASE ?
    // Local variable names are written in lowerCamelCase [...] Even when final and immutable, local
    // variables are not considered to be constants, and should not be styled as constants.
    final String myPropertyName = "myprop1";

    // Will read either 'myval1-file-property' or 'myval1-gitrepo-property' (depends on server cfg):
    String myPropertyValue = env.getProperty(myPropertyName);
    logger.debug("Reading property '{}' = {}", myPropertyName, myPropertyValue);
    logger.debug("Reading property 'spring.application.name' = {}", 
        env.getProperty("spring.application.name"));

    return myPropertyName + " = " + myPropertyValue;
  }

  public static void main(String[] args) {
    SpringApplication.run(ConfigurationClient.class, args);
  }

}