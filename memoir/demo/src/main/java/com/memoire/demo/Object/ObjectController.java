package com.memoire.demo.Object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "api/v1/objects")
public class ObjectController {

    private ObjectService objectService;

    @Autowired
    public ObjectController(ObjectService objectService){
        this.objectService = objectService;
    }
    @GetMapping
    public List<Produit> getObjects(){
        return objectService.getObjects();
    }

    @PostMapping
    public String addObject(Produit x, Model model){
        objectService.addObject(x);
        model.addAttribute("produit", x);
        return "/image";
    }

    @DeleteMapping(path = "/delete/{objectId}")
    public void deleteObject (@PathVariable("objectId") Integer objectId){
        objectService.deleteObject(objectId);
    }

    @GetMapping(path = "/add/{objectId}")
    public void saveObject(){
        objectService.addObject(new Produit("book"));
    }

}