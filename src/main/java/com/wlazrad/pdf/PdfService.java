package com.wlazrad.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.wlazrad.word.Word;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

@Service
public class PdfService {


    private final TemplateEngine templateEngine;

    public PdfService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public ByteArrayOutputStream generateFile(List<Word> word) {
        try {
            return generate(word);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("404", "pdf error");
        }
    }

    private ByteArrayOutputStream generate(List<Word> word) {
        try {
            Locale locale = Locale.forLanguageTag("PL");
            Context ctx = new Context(locale);

            ctx.setVariable("model", word);
            ctx.setVariable("copy", false);

            ByteArrayOutputStream os = new ByteArrayOutputStream();

            ITextRenderer renderer = new ITextRenderer();
            renderer.getFontResolver().addFont("fonts/times.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            renderer.getFontResolver().addFont("fonts/timesbd.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            renderer.getFontResolver().addFont("fonts/timesbi.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            renderer.getFontResolver().addFont("fonts/timesi.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

            renderer.setDocumentFromString(templateEngine.process("templates/wordCard.html", ctx));
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
    public FileOBJ previewFile(List<Word> wordList) {
        return new FileOBJ("2", generateFile(wordList));
    }

}
