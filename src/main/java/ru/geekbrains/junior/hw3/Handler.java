package ru.geekbrains.junior.hw3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class Handler {
    private static final File FILE_JSON = new File("junior_hw3.json");
    private static final File FILE_BIN = new File("junior_hw3.bin");
    private static final File FILE_XML = new File("junior_hw3.xml");
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    /**
     * Сериализует объект в бинарный файл
     * @param object
     */
    public static void serialToBin(Object object) {

            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_BIN))) {
                outputStream.writeObject(object);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    /**
     * Десериализует объект из бинарного файла
     * @return
     */
    public static Student deSerialFromBin() {
        Student student = null;
        if (FILE_BIN.exists() && !FILE_BIN.isDirectory()) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_BIN))) {
                student = (Student) inputStream.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File not found!");
        }
        return student;
    }

    /**
     * Сериализует объект в json файл
     * @param object
     */
    public static void serialToJson(Object object) {
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        try {
            objectMapper.writeValue(FILE_JSON, object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Десериализует объект из json файла
     * @return
     */
    public static Student deSerialFromJson() {
        Student student = null;
        if (FILE_JSON.exists() && !FILE_JSON.isDirectory()) {
            try {
                student = objectMapper.readValue(FILE_JSON, objectMapper.getTypeFactory().constructType(Student.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File not found");
        }

        return student;
    }
    /**
     * Сериализует объект в xml файл
     * @param object
     */
    public static void serialToXml(Object object) {
        xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        try {
            xmlMapper.writeValue(FILE_XML, object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Десериализует объект из xml файла
     * @return
     */
    public static Student deSerialFromXml() {
        Student student = null;
        if (FILE_XML.exists() && !FILE_XML.isDirectory()) {
            try {
                student = xmlMapper.readValue(FILE_XML, xmlMapper.getTypeFactory().constructType(Student.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File not found");
        }

        return student;
    }

}
