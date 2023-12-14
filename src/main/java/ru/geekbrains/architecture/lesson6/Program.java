package ru.geekbrains.architecture.lesson6;

import ru.geekbrains.architecture.lesson6.database.NotesDatabase;
import ru.geekbrains.architecture.lesson6.notes.application.ConcreteNoteEditor;
import ru.geekbrains.architecture.lesson6.notes.infrastructure.persistance.DatabaseContext;
import ru.geekbrains.architecture.lesson6.notes.presentation.queries.controllers.NotesController;
import ru.geekbrains.architecture.lesson6.notes.presentation.queries.views.NotesConsolePresenter;

public class Program {

    public static void main(String[] args) {
        NotesController notesController = new NotesController(new ConcreteNoteEditor(new NotesConsolePresenter(), new DatabaseContext(new NotesDatabase())));
        notesController.routeGetAll();
    }

}
