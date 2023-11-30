package ru.geekbrains.lesson6.srp2.view;

import ru.geekbrains.lesson6.srp2.presenter.Model;
import ru.geekbrains.lesson6.srp2.presenter.View;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OrderView implements View {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void inputFromConsole(Model order) {
        order.setClientName(prompt("Имя клиента: "));
        order.setProduct(prompt("Продукт: "));
        order.setQnt(Integer.parseInt(prompt("Кол-во: ")));
        order.setPrice(Integer.parseInt(prompt("Цена: ")));

    }

    @Override
    public void saveToJson(Model order) {
        String fileName = "order.json";
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("{\n");
            writer.write("\"clientName\":\""+ order.getClientName() + "\",\n");
            writer.write("\"product\":\""+order.getProduct()+"\",\n");
            writer.write("\"qnt\":"+order.getQnt()+",\n");
            writer.write("\"price\":"+order.getPrice()+"\n");
            writer.write("}\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    /**
     * Gets String from console
     * @param message request message
     * @return String input
     */
    private String prompt(String message){
        System.out.println(message);
        return scanner.nextLine();
    }

}
