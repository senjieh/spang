package com.spang.prod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spang.prod.model.Word;
import com.spang.prod.repository.WordRepository;


@Service
public class WordService {

    @Autowired
    private WordRepository repository;

    public Word findWord(String language, String word) {
        return repository.findWord(language, word);
    }
}
