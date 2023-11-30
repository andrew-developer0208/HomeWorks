package ru.geekbrains.lesson7.bulder;

public class Program {

    public static void main(String[] args) {

        //MailMessage mailMessage1 = new MailMessage("from@gmail.com",
         //       "to@gmail.com", "subject", "body", 12, 12.12);

        MailMessage mailMessage = new MailMessageBuilder()
                .setFrom("from@gmail.com")
                .setSubject("subject")
                .setParam2(12.12)
                .setTo("to@gmail.com")
                .build();

        StringBuilder stringBuilder = new StringBuilder("AAA");
        String str = stringBuilder.append("BBB")
                .append("CCCC")
                .append("DDDDD")
                .toString();

        System.out.println(str);


    }

}
