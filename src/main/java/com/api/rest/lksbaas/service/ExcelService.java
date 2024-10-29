package com.api.rest.lksbaas.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import com.api.rest.lksbaas.model.CondicionFinanciera;
import com.api.rest.lksbaas.model.Credito;
import com.api.rest.lksbaas.model.CreditoFechaCorte;
import com.api.rest.lksbaas.model.DatoVivienda;
import com.api.rest.lksbaas.model.IdentificadorAcreditado;
import com.api.rest.lksbaas.model.IdentificadorCredito;
import com.api.rest.lksbaas.model.IdentificadorInversiones;
import com.api.rest.lksbaas.model.IdentificadorReporte;
import com.api.rest.lksbaas.model.InformacionFinanciera;
import com.api.rest.lksbaas.model.UbicacionGeograficaActividadEconomica;
import com.api.rest.lksbaas.model.VariablesFinancieras;
import org.springframework.stereotype.Service;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ExcelService {

    // Exportar CondicionFinanciera a Excel
    public ByteArrayInputStream exportCondicionFinancieraToExcel(List<CondicionFinanciera> data) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            XSSFSheet sheet = workbook.createSheet("CondicionFinanciera");

            // Crear encabezado
            Row headerRow = sheet.createRow(0);
            String[] columnNames = {"ID", "Monto Pesos", "Monto Moneda Origen", "Fecha Disposicion", "Fecha Vencimiento",
                    "Forma Adquisicion", "Tasa Interes", "Diferencia Tasa", "Operacion Tasa", "Tipo Moneda",
                    "Periodo Pagos Capital", "Periodo Pagos Interes", "Periodo Facturacion", "Comision A Tasa",
                    "Comision A Monto", "Comision D Tasa", "Comision D Monto"};
            for (int i = 0; i < columnNames.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columnNames[i]);
            }

            // Crear filas de datos
            for (int i = 0; i < data.size(); i++) {
                Row row = sheet.createRow(i + 1);
                CondicionFinanciera condicion = data.get(i);
                row.createCell(0).setCellValue(condicion.getId());
                row.createCell(1).setCellValue(condicion.getMontoPesos());
                row.createCell(2).setCellValue(condicion.getMontoMonedaOrigen());
                row.createCell(3).setCellValue(condicion.getFechaDisposicion());
                row.createCell(4).setCellValue(condicion.getFechaVencimiento());
                row.createCell(5).setCellValue(condicion.getFormaAdquisicion());
                row.createCell(6).setCellValue(condicion.getTasaInteres());
                row.createCell(7).setCellValue(condicion.getDiferenciaTasa());
                row.createCell(8).setCellValue(condicion.getOperacionTasa());
                row.createCell(9).setCellValue(condicion.getTipoMoneda());
                row.createCell(10).setCellValue(condicion.getPeriodoPagosCapital());
                row.createCell(11).setCellValue(condicion.getPeriodoPagosInteres());
                row.createCell(12).setCellValue(condicion.getPeriodoFacturacion());
                row.createCell(13).setCellValue(condicion.getComisionATasa());
                row.createCell(14).setCellValue(condicion.getComisionAMonto());
                row.createCell(15).setCellValue(condicion.getComisionDTasa());
                row.createCell(16).setCellValue(condicion.getComisionDMonto());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    // Importar CondicionFinanciera desde Excel
    public List<CondicionFinanciera> importCondicionFinancieraFromExcel(MultipartFile file) throws IOException {
        List<CondicionFinanciera> list = new ArrayList<>();
        try (InputStream is = file.getInputStream(); XSSFWorkbook workbook = new XSSFWorkbook(is)) {
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            // Skip header row
            if (rows.hasNext()) {
                rows.next();
            }

            while (rows.hasNext()) {
                Row row = rows.next();
                CondicionFinanciera condicion = new CondicionFinanciera();
                condicion.setId((int) row.getCell(0).getNumericCellValue());
                condicion.setMontoPesos(row.getCell(1).getNumericCellValue());
                condicion.setMontoMonedaOrigen(row.getCell(2).getNumericCellValue());
                condicion.setFechaDisposicion(row.getCell(3).getStringCellValue());
                condicion.setFechaVencimiento(row.getCell(4).getStringCellValue());
                condicion.setFormaAdquisicion(row.getCell(5).getStringCellValue());
                condicion.setTasaInteres(row.getCell(6).getNumericCellValue());
                condicion.setDiferenciaTasa(row.getCell(7).getNumericCellValue());
                condicion.setOperacionTasa((int) row.getCell(8).getNumericCellValue());
                condicion.setTipoMoneda((int) row.getCell(9).getNumericCellValue());
                condicion.setPeriodoPagosCapital((int) row.getCell(10).getNumericCellValue());
                condicion.setPeriodoPagosInteres((int) row.getCell(11).getNumericCellValue());
                condicion.setPeriodoFacturacion((int) row.getCell(12).getNumericCellValue());
                condicion.setComisionATasa(row.getCell(13).getNumericCellValue());
                condicion.setComisionAMonto(row.getCell(14).getNumericCellValue());
                condicion.setComisionDTasa(row.getCell(15).getNumericCellValue());
                condicion.setComisionDMonto(row.getCell(16).getNumericCellValue());

                list.add(condicion);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("Error reading Excel file", e);
        }
        return list;
    }

    // Exportar CreditoFechaCorte a Excel
    public ByteArrayInputStream exportCreditoFechaCorteToExcel(List<CreditoFechaCorte> data) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            XSSFSheet sheet = workbook.createSheet("CreditoFechaCorte");

            // Crear encabezado
            Row headerRow = sheet.createRow(0);
            String[] columnNames = {"ID", "Fecha Corte", "Monto Insoluto", "Saldo Insoluto", "Pago Amortizacion",
                    "Pago Intereses", "Pago Capital", "Total Pagado"};
            for (int i = 0; i < columnNames.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columnNames[i]);
            }

            // Crear filas de datos
            for (int i = 0; i < data.size(); i++) {
                Row row = sheet.createRow(i + 1);
                CreditoFechaCorte credito = data.get(i);
                row.createCell(0).setCellValue(credito.getId());
                row.createCell(1).setCellValue(credito.getFechaCorte());
                row.createCell(2).setCellValue(credito.getMontoInsoluto());
                row.createCell(3).setCellValue(credito.getSaldoInsoluto());
                row.createCell(4).setCellValue(credito.getPagoAmortizacion());
                row.createCell(5).setCellValue(credito.getPagoIntereses());
                row.createCell(6).setCellValue(credito.getPagoCapital());
                row.createCell(7).setCellValue(credito.getTotalPagado());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    // Importar CreditoFechaCorte desde Excel
    public List<CreditoFechaCorte> importCreditoFechaCorteFromExcel(MultipartFile file) throws IOException {
        List<CreditoFechaCorte> list = new ArrayList<>();
        try (InputStream is = file.getInputStream(); XSSFWorkbook workbook = new XSSFWorkbook(is)) {
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            // Skip header row
            if (rows.hasNext()) {
                rows.next();
            }

            while (rows.hasNext()) {
                Row row = rows.next();
                CreditoFechaCorte credito = new CreditoFechaCorte();
                credito.setId((int) row.getCell(0).getNumericCellValue());
                credito.setFechaCorte(row.getCell(1).getStringCellValue());
                credito.setMontoInsoluto(row.getCell(2).getNumericCellValue());
                credito.setSaldoInsoluto(row.getCell(3).getNumericCellValue());
                credito.setPagoAmortizacion(row.getCell(4).getNumericCellValue());
                credito.setPagoIntereses(row.getCell(5).getNumericCellValue());
                credito.setPagoCapital(row.getCell(6).getNumericCellValue());
                credito.setTotalPagado(row.getCell(7).getNumericCellValue());

                list.add(credito);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("Error reading Excel file", e);
        }
        return list;
    }

    // Exportar DatoVivienda a Excel
    public ByteArrayInputStream exportDatoViviendaToExcel(List<DatoVivienda> data) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            XSSFSheet sheet = workbook.createSheet("DatoVivienda");

            // Crear encabezado
            Row headerRow = sheet.createRow(0);
            String[] columnNames = {"ID", "Valor Vivienda", "Valor Inmueble", "No Avaluo", "Loan"};
            for (int i = 0; i < columnNames.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columnNames[i]);
            }

            // Crear filas de datos
            for (int i = 0; i < data.size(); i++) {
                Row row = sheet.createRow(i + 1);
                DatoVivienda dato = data.get(i);
                row.createCell(0).setCellValue(dato.getId());
                row.createCell(1).setCellValue(dato.getValorVivienda());
                row.createCell(2).setCellValue(dato.getValorInmueble());
                row.createCell(3).setCellValue(dato.getNoAvaluo());
                row.createCell(4).setCellValue(dato.getLoan());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    // Importar DatoVivienda desde Excel
    public List<DatoVivienda> importDatoViviendaFromExcel(MultipartFile file) throws IOException {
        List<DatoVivienda> list = new ArrayList<>();
        try (InputStream is = file.getInputStream(); XSSFWorkbook workbook = new XSSFWorkbook(is)) {
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            // Skip header row
            if (rows.hasNext()) {
                rows.next();
            }

            while (rows.hasNext()) {
                Row row = rows.next();
                DatoVivienda dato = new DatoVivienda();
                dato.setId((int) row.getCell(0).getNumericCellValue());
                dato.setValorVivienda(row.getCell(1).getNumericCellValue());
                dato.setValorInmueble(row.getCell(2).getNumericCellValue());
                dato.setNoAvaluo((int) row.getCell(3).getNumericCellValue());
                dato.setLoan(row.getCell(4).getNumericCellValue());

                list.add(dato);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("Error reading Excel file", e);
        }
        return list;
    }
    
    public ByteArrayInputStream exportIdentificadorAcreditadoToExcel(List<IdentificadorAcreditado> data) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            XSSFSheet sheet = workbook.createSheet("IdentificadorAcreditado");

            // Crear encabezado
            Row headerRow = sheet.createRow(0);
            String[] columnNames = {"No Cliente", "Tipo Cliente", "Nombres", "A Paterno", "A Materno",
                    "P Juridica", "Grupo Riesgo", "Act Economica Acreditado", "Nacionalidad", "Fecha Nacimiento",
                    "RFC", "CURP", "Genero", "Calle", "No Exterior", "Colonia", "CP", "Localidad",
                    "Estado", "Municipio", "Pais", "Tipo Acreditado", "Consultas SIC", "Ingresos", "Tamaño"};
            for (int i = 0; i < columnNames.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columnNames[i]);
            }

            // Crear filas de datos
            for (int i = 0; i < data.size(); i++) {
                Row row = sheet.createRow(i + 1);
                IdentificadorAcreditado identificador = data.get(i);
                row.createCell(0).setCellValue(identificador.getNoCliente());
                row.createCell(1).setCellValue(identificador.getTipoCliente());
                row.createCell(2).setCellValue(identificador.getNombres());
                row.createCell(3).setCellValue(identificador.getaPaterno());
                row.createCell(4).setCellValue(identificador.getaMaterno());
                row.createCell(5).setCellValue(identificador.getpJuridica());
                row.createCell(6).setCellValue(identificador.getGrupoRiesgo());
                row.createCell(7).setCellValue(identificador.getActEconomicaAcreditado());
                row.createCell(8).setCellValue(identificador.getNacionalidad());
                row.createCell(9).setCellValue(identificador.getFechaNacimiento());
                row.createCell(10).setCellValue(identificador.getRfc());
                row.createCell(11).setCellValue(identificador.getCurp());
                row.createCell(12).setCellValue(identificador.getGenero());
                row.createCell(13).setCellValue(identificador.getCalle());
                row.createCell(14).setCellValue(identificador.getNoExterior());
                row.createCell(15).setCellValue(identificador.getColonia());
                row.createCell(16).setCellValue(identificador.getCp());
                row.createCell(17).setCellValue(identificador.getLocalidad());
                row.createCell(18).setCellValue(identificador.getEstado());
                row.createCell(19).setCellValue(identificador.getMunicipio());
                row.createCell(20).setCellValue(identificador.getPais());
                row.createCell(21).setCellValue(identificador.getTipoAcreditado());
                row.createCell(22).setCellValue(identificador.getConsultasSIC() != null ? identificador.getConsultasSIC() : 0);
                row.createCell(23).setCellValue(identificador.getIngresos());
                row.createCell(24).setCellValue(identificador.getTamaño() != null ? identificador.getTamaño() : 0);
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    // Importar IdentificadorAcreditado desde Excel
    public List<IdentificadorAcreditado> importIdentificadorAcreditadoFromExcel(MultipartFile file) throws IOException {
        List<IdentificadorAcreditado> list = new ArrayList<>();
        try (InputStream is = file.getInputStream(); XSSFWorkbook workbook = new XSSFWorkbook(is)) {
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            // Skip header row
            if (rows.hasNext()) {
                rows.next();
            }

            while (rows.hasNext()) {
                Row row = rows.next();
                IdentificadorAcreditado identificador = new IdentificadorAcreditado();
                identificador.setNoCliente(row.getCell(0).getStringCellValue());
                identificador.setTipoCliente((int) row.getCell(1).getNumericCellValue());
                identificador.setNombres(row.getCell(2).getStringCellValue());
                identificador.setaPaterno(row.getCell(3).getStringCellValue());
                identificador.setaMaterno(row.getCell(4).getStringCellValue());
                identificador.setpJuridica((int) row.getCell(5).getNumericCellValue());
                identificador.setGrupoRiesgo(row.getCell(6).getStringCellValue());
                identificador.setActEconomicaAcreditado(row.getCell(7).getStringCellValue());
                identificador.setNacionalidad((int) row.getCell(8).getNumericCellValue());
                identificador.setFechaNacimiento(row.getCell(9).getStringCellValue());
                identificador.setRfc(row.getCell(10).getStringCellValue());
                identificador.setCurp(row.getCell(11).getStringCellValue());
                identificador.setGenero((int) row.getCell(12).getNumericCellValue());
                identificador.setCalle(row.getCell(13).getStringCellValue());
                identificador.setNoExterior(row.getCell(14).getStringCellValue());
                identificador.setColonia(row.getCell(15).getStringCellValue());
                identificador.setCp((int) row.getCell(16).getNumericCellValue());
                identificador.setLocalidad(row.getCell(17).getStringCellValue());
                identificador.setEstado((int) row.getCell(18).getNumericCellValue());
                identificador.setMunicipio((int) row.getCell(19).getNumericCellValue());
                identificador.setPais((int) row.getCell(20).getNumericCellValue());
                identificador.setTipoAcreditado((int) row.getCell(21).getNumericCellValue());
                identificador.setConsultasSIC((int) row.getCell(22).getNumericCellValue());
                identificador.setIngresos((float) row.getCell(23).getNumericCellValue());
                identificador.setTamaño((int) row.getCell(24).getNumericCellValue());

                list.add(identificador);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("Error reading Excel file", e);
        }
        return list;
    }
    
 // Exportar IdentificadorCredito a Excel
    public ByteArrayInputStream exportIdentificadorCreditoToExcel(List<IdentificadorCredito> data) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            XSSFSheet sheet = workbook.createSheet("IdentificadorCredito");

            // Crear encabezado
            Row headerRow = sheet.createRow(0);
            String[] columnNames = {"ID", "IDE Credito", "IDE Linea Credito", "Fecha Otorgamiento", "Tipo Alta",
                    "Tipo Cartera", "Tipo Producto", "Destino Credito", "Clave Sucursal", "No Cuenta",
                    "No Contrato", "Nombre Factorado", "RFC Factorado", "No Cliente"};
            for (int i = 0; i < columnNames.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columnNames[i]);
            }

            // Crear filas de datos
            for (int i = 0; i < data.size(); i++) {
                Row row = sheet.createRow(i + 1);
                IdentificadorCredito identificador = data.get(i);
                row.createCell(0).setCellValue(identificador.getId());
                row.createCell(1).setCellValue(identificador.getIdeCredito());
                row.createCell(2).setCellValue(identificador.getIdeLineaCredito());
                row.createCell(3).setCellValue(identificador.getFechaOtorgamiento());
                row.createCell(4).setCellValue(identificador.getTipoAlta());
                row.createCell(5).setCellValue(identificador.getTipoCartera());
                row.createCell(6).setCellValue(identificador.getTipoProducto());
                row.createCell(7).setCellValue(identificador.getDestinoCredito());
                row.createCell(8).setCellValue(identificador.getClaveSucursal());
                row.createCell(9).setCellValue(identificador.getNoCuenta());
                row.createCell(10).setCellValue(identificador.getNoContrato());
                row.createCell(11).setCellValue(identificador.getNombreFactorado());
                row.createCell(12).setCellValue(identificador.getRfcFactorado());
                row.createCell(13).setCellValue(identificador.getNoCliente());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    // Importar IdentificadorCredito desde Excel
    public List<IdentificadorCredito> importIdentificadorCreditoFromExcel(MultipartFile file) throws IOException {
        List<IdentificadorCredito> list = new ArrayList<>();
        try (InputStream is = file.getInputStream(); XSSFWorkbook workbook = new XSSFWorkbook(is)) {
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            // Skip header row
            if (rows.hasNext()) {
                rows.next();
            }

            while (rows.hasNext()) {
                Row row = rows.next();
                IdentificadorCredito identificador = new IdentificadorCredito();
                identificador.setId((int) row.getCell(0).getNumericCellValue());
                identificador.setIdeCredito(row.getCell(1).getStringCellValue());
                identificador.setIdeLineaCredito(row.getCell(2).getStringCellValue());
                identificador.setFechaOtorgamiento(row.getCell(3).getStringCellValue());
                identificador.setTipoAlta((int) row.getCell(4).getNumericCellValue());
                identificador.setTipoCartera((int) row.getCell(5).getNumericCellValue());
                identificador.setTipoProducto(row.getCell(6).getStringCellValue());
                identificador.setDestinoCredito((int) row.getCell(7).getNumericCellValue());
                identificador.setClaveSucursal(row.getCell(8).getStringCellValue());
                identificador.setNoCuenta(row.getCell(9).getStringCellValue());
                identificador.setNoContrato(row.getCell(10).getStringCellValue());
                identificador.setNombreFactorado(row.getCell(11).getStringCellValue());
                identificador.setRfcFactorado(row.getCell(12).getStringCellValue());
                identificador.setNoCliente(row.getCell(13).getStringCellValue());

                list.add(identificador);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("Error reading Excel file", e);
        }
        return list;
    }
    
    public ByteArrayInputStream exportIdentificadorInversionesToExcel(List<IdentificadorInversiones> data) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            XSSFSheet sheet = workbook.createSheet("IdentificadorInversiones");

            // Crear encabezado
            Row headerRow = sheet.createRow(0);
            String[] columnNames = {"ID", "Entidad Inversion", "Emisora", "Serie", "Tipo Valor",
                    "Forma Adquisicion", "Tipo Inversion", "Tipo Instrumento", "Clasificacion Contable",
                    "Fecha Contratacion", "Fecha Vencimiento"};
            for (int i = 0; i < columnNames.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columnNames[i]);
            }

            // Crear filas de datos
            for (int i = 0; i < data.size(); i++) {
                Row row = sheet.createRow(i + 1);
                IdentificadorInversiones inversion = data.get(i);
                row.createCell(0).setCellValue(inversion.getId());
                row.createCell(1).setCellValue(inversion.getEntidadInversion());
                row.createCell(2).setCellValue(inversion.getEmisora());
                row.createCell(3).setCellValue(inversion.getSerie());
                row.createCell(4).setCellValue(inversion.getTipoValor());
                row.createCell(5).setCellValue(inversion.getFormaAdquisicion());
                row.createCell(6).setCellValue(inversion.getTipoInversion());
                row.createCell(7).setCellValue(inversion.getTipoInstrumento());
                row.createCell(8).setCellValue(inversion.getClasificacionContable());
                row.createCell(9).setCellValue(inversion.getFechaContratacion());
                row.createCell(10).setCellValue(inversion.getFechaVencimiento());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    // Importar IdentificadorInversiones desde Excel
    public List<IdentificadorInversiones> importIdentificadorInversionesFromExcel(MultipartFile file) throws IOException {
        List<IdentificadorInversiones> list = new ArrayList<>();
        try (InputStream is = file.getInputStream(); XSSFWorkbook workbook = new XSSFWorkbook(is)) {
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            // Skip header row
            if (rows.hasNext()) {
                rows.next();
            }

            while (rows.hasNext()) {
                Row row = rows.next();
                IdentificadorInversiones inversion = new IdentificadorInversiones();
                inversion.setId((int) row.getCell(0).getNumericCellValue());
                inversion.setEntidadInversion(row.getCell(1).getStringCellValue());
                inversion.setEmisora(row.getCell(2).getStringCellValue());
                inversion.setSerie(row.getCell(3).getStringCellValue());
                inversion.setTipoValor(row.getCell(4).getStringCellValue());
                inversion.setFormaAdquisicion((int) row.getCell(5).getNumericCellValue());
                inversion.setTipoInversion((int) row.getCell(6).getNumericCellValue());
                inversion.setTipoInstrumento((int) row.getCell(7).getNumericCellValue());
                inversion.setClasificacionContable(row.getCell(8).getStringCellValue());
                inversion.setFechaContratacion(row.getCell(9).getStringCellValue());
                inversion.setFechaVencimiento(row.getCell(10).getStringCellValue());

                list.add(inversion);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("Error reading Excel file", e);
        }
        return list;
    }
    
    
    // Exportar IdentificadorReporte a Excel
    public ByteArrayInputStream exportIdentificadorReporteToExcel(List<IdentificadorReporte> data) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            XSSFSheet sheet = workbook.createSheet("IdentificadorReporte");

            // Crear encabezado
            Row headerRow = sheet.createRow(0);
            String[] columnNames = {"Periodo", "Clave Entidad", "Reporte", "Clave Institucion", 
                                    "Clave Federacion", "Clave Nivel", "Numero Subsidiarias"};
            for (int i = 0; i < columnNames.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columnNames[i]);
            }

            // Crear filas de datos
            for (int i = 0; i < data.size(); i++) {
                Row row = sheet.createRow(i + 1);
                IdentificadorReporte reporte = data.get(i);
                row.createCell(0).setCellValue(reporte.getPeriodo());
                row.createCell(1).setCellValue(reporte.getClaveEntidad());
                row.createCell(2).setCellValue(reporte.getReporte());
                row.createCell(3).setCellValue(reporte.getClaveInstitucion() != null ? String.valueOf(reporte.getClaveInstitucion()) : "");
                row.createCell(4).setCellValue(reporte.getClaveFederacion() != null ? reporte.getClaveFederacion() : 0);
                row.createCell(5).setCellValue(reporte.getClaveNivel() != null ? reporte.getClaveNivel() : 0);
                row.createCell(6).setCellValue(reporte.getNumeroSubsidiarias() != null ? reporte.getNumeroSubsidiarias() : 0);
            }


            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    // Importar IdentificadorReporte desde Excel
    public List<IdentificadorReporte> importIdentificadorReporteFromExcel(MultipartFile file) throws IOException {
        List<IdentificadorReporte> list = new ArrayList<>();
        try (InputStream is = file.getInputStream(); XSSFWorkbook workbook = new XSSFWorkbook(is)) {
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            // Skip header row
            if (rows.hasNext()) {
                rows.next();
            }

            while (rows.hasNext()) {
                Row row = rows.next();
                IdentificadorReporte reporte = new IdentificadorReporte();
                reporte.setPeriodo(row.getCell(0).getStringCellValue());
                reporte.setClaveEntidad(row.getCell(1).getStringCellValue());
                //reporte.setReporte((int) row.getCell(2).getNumericCellValue());
                reporte.setClaveInstitucion(row.getCell(3) != null ? row.getCell(3).getStringCellValue() : null);
                reporte.setClaveFederacion(row.getCell(4) != null ? (int) row.getCell(4).getNumericCellValue() : null);
                reporte.setClaveNivel(row.getCell(5) != null ? (int) row.getCell(5).getNumericCellValue() : null);
                reporte.setNumeroSubsidiarias(row.getCell(6) != null ? (int) row.getCell(6).getNumericCellValue() : null);

                list.add(reporte);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("Error reading Excel file", e);
        }
        return list;
    }
    
    
    // Exportar InformacionFinanciera a Excel
    public ByteArrayInputStream exportInformacionFinancieraToExcel(List<InformacionFinanciera> data) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            XSSFSheet sheet = workbook.createSheet("InformacionFinanciera");

            // Crear encabezado
            Row headerRow = sheet.createRow(0);
            String[] columnNames = {"ID", "Concepto", "Moneda", "Dato", "Reporte", 
                                    "Tipo Cartera", "Tipo Saldo", "Tipo Movimiento", "Descripcion"};
            for (int i = 0; i < columnNames.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columnNames[i]);
            }

            // Crear filas de datos
            for (int i = 0; i < data.size(); i++) {
                Row row = sheet.createRow(i + 1);
                InformacionFinanciera info = data.get(i);
                row.createCell(0).setCellValue(info.getId());
                row.createCell(1).setCellValue(info.getConcepto());
                row.createCell(2).setCellValue(info.getMoneda());
                row.createCell(3).setCellValue(info.getDato());
                row.createCell(4).setCellValue(info.getReporte() != null ? String.valueOf(info.getReporte()) : "");
                row.createCell(5).setCellValue(info.getTipoCartera() != null ? String.valueOf(info.getTipoCartera()) : "");
                row.createCell(6).setCellValue(info.getTipoSaldo() != null ? String.valueOf(info.getTipoSaldo()) : "");
                row.createCell(7).setCellValue(info.getTipoMovimiento() != null ? String.valueOf(info.getTipoMovimiento()) : "");
                row.createCell(8).setCellValue(info.getDescripcion() != null ? info.getDescripcion() : "");
            }


            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    // Importar InformacionFinanciera desde Excel
    public List<InformacionFinanciera> importInformacionFinancieraFromExcel(MultipartFile file) throws IOException {
        List<InformacionFinanciera> list = new ArrayList<>();
        try (InputStream is = file.getInputStream(); XSSFWorkbook workbook = new XSSFWorkbook(is)) {
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            // Skip header row
            if (rows.hasNext()) {
                rows.next();
            }

            while (rows.hasNext()) {
                Row row = rows.next();
                InformacionFinanciera info = new InformacionFinanciera();
                info.setId((int) row.getCell(0).getNumericCellValue());
                info.setConcepto(row.getCell(1).getStringCellValue());
                info.setMoneda((int) row.getCell(2).getNumericCellValue());
                info.setDato(row.getCell(3).getNumericCellValue());
                info.setReporte(row.getCell(4) != null ? (int) row.getCell(4).getNumericCellValue() : null);
                info.setTipoCartera(row.getCell(5) != null ? (int) row.getCell(5).getNumericCellValue() : null);
                info.setTipoSaldo(row.getCell(6) != null ? (int) row.getCell(6).getNumericCellValue() : null);
                info.setTipoMovimiento(row.getCell(7) != null ? (int) row.getCell(7).getNumericCellValue() : null);
                info.setDescripcion(row.getCell(8) != null ? row.getCell(8).getStringCellValue() : null);

                list.add(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("Error reading Excel file", e);
        }
        return list;
    }
    
 // Exportar UbicacionGeograficaActividadEconomica a Excel
    public ByteArrayInputStream exportUbicacionGeograficaToExcel(List<UbicacionGeograficaActividadEconomica> data) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            XSSFSheet sheet = workbook.createSheet("UbicacionGeograficaActividadEconomica");

            // Crear encabezado
            Row headerRow = sheet.createRow(0);
            String[] columnNames = {"ID", "Localidad Destino", "Municipio Destino", "Estado Destino", "Actividad Económica Destino"};
            for (int i = 0; i < columnNames.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columnNames[i]);
            }

            // Crear filas de datos
            for (int i = 0; i < data.size(); i++) {
                Row row = sheet.createRow(i + 1);
                UbicacionGeograficaActividadEconomica ubicacion = data.get(i);
                row.createCell(0).setCellValue(ubicacion.getId());
                row.createCell(1).setCellValue(ubicacion.getLocalidadDestino());
                row.createCell(2).setCellValue(ubicacion.getMunicipioDestino());
                row.createCell(3).setCellValue(ubicacion.getEstadoDestino());
                row.createCell(4).setCellValue(ubicacion.getActEconomicaDestino());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    // Importar UbicacionGeograficaActividadEconomica desde Excel
    public List<UbicacionGeograficaActividadEconomica> importUbicacionGeograficaFromExcel(MultipartFile file) throws IOException {
        List<UbicacionGeograficaActividadEconomica> list = new ArrayList<>();
        try (InputStream is = file.getInputStream(); XSSFWorkbook workbook = new XSSFWorkbook(is)) {
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            // Skip header row
            if (rows.hasNext()) {
                rows.next();
            }

            while (rows.hasNext()) {
                Row row = rows.next();
                UbicacionGeograficaActividadEconomica ubicacion = new UbicacionGeograficaActividadEconomica();
                ubicacion.setId((int) row.getCell(0).getNumericCellValue());
                ubicacion.setLocalidadDestino(row.getCell(1).getStringCellValue());
                ubicacion.setMunicipioDestino((int) row.getCell(2).getNumericCellValue());
                ubicacion.setEstadoDestino((int) row.getCell(3).getNumericCellValue());
                ubicacion.setActEconomicaDestino(row.getCell(4).getStringCellValue());

                list.add(ubicacion);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("Error reading Excel file", e);
        }
        return list;
    }
    
    // Exportar VariablesFinancieras a Excel
    public ByteArrayInputStream exportVariablesFinancierasToExcel(List<VariablesFinancieras> data) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            XSSFSheet sheet = workbook.createSheet("VariablesFinancieras");

            // Crear encabezado
            Row headerRow = sheet.createRow(0);
            String[] columnNames = {"ID", "Número de Título", "Costo Adquisitivo", "Tasa de Interés", "Grupo de Riesgo", "Valoración Directa", "Resultado de Valuación"};
            for (int i = 0; i < columnNames.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columnNames[i]);
            }

            // Crear filas de datos
            for (int i = 0; i < data.size(); i++) {
                Row row = sheet.createRow(i + 1);
                VariablesFinancieras variables = data.get(i);
                row.createCell(0).setCellValue(variables.getId());
                row.createCell(1).setCellValue(variables.getNoTitulo());
                row.createCell(2).setCellValue(variables.getCostoAdquisitivo());
                row.createCell(3).setCellValue(variables.getTasaInt());
                row.createCell(4).setCellValue(variables.getGrupoRiesgo());
                row.createCell(5).setCellValue(variables.getValoracionDirecta());
                row.createCell(6).setCellValue(variables.getResultadoValuacion());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    // Importar VariablesFinancieras desde Excel
    public List<VariablesFinancieras> importVariablesFinancierasFromExcel(MultipartFile file) throws IOException {
        List<VariablesFinancieras> list = new ArrayList<>();
        try (InputStream is = file.getInputStream(); XSSFWorkbook workbook = new XSSFWorkbook(is)) {
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            // Skip header row
            if (rows.hasNext()) {
                rows.next();
            }

            while (rows.hasNext()) {
                Row row = rows.next();
                VariablesFinancieras variables = new VariablesFinancieras();
                variables.setId((int) row.getCell(0).getNumericCellValue());
                variables.setNoTitulo((int) row.getCell(1).getNumericCellValue());
                variables.setCostoAdquisitivo(row.getCell(2).getNumericCellValue());
                variables.setTasaInt(row.getCell(3).getNumericCellValue());
                variables.setGrupoRiesgo((int) row.getCell(4).getNumericCellValue());
                variables.setValoracionDirecta(row.getCell(5).getNumericCellValue());
                variables.setResultadoValuacion(row.getCell(6).getNumericCellValue());

                list.add(variables);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("Error reading Excel file", e);
        }
        return list;
    }

	public ByteArrayInputStream exportUbicacionGeograficaActividadEconomicaToExcel(
			List<UbicacionGeograficaActividadEconomica> data) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UbicacionGeograficaActividadEconomica> importUbicacionGeograficaActividadEconomicaFromExcel(
			MultipartFile file) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Credito> importCreditoFromExcel(MultipartFile file) {
		// TODO Auto-generated method stub
		return null;
	}

	public ByteArrayInputStream exportCreditoToExcel(List<Credito> data) {
		// TODO Auto-generated method stub
		return null;
	}
}
