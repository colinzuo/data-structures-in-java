import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Preprocess {
    private static final Logger logger = LoggerFactory.getLogger(Preprocess.class);

    private final Pattern p = Pattern.compile("^#include\\s\"(.*)\"$");

    public static void main(String args[]) throws IOException {
        logger.info("Working Directory = {}", System.getProperty("user.dir"));

        Preprocess preprocess = new Preprocess();

        String processedContent = preprocess.preprocess("data/header1.h");

        logger.info("processedContent: \n{}", processedContent);
    }

    public String preprocess(String filePath) throws IOException {
        StringBuilder stringBuffer = new StringBuilder();

        Path path = Paths.get(filePath);

        BufferedReader reader = Files.newBufferedReader(path);
        String line;

        while ((line = reader.readLine()) != null) {
            Matcher matcher = p.matcher(line);
            boolean matchFound = matcher.find();

            if (matchFound) {
                String includedFilePath = matcher.group(1);
                String includedContent = preprocess(includedFilePath);
                stringBuffer.append(includedContent);
                continue;
            }

            stringBuffer.append(line);
            stringBuffer.append("\n");
        }

        return stringBuffer.toString();
    }
}
