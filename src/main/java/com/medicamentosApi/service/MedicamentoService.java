package com.medicamentosApi.service;

public class MedicamentoService {

    private Idao<Medicamento> medicamentoDao;

    public MedicamentoService(Idao<Medicamento> medicamentoDao) {
        this.medicamentoDao = medicamentoDao;
    }

    public Medicamento guardar(Medicamento medicamento) {
        return medicamentoDao.guardar(medicamento);
    }

    public Medicamento buscar(Integer id) {
        return medicamenti.buscar(id);
    }
}
