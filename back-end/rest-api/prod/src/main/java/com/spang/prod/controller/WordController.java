package com.spang.prod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spang.prod.model.Word;
import com.spang.prod.service.WordService;


@RestController
@RequestMapping("/api/words")
public class WordController {

    @Autowired
    private WordService service;

    // Language Parameter:
    // spang_eng - spanish to english
    @GetMapping("/{language}/{word}")
    public Word getWordByLanguage(@PathVariable String language, @PathVariable String word) {
        return service.findWord(language, word);
    }

}
