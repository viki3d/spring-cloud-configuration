package com.viki3d.spring.cloud.configuration.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * The server module, providing configuration for client module.
 *
 * @author Victor Kirov
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigurationServer {
  public static void main(String[] args) {
    SpringApplication.run(ConfigurationServer.class, args);
  }
}