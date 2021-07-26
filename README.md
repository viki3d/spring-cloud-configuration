# spring-cloud-configuration
Java, Spring, Spring Cloud, Microservices

The HTTP service uses resources in the following form:
  > /{application}/{profile}[/{label}]  
  > /{label}/{application}-{profile}.properties  

where:  
_{application}_ is set by:  

| spring.config.name=... |
| ---------------------- |

_{profile}_ is set by:  

| spring.profiles.active=...  |
| --------------------------- |

_{label}_ is the repository branch. The default is now _main_ but before it was
_master_.  

