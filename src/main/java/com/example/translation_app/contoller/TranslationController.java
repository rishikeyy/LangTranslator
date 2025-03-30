package com.example.translation_app.contoller;


import com.example.translation_app.RequestBodyDTO;
import com.example.translation_app.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslationController {

    @Autowired
    TranslationService translationService;

    @PostMapping("/translate")
    public ResponseEntity<String> translate(@RequestBody RequestBodyDTO requestBodyDTO){
       return  translationService.getTranslation(requestBodyDTO);
    }
}
