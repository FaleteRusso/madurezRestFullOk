package com.corenetworks.madurezRestFull.servicio;

import com.corenetworks.madurezRestFull.repository.IGenericoRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class CRUDImpl<T,ID> implements ICRUD<T,ID>{

protected abstract IGenericoRepo<T,ID>getRepo();

    @Override
    public T crear(T t) {
        return getRepo().save(t);
    }

    @Override
    public T modificar(T t) {
        return getRepo().save(t);
    }

    @Override
    public void eliminar(ID id) {
getRepo().deleteById(id);
    }

    @Override
    public T consultarUno(ID id) {
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public List<T> consultaTodos() {
        return getRepo().findAll();
    }
}
