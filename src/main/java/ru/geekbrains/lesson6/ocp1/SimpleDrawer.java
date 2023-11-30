package ru.geekbrains.lesson6.ocp1;

public class SimpleDrawer {

    public void draw(Shape shape){
        switch (shape.getType()){
            case Circle ->
                drawCircle(shape);
            case Square ->
                drawSquare(shape);
            case Triangle ->
                drawTriangle(shape);
        }
    }


    private void drawSquare(Shape shape){
        //..
    }

    private void drawCircle(Shape shape){
        //..
    }

    private void drawTriangle(Shape shape){
        // ...
    }

}
