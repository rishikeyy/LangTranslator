package com.example.translation_app.service;

import com.example.translation_app.LibreTranslateResponseDTO;
import com.example.translation_app.RepoEntityenes;
import com.example.translation_app.RequestBodyDTO;
import com.example.translation_app.repository.WordRepositoryenes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Objects;
import java.util.Optional;

@Service
public class TranslationService {

    @Value("${libretranslate.url}")
    private String libreTranslateUrl;
    @Autowired
    RestClient restClient;  // field injection
    @Autowired
    WordRepositoryenes wordRepositoryenes;

    Optional<RepoEntityenes> enesDB(RequestBodyDTO requestBodyDTO){
       return wordRepositoryenes.findById(requestBodyDTO.sourceLangCode);
    }
    public void getTranslation(RequestBodyDTO requestBody) {

        //check in cache

        //check in DB
            //check for en to es
        if(Objects.equals(requestBody.sourceLangCode, "en") && Objects.equals(requestBody.targetLangCode, "es")){
            Optional<RepoEntityenes> chck=enesDB(requestBody);
            if(chck.isPresent()) {
                System.out.println(chck);
              //  return chck.get().toString();

            }
            //else call Translate API and insert in DB
            else{
                LibreTranslateResponseDTO result = restClient.post()
                        .uri(libreTranslateUrl+"/translate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(requestBody)
                        .retrieve()
                        .body(LibreTranslateResponseDTO.class);//convert response to entity


               // System.out.println(result);
                //Tailor repoentity using request attribute("source") and result attribute("translatedText")
                RepoEntityenes repoEntityenesDTO=new RepoEntityenes() ;
                repoEntityenesDTO.source=requestBody.textSource;
                repoEntityenesDTO.target=result.translatedText;
                wordRepositoryenes.save(repoEntityenesDTO);//put repoentityenesDTO object to this repo

            }
        }


        //call Traslate API


    }
}
