package com.example.nusabasa.jv;

import java.util.ArrayList;

public class QuestionData {
    public static String TOTAL_QUESTION = "total_question";
    public static String CORRECT_ANSWERS = "correct_answers";

    public static ArrayList<Question> getQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();

        Question que1 = new Question();
        que1.id = 1;
        que1.question = "Apa kabar? (Krama Inggil)";
        que1.optionOne = "Piye kabare";
        que1.optionTwo = "Pripun kabaripun";
        que1.optionThree = "Kados pundi pawartosipun";
        que1.correctAnswer = 3;
        questionList.add(que1);

        Question que2 = new Question();
        que2.id = 2;
        que2.question = "Pergi (Ngoko)";
        que2.optionOne = "Lungo";
        que2.optionTwo = "Teko";
        que2.optionThree = "Ndelok";
        que2.correctAnswer = 1;
        questionList.add(que2);

        Question que3 = new Question();
        que3.id = 3;
        que3.question = "Jauh (Krama Inggil)";
        que3.optionOne = "Tebeh";
        que3.optionTwo = "Cetak";
        que3.optionThree = "Ageng";
        que3.correctAnswer = 3;
        questionList.add(que3);

        Question que4 = new Question();
        que4.id = 4;
        que4.question = "Sakit (Ngoko)";
        que4.optionOne = "Lara";
        que4.optionTwo = "Waras";
        que4.optionThree = "Seda";
        que4.correctAnswer = 1;
        questionList.add(que4);

        Question que5 = new Question();
        que5.id = 5;
        que5.question = "Ayam";
        que5.optionOne = "Pitik";
        que5.optionTwo = "Wedhus";
        que5.optionThree = "Kethek";
        que5.correctAnswer = 1;
        questionList.add(que5);

        return questionList;
    }

    public static ArrayList<Question> getQuestions2() {
        ArrayList<Question> questionList2 = new ArrayList<>();

        Question que1 = new Question();
        que1.id = 1;
        que1.question = "Pisang";
        que1.optionOne = "Pelem";
        que1.optionTwo = "Gedhang";
        que1.optionThree = "Walum";
        que1.correctAnswer = 2;
        questionList2.add(que1);

        Question que2 = new Question();
        que2.id = 2;
        que2.question = "Saya (Krama Inggil)";
        que2.optionOne = "Aku";
        que2.optionTwo = "Dalem";
        que2.optionThree = "Kowe";
        que2.correctAnswer = 2;
        questionList2.add(que2);

        Question que3 = new Question();
        que3.id = 3;
        que3.question = "Kamar kecil (Ngoko)";
        que3.optionOne = "Amben";
        que3.optionTwo = "Mburi";
        que3.optionThree = "Wingking";
        que3.correctAnswer = 1;
        questionList2.add(que3);

        Question que4 = new Question();
        que4.id = 4;
        que4.question = "Belajar";
        que4.optionOne = "Adus";
        que4.optionTwo = "Mlayu";
        que4.optionThree = "Sinau";
        que4.correctAnswer = 3;
        questionList2.add(que4);

        Question que5 = new Question();
        que5.id = 5;
        que5.question = "Sepeda";
        que5.optionOne = "Pit";
        que5.optionTwo = "Monitor";
        que5.optionThree = "Sepur";
        que5.correctAnswer = 1;
        questionList2.add(que5);

        return questionList2;
    }

    public static ArrayList<Question> getQuestions3() {
        ArrayList<Question> questionList3 = new ArrayList<>();

        Question que1 = new Question();
        que1.id = 1;
        que1.question = "Minum";
        que1.optionOne = "Mangan";
        que1.optionTwo = "Manginum";
        que1.optionThree = "Ngombeh";
        que1.correctAnswer = 3;
        questionList3.add(que1);

        Question que2 = new Question();
        que2.id = 2;
        que2.question = "Belajar";
        que2.optionOne = "Sinau";
        que2.optionTwo = "Sare";
        que2.optionThree = "Waos";
        que2.correctAnswer = 1;
        questionList3.add(que2);

        Question que3 = new Question();
        que3.id = 3;
        que3.question = "Tidur";
        que3.optionOne = "Sare";
        que3.optionTwo = "Uwos";
        que3.optionThree = "Selem";
        que3.correctAnswer = 1;
        questionList3.add(que3);

        Question que4 = new Question();
        que4.id = 4;
        que4.question = "Bekerja";
        que4.optionOne = "Reged";
        que4.optionTwo = "Tandang";
        que4.optionThree = "Madang";
        que4.correctAnswer = 2;
        questionList3.add(que4);

        Question que5 = new Question();
        que5.id = 5;
        que5.question = "Kejar";
        que5.optionOne = "Mlayu";
        que5.optionTwo = "Uber";
        que5.optionThree = "Ngguwak";
        que5.correctAnswer = 2;
        questionList3.add(que5);

        Question que6 = new Question();
        que6.id = 6;
        que6.question = "Hujan";
        que6.optionOne = "Banyu";
        que6.optionTwo = "Tirta";
        que6.optionThree = "Udan";
        que6.correctAnswer = 3;
        questionList3.add(que6);

        Question que7 = new Question();
        que7.id = 7;
        que7.question = "Belajar";
        que7.optionOne = "Sinau";
        que7.optionTwo = "Sare";
        que7.optionThree = "Waos";
        que7.correctAnswer = 1;
        questionList3.add(que7);

        Question que8 = new Question();
        que8.id = 8;
        que8.question = "Baca";
        que8.optionOne = "Maca";
        que8.optionTwo = "Mangkos";
        que8.optionThree = "Daos";
        que8.correctAnswer = 1;
        questionList3.add(que8);

        Question que9 = new Question();
        que9.id = 9;
        que9.question = "Lari";
        que9.optionOne = "Mlaku";
        que9.optionTwo = "Mlayu";
        que9.optionThree = "Mlampah";
        que9.correctAnswer = 2;
        questionList3.add(que9);

        Question que10 = new Question();
        que10.id = 10;
        que10.question = "Jalan";
        que10.optionOne = "Mlayu";
        que10.optionTwo = "Madusi";
        que10.optionThree = "Mlaku";
        que10.correctAnswer = 3;
        questionList3.add(que10);

        return questionList3;
    }

    public static ArrayList<Question> getQuestions4() {
        ArrayList<Question> questionList3 = new ArrayList<>();

        Question que1 = new Question();
        que1.id = 1;
        que1.question = "Air";
        que1.optionOne = "Banyu";
        que1.optionTwo = "Bayu";
        que1.optionThree = "Agni";
        que1.correctAnswer = 1;
        questionList3.add(que1);

        Question que2 = new Question();
        que2.id = 2;
        que2.question = "Beras";
        que2.optionOne = "Luwes";
        que2.optionTwo = "Waos";
        que2.optionThree = "Uwos";
        que2.correctAnswer = 3;
        questionList3.add(que2);

        Question que3 = new Question();
        que3.id = 3;
        que3.question = "Gula";
        que3.optionOne = "Branang";
        que3.optionTwo = "Gundhi";
        que3.optionThree = "Gendhis";
        que3.correctAnswer = 3;
        questionList3.add(que3);

        Question que4 = new Question();
        que4.id = 4;
        que4.question = "Garam";
        que4.optionOne = "Wayah";
        que4.optionTwo = "Uyah";
        que4.optionThree = "Mawah";
        que4.correctAnswer = 2;
        questionList3.add(que4);

        Question que5 = new Question();
        que5.id = 5;
        que5.question = "Padi";
        que5.optionOne = "Pari";
        que5.optionTwo = "Patri";
        que5.optionThree = "Yatra";
        que5.correctAnswer = 1;
        questionList3.add(que5);

        Question que6 = new Question();
        que6.id = 6;
        que6.question = "Uang";
        que6.optionOne = "Yatra";
        que6.optionTwo = "Asma";
        que6.optionThree = "Yusma";
        que6.correctAnswer = 1;
        questionList3.add(que6);

        Question que7 = new Question();
        que7.id = 7;
        que7.question = "Kambing";
        que7.optionOne = "Pedhet";
        que7.optionTwo = "Belo";
        que7.optionThree = "Wedhus";
        que7.correctAnswer = 3;
        questionList3.add(que7);

        Question que8 = new Question();
        que8.id = 8;
        que8.question = "Perahu";
        que8.optionOne = "Prau";
        que8.optionTwo = "Parau";
        que8.optionThree = "Perawu";
        que8.correctAnswer = 1;
        questionList3.add(que8);

        Question que9 = new Question();
        que9.id = 9;
        que9.question = "Pasar";
        que9.optionOne = "Peken";
        que9.optionTwo = "Reken";
        que9.optionThree = "Seken";
        que9.correctAnswer = 1;
        questionList3.add(que9);

        Question que10 = new Question();
        que10.id = 10;
        que10.question = "Rumah";
        que10.optionOne = "Gubug";
        que10.optionTwo = "Gedhong";
        que10.optionThree = "Omah";
        que10.correctAnswer = 3;
        questionList3.add(que10);

        return questionList3;
    }

    public static ArrayList<Question> getQuestions5() {
        ArrayList<Question> questionList3 = new ArrayList<>();

        Question que1 = new Question();
        que1.id = 1;
        que1.question = "Cucu";
        que1.optionOne = "Putu";
        que1.optionTwo = "Cicit";
        que1.optionThree = "Piyih";
        que1.correctAnswer = 1;
        questionList3.add(que1);

        Question que2 = new Question();
        que2.id = 2;
        que2.question = "Teman";
        que2.optionOne = "Kanca";
        que2.optionTwo = "Arek";
        que2.optionThree = "Kancah";
        que2.correctAnswer = 1;
        questionList3.add(que2);

        Question que3 = new Question();
        que3.id = 3;
        que3.question = "Bangsawan";
        que3.optionOne = "Praya";
        que3.optionTwo = "Priyayi";
        que3.optionThree = "Arya";
        que3.correctAnswer = 2;
        questionList3.add(que3);

        Question que4 = new Question();
        que4.id = 4;
        que4.question = "Bapak";
        que4.optionOne = "Abi";
        que4.optionTwo = "Biyung";
        que4.optionThree = "Rama";
        que4.correctAnswer = 3;
        questionList3.add(que4);

        Question que5 = new Question();
        que5.id = 5;
        que5.question = "Ibu";
        que5.optionOne = "Ummi";
        que5.optionTwo = "Biyung";
        que5.optionThree = "Mbabuk";
        que5.correctAnswer = 2;
        questionList3.add(que5);

        Question que6 = new Question();
        que6.id = 6;
        que6.question = "Nenek";
        que6.optionOne = "Simbah";
        que6.optionTwo = "Emak";
        que6.optionThree = "Simbok";
        que6.correctAnswer = 3;
        questionList3.add(que6);

        Question que7 = new Question();
        que7.id = 7;
        que7.question = "Kakek";
        que7.optionOne = "Simbok";
        que7.optionTwo = "Emak";
        que7.optionThree = "Simbah";
        que7.correctAnswer = 1;
        questionList3.add(que7);

        Question que8 = new Question();
        que8.id = 8;
        que8.question = "Om Muda";
        que8.optionOne = "Pakdhe";
        que8.optionTwo = "Paklek";
        que8.optionThree = "Gus";
        que8.correctAnswer = 2;
        questionList3.add(que8);

        Question que9 = new Question();
        que9.id = 9;
        que9.question = "Om Tua";
        que9.optionOne = "Paklek";
        que9.optionTwo = "Pakdhe";
        que9.optionThree = "Abah";
        que9.correctAnswer = 2;
        questionList3.add(que9);

        Question que10 = new Question();
        que10.id = 10;
        que10.question = "Kakak laki-laki";
        que10.optionOne = "Kangmas";
        que10.optionTwo = "Adimas";
        que10.optionThree = "Abang";
        que10.correctAnswer = 1;
        questionList3.add(que10);

        return questionList3;
    }

    public static ArrayList<Question> getQuestions6() {
        ArrayList<Question> questionList3 = new ArrayList<>();

        Question que1 = new Question();
        que1.id = 1;
        que1.question = "Satu";
        que1.optionOne = "Setunggal";
        que1.optionTwo = "Sedasa";
        que1.optionThree = "Kalih";
        que1.correctAnswer = 1;
        questionList3.add(que1);

        Question que2 = new Question();
        que2.id = 2;
        que2.question = "Sepuluh";
        que2.optionOne = "Sewelas";
        que2.optionTwo = "Sedasa";
        que2.optionThree = "Satus";
        que2.correctAnswer = 2;
        questionList3.add(que2);

        Question que3 = new Question();
        que3.id = 3;
        que3.question = "Dua puluh satu";
        que3.optionOne = "Kalih dasa setunggal";
        que3.optionTwo = "Selikur";
        que3.optionThree = "Selawe";
        que3.correctAnswer = 2;
        questionList3.add(que3);

        Question que4 = new Question();
        que4.id = 4;
        que4.question = "Seratus";
        que4.optionOne = "Satus";
        que4.optionTwo = "Sewelas";
        que4.optionThree = "Setungal atus";
        que4.correctAnswer = 1;
        questionList3.add(que4);

        Question que5 = new Question();
        que5.id = 5;
        que5.question = "Dua puluh lima";
        que5.optionOne = "Kalih dasa lima";
        que5.optionTwo = "Selawe";
        que5.optionThree = "Selikur";
        que5.correctAnswer = 2;
        questionList3.add(que5);

        Question que6 = new Question();
        que6.id = 6;
        que6.question = "Lima puluh";
        que6.optionOne = "Limang Dasa";
        que6.optionTwo = "Seket";
        que6.optionThree = "Sewidak";
        que6.correctAnswer = 2;
        questionList3.add(que6);

        Question que7 = new Question();
        que7.id = 7;
        que7.question = "Enam puluh";
        que7.optionOne = "Sewidak";
        que7.optionTwo = "Selawe";
        que7.optionThree = "Enem Dasa";
        que7.correctAnswer = 1;
        questionList3.add(que7);

        Question que8 = new Question();
        que8.id = 8;
        que8.question = "Sebelas";
        que8.optionOne = "Selawe";
        que8.optionTwo = "Selikur";
        que8.optionThree = "Sewelas";
        que8.correctAnswer = 3;
        questionList3.add(que8);

        Question que9 = new Question();
        que9.id = 9;
        que9.question = "Seratus sebelas";
        que9.optionOne = "Satus siji siji";
        que9.optionTwo = "Satus sewelas";
        que9.optionThree = "Satus dasa sewelas";
        que9.correctAnswer = 2;
        questionList3.add(que9);

        Question que10 = new Question();
        que10.id = 10;
        que10.question = "Seratus dua puluh satu";
        que10.optionOne = "Satus kalih dasa setunggal";
        que10.optionTwo = "Satus selikur";
        que10.optionThree = "Satus dasa Kalih setunggal";
        que10.correctAnswer = 2;
        questionList3.add(que10);

        return questionList3;
    }

    public static ArrayList<Question> getQuestions7() {
        ArrayList<Question> questionList3 = new ArrayList<>();

        Question que1 = new Question();
        que1.id = 1;
        que1.question = "Atas";
        que1.optionOne = "Ndukur";
        que1.optionTwo = "Ndulur";
        que1.optionThree = "Nduwur";
        que1.correctAnswer = 3;
        questionList3.add(que1);

        Question que2 = new Question();
        que2.id = 2;
        que2.question = "Bawah";
        que2.optionOne = "Ngasor";
        que2.optionTwo = "Ngisor";
        que2.optionThree = "Ngalor";
        que2.correctAnswer = 2;
        questionList3.add(que2);

        Question que3 = new Question();
        que3.id = 3;
        que3.question = "Depan";
        que3.optionOne = "Ngarep";
        que3.optionTwo = "Ndarep";
        que3.optionThree = "Marep";
        que3.correctAnswer = 1;
        questionList3.add(que3);

        Question que4 = new Question();
        que4.id = 4;
        que4.question = "Belakang";
        que4.optionOne = "Mabur";
        que4.optionTwo = "Mburi";
        que4.optionThree = "Ngidul";
        que4.correctAnswer = 2;
        questionList3.add(que4);

        Question que5 = new Question();
        que5.id = 5;
        que5.question = "Samping";
        que5.optionOne = "Manggir";
        que5.optionTwo = "Pinggir";
        que5.optionThree = "Sisih";
        que5.correctAnswer = 2;
        questionList3.add(que5);

        Question que6 = new Question();
        que6.id = 6;
        que6.question = "Kanan";
        que6.optionOne = "Wetan";
        que6.optionTwo = "Kengen";
        que6.optionThree = "Tengen";
        que6.correctAnswer = 3;
        questionList3.add(que6);

        Question que7 = new Question();
        que7.id = 7;
        que7.question = "Kiri";
        que7.optionOne = "Kawi";
        que7.optionTwo = "Kiwo";
        que7.optionThree = "Lawe";
        que7.correctAnswer = 2;
        questionList3.add(que7);

        Question que8 = new Question();
        que8.id = 8;
        que8.question = "Putar";
        que8.optionOne = "Marit";
        que8.optionTwo = "Muter";
        que8.optionThree = "Suter";
        que8.correctAnswer = 2;
        questionList3.add(que8);

        Question que9 = new Question();
        que9.id = 9;
        que9.question = "Sebelah";
        que9.optionOne = "Siseh";
        que9.optionTwo = "Pinggir";
        que9.optionThree = "Sisih";
        que9.correctAnswer = 3;
        questionList3.add(que9);

        Question que10 = new Question();
        que10.id = 10;
        que10.question = "Dalam";
        que10.optionOne = "Dalem";
        que10.optionTwo = "Njero";
        que10.optionThree = "Ngisor";
        que10.correctAnswer = 2;
        questionList3.add(que10);

        return questionList3;
    }
}
