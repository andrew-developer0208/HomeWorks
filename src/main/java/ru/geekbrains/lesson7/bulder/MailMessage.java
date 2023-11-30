package ru.geekbrains.lesson7.bulder;

public class MailMessage {

    private String from;
    private String to;
    private String subject;
    private String body;
    private int param1;
    private double param2;

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setParam1(int param1) {
        this.param1 = param1;
    }

    public void setParam2(double param2) {
        this.param2 = param2;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public int getParam1() {
        return param1;
    }

    public double getParam2() {
        return param2;
    }
}
