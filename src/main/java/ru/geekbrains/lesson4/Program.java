package ru.geekbrains.lesson4;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {


        SimpleAccount simpleAccount01 = new SimpleAccount(11223, 500.123);
        System.out.println(simpleAccount01);

        UniversalAccount universalAccount01 = new UniversalAccount(new AccountIdentifier(99112, "BB"), 1000.34);
        System.out.println(universalAccount01);
        System.out.println(((AccountIdentifier)universalAccount01.getId()).getId());

        Account<AccountIdentifier> account01 = new Account<>(new AccountIdentifier(99112, "BB"), 2000.12);
        AccountIdentifier accountIdentifier01 = account01.getId();
        System.out.println(accountIdentifier01);


        Integer[] numbers = {2, 5, 12, -5, 9, 0, 122, 45, 34};

        String[] names = {"Дарья", "Андрей", "Станислав", "Мария", "Сергей"};

        String[] newNames = ArrayUtils.replaceTwoElements(names, 1, 3);

        for (String name : newNames) {
            System.out.println(name);
        }

        System.out.println("\n****\n");

        for (String name : names) {
            System.out.println(name);
        }


        Object[] newNumbers =  ArrayUtils.replaceTwoElementsV2(numbers, 1, 3);
        for (Object number : newNumbers) {
            System.out.println(number);
        }

    }

}
