package com.api.rest.lksbaas.controller;

import com.api.rest.lksbaas.model.*;
import com.api.rest.lksbaas.service.ExcelService;
import com.api.rest.lksbaas.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.api.rest.lksbaas.model.Credito;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/excel")
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @Autowired
    private CondicionFinancieraService condicionFinancieraService;

    @Autowired
    private CreditoService creditoService;

    @Autowired
    private IdentificadorAcreditadoService identificadorAcreditadoService;

    @Autowired
    private IdentificadorInversionesService identificadorInversionesService;

    @Autowired
    private IdentificadorReporteService identificadorReporteService;

    @Autowired
    private InformacionFinancieraService informacionFinancieraService;

    @Autowired
    private UbicacionGeograficaActividadEconomicaService ubicacionGeograficaActividadEconomicaService;

    @Autowired
    private VariablesFinancierasService variablesFinancierasService;

    @Autowired
    private CreditoFechaCorteService creditoFechaCorteService;

    // Exportar CondicionFinanciera
    @GetMapping("/condicion-financiera/export")
    public ResponseEntity<byte[]> exportCondicionFinanciera() throws IOException {
        List<CondicionFinanciera> data = condicionFinancieraService.findAll();
        ByteArrayInputStream in = excelService.exportCondicionFinancieraToExcel(data);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=condicion_financiera.xlsx");

        return new ResponseEntity<>(in.readAllBytes(), headers, HttpStatus.OK);
    }

    // Importar CondicionFinanciera
    @PostMapping("/condicion-financiera/import")
    public ResponseEntity<String> importCondicionFinanciera(@RequestParam("file") MultipartFile file) {
        try {
            List<CondicionFinanciera> list = excelService.importCondicionFinancieraFromExcel(file);
            condicionFinancieraService.saveAll(list);
            return ResponseEntity.ok("Importación exitosa");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al importar el archivo");
        }
    }

    // Exportar Credito
    @GetMapping("/credito/export")
    public ResponseEntity<byte[]> exportCredito() throws IOException {
        List<Credito> data = creditoService.findAll();
        ByteArrayInputStream in = excelService.exportCreditoToExcel(data);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=credito.xlsx");

        return new ResponseEntity<>(in.readAllBytes(), headers, HttpStatus.OK);
    }

    // Importar Credito
    @SuppressWarnings("hiding")
	@PostMapping("/credito/import")
    public <Credito> ResponseEntity<String> importCredito(@RequestParam("file") MultipartFile file) throws IOException {
        List<com.api.rest.lksbaas.model.Credito> list = excelService.importCreditoFromExcel(file);
		creditoService.saveAll(list);
		return ResponseEntity.ok("Importación exitosa");
    }

    // Exportar IdentificadorAcreditado
    @GetMapping("/identificador-acreditado/export")
    public ResponseEntity<byte[]> exportIdentificadorAcreditado() throws IOException {
        List<IdentificadorAcreditado> data = identificadorAcreditadoService.findAll();
        ByteArrayInputStream in = excelService.exportIdentificadorAcreditadoToExcel(data);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=identificador_acreditado.xlsx");

        return new ResponseEntity<>(in.readAllBytes(), headers, HttpStatus.OK);
    }

    // Importar IdentificadorAcreditado
    @PostMapping("/identificador-acreditado/import")
    public ResponseEntity<String> importIdentificadorAcreditado(@RequestParam("file") MultipartFile file) {
        try {
            List<IdentificadorAcreditado> list = excelService.importIdentificadorAcreditadoFromExcel(file);
            identificadorAcreditadoService.saveAll(list);
            return ResponseEntity.ok("Importación exitosa");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al importar el archivo");
        }
    }

    // Exportar IdentificadorInversiones
    @GetMapping("/identificador-inversiones/export")
    public ResponseEntity<byte[]> exportIdentificadorInversiones() throws IOException {
        List<IdentificadorInversiones> data = identificadorInversionesService.findAll();
        ByteArrayInputStream in = excelService.exportIdentificadorInversionesToExcel(data);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=identificador_inversiones.xlsx");

        return new ResponseEntity<>(in.readAllBytes(), headers, HttpStatus.OK);
    }

    // Importar IdentificadorInversiones
    @PostMapping("/identificador-inversiones/import")
    public ResponseEntity<String> importIdentificadorInversiones(@RequestParam("file") MultipartFile file) {
        try {
            List<IdentificadorInversiones> list = excelService.importIdentificadorInversionesFromExcel(file);
            identificadorInversionesService.saveAll(list);
            return ResponseEntity.ok("Importación exitosa");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al importar el archivo");
        }
    }

    // Exportar IdentificadorReporte
    @GetMapping("/identificador-reporte/export")
    public ResponseEntity<byte[]> exportIdentificadorReporte() throws IOException {
        List<IdentificadorReporte> data = identificadorReporteService.findAll();
        ByteArrayInputStream in = excelService.exportIdentificadorReporteToExcel(data);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=identificador_reporte.xlsx");

        return new ResponseEntity<>(in.readAllBytes(), headers, HttpStatus.OK);
    }

    // Importar IdentificadorReporte
    @PostMapping("/identificador-reporte/import")
    public ResponseEntity<String> importIdentificadorReporte(@RequestParam("file") MultipartFile file) {
        try {
            List<IdentificadorReporte> list = excelService.importIdentificadorReporteFromExcel(file);
            identificadorReporteService.saveAll(list);
            return ResponseEntity.ok("Importación exitosa");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al importar el archivo");
        }
    }

    // Exportar InformacionFinanciera
    @GetMapping("/informacion-financiera/export")
    public ResponseEntity<byte[]> exportInformacionFinanciera() throws IOException {
        List<InformacionFinanciera> data = informacionFinancieraService.findAll();
        ByteArrayInputStream in = excelService.exportInformacionFinancieraToExcel(data);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=informacion_financiera.xlsx");

        return new ResponseEntity<>(in.readAllBytes(), headers, HttpStatus.OK);
    }

    // Importar InformacionFinanciera
    @PostMapping("/informacion-financiera/import")
    public ResponseEntity<String> importInformacionFinanciera(@RequestParam("file") MultipartFile file) {
        try {
            List<InformacionFinanciera> list = excelService.importInformacionFinancieraFromExcel(file);
            informacionFinancieraService.saveAll(list);
            return ResponseEntity.ok("Importación exitosa");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al importar el archivo");
        }
    }

    // Exportar UbicacionGeograficaActividadEconomica
    @GetMapping("/ubicacion-geografica-actividad-economica/export")
    public ResponseEntity<byte[]> exportUbicacionGeograficaActividadEconomica() throws IOException {
        List<UbicacionGeograficaActividadEconomica> data = ubicacionGeograficaActividadEconomicaService.findAll();
        ByteArrayInputStream in = excelService.exportUbicacionGeograficaActividadEconomicaToExcel(data);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=ubicacion_geografica_actividad_economica.xlsx");

        return new ResponseEntity<>(in.readAllBytes(), headers, HttpStatus.OK);
    }

    // Importar UbicacionGeograficaActividadEconomica
    @PostMapping("/ubicacion-geografica-actividad-economica/import")
    public ResponseEntity<String> importUbicacionGeograficaActividadEconomica(@RequestParam("file") MultipartFile file) {
        List<UbicacionGeograficaActividadEconomica> list = excelService.importUbicacionGeograficaActividadEconomicaFromExcel(file);
		ubicacionGeograficaActividadEconomicaService.saveAll(list);
		return ResponseEntity.ok("Importación exitosa");
    }

    // Exportar VariablesFinancieras
    @GetMapping("/variables-financieras/export")
    public ResponseEntity<byte[]> exportVariablesFinancieras() throws IOException {
        List<VariablesFinancieras> data = variablesFinancierasService.findAll();
        ByteArrayInputStream in = excelService.exportVariablesFinancierasToExcel(data);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=variables_financieras.xlsx");

        return new ResponseEntity<>(in.readAllBytes(), headers, HttpStatus.OK);
    }

    // Importar VariablesFinancieras
    @PostMapping("/variables-financieras/import")
    public ResponseEntity<String> importVariablesFinancieras(@RequestParam("file") MultipartFile file) {
        try {
            List<VariablesFinancieras> list = excelService.importVariablesFinancierasFromExcel(file);
            variablesFinancierasService.saveAll(list);
            return ResponseEntity.ok("Importación exitosa");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al importar el archivo");
        }
    }

    // Exportar CreditoFechaCorte
    @GetMapping("/credito-fecha-corte/export")
    public ResponseEntity<byte[]> exportCreditoFechaCorte() throws IOException {
        List<CreditoFechaCorte> data = creditoFechaCorteService.findAll();
        ByteArrayInputStream in = excelService.exportCreditoFechaCorteToExcel(data);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=credito_fecha_corte.xlsx");

        return new ResponseEntity<>(in.readAllBytes(), headers, HttpStatus.OK);
    }

    // Importar CreditoFechaCorte
    @PostMapping("/credito-fecha-corte/import")
    public ResponseEntity<String> importCreditoFechaCorte(@RequestParam("file") MultipartFile file) {
        try {
            List<CreditoFechaCorte> list = excelService.importCreditoFechaCorteFromExcel(file);
            creditoFechaCorteService.saveAll(list);
            return ResponseEntity.ok("Importación exitosa");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al importar el archivo");
        }
    }
}
