package exceptions.homework3;

import java.util.LinkedList;

public class Parser implements LineParser{
    /**
     * Parses input line
     *
     * @param line String
     * @return String formatted line
     */
    @Override
    public String parseLine(String line) throws IncorrectInputException {
        StringBuilder result = new StringBuilder();
        String gender = null;
        String birthDate = null;
        String phone = null;
        StringBuilder loger = new StringBuilder();
        LinkedList<String> fio = new LinkedList<>();
        String[] array = line.split(" ");

        for (String element: array) {
            if (element.matches("[0-9]*")) {
                phone = element;
            } else if (element.equals("f") || element.equals("m")) {
                gender = element;
            } else if (element.matches("[0-9][0-9]\\.[0-9][0-9]\\.[0-9][0-9][0-9][0-9]")) {
                birthDate = element;
            } else if (element.matches("[a-zA-Zа-яА-Я]*")) {
                fio.add(element);
            } else {
                throw new IncorrectInputException("Ошибка! Данные содержат недопустимые символы");
            }
        }

        if (gender == null) loger.append("Нет пола ");
        if (birthDate == null) loger.append("Нет даты рождения ");
        if (phone == null) loger.append("Нет телефона ");
        if (fio.size() < 3) loger.append("ФИО неполные данные ");

        if (loger.length() > 0) {
            throw new IncorrectInputException(String.format("Ошибка! %s", loger.toString()));
        }

        fio.forEach(x -> result.append(String.format("<%s>", x)));
        result.append(String.format("<%s>", birthDate));
        result.append(String.format("<%s>", phone));
        result.append(String.format("<%s>", gender));

        return result.toString();
    }

    /**
     * Checks the equal of the number of arguments to the standard
     * @param line input line
     * @param standard correct array size from input line
     * @return -1 if array.length < standard;
     * 0 if array.length > standard;
     * standard if array.length == standard
     */
    @Override
    public int checkLine(String line, int standard) {
        String[] array = line.split(" ");
        if (array.length < standard) return -1;
        if (array.length > standard) return 0;
        return standard;
    }
}
