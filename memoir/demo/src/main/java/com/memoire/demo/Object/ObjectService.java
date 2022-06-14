package com.memoire.demo.Object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectService {

    private final ObjectRepository objectRepository;

    @Autowired
    public ObjectService(ObjectRepository objectRepository){
        this.objectRepository = objectRepository;
    }

    public List<Produit> getObjects(){
        return objectRepository.findAll();
    }

    public void addObject(Produit newObject){
        objectRepository.save(newObject);
    }

    public String deleteObject(Integer objectId){objectRepository.findById(objectId);
        return "Object id : " + objectId + "has been deleted";
    }

}
