package com.example.nusabasa.bl;

import java.util.ArrayList;

public class BaliFillTextQuestionData {
    public static String TOTAL_QUESTION = "total_question";
    public static String CORRECT_ANSWERS = "correct_answers";

    public static ArrayList<BaliFillTextQuestion> getQuestions() {
        ArrayList<BaliFillTextQuestion> questionList = new ArrayList<>();

        BaliFillTextQuestion que1 = new BaliFillTextQuestion();
        que1.id = 1;
        que1.question = "Lita ……… (menangis) ditinggal ayahnya";
        que1.answer = "Ngeling";
        questionList.add(que1);

        BaliFillTextQuestion que2 = new BaliFillTextQuestion();
        que2.id = 2;
        que2.question = "Adiknya tiba – tiba …… (sakit) panas dingin";
        que2.answer = "Gelem";
        questionList.add(que2);

        BaliFillTextQuestion que3 = new BaliFillTextQuestion();
        que3.id = 3;
        que3.question = "Putu Ayu …… (makan) bakso di Kuta";
        que3.answer = "Ngajeng";
        questionList.add(que3);

        BaliFillTextQuestion que4 = new BaliFillTextQuestion();
        que4.id = 4;
        que4.question = "Dewa Jo …….  (bekerja) di kantor bank BCA pusat";
        que4.answer = "Megae";
        questionList.add(que4);

        BaliFillTextQuestion que5 = new BaliFillTextQuestion();
        que5.id = 5;
        que5.question = "Sukreni adalah gadis bali yang sangat …….(cantik)";
        que5.answer = "Jegeg";
        questionList.add(que5);

        BaliFillTextQuestion que6 = new BaliFillTextQuestion();
        que6.id = 6;
        que6.question = "Rama ……. (tidur) di kamar adiknya";
        que6.answer = "Sirep";
        questionList.add(que6);

        BaliFillTextQuestion que7 = new BaliFillTextQuestion();
        que7.id = 7;
        que7.question = "Komang ……… (duduk) sambil menaikan satu kakinya";
        que7.answer = "Negak";
        questionList.add(que7);

        BaliFillTextQuestion que8 = new BaliFillTextQuestion();
        que8.id = 8;
        que8.question = "Okta membersihkan …….. (dapur) yang penuh alat masak";
        que8.answer = "Paon";
        questionList.add(que8);

        BaliFillTextQuestion que9 = new BaliFillTextQuestion();
        que9.id = 9;
        que9.question = "Genta …… (takut) sendirian di rumah";
        que9.answer = "Jejeh";
        questionList.add(que9);

        BaliFillTextQuestion que10 = new BaliFillTextQuestion();
        que10.id = 10;
        que10.question = "Ayu ….. (jalan-jalan) ke Mall Bali Galleria";
        que10.answer = "Melali";
        questionList.add(que10);

        return questionList;
    }

    public static ArrayList<BaliFillTextQuestion> getQuestions2() {
        ArrayList<BaliFillTextQuestion> questionList = new ArrayList<>();

        BaliFillTextQuestion que1 = new BaliFillTextQuestion();
        que1.id = 1;
        que1.question = "Lisa potong ….. (rambut) ke salon";
        que1.answer = "Bok";
        questionList.add(que1);

        BaliFillTextQuestion que2 = new BaliFillTextQuestion();
        que2.id = 2;
        que2.question = "Kadek Ina ……. (menonton) TV setiap hari";
        que2.answer = "Mebalih";
        questionList.add(que2);

        BaliFillTextQuestion que3 = new BaliFillTextQuestion();
        que3.id = 3;
        que3.question = "Adi dan Uci ……..(bermain) kelereng bersama";
        que3.answer = "Memplaian";
        questionList.add(que3);

        BaliFillTextQuestion que4 = new BaliFillTextQuestion();
        que4.id = 4;
        que4.question = "Ari ….. (sembahyang) ke pura bersama keluar";
        que4.answer = "Maturan";
        questionList.add(que4);

        BaliFillTextQuestion que5 = new BaliFillTextQuestion();
        que5.id = 5;
        que5.question = "Ibu sinta ……..(pulang) kerumah asalnya karena berkelahi dengan suaminya";
        que5.answer = "Mulih";
        questionList.add(que5);

        BaliFillTextQuestion que6 = new BaliFillTextQuestion();
        que6.id = 6;
        que6.question = "Ketut jarang ……. (mencuci) baju menggunakan mesin cuci";
        que6.answer = "Ngumbah";
        questionList.add(que6);

        BaliFillTextQuestion que7 = new BaliFillTextQuestion();
        que7.id = 7;
        que7.question = "Melya hanya bisa makan …… (bubur) ayam karena sakit gigi";
        que7.answer = "Gendar";
        questionList.add(que7);

        BaliFillTextQuestion que8 = new BaliFillTextQuestion();
        que8.id = 8;
        que8.question = "Burung Sany …… (lepas) dari sangkarnya";
        que8.answer = "Leb";
        questionList.add(que8);

        BaliFillTextQuestion que9 = new BaliFillTextQuestion();
        que9.id = 9;
        que9.question = "Di taman kota sekarang sudah disediakan tempat untuk ……. (duduk) yang lebih luas";
        que9.answer = "Negak";
        questionList.add(que9);

        BaliFillTextQuestion que10 = new BaliFillTextQuestion();
        que10.id = 10;
        que10.question = "Milla adalah orang yang murah ……. (senyum)";
        que10.answer = "Kenyem";
        questionList.add(que10);

        return questionList;
    }
}
