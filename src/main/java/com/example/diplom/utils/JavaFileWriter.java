package com.example.diplom.utils;

import com.example.diplom.models.WebElement;

import java.io.File;
import java.nio.file.Files;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JavaFileWriter {

    private static final String FILE_TYPE = ".java";
    private static final String OUTPUT_FILES_DIRECTORY = "./output";
    private static final String OUTPUT_MODELS_DIRECTORY = "./output/models";
    private static final String OUTPUT_PAGES_DIRECTORY = "./output/pages";
    private static final String OUTPUT_HELPERS_DIRECTORY = "./output/helpers";
    private static final String OUTPUT_TESTS_DIRECTORY = "./output/tests";


    public void writeJavaCodeToJavaFile(String fileData,String fileName, String directory) throws IOException {
        createDirectoryForOutputFiles();
        System.out.println(chooseDirectoryToWrite(directory)+fileName+FILE_TYPE);
        FileOutputStream fos = new FileOutputStream(chooseDirectoryToWrite(directory)+fileName+FILE_TYPE);
        fos.write(fileData.getBytes());
        fos.flush();
        fos.close();
    }

    private void createDirectoryForOutputFiles() throws IOException {
        String fileName = OUTPUT_FILES_DIRECTORY;

        String fileModels= OUTPUT_MODELS_DIRECTORY;
        String filePages= OUTPUT_PAGES_DIRECTORY;
        String fileHelpers = OUTPUT_HELPERS_DIRECTORY;
        String fileTests = OUTPUT_TESTS_DIRECTORY;

        Path path = Paths.get(fileName);
        Path modelPath = Paths.get(fileModels);
        Path pagePath = Paths.get(filePages);
        Path helperPath = Paths.get(fileHelpers);
        Path testPath = Paths.get(fileTests);

        if (!Files.exists(modelPath))
            Files.createDirectories(modelPath);

        if (!Files.exists(pagePath))
            Files.createDirectories(pagePath);

        if (!Files.exists(helperPath))
            Files.createDirectories(helperPath);

        if (!Files.exists(testPath))
            Files.createDirectories(testPath);

        if (!Files.exists(path)) {
            Files.createDirectory(path);

            if (!Files.exists(modelPath))
                Files.createDirectories(modelPath);

            if (!Files.exists(pagePath))
                Files.createDirectories(pagePath);

            if (!Files.exists(helperPath))
                Files.createDirectories(helperPath);

            if (!Files.exists(testPath))
                Files.createDirectories(testPath);

            System.out.println("New Directory created !   " + fileName);
        } else {
            System.out.println("Directory already exists");
        }
    }

    private String chooseDirectoryToWrite(String directory) throws IOException {

        String finalDirectory;
            switch (directory) {
                case "models":
                    finalDirectory = OUTPUT_MODELS_DIRECTORY;
                    break;
                case "root":
                    finalDirectory = OUTPUT_FILES_DIRECTORY;
                    break;
                case "pages":
                    finalDirectory=OUTPUT_PAGES_DIRECTORY;
                    break;
                case "helpers":
                    finalDirectory=OUTPUT_HELPERS_DIRECTORY;
                    break;
                case "tests":
                    finalDirectory=OUTPUT_TESTS_DIRECTORY;
                    break;
                default:
                    finalDirectory=OUTPUT_FILES_DIRECTORY;
                    break;
            }
            finalDirectory=finalDirectory+"/";
            return finalDirectory;
        }

}
