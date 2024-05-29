package br.com.arcelino.api.cepservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import br.com.arcelino.api.cepservice.viacep.ViaCepClient;
import br.com.arcelino.api.cepservice.viacep.api.Endereco;
import br.com.arcelino.api.cepservice.viacep.client.ViaCepRequest;

public class ViaCepControllerTest {

    private ViaCepRequest viaCepRequest;
    private ViaCepClient viaCepClient;
    private ViaCepController viaCepController;

    @BeforeEach
    void setUp() {
        viaCepRequest = mock(ViaCepRequest.class);
        viaCepClient = new ViaCepClient(viaCepRequest);
        viaCepController = new ViaCepController(viaCepClient);
    }

    @Test
    void consultaCep_ValidCep_ReturnsEndereco() {
        var cep = "12345678";
        var endereco = Endereco.builder().cep(cep).build();
        when(viaCepClient.viaCepRequest().consultaCep(cep)).thenReturn(endereco);

        var response = viaCepController.consultaCep(cep);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(endereco, response.getBody());
    }

    @Test
    void consultaCep_InvalidCep_ReturnsNotFound() {
        var cep = "invalid";
        when(viaCepClient.viaCepRequest().consultaCep(cep)).thenReturn(null);

        var response = viaCepController.consultaCep(cep);

        assertEquals(null, response.getBody());
    }
}
