package ru.geekbrains.architecture.lesson5;

public interface UILayer {

    void openProject(String fileName);
    void showProjectSettings();

    void saveProject();

    void printAllModels();

    void printAllTextures();

    void renderAll();
    void renderModel(int i);

    /**
     * Adds 3D-model to dataBase
     */
    void addModel();

    /**
     * Removes 3D-model from dataBase
     * @param i model index
     */
    void removeModel(int i);

}
