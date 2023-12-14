package ru.geekbrains.architecture.lesson5;

import java.util.Collection;

public interface BusinessLogicalLayer {

    Collection<Model3D> getAllModels();
    Collection<Texture> getAllTextures();
    void renderModel(Model3D model);
    void renderAllModels();

    /**
     * Adds model
     */
    void addModel();

    /**
     * Removes model
     */
    void removeModel(Model3D model3D);


}
