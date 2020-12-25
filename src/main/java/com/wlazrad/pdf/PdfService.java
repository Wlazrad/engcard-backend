package com.wlazrad.pdf;

import com.itextpdf.text.DocumentException;
import com.wlazrad.word.Word;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class PdfService {


    private final TemplateEngine templateEngine;

    public PdfService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public ByteArrayOutputStream generateFile(CardPdfParameters cardPdfParameters) {
        try {
            return generate(cardPdfParameters);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + "lala");
            throw new CustomException("404", "pdf error");
        }
    }

    private ByteArrayOutputStream generate(CardPdfParameters cardPdfParameters) {
        try {

            Locale locale = Locale.forLanguageTag("PL");
            Context ctx = new Context(locale);

            List<Word> wordList = new ArrayList<>();

            Word word1 = new Word();
            word1.setPartOne("radek");
            word1.setArticulation("lala");
            wordList.add(word1);

            ctx.setVariable("model", cardPdfParameters);
            ctx.setVariable("list", wordList);
            ctx.setVariable("copy", false);

            ByteArrayOutputStream os = new ByteArrayOutputStream();

            ITextRenderer renderer = new ITextRenderer();

            renderer.setDocumentFromString(templateEngine.process("wordCard.html", ctx));
            renderer.layout();
            renderer.createPDF(os, false);
            renderer.finishPDF();

            return os;

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            throw new CustomException("303", "pdf errors");
        }
    }


    @Transactional(readOnly = true)
    public FileOBJ previewFile(CardPdfParameters cardPdfParameters) {
        return new FileOBJ("2", generateFile(cardPdfParameters));
    }
}
