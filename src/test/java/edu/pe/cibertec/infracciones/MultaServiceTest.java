package edu.pe.cibertec.infracciones;

import edu.pe.cibertec.infracciones.exception.InfractorBloqueadoException;
import edu.pe.cibertec.infracciones.model.EstadoMulta;
import edu.pe.cibertec.infracciones.model.Infractor;
import edu.pe.cibertec.infracciones.model.Multa;
import edu.pe.cibertec.infracciones.model.Vehiculo;
import edu.pe.cibertec.infracciones.repository.InfractorRepository;
import edu.pe.cibertec.infracciones.repository.MultaRepository;
import edu.pe.cibertec.infracciones.service.impl.MultaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MultaServiceTest {

    @Mock
    private MultaRepository multaRepository;

    @Mock
    private InfractorRepository infractorRepository;

    @InjectMocks
    private MultaServiceImpl multaService;

    @Test
    void transferirMulta_DebeLanzarExcepcionYNoGuardar_CuandoInfractorBEstaBloqueado() {
        // GIVEN: Escenario Pregunta 4
        Long multaId = 1L;
        Long infractorBId = 2L;

        Multa multa = new Multa();
        multa.setId(multaId);
        multa.setEstado(EstadoMulta.PENDIENTE);

        Infractor infractorB = new Infractor();
        infractorB.setId(infractorBId);
        infractorB.setBloqueado(true);

        when(multaRepository.findById(multaId)).thenReturn(Optional.of(multa));
        when(infractorRepository.findById(infractorBId)).thenReturn(Optional.of(infractorB));
        assertThrows(InfractorBloqueadoException.class, () -> {
            multaService.transferirMulta(multaId, infractorBId);
        });
        verify(multaRepository, never()).save(any(Multa.class));
    }

    @Test
    void transferirMulta_Exito_DebeUsarArgumentCaptor() {
        // GIVEN
        Long multaId = 1L;
        Long infractorBId = 3L;

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setId(10L);

        Multa multa = new Multa();
        multa.setEstado(EstadoMulta.PENDIENTE);
        multa.setVehiculo(vehiculo);

        Infractor infractorB = new Infractor();
        infractorB.setId(infractorBId);
        infractorB.setBloqueado(false);
        // Inicializamos la lista para evitar el NullPointerException
        infractorB.setVehiculos(new ArrayList<>(List.of(vehiculo)));

        when(multaRepository.findById(multaId)).thenReturn(Optional.of(multa));
        when(infractorRepository.findById(infractorBId)).thenReturn(Optional.of(infractorB));

        // WHEN
        multaService.transferirMulta(multaId, infractorBId);

        // THEN: Requisitos Pregunta 4
        ArgumentCaptor<Multa> multaCaptor = ArgumentCaptor.forClass(Multa.class);
        verify(multaRepository, times(1)).save(multaCaptor.capture());

        assertEquals(infractorBId, multaCaptor.getValue().getInfractor().getId());
    }
}