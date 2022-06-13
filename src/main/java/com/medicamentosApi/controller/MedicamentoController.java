package com.medicamentosApi.controller;

import com.medicamentosApi.service.MedicamentoService;
import org.springframework.web.bind.annotation.*;

@RestController
public class MedicamentoController {

    private MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoDaoH2(new ConfiguracionJDBC()));

@PostMapping("registrar")
    public Medicamento guardar(@RequestBody Medicamento medicamento) {
        return null;
    }
@GetMapping("/{id}")
    public Medicamento buscar(@PathVariable("id") Integer int) {
        return medicamentosService.buscar(id);
    }
}
