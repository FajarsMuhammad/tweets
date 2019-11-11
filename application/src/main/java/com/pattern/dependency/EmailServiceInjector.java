package com.pattern.dependency;

public class EmailServiceInjector implements MessageServiceInjector {

    @Override
    public Process getProcess() {
        return new MyDInjectionApplication(new EmailServiceImpl());
    }

}