package ru.geekbrains.architecture.lesson5;

import ru.geekbrains.architecture.lesson5.Texture;

import java.util.ArrayList;
import java.util.Collection;

public class Model3D implements Entity {
    private static int counter = 10000;
    private int id;
    private Collection<Texture> textures = new ArrayList<>();

    {
        id = ++counter;
    }

    public Model3D(){

    }

    public Model3D(Collection<Texture> textures){
        this.textures = textures;
    }

    @Override
    public int getId() {
        return id;
    }

    public Collection<Texture> getTextures() {
        return textures;
    }

    @Override
    public String toString() {
        return String.format("Model #%s", id);
    }
}
