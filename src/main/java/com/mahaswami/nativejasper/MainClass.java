package com.mahaswami.nativejasper;

import net.sf.jasperreports.engine.JRException;

public class MainClass {

    public static void main(String[] args) {
        System.out.println("Generating Report");
        ReportGenerator reportGenerator = new ReportGenerator();
        try {
            reportGenerator.generatePdfReport();
        }
        catch(JRException JRex){
            System.out.println("Exception generating report");
            System.out.println(JRex.getMessage());
        }
    }
}
