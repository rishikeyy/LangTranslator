package com.example.translation_app.service;

import com.example.translation_app.RepoEntityenes;
import com.example.translation_app.RequestBodyDTO;
import com.example.translation_app.repository.WordRepositoryenes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Objects;
import java.util.Optional;

@Service
public class TranslationService {

    @Autowired
    RestClient restClient;  // field injection
    @Autowired
    WordRepositoryenes wordRepositoryenes;
    Optional<RepoEntityenes> enesDB(RequestBodyDTO requestBodyDTO){
       return wordRepositoryenes.findById(requestBodyDTO.sourceLangCode);
    }
    public void getTranslation(RequestBodyDTO requestBodyDTO) {
        private String chck;
        //check in cache

        //check in DB
        if(Objects.equals(requestBodyDTO.sourceLangCode, "en") && Objects.equals(requestBodyDTO.targetLangCode, "es")){
            chck=enesDB(requestBodyDTO);
        }


        //call Traslate API


    }
}
