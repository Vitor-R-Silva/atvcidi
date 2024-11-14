package org.example.atvdcicd;

import org.example.atvdcicd.service.CalculadoraService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CalculadoraServiceTest {

    @InjectMocks
    private CalculadoraService calculadoraService;

    @Test
    public void testDivisaoComValorNormal() {
        double resultado = calculadoraService.dividir(10, 2);
        assertEquals(5.0, resultado);
    }

    @Test
    public void testDivisaoPorZero() {
        assertThrows(ResponseStatusException.class, () -> calculadoraService.dividir(10, 0), "Divisão por zero não permitida");
    }
}


