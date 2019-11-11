package com.pattern.dependency;

public class MyDInjectionApplication implements Process {

    private MessageService service;

    public MyDInjectionApplication(MessageService service) {
        this.service = service;
    }

    @Override
    public void processMessages(String msg, String rec) {
        this.service.sendMessage(msg, rec);
    }

}