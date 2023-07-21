package tech.learning.dependencyinjection.services;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    public SingletonBean() {
        System.out.println("Creating a singleton bean.");
    }

    public String getScope() {
        return "This bean is a singleton.";
    }
}
