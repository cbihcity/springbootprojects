package com.example.web;

import com.example.entity.Journal;
import com.example.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by HeroDishonest on 22.04.2017.
 */
@Controller
public class JournalController {

    @Autowired
    JournalRepository repo;

    @RequestMapping(value="/journal", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    List<Journal> getJournal(){
        return repo.findAll();
    }

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("journal", repo.findAll());
        return "index";
    }
}
