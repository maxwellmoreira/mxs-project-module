package com.mxs.project.util;

import com.mxs.project.type.FileType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

/**
 * Class responsible for file manipulation functionalities
 */
public class FileUtil {

    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    /**
     * Reads a file located in the resources directory and returns its content stored in a variable of type String
     *
     * @param file - File located in the resources directory
     * @return File content
     */
    public static String readFile(String file) {
        InputStream inputStream = FileUtil.class.getResourceAsStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        return reader.lines().collect(Collectors.joining("\n"));
    }

    /**
     * Method responsible for creating a file at a specific path
     *
     * @param filePath - Directory where the file will be created
     * @param fileName - Name of the file to be created
     * @param fileFormat - Format of the file to be created
     */
    public static void createFile(String filePath, String fileName, FileType fileFormat) {
        File file = new File(filePath + "/" + fileName + "." + fileFormat.getCode());
        try {
            file.createNewFile();
            logger.info("FileUtil.createFile -> File created successfully! " +
                    "path: {}, name: {}, format: {}",
                    filePath, fileName, fileFormat);
        } catch (IOException e) {
            logger.error("FileUtil.createFile -> Error creating file! " +
                    "path: {}, name: {}, format: {}, cause: {}, message: {}",
                    filePath, fileName, fileFormat, e.getCause(), e.getMessage());
        }
    }
}
