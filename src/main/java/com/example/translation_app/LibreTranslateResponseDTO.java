package com.example.translation_app;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LibreTranslateResponseDTO {

    public String[] alternatives;
    public String  translatedText;
}
