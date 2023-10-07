package com.gl.mongodb.service.Impl;

import com.gl.mongodb.exception.AllAlreadyExisteException;
import com.gl.mongodb.exception.AllDoesntExisteException;
import com.gl.mongodb.model.Credentiel;
import com.gl.mongodb.repositoriy.CredentielRepository;
import com.gl.mongodb.service.CredentielService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CredentielServiceImpl implements CredentielService {
    private final CredentielRepository credentielRepository;

    @Override
    public Credentiel create(Credentiel body) throws AllAlreadyExisteException {
        if(credentielRepository.existsByEmail (body.getEmail ()))
            throw new AllAlreadyExisteException("Credentiel with UserName already excite ");
        return credentielRepository.save (body);
    }

    @Override
    public Credentiel update(Credentiel body, String id) throws AllAlreadyExisteException, AllDoesntExisteException {
        if(credentielRepository.existsByEmail (body.getEmail ()))
            throw new AllAlreadyExisteException("Credentiel with UserName already excite ");
        Credentiel old = this.find (id);
        old.setPassword(body.getPassword());
        old.setId (id);
        return credentielRepository.save (old);


    }

    @Override
    public void delete(String id) throws AllDoesntExisteException {
        Credentiel todelete = this.find (id);
        credentielRepository.delete (todelete);
    }

    @Override
    public Credentiel find(String id) throws AllDoesntExisteException {
        return credentielRepository.findById (id).orElseThrow (() ->new AllDoesntExisteException("Credentiel doesn't excite "));
    }

    @Override
    public List<Credentiel> fetchAll() {
        return credentielRepository.findAll ();
    }

}
