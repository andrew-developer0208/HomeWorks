package ru.geekbrains.lesson7.bulder;

public class MailMessageBuilder {

    private MailMessage mailMessage;


    public MailMessage build(){

        if (mailMessage.getTo() == null || mailMessage.getTo().equals(""))
            throw new RuntimeException("Получатель должен быть указан!");
        return mailMessage;
    }

    public MailMessageBuilder(){
        mailMessage = new MailMessage();
    }

    public MailMessageBuilder setFrom(String address) {
        mailMessage.setFrom(address);
        return this;
    }

    public MailMessageBuilder setTo(String address) {
        mailMessage.setTo(address);
        return this;
    }

    public MailMessageBuilder setSubject(String subject) {
        mailMessage.setSubject(subject);
        return this;
    }

    public MailMessageBuilder setBody(String body) {
        mailMessage.setBody(body);
        return this;
    }

    public MailMessageBuilder setParam1(int param1) {
        mailMessage.setParam1(param1);
        return this;
    }

    public MailMessageBuilder setParam2(double param2) {
        mailMessage.setParam2(param2);
        return this;
    }


}
