package com.mahaswami.nativejasper;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRCsvDataSource;

import java.util.HashMap;

public class ReportGenerator {
    public void generatePdfReport() throws JRException {
        var xmlFile = "report.xml";
        var report = JasperCompileManager.compileReport(xmlFile);

        var columnNames = new String[]{"Id", "Name", "Price"};

        var fileName = "cars.csv";
        var ds = new JRCsvDataSource(fileName);
        ds.setColumnNames(columnNames);

        var params = new HashMap<String, Object>();
        var jasperPrint = JasperFillManager.fillReport(report,
                params, ds);

        JasperExportManager.exportReportToPdfFile(jasperPrint,
                "CarReport.pdf");
    }
}
