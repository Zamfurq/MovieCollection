package com.example.nusabasa.bl;

import com.example.nusabasa.jv.Question;

import java.util.ArrayList;

public class BaliQuestionData {
    public static String TOTAL_QUESTION = "total_question";
    public static String CORRECT_ANSWERS = "correct_answers";

    public static ArrayList<BaliQuestion> getQuestions() {
        ArrayList<BaliQuestion> questionList = new ArrayList<>();

        BaliQuestion que1 = new BaliQuestion();
        que1.id = 1;
        que1.question = "Makan";
        que1.optionOne = "Melaib";
        que1.optionTwo = "Mejaguran";
        que1.optionThree = "Ngajeng";
        que1.correctAnswer = 3;
        questionList.add(que1);

        BaliQuestion que2 = new BaliQuestion();
        que2.id = 2;
        que2.question = "Tidur";
        que2.optionOne = "Sirep";
        que2.optionTwo = "Melali";
        que2.optionThree = "Becik";
        que2.correctAnswer = 1;
        questionList.add(que2);

        BaliQuestion que3 = new BaliQuestion();
        que3.id = 3;
        que3.question = "Cantik";
        que3.optionOne = "Suargan";
        que3.optionTwo = "Jegeg";
        que3.optionThree = "Iwang";
        que3.correctAnswer = 2;
        questionList.add(que3);

        BaliQuestion que4 = new BaliQuestion();
        que4.id = 4;
        que4.question = "Kaki";
        que4.optionOne = "Cokor";
        que4.optionTwo = "Prabu";
        que4.optionThree = "Penyingakan";
        que4.correctAnswer = 1;
        questionList.add(que4);

        BaliQuestion que5 = new BaliQuestion();
        que5.id = 5;
        que5.question = "Kakak Perempuan";
        que5.optionOne = "Wastana";
        que5.optionTwo = "Lunga";
        que5.optionThree = "Mbok";
        que5.correctAnswer = 3;
        questionList.add(que5);

        BaliQuestion que6 = new BaliQuestion();
        que6.id = 6;
        que6.question = "Gila";
        que6.optionOne = "Sajan";
        que6.optionTwo = "Buduh";
        que6.optionThree = "Megae";
        que6.correctAnswer = 2;
        questionList.add(que6);

        BaliQuestion que7 = new BaliQuestion();
        que7.id = 7;
        que7.question = "Mandi";
        que7.optionOne = "Meplesiran";
        que7.optionTwo = "Merorasan";
        que7.optionThree = "Manjus";
        que7.correctAnswer = 3;
        questionList.add(que7);

        BaliQuestion que8 = new BaliQuestion();
        que8.id = 8;
        que8.question = "Rajin";
        que8.optionOne = "Jemet";
        que8.optionTwo = "Konden";
        que8.optionThree = "Gatra";
        que8.correctAnswer = 1;
        questionList.add(que8);

        BaliQuestion que9 = new BaliQuestion();
        que9.id = 9;
        que9.question = "Terima Kasih";
        que9.optionOne = "Suksma";
        que9.optionTwo = "Ngiring";
        que9.optionThree = "Becik";
        que9.correctAnswer = 1;
        questionList.add(que9);

        BaliQuestion que10 = new BaliQuestion();
        que10.id = 10;
        que10.question = "Selamat Datang";
        que10.optionOne = "Rahajeng semeng";
        que10.optionTwo = "Rahajeng rauh";
        que10.optionThree = "Rahajeng wengi";
        que10.correctAnswer = 2;
        questionList.add(que10);

        return questionList;
    }

    public static ArrayList<BaliQuestion> getQuestions2() {
        ArrayList<BaliQuestion> questionList = new ArrayList<>();

        BaliQuestion que1 = new BaliQuestion();
        que1.id = 1;
        que1.question = "Saya";
        que1.optionOne = "Idane";
        que1.optionTwo = "Tiyang";
        que1.optionThree = "Semeton";
        que1.correctAnswer = 2;
        questionList.add(que1);

        BaliQuestion que2 = new BaliQuestion();
        que2.id = 2;
        que2.question = "Bekerja";
        que2.optionOne = "Mejalan";
        que2.optionTwo = "Mepamit";
        que2.optionThree = "Megae";
        que2.correctAnswer = 3;
        questionList.add(que2);

        BaliQuestion que3 = new BaliQuestion();
        que3.id = 3;
        que3.question = "Bertanya";
        que3.optionOne = "Melakon";
        que3.optionTwo = "Metakon";
        que3.optionThree = "Makarya";
        que3.correctAnswer = 2;
        questionList.add(que3);

        BaliQuestion que4 = new BaliQuestion();
        que4.id = 4;
        que4.question = "Pergi";
        que4.optionOne = "Nunas";
        que4.optionTwo = "Jagi";
        que4.optionThree = "Lunga";
        que4.correctAnswer = 3;
        questionList.add(que4);

        BaliQuestion que5 = new BaliQuestion();
        que5.id = 5;
        que5.question = "Kakak laki-laki";
        que5.optionOne = "Sulingih";
        que5.optionTwo = "Bli";
        que5.optionThree = "Nyame";
        que5.correctAnswer = 2;
        questionList.add(que5);

        BaliQuestion que6 = new BaliQuestion();
        que6.id = 6;
        que6.question = "Lari";
        que6.optionOne = "Melaib";
        que6.optionTwo = "Megentos";
        que6.optionThree = "Mesaput";
        que6.correctAnswer = 1;
        questionList.add(que6);

        BaliQuestion que7 = new BaliQuestion();
        que7.id = 7;
        que7.question = "Senang";
        que7.optionOne = "Kimud";
        que7.optionTwo = "Kajengit";
        que7.optionThree = "Liang";
        que7.correctAnswer = 3;
        questionList.add(que7);

        BaliQuestion que8 = new BaliQuestion();
        que8.id = 8;
        que8.question = "Diam";
        que8.optionOne = "Nengil";
        que8.optionTwo = "Cacak";
        que8.optionThree = "Kude";
        que8.correctAnswer = 1;
        questionList.add(que8);

        BaliQuestion que9 = new BaliQuestion();
        que9.id = 9;
        que9.question = "Lupa";
        que9.optionOne = "Engsap";
        que9.optionTwo = "Suwud";
        que9.optionThree = "Meju";
        que9.correctAnswer = 1;
        questionList.add(que9);

        BaliQuestion que10 = new BaliQuestion();
        que10.id = 10;
        que10.question = "Telinga";
        que10.optionOne = "Lengen";
        que10.optionTwo = "Karna";
        que10.optionThree = "Bibih";
        que10.correctAnswer = 2;
        questionList.add(que10);

        return questionList;
    }

    public static ArrayList<BaliQuestion> getQuestions3() {
        ArrayList<BaliQuestion> questionList = new ArrayList<>();

        BaliQuestion que1 = new BaliQuestion();
        que1.id = 1;
        que1.question = "Minum";
        que1.optionOne = "Ningal";
        que1.optionTwo = "Niman";
        que1.optionThree = "Nginem";
        que1.correctAnswer = 3;
        questionList.add(que1);

        BaliQuestion que2 = new BaliQuestion();
        que2.id = 2;
        que2.question = "Tertawa";
        que2.optionOne = "Kedek";
        que2.optionTwo = "Ngutut";
        que2.optionThree = "Makecuh";
        que2.correctAnswer = 1;
        questionList.add(que2);

        BaliQuestion que3 = new BaliQuestion();
        que3.id = 3;
        que3.question = "Berenang";
        que3.optionOne = "Mejek";
        que3.optionTwo = "Ngelangi";
        que3.optionThree = "Mekeber";
        que3.correctAnswer = 2;
        questionList.add(que3);

        BaliQuestion que4 = new BaliQuestion();
        que4.id = 4;
        que4.question = "Mencuci";
        que4.optionOne = "Nyait";
        que4.optionTwo = "Ngumbah";
        que4.optionThree = "Ngentungan";
        que4.correctAnswer = 2;
        questionList.add(que4);

        BaliQuestion que5 = new BaliQuestion();
        que5.id = 5;
        que5.question = "Bermain";
        que5.optionOne = "Meplalian";
        que5.optionTwo = "Mejangkut";
        que5.optionThree = "Mesare";
        que5.correctAnswer = 1;
        questionList.add(que5);

        BaliQuestion que6 = new BaliQuestion();
        que6.id = 6;
        que6.question = "Terima keasih kembali";
        que6.optionOne = "Sampun sue";
        que6.optionTwo = "Suksma";
        que6.optionThree = "Suksma mewali";
        que6.correctAnswer = 3;
        questionList.add(que6);

        BaliQuestion que7 = new BaliQuestion();
        que7.id = 7;
        que7.question = "Memotong";
        que7.optionOne = "Singkuh";
        que7.optionTwo = "Nyoncong";
        que7.optionThree = "Ngetep";
        que7.correctAnswer = 3;
        questionList.add(que7);

        BaliQuestion que8 = new BaliQuestion();
        que8.id = 8;
        que8.question = "Takut";
        que8.optionOne = "Jejeh";
        que8.optionTwo = "Miyegan";
        que8.optionThree = "Ngosek";
        que8.correctAnswer = 1;
        questionList.add(que8);

        BaliQuestion que9 = new BaliQuestion();
        que9.id = 9;
        que9.question = "Tampan";
        que9.optionOne = "Beling";
        que9.optionTwo = "Betek";
        que9.optionThree = "Bagus";
        que9.correctAnswer = 3;
        questionList.add(que9);

        BaliQuestion que10 = new BaliQuestion();
        que10.id = 10;
        que10.question = "Nenek";
        que10.optionOne = "Enyak";
        que10.optionTwo = "Dadong";
        que10.optionThree = "Daar";
        que10.correctAnswer = 2;
        questionList.add(que10);

        return questionList;
    }
}
