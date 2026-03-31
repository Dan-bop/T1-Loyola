package edu.pe.cibertec.infracciones.service;

import edu.pe.cibertec.infracciones.dto.InfractorRequestDTO;
import edu.pe.cibertec.infracciones.dto.InfractorResponseDTO;
import java.util.List;

public interface IInfractorService {
    InfractorResponseDTO registrarInfractor(InfractorRequestDTO dto);
    InfractorResponseDTO obtenerInfractorPorId(Long id);
    List<InfractorResponseDTO> obtenerTodos();
    void asignarVehiculo(Long infractorId, Long vehiculoId);

     // Pregunta 1
    double calcularDeuda(Long idInfractor); //
     //Pregunta 2
    void desasignarVehiculo(Long infractorId, Long vehiculoId);
}