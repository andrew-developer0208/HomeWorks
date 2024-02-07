package ru.geekbrains.junior.ionio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Чтение файла через отображение в буфер
 */
public class MappedChannelRead {
    public static void main(String[] args) {

        // получить канал к файлу
        try (FileChannel channel = (FileChannel)
                Files.newByteChannel(Paths.get("test.txt"))) {

            long fSize = channel.size();

            // отобразить файл в буфер
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, fSize);

            for (int i = 0; i < fSize; i++) System.out.print((char) buffer.get());

//            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
