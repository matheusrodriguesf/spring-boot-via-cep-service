package br.com.arcelino.api.cepservice.viacep.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.arcelino.api.cepservice.viacep.api.Endereco;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepRequest {

    @GetMapping("/{cep}/json")
    Endereco consultaCep(@PathVariable String cep);
}
