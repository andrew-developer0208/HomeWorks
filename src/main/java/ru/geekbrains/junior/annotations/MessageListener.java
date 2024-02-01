package ru.geekbrains.junior.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MessageListener {

    private static final Map<String, Method> COMMANDS = new HashMap<>();
    private static final CommandListener LISTENER = new CommandListener();

    /**
     * Средствами рефлексии заполняем map COMMANDS парами комманда: метод
     * добываемыми из аннотаций к методам класса CommandListener
     */
    static
    {
        for (Method method: LISTENER.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Command.class)) {
                Command command = method.getAnnotation(Command.class);
                COMMANDS.put(command.name(), method);
                for (String alias: command.aliases()) {
                    COMMANDS.put(alias, method);
                }
            }
        }
    }

    /**
     * Принимает строку сообщения
     * @param eventMessage
     */
    public void onMessageReceived(String eventMessage) {
        String message = eventMessage.toLowerCase();
        if (message.startsWith("бот")) {
            try {
                String[] args = message.split(" ");
                String command = args[1];
                String[] nArgs = Arrays.copyOfRange(args, 2,args.length);
                Method method = COMMANDS.get(command);
                if (method == null) {
                    System.out.println("No this command");
                    return;
                }
                Command com = method.getAnnotation(Command.class);
                if (nArgs.length < com.minArgs()) {
                    System.out.println("Мало аргументов");
                }
                else if (nArgs.length > com.maxArgs()) {
                    System.out.println("Много аргументов");
                }

                // выполняем метод, соответствующий переданной комманде
                method.invoke(LISTENER, (Object) nArgs);

            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
