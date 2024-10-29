package com.api.rest.lksbaas.util;

import com.api.rest.lksbaas.model.Credito;
import com.api.rest.lksbaas.model.IdentificadorAcreditado;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelHelper {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "ID", "TipoCredito", "MontoOriginal", "SaldoActual", "TasaInteres", "IdAcreditado" };
    static String SHEET = "Creditos";

    public static boolean hasExcelFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }

    public static ByteArrayInputStream creditosToExcel(List<Credito> creditos) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            XSSFSheet sheet = workbook.createSheet(SHEET);

            // Crear encabezado
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < HEADERs.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(HEADERs[i]);
            }

            // Crear filas de datos
            int rowIdx = 1;
            for (Credito credito : creditos) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(credito.getId());
                row.createCell(1).setCellValue(credito.getTipoCredito());
                row.createCell(2).setCellValue(credito.getMontoOriginal());
                row.createCell(3).setCellValue(credito.getSaldoActual());
                row.createCell(4).setCellValue(credito.getTasaInteres());
                row.createCell(5).setCellValue(credito.getAcreditado().getId());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    public static List<Credito> excelToCreditos(InputStream is) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook(is)) {
            XSSFSheet sheet = workbook.getSheet(SHEET);
            List<Credito> creditos = new ArrayList<>();

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                Credito credito = new Credito();
                credito.setId((int) row.getCell(0).getNumericCellValue());
                credito.setTipoCredito(row.getCell(1).getStringCellValue());
                credito.setMontoOriginal(row.getCell(2).getNumericCellValue());
                credito.setSaldoActual(row.getCell(3).getNumericCellValue());
                credito.setTasaInteres(row.getCell(4).getNumericCellValue());

                // Aquí necesitarías cargar el objeto IdentificadorAcreditado según el ID
                // Esto es solo un ejemplo
                IdentificadorAcreditado acreditado = new IdentificadorAcreditado();
                acreditado.setId((int) row.getCell(5).getNumericCellValue());
                credito.setAcreditado(acreditado);

                creditos.add(credito);
            }

            return creditos;
        }
    }
}
