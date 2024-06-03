package br.com.arcelino.api.cepservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arcelino.api.cepservice.viacep.ViaCepClient;
import br.com.arcelino.api.cepservice.viacep.api.Endereco;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/viacep")
@RequiredArgsConstructor
public class ViaCepController {

    private final ViaCepClient viaCepClient;

    @GetMapping("/{cep}")
    public ResponseEntity<Endereco> consultaCep(@PathVariable String cep) {
        return ResponseEntity.ok(viaCepClient.viaCepRequest().consultaCep(cep
    }
}
