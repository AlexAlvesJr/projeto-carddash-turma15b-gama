package br.fullstacks.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fullstacks.spring.model.AgFinanceiro;
import br.fullstacks.spring.repository.AgFinanceiroRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/agente")
public class AgFinanceiroController {
    
    @Autowired
    private AgFinanceiroRepo repo;

    @GetMapping("/top10")
    public ResponseEntity<List<AgFinanceiro>> listarAgFinanceiroTop10() {
        List<AgFinanceiro> lista = (List<AgFinanceiro>) repo.findTop10ByOrderByVolumeTransacionalDesc();

        return ResponseEntity.ok(lista);
    }

}
