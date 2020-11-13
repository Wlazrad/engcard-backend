package com.wlazrad.txt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class ReadFile {

    @Autowired
    ResourceLoader resourceLoader;

    public List<String> main() {
        try {
            Resource resource = loadFile("/textfiles/nounSortedList.txt");
            String filename = resource.getFilename();
            InputStream inputStream = resource.getInputStream();

            Scanner myReader = new Scanner(inputStream, StandardCharsets.UTF_8.name());
            List<String> wordList = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                wordList.add(data);
            }
            myReader.close();
            return wordList;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Resource loadFile(String path) {
        return resourceLoader.getResource(
                "classpath:" + path);
    }

    private class TextFile {
        private String name;
        private String content;

        public TextFile(String name, String content) {
            this.name = name;
            this.content = content;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
