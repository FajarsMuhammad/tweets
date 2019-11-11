package com.pattern.dependency;

public class SMSServiceInjector implements MessageServiceInjector {

    @Override
    public Process getProcess() {
        return new MyDInjectionApplication(new SMSServiceImpl());
    }

}