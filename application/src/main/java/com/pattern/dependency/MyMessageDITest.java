package com.pattern.dependency;

public class MyMessageDITest {

    public static void main(String[] args) {
        String msg = "Hi Paul";
        String email = "paul@abc.com";
        String phone = "4088888888";

        // Send email
        MessageServiceInjector injector = new EmailServiceInjector();
        Process app = injector.getProcess();
        app.processMessages(msg, email);

        // Send SMS
        injector = new SMSServiceInjector();
        app = injector.getProcess();
        app.processMessages(msg, phone);
    }

}