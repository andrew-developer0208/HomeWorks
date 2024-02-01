package ru.geekbrains.junior.annotations;

import java.lang.reflect.Method;

public class CommandListener {

    @Command(name = "привет",
             args = "",
             desc = "Будь культурным, поздоровайся",
             showInHelp = false,
             aliases = {"здаров", "hello"})
    public void hello(String[] args) {
        System.out.println("from hello");
    }

    @Command(name = "пока",
            args = "",
            desc = "Будучи культурным, бот прощается",
            aliases = {"удачи", "bye"})
    public void bye(String[] args)
    {
        System.out.println("From bye");
    }

    @Command(name = "помощь",
            args = "",
            desc = "Выводит список команд",
            aliases = {"help", "команды"})
    public void help(String[] args)
    {
        StringBuilder sb = new StringBuilder("Список команд: \n");
        for (Method m : this.getClass().getDeclaredMethods())
        {
            if (m.isAnnotationPresent(Command.class))
            {
                Command com = m.getAnnotation(Command.class);
                if (com.showInHelp()) //Если нужно показывать команду в списке.
                {
                    sb.append("Бот, ")
                            .append(com.name()).append(" ")
                            .append(com.args()).append(" - ")
                            .append(com.desc()).append("\n");
                }
            }
        }
        System.out.println("Справочная информация:");
        System.out.println(sb);

    }


}
