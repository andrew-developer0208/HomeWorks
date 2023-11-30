package ru.geekbrains.lesson4.bank;

public class Program {

    public static void main(String[] args) {

        DebetAccount<Entity> entityDebetAccount1 =
                new DebetAccount<>(new Entity("ООО Рога и копыта", "2223"), 50000);
        CreditAccount<Person> personCreditAccount1 =
                new CreditAccount<>(new Person("Иванов А. C.", "444332"), 300.15);

        Transaction<Account<?>> transaction = new Transaction<>(entityDebetAccount1, personCreditAccount1, 26000);
        transaction.execute();
        transaction.execute();

    }

}
