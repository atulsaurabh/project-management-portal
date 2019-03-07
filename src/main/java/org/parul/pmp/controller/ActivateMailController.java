package org.parul.pmp.controller;

import org.parul.pmp.entity.User;
import org.parul.pmp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/activate")
public class ActivateMailController {
    @Autowired
    UserRepository userRepository;
    public String activateUser(Model model, long userid)
    {
        User user= userRepository.findById(userid).get();
        user.setActivate(true);
        userRepository.saveAndFlush(user);
        return "http://localhost:8080/accountactivationpage";
    }
}
