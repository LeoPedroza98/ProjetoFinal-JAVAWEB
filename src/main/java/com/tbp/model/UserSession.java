package com.tbp.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSession {

    Person person;

    public  void AddLoggedUser(Person person){
        this.person = person;
    }

    public Person getLoggerUser(){
       return person;
    }

    public void removedLoggedUser(){
        this.person = null;
    }
}
