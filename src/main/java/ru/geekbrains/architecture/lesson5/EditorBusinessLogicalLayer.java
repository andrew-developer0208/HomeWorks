package ru.geekbrains.architecture.lesson5;

import java.util.Collection;
import java.util.Random;

/**
 * Business Logical Layer
 * Описываем реализацию конкретных функций проекта
 */
public class EditorBusinessLogicalLayer implements BusinessLogicalLayer {

    private DatabaseAccess databaseAccess;

    public EditorBusinessLogicalLayer(DatabaseAccess databaseAccess){
        this.databaseAccess = databaseAccess;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        return databaseAccess.getAllModels();
    }

    @Override
    public Collection<Texture> getAllTextures() {
        return databaseAccess.getAllTextures();
    }

    @Override
    public void renderModel(Model3D model) {
        processRender(model);
    }

    @Override
    public void renderAllModels() {
        for (Model3D model: getAllModels()) {
            processRender(model);
        }
    }

    /**
     * Adds model
     */
    @Override
    public void addModel() {
        databaseAccess.addEntity(new Model3D());
    }

    /**
     * Removes model
     */
    @Override
    public void removeModel(Model3D model3D) {
        databaseAccess.removeEntity(model3D);

    }

    private Random random = new Random();
    private void processRender(Model3D model){
        try {
            Thread.sleep(2500 - random.nextInt(2000));
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
