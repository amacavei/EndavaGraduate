package com.endava.amacavei.controller;



import com.endava.amacavei.jdbc.clienti.Clienti;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by amacavei on 8/4/2015.
 */
@Controller
@RequestMapping("/")
public class HelloController {
    Clienti client1 = new Clienti();
    @RequestMapping(method = RequestMethod.GET)


    public String printWelcome(ModelMap model) {

        model.addAttribute("message", client1.getCity());
        return "hello";
    }


}
