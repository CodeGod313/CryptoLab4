package com.cleverdeadth.cryptolabfourth;

import com.cleverdeadth.cryptolabfourth.fileprocessor.FileProcessor;
import com.cleverdeadth.cryptolabfourth.fileprocessor.impl.FileProcessorImpl;
import com.cleverdeadth.cryptolabfourth.service.HashService;
import com.cleverdeadth.cryptolabfourth.service.impl.HashServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GeneralApplicationTest {

    HashService hashService;
    FileProcessor fileProcessor;
    String inputFilePath;
    String outputFilePath;

    @BeforeAll
    void setUp() {
        hashService = new HashServiceImpl();
        fileProcessor = new FileProcessorImpl();
        inputFilePath = "src/test/resources/input.txt";
        outputFilePath = "src/test/resources/output.txt";
    }

    @Test
    void test() {
        Path path = Paths.get(inputFilePath);
        String message = fileProcessor.readStringFromFile(path).get();
        String hash = hashService.generateHash(message);
        fileProcessor.writeStringToFile(hash, outputFilePath);
        Path path2 = Paths.get(outputFilePath);
        String hashFromOutputFile = fileProcessor.readStringFromFile(path2).get();
        Assertions.assertEquals(hash, hashFromOutputFile);
    }
}
