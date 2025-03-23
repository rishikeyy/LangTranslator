package com.example.translation_app.service;

import com.example.translation_app.RequestBodyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class TranslationService {

    @Autowired
    RestClient restClient;  // field injection

    public void getTranslation(RequestBodyDTO requestBodyDTO) {
        //check in DB
        //check in cache
        //call Traslate API


    }
}
