package com.example.family.utils.config;

import java.io.File;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Word2Pdf {
    private static final Logger LOGGER = LoggerFactory.getLogger(Word2Pdf.class);
    public static void wToPdf(String wordUrl, String pdfUrl) {
        ActiveXComponent app = null;
        LOGGER.info("word转为pdf开始转换：");
        long start = System.currentTimeMillis();
        try {
            // 打开word
            app = new ActiveXComponent("Word.Application");
            // app.setProperty("Visible", false);
            // 获得word中所有打开的文档
            Dispatch documents = app.getProperty("Documents").toDispatch();
            LOGGER.info("打开文件: " + wordUrl);
            // 打开文档
            Dispatch document = Dispatch.call(documents, "Open", wordUrl, false, true).toDispatch();
            // 如果文件存在的话，不会覆盖，会直接报错，所以我们需要判断文件是否存在
            File target = new File(pdfUrl);
            if (target.exists()) {
                target.delete();
            }
            LOGGER.info("另存为: " + pdfUrl);
            // 另存为，将文档报错为pdf，其中word保存为pdf的格式宏的值是17
            Dispatch.call(document, "SaveAs", pdfUrl, 17);
            // 关闭文档
            Dispatch.call(document, "Close", false);
            // 结束时间
            long end = System.currentTimeMillis();
            LOGGER.info("转换成功，用时：" + (end - start) + "ms");
        } catch (Exception e) {
            LOGGER.info("转换失败" + e.getMessage());
        } finally {
        // 关闭office
            app.invoke("Quit", 0);
        }
    }

    //测试转换
    public static void main(String[] args) {
        String wordUrl = "C:\\release\\sites\\upload\\pdf\\template\\马涛.docx";
        String pdfUrl = "C:\\release\\sites\\upload\\pdf\\template\\马涛.pdf";
        wToPdf(wordUrl,pdfUrl);
    }
}