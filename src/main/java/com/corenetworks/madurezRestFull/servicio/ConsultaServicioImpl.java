package com.corenetworks.madurezRestFull.servicio;

import com.corenetworks.madurezRestFull.modelo.ConsultaMedica;
import com.corenetworks.madurezRestFull.repository.IConsultasRepo;
import com.corenetworks.madurezRestFull.repository.IGenericoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ConsultaServicioImpl extends CRUDImpl<ConsultaMedica,Integer>implements IConsultaServicio{
@Autowired
private IConsultasRepo repo;

    @Override
    protected IGenericoRepo<ConsultaMedica, Integer> getRepo() {
        return repo;
    }
}
