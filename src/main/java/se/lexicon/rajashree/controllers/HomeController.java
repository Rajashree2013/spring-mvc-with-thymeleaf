package se.lexicon.rajashree.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private List<String> contactViews = new ArrayList<>();

    @RequestMapping(value = "/index" , method = RequestMethod.GET)
    public String index(){
        System.out.println("##### index method has been executed ####");
        return "index";
    }
    @GetMapping("/contact")
    public String contact(){
        System.out.println("##### contact method has been executed ####");
        return "contact";
    }

    @PostMapping("/contact")
    public String contact(@RequestParam("contactInfo")String contact){
        System.out.println("##### contact method has been executed ####");
        System.out.println("##### input passed from form ####" + contact);
        contactViews.add(contact);
        System.out.println("##### input passed from form ####" + contactViews.size());
        return "contact";
    }


    @GetMapping("/contacts")
    public String contactList(Model model)
    {
        System.out.println("Number of Contacts: " + contactViews.size());
        model.addAttribute("contactViews",contactViews);
        return "contactList";
    }

}
