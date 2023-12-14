package ru.geekbrains.architecture.lesson6.notes.application.interfaces;

import ru.geekbrains.architecture.lesson6.notes.domain.Note;

public interface NoteEditor extends Editor<Note, Integer> {

    void printAll();

}
