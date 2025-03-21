package com.example.translation_app.contoller;


import com.example.translation_app.RequestBodyDTO;
import com.example.translation_app.service.TranslationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslationController {

    TranslationService translationService;
    @PostMapping("/translate")
    public void translate(@RequestBody RequestBodyDTO requestBodyDTO){
        translationService.getTranslation();
    }
}
