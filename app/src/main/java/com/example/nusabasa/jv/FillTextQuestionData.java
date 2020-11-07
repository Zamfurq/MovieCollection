package com.example.nusabasa.jv;

import java.util.ArrayList;

public class FillTextQuestionData {
    public static String TOTAL_QUESTION = "total_question";
    public static String CORRECT_ANSWERS = "correct_answers";

    public static ArrayList<FillTextQuestion> getQuestions() {
        ArrayList<FillTextQuestion> questionList = new ArrayList<>();

        FillTextQuestion que1 = new FillTextQuestion();
        que1.id = 1;
        que1.question = "Rudi ……(Baca) Buku";
        que1.answer = "Maca";
        questionList.add(que1);

        FillTextQuestion que2 = new FillTextQuestion();
        que2.id = 2;
        que2.question = "Slamet ……..(Makan) Tahu";
        que2.answer = "Mangan";
        questionList.add(que2);

        FillTextQuestion que3 = new FillTextQuestion();
        que3.id = 3;
        que3.question = "Agung …….(Naik) Motor Ngawang";
        que3.answer = "Numpak";
        questionList.add(que3);

        FillTextQuestion que4 = new FillTextQuestion();
        que4.id = 4;
        que4.question = "Siti ……(Buang) Sapu Rusak";
        que4.answer = "Ngguwak";
        questionList.add(que4);

        FillTextQuestion que5 = new FillTextQuestion();
        que5.id = 5;
        que5.question = "Mandala ……(Mengejar) Maling";
        que5.answer = "Nguber";
        questionList.add(que5);

        FillTextQuestion que6 = new FillTextQuestion();
        que6.id = 6;
        que6.question = "Sutris ……..(Mematikan) Laptop";
        que6.answer = "Mateni";
        questionList.add(que6);

        FillTextQuestion que7 = new FillTextQuestion();
        que7.id = 7;
        que7.question = "Dedi ……..(Membuka) Lawang";
        que7.answer = "Mbukak";
        questionList.add(que7);

        FillTextQuestion que8 = new FillTextQuestion();
        que8.id = 8;
        que8.question = "Fini ……..(Duduk) Ning Meja";
        que8.answer = "Lungguh";
        questionList.add(que8);

        FillTextQuestion que9 = new FillTextQuestion();
        que9.id = 9;
        que9.question = "Gugun …….(Tidur) Ning Kasur";
        que9.answer = "Turu";
        questionList.add(que9);

        FillTextQuestion que10 = new FillTextQuestion();
        que10.id = 10;
        que10.question = "Edward …….(Pergi) Saking Amrik";
        que10.answer = "Tindak";
        questionList.add(que10);

        return questionList;
    }

    public static ArrayList<FillTextQuestion> getQuestions2() {
        ArrayList<FillTextQuestion> questionList = new ArrayList<>();

        FillTextQuestion que1 = new FillTextQuestion();
        que1.id = 1;
        que1.question = "Dewi ……(Mandi) Ning Kali";
        que1.answer = "Adus";
        questionList.add(que1);

        FillTextQuestion que2 = new FillTextQuestion();
        que2.id = 2;
        que2.question = "Sari …….(Main) Hape";
        que2.answer = "Dolanan";
        questionList.add(que2);

        FillTextQuestion que3 = new FillTextQuestion();
        que3.id = 3;
        que3.question = "Basuki …….(Beli) Sapi";
        que3.answer = "Tuku";
        questionList.add(que3);

        FillTextQuestion que4 = new FillTextQuestion();
        que4.id = 4;
        que4.question = "Sulastri …….(Mengambil) Duwek";
        que4.answer = "Njupuk";
        questionList.add(que4);

        FillTextQuestion que5 = new FillTextQuestion();
        que5.id = 5;
        que5.question = "Pak dhe ……(Membuat) Kopi";
        que5.answer = "Nggawe";
        questionList.add(que5);

        FillTextQuestion que6 = new FillTextQuestion();
        que6.id = 6;
        que6.question = "Fikri ……..(Membersihkan) Radio";
        que6.answer = "Ngeresiki";
        questionList.add(que6);

        FillTextQuestion que7 = new FillTextQuestion();
        que7.id = 7;
        que7.question = "Bapak ……(Menyalakan) Tipi";
        que7.answer = "Nguripi";
        questionList.add(que7);

        FillTextQuestion que8 = new FillTextQuestion();
        que8.id = 8;
        que8.question = "Indri ……..(Mencuri) Roti";
        que8.answer = "Nyolong";
        questionList.add(que8);

        FillTextQuestion que9 = new FillTextQuestion();
        que9.id = 9;
        que9.question = "Tari …….(Memasak) Nasi";
        que9.answer = "Masak";
        questionList.add(que9);

        FillTextQuestion que10 = new FillTextQuestion();
        que10.id = 10;
        que10.question = "Dendi ……(Menanam) Pari";
        que10.answer = "Nandur";
        questionList.add(que10);

        return questionList;
    }
}
