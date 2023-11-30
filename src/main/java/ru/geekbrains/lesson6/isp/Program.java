package ru.geekbrains.lesson6.isp;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        List<PaymentService> paymentServices = new ArrayList<>();
        paymentServices.add(new TerminalPaymentService());
        paymentServices.add(new InternetPaymentService());

        for (PaymentService paymentService : paymentServices){
            if (paymentService instanceof PhonePayable)
                ((PhonePayable)paymentService).payPhoneNumber(300);
            break;
        }

    }

}
