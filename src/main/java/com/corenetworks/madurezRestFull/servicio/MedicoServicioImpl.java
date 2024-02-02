package com.corenetworks.madurezRestFull.servicio;

import com.corenetworks.madurezRestFull.modelo.ConsultaMedica;
import com.corenetworks.madurezRestFull.modelo.Medico;
import com.corenetworks.madurezRestFull.repository.IGenericoRepo;
import com.corenetworks.madurezRestFull.repository.IMedicoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoServicioImpl extends CRUDImpl<Medico,Integer>implements IMedicoServicio{
    @Autowired
    private IMedicoRepo repo;
    @Override
    protected IGenericoRepo<Medico, Integer> getRepo() {
        return repo;
    }
}
