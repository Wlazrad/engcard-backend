package com.wlazrad.pdf;

import com.wlazrad.word.Word;
import com.wlazrad.word.WordService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class PdfWordController {

    private final PdfService pdfService;
    private final WordService wordService;


    @GetMapping(value = "/pdf/download/")
    public void downloadWordPDF(HttpServletResponse response) {

        List<Word> wordList = wordService.returnAllWords();
        FileOBJ fileOBJ = pdfService.previewFile(wordList);
        setHeader(response, fileOBJ.getFileName());
        writeFile(response, fileOBJ);
    }

    private void writeFile(HttpServletResponse response, FileOBJ fileOBJ) {
        try {
            IOUtils.write(fileOBJ.getStream().toByteArray(), response.getOutputStream());
            response.flushBuffer();

        } catch (IOException e) {
            e.printStackTrace();
            throw new CustomException(e.getMessage());
        }
    }

    private static void setHeader(HttpServletResponse response, String filename) {
        ECUtils.setFileHeader(response, filename, "pdf");
    }
}
