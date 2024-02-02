package com.corenetworks.madurezRestFull.repository;

import com.corenetworks.madurezRestFull.modelo.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepo extends IGenericoRepo<Paciente,Integer> {
}
