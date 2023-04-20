package br.com.arcelino.api.cepservice.viacep;

import org.springframework.stereotype.Service;

import br.com.arcelino.api.cepservice.viacep.client.ViaCepRequest;

@Service
public record ViaCepClient(ViaCepRequest viaCepRequest) {
}