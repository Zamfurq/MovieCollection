package com.example.nusabasa;

import java.util.ArrayList;

public class LanguageData {
    private static String[] languageNames = {
      "Jawa","Bali"
    };

    private static int[] languagePhoto = {
       R.drawable.java_images,
            R.drawable.bali_island
    };

    static ArrayList<Language> getListData() {
        ArrayList<Language> languages = new ArrayList<>();
        for (int position = 0; position < languageNames.length; position++){
            Language language = new Language();
            language.setLanguage(languageNames[position]);
            language.setImage(languagePhoto[position]);
            languages.add(language);
        }
        return languages;
    }
}
