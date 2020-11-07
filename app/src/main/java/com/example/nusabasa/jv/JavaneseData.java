package com.example.nusabasa.jv;

import java.util.ArrayList;

public class JavaneseData {
    private static final String[] typeNames = {
            "Pilihan Ganda 1",
            "Pilihan Ganda 2",
            "Pilihan Ganda 3",
            "Pilihan Ganda 4",
            "Pilihan Ganda 5",
            "Isian 1",
            "Isian 2",
            "Tebak Aksara 1",
            "Tebak Aksara 2",
            "Tebak Aksara 3",

    };

    static ArrayList<Javanese> getListData() {
        ArrayList<Javanese> pilihans= new ArrayList<>();
        for (int position = 0; position < typeNames.length; position++){
            Javanese pilihan = new Javanese();
            pilihan.setName(typeNames[position]);
            pilihans.add(pilihan);
        }
        return pilihans;
    }
}
