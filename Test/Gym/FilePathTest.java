package Gym;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class FilePathTest extends MemberList {

    static final Path filePath = Paths.get("Test/Gym/customersTest.txt");
    static final Path visitsFilePath = Paths.get("Test/Gym/customersTest.txt");

}