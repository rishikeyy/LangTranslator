package com.example.translation_app;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestBodyDTO {
    private String textSource;
    private String sourceLangCode;
    private String targetLangCode;
    private String format;
    private String alternatives;
    private String api_key;

}
