package com.wlazrad.pdf;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;

@Component
public class ECUtils {

    public static void setFileHeader(HttpServletResponse response, String filename, String ext) {
        if (filename == null) {
            filename = "tmp";
        } else {
            filename = filename.replaceAll("\\s", "");
            if (StringUtils.isEmpty(filename)) {
                filename = "tmp";
            }
        }
        response.addHeader("Content-disposition", "attachment; filename=" + filename + "." + ext);
        response.setContentType("application/octet-stream");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
    }

}
