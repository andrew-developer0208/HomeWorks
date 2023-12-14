package ru.geekbrains.jdk.chat.server;

import ru.geekbrains.jdk.chat.client.Client;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ServerDefault implements Server{

    private List<String> messages;
    private List<Client> clients;
    private IOController ioController;
    private File logFile;
    private ServerView view;
    private boolean status;

    /**
     * Constructor
     */
    public ServerDefault(ServerView view) {
        this.view = view;
        clients = new ArrayList<>();
        messages = new ArrayList<>();
        status =false;
        ioController = new IOControllerDefault();
        logFile = new File("./log.txt");
    }

    /**
     * Возвращает историю сообщений
     *
     * @return список сообщений
     */
    @Override
    public List<String> getHistory() {
        return messages;
    }

    /**
     * Получает и обрабатывает сообщение
     *
     * @param message сообщение
     */
    @Override
    public void receiveMessage(String message) {
        broadcastMessage(message);
        view.showOnWindow(message);
        messages.add(message);
        ioController.writeFile(messages, logFile);

    }

    /**
     * Рассылает сообщение всем участникам чата
     * @param message сообщение
     */
    private void broadcastMessage(String message) {
        if (!clients.isEmpty()) {
            clients.forEach(x -> x.answerFromServer(message));
        }
    }

    /**
     * Добавляет к чату клиента
     *
     * @param client Client
     * @return результат операции
     */
    @Override
    public boolean connectUser(Client client) {
        if (status) {
            clients.add(client);
            view.showOnWindow(String.format("Server: %s присоединился к чату", client.getLogin()));
            broadcastMessage(String.format("Server: %s присоединился к чату", client.getLogin()));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Удаляет из чата клиента
     *
     * @param client Client
     */
    @Override
    public void disconnectUser(Client client) {
        clients.remove(client);
    }

    /**
     * Запускает сервер
     */
    @Override
    public void startServer() {
        if (logFile.exists()) {
            loadMessages();
        } else {
            view.showOnWindow("История чата пуста");
        }
        view.showOnWindow("Server: Сервер запущен.");
        status = true;
    }

    /**
     * Останавливает сервер
     */
    @Override
    public void stopServer() {
        broadcastMessage("Server: Сервер остановлен.");

        while (!clients.isEmpty()) {
            clients.get(0).disconnectFromServer();
        }
        status = false;
    }

    /**
     * Проверяет запущен ли сервер
     *
     * @return результат проверки
     */
    @Override
    public boolean status() {
        return status;
    }

    /**
     * Обнавляет чат
     */
    private void loadMessages() {
        messages = ioController.readFile(logFile);
        for (int i = 0; i < messages.size(); i++) {
            view.showOnWindow(messages.get(i));
        }
    }
}
