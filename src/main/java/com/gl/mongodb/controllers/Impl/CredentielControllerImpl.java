package com.gl.mongodb.controllers.Impl;

import com.gl.mongodb.controllers.CredentielController;
import com.gl.mongodb.dto.CredentielDto;
import com.gl.mongodb.exception.AllAlreadyExisteException;
import com.gl.mongodb.exception.AllDoesntExisteException;
import com.gl.mongodb.model.Credentiel;
import com.gl.mongodb.service.CredentielService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credentiel")
@AllArgsConstructor
@Slf4j
public class CredentielControllerImpl implements CredentielController {
    private final CredentielService credentielService;
    private final ModelMapper modelMapper;
    @PostMapping
    @Override
    public ResponseEntity<Credentiel> create(@RequestBody CredentielDto body) throws AllAlreadyExisteException, AllDoesntExisteException {
        log.info("CredentielController::create request body {}", body);
        Credentiel myCredentiel = modelMapper.map (body,Credentiel.class);
        return new ResponseEntity<>(credentielService.create (myCredentiel), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Credentiel> update(@RequestBody  CredentielDto body,@PathVariable String id) throws AllDoesntExisteException, AllAlreadyExisteException {
        log.info("CredentielController::update request body {"+body+"} and path variable "+id);
        Credentiel myCredentiel = modelMapper.map (body,Credentiel.class);
        return new ResponseEntity<>(credentielService.update (myCredentiel,id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Credentiel> delete(@PathVariable  String id) throws AllDoesntExisteException {
        log.info("CredentielController::delete   path variable "+id);
        credentielService.delete (id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping ("/{id}")
    @Override
    public ResponseEntity<Credentiel> find(@PathVariable String id) throws AllDoesntExisteException {
        log.info("CredentielController::find   path variable "+id);
        return new ResponseEntity<>(credentielService.find (id), HttpStatus.OK);
    }
    @GetMapping
    @Override
    public ResponseEntity<List<Credentiel>> fetchAll() {
        log.info("CredentielController::fetchAll ");
        return new ResponseEntity<>(credentielService.fetchAll (), HttpStatus.OK);
    }
}
