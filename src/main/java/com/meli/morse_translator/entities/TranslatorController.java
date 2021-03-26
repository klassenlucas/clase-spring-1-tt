package com.meli.morse_translator.entities;

import com.meli.morse_translator.controllers.Translator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslatorController {
    @GetMapping(path = "/{morse}")
    public Translator translate(@PathVariable String morse) {
        return new Translator(morse);
    }
}
