package com.mahaswami.nativejasper;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRCsvDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import java.io.File;
import java.util.HashMap;

public class ReportGenerator {
    public void generatePdfReport() throws JRException {
        var xmlFile = "src/main/resources/report.xml";
        var report = JasperCompileManager.compileReport(xmlFile);
    /*    File jasperFile = new File("src/main/resources/reports.jasper");
        JasperReport report = (JasperReport) JRLoader.loadObject(jasperFile);
*/
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
