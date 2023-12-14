package ru.geekbrains.architecture.lesson6.database;

import ru.geekbrains.architecture.lesson6.notes.infrastructure.persistance.Database;

public class NotesDatabase implements Database {

    private NotesTable notesTable = new NotesTable();

    public NotesTable getNotesTable() {
        return notesTable;
    }

}
