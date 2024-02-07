package ru.geekbrains.junior.ionio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Чтение файла через канал
 */
public class ExplicitChannelRead {
    public static void main(String[] args) {
        int count;
        Path filePath = null;

        // получить путь к файлу
        try {
            filePath = Paths.get("test.txt");
        } catch (InvalidPathException e) {
            System.out.println(e.getMessage());
            return;
        }

        // получить канал к этому файлу
        try (SeekableByteChannel channel = Files.newByteChannel(filePath)) {

            // выделить память под буфер
            ByteBuffer buffer = ByteBuffer.allocate(128);

            do {
                count = channel.read(buffer);

                if (count != -1) {
                    buffer.rewind();

                    for (int i = 0; i < count; i++) {
                        System.out.print((char) buffer.get());
                    }
                }
            }
            while (count != -1);
//            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
