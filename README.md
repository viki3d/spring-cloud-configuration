# spring-cloud-configuration
Java, Spring, Spring Cloud, Microservices

![spring-cloud-configuration](spring-cloud-configuration.png?id=1)  

### spring-cloud-config

Spring Cloud Config provides server-side and client-side support for externalized configuration in a distributed system. 
With the Config Server, you have a central place to manage external properties for applications across all environments.  

As an application moves through the deployment pipeline from dev to test and into production, you can manage the
configuration between those environments and be certain that applications have everything they need to run when they migrate.  

The HTTP service uses resources in the following form:
  > cloud-config-server:8888/{application}/{profile}[/{label}]  
  > cloud-config-server:8888/{label}/{application}-{profile}.properties  

where:  
_{application}_ is set by:  

| spring.cloud.config.name=... |
| ---------------------------- |

_{profile}_ is set by:  

| spring.cloud.config.profile=...  |
| -------------------------------- |

_{label}_ is the repository branch. The default is now _main_ but before it was
_master_.  

### spring-cloud-configuration-server

__Configuration files__  
The Cloud Config Server provides the configuration files to the Client:  
{application}-{profile}.properties  
{application}-{profile}.yml  

__Vault__  
Vault is a tool for securely accessing secrets (across Dynamic infrastructure).  
A secret is anything that to which you want to tightly control access, such as  
API keys, passwords, certificates, and other sensitive information. Vault provi-  
des a unified interface to any secret while providing tight access control and  
recording a detailed audit log.

  > INFO 10040 --- [           main] c.v.s.c.c.server.ConfigurationServer     : Starting ConfigurationServer using Java 16.0.1  
  INFO 10040 --- [           main] c.v.s.c.c.server.ConfigurationServer     : No active profile set, falling back to default profiles: default  
  INFO 10040 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8888 (http) with context path ''  

### spring-cloud-configuration-client

  > INFO  Fetching config from server at : http://localhost:8888
INFO  Located environment: name=spring-cloud-config-client, profiles=[dev], label=null, version=52596ab7b3768b7d99ae9282d39321a322dd8fb3, state=null  
  INFO  Tomcat initialized with port(s): 8080 (http)  
  INFO  Started ConfigurationClient in 10.633 seconds (JVM running for 11.119)  

When server is reading configuration from file ("native" approach):  
  > myprop1 = myval1-file-property  

When server is reading configuration from git repository:  
  > myprop1 = myval1-gitrepo-property

Enabling usage of: _bootstrap.properties_  
  >  
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-bootstrap</artifactId>
        </dependency>




