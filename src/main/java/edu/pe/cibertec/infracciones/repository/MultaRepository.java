package edu.pe.cibertec.infracciones.repository;

import edu.pe.cibertec.infracciones.model.EstadoMulta;
import edu.pe.cibertec.infracciones.model.Multa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MultaRepository extends JpaRepository<Multa, Long> {

    // Para Pregunta 1: Obtener todas las multas del infractor para calcular deuda ]
    List<Multa> findByInfractor_Id(Long infractorId);

    // Para Pregunta 2: Verificar si existen multas PENDIENTES para un vehículo específico
    boolean existsByVehiculo_IdAndEstado(Long vehiculoId, EstadoMulta estado);

    List<Multa> findByVehiculo_Id(Long vehiculoId);
    List<Multa> findByInfractor_IdAndEstado(Long infractorId, EstadoMulta estado);
    List<Multa> findByVehiculo_IdAndEstado(Long vehiculoId, EstadoMulta estado);
    boolean existsByCodigo(String codigo);
}