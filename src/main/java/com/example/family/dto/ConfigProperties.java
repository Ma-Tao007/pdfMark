package com.example.family.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author badado
 * @version 1.0
 * @see
 **/
@Component
@ConfigurationProperties(prefix = ConfigProperties.PREFIX)
public class ConfigProperties {
    public static  final String PREFIX = "ws";

    private String pdfloadPath;

    public String getPdfloadPath() {
        return pdfloadPath;
    }

    public void setPdfloadPath(String pdfloadPath) {
        this.pdfloadPath = pdfloadPath;
    }


}