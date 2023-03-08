package com.calpyte.livabl.controller;

import com.calpyte.livabl.dto.ExcelDTO;
import com.calpyte.livabl.service.CombustionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private CombustionService combustionService;

    @PostMapping("/excel")
    private ResponseEntity<?> downloadExcel(@RequestBody ExcelDTO exportDTO) throws IOException{
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
        headers.add("Content-Disposition", "attachment; filename=" + exportDTO.getName() +"_"+".xls");
        ByteArrayInputStream byteArrayInputStream = combustionService.downloadExcel(exportDTO);
        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(byteArrayInputStream));
    }
}
