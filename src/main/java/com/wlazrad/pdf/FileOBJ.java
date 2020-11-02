package com.wlazrad.pdf;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.ByteArrayOutputStream;

@Getter
@Setter
@ToString
public class FileOBJ {
    private String fileName;
    private ByteArrayOutputStream stream;

    public FileOBJ(Long fileName, ByteArrayOutputStream stream) {
        this.fileName = fileName.toString();
        this.stream = stream;
    }

    public FileOBJ(Long fileName, byte[] bytes) {
        this.fileName = fileName.toString();
        this.stream = new ByteArrayOutputStream(bytes.length);
        this.stream.write(bytes, 0, bytes.length);
    }


    public FileOBJ(String fileName, byte[] bytes) {
        this.fileName = fileName;
        this.stream = new ByteArrayOutputStream(bytes.length);
        this.stream.write(bytes, 0, bytes.length);
    }

    public FileOBJ(String fileName, ByteArrayOutputStream stream) {
        this.fileName = fileName;
        this.stream = stream;
    }

    public String getFileName() {
        if (this.fileName != null) {
            return fileName.replaceAll("/", "_").replaceAll("\\s", "");
        } else {
            return "tmp";
        }
    }
}
