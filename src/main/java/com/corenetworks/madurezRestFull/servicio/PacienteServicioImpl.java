package com.corenetworks.madurezRestFull.servicio;

import com.corenetworks.madurezRestFull.modelo.Paciente;
import com.corenetworks.madurezRestFull.repository.IGenericoRepo;
import com.corenetworks.madurezRestFull.repository.IPacienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PacienteServicioImpl extends CRUDImpl<Paciente,Integer>implements IPacienteServicio{
@Autowired
private IPacienteRepo repo;
    @Override
    protected IGenericoRepo<Paciente, Integer> getRepo() {
        return repo;
    }
}
