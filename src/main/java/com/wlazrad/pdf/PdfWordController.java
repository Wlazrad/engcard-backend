package com.wlazrad.pdf;

import com.wlazrad.word.Word;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class PdfWordController {

    private final PdfService pdfService;


    @GetMapping(value = "/pdf/download/")
    public void downloadWordPDF(HttpServletResponse response, @PathVariable(name = "invoiceId") Long invoiceId){
        List<Word> wordList = new ArrayList<>();
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
