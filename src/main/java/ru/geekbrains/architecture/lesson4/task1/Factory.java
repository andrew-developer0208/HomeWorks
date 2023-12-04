package ru.geekbrains.architecture.lesson4.task1;

/**
 * Фабрика
 */
public interface Factory {

    /**
     * Метод получения информации о детали
     * @param id идентификатор детали
     * @return информация о детали
     */
    ComponentInfo getComponentInfo(int id);

}
