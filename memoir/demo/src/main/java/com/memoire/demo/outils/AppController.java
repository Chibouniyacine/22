package com.memoire.demo.outils;

import com.memoire.demo.Object.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AppController {
    @Autowired private AppService service;

    @GetMapping("/profil_client/produit")
    public String page(Model model){
        model.addAttribute("product", new Produit());
        model.addAttribute("pageTitel", "produit");
        return "/produit";
    }


    @GetMapping("/index/apropos")
    public String apropos(){

        return "/apropos";
    }

    @GetMapping("/index/contact")
    public String contact(){

        return "/contact";
    }

    @GetMapping("/index")
    public String index() {

        return "/index";
    }
    @GetMapping("/Inscreption/save1/produit")
    public String produit(){
        return "/produit";
    }
    @GetMapping("/index/book1")
    public String book1(){
        return "/book1";
    }

    @GetMapping("/index/book2")
    public String book2(){
        return "/book2";
    }


    @GetMapping("/index/inscreption")
    public String inscrept(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("pageTitel", "Inscreption");
        return "/Inscreption";
    }

    @PostMapping("/Inscreption/save")
    public String saveUser( User user)
    {   if (user.getName().equals("Amine")) user.setAdmin(true);
        service.save(user);
        return "/index";
    }

    @PostMapping("/Inscreption/save1")
    public String saveUser1( User user)
    {

        if (service.login(user.getEmail(),user.getPassword()))
        {   user=service.find_user_by_mail(user.getEmail());
            if (user.isAdmin()) return "/Profil_Admin";
            else return "/Profil_client";}
        else return "/index";
    }
    @PostMapping("/Inscreption/sup")
    public String delete ( User user)
    {

        if (service.login(user.getEmail(),user.getPassword()))
        {   user=service.find_user_by_mail(user.getEmail());
            service.delete(user);
            return "/index" ;
        }
        else return "/index";
    }
}
