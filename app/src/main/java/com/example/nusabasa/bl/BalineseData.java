package com.example.nusabasa.bl;

import java.util.ArrayList;

public class BalineseData {
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

    static ArrayList<Balinese> getListData() {
        ArrayList<Balinese> pilihans= new ArrayList<>();
        for (int position = 0; position < typeNames.length; position++){
            Balinese pilihan = new Balinese();
            pilihan.setName(typeNames[position]);
            pilihans.add(pilihan);
        }
        return pilihans;
    }
}
