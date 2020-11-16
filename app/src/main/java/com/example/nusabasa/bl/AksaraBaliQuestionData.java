package com.example.nusabasa.bl;

import com.example.nusabasa.R;
import com.example.nusabasa.bl.AksaraBaliQuestion;

import java.util.ArrayList;

public class AksaraBaliQuestionData {
    public static String TOTAL_QUESTION = "total_question";
    public static String CORRECT_ANSWERS = "correct_answers";

    public static ArrayList<AksaraBaliQuestion> getAksaraQuestion() {
        ArrayList<AksaraBaliQuestion> questionList = new ArrayList<>();

        AksaraBaliQuestion que1 = new AksaraBaliQuestion();
        que1.id = 1;
        que1.aksara = R.drawable.aksara_bali_1;
        que1.optionOne = "Ta";
        que1.optionTwo = "Ka";
        que1.optionThree = "Ga";
        que1.correctAnswer = 2;
        questionList.add(que1);

        AksaraBaliQuestion que2 = new AksaraBaliQuestion();
        que2.id = 1;
        que2.aksara = R.drawable.aksara_bali_2;
        que2.optionOne = "Sa";
        que2.optionTwo = "Na";
        que2.optionThree = "Ra";
        que2.correctAnswer = 2;
        questionList.add(que2);

        AksaraBaliQuestion que3 = new AksaraBaliQuestion();
        que3.id = 1;
        que3.aksara = R.drawable.aksara_bali_3;
        que3.optionOne = "Li";
        que3.optionTwo = "Ki";
        que3.optionThree = "Ji";
        que3.correctAnswer = 3;
        questionList.add(que3);

        AksaraBaliQuestion que4 = new AksaraBaliQuestion();
        que4.id = 1;
        que4.aksara = R.drawable.aksara_bali_4;
        que4.optionOne = "Gi";
        que4.optionTwo = "Ji";
        que4.optionThree = "Di";
        que4.correctAnswer = 1;
        questionList.add(que4);

        AksaraBaliQuestion que5 = new AksaraBaliQuestion();
        que5.id = 1;
        que5.aksara = R.drawable.aksara_bali_5;
        que5.optionOne = "Ru";
        que5.optionTwo = "Hu";
        que5.optionThree = "Nu";
        que5.correctAnswer = 2;
        questionList.add(que5);

        AksaraBaliQuestion que6 = new AksaraBaliQuestion();
        que6.id = 1;
        que6.aksara = R.drawable.aksara_bali_6;
        que6.optionOne = "Yu";
        que6.optionTwo = "Gu";
        que6.optionThree = "Du";
        que6.correctAnswer = 3;
        questionList.add(que6);

        AksaraBaliQuestion que7 = new AksaraBaliQuestion();
        que7.id = 1;
        que7.aksara = R.drawable.aksara_bali_7;
        que7.optionOne = "Ne";
        que7.optionTwo = "Ke";
        que7.optionThree = "Me";
        que7.correctAnswer = 2;
        questionList.add(que7);

        AksaraBaliQuestion que8 = new AksaraBaliQuestion();
        que8.id = 1;
        que8.aksara = R.drawable.aksara_bali_8;
        que8.optionOne = "We";
        que8.optionTwo = "Ce";
        que8.optionThree = "Ke";
        que8.correctAnswer = 2;
        questionList.add(que8);

        AksaraBaliQuestion que9 = new AksaraBaliQuestion();
        que9.id = 1;
        que9.aksara = R.drawable.aksara_bali_9;
        que9.optionOne = "Do";
        que9.optionTwo = "Ko";
        que9.optionThree = "Jo";
        que9.correctAnswer = 1;
        questionList.add(que9);

        AksaraBaliQuestion que10 = new AksaraBaliQuestion();
        que10.id = 1;
        que10.aksara = R.drawable.aksara_bali_10;
        que10.optionOne = "Mo";
        que10.optionTwo = "Ko";
        que10.optionThree = "To";
        que10.correctAnswer = 1;
        questionList.add(que10);
        
        return questionList;
    }

    public static ArrayList<AksaraBaliQuestion> getAksaraQuestion2() {
        ArrayList<AksaraBaliQuestion> questionList = new ArrayList<>();

        AksaraBaliQuestion que1 = new AksaraBaliQuestion();
        que1.id = 1;
        que1.aksara = R.drawable.aksara_bali_11;
        que1.optionOne = "Ngajeng";
        que1.optionTwo = "Nejeng";
        que1.optionThree = "Majeng";
        que1.correctAnswer = 1;
        questionList.add(que1);

        AksaraBaliQuestion que2 = new AksaraBaliQuestion();
        que2.id = 1;
        que2.aksara = R.drawable.aksara_bali_12;
        que2.optionOne = "Anjus";
        que2.optionTwo = "Mandus";
        que2.optionThree = "Manjus";
        que2.correctAnswer = 3;
        questionList.add(que2);

        AksaraBaliQuestion que3 = new AksaraBaliQuestion();
        que3.id = 1;
        que3.aksara = R.drawable.aksara_bali_13;
        que3.optionOne = "Jaken";
        que3.optionTwo = "Taken";
        que3.optionThree = "Takon";
        que3.correctAnswer = 2;
        questionList.add(que3);

        AksaraBaliQuestion que4 = new AksaraBaliQuestion();
        que4.id = 1;
        que4.aksara = R.drawable.aksara_bali_14;
        que4.optionOne = "Bunga";
        que4.optionTwo = "Kunga";
        que4.optionThree = "Lunga";
        que4.correctAnswer = 3;
        questionList.add(que4);

        AksaraBaliQuestion que5 = new AksaraBaliQuestion();
        que5.id = 1;
        que5.aksara = R.drawable.aksara_bali_15;
        que5.optionOne = "Nginum";
        que5.optionTwo = "Nginem";
        que5.optionThree = "Kinem";
        que5.correctAnswer = 2;
        questionList.add(que5);

        AksaraBaliQuestion que6 = new AksaraBaliQuestion();
        que6.id = 1;
        que6.aksara = R.drawable.aksara_bali_16;
        que6.optionOne = "Bali";
        que6.optionTwo = "Pali";
        que6.optionThree = "Baji";
        que6.correctAnswer = 1;
        questionList.add(que6);

        AksaraBaliQuestion que7 = new AksaraBaliQuestion();
        que7.id = 1;
        que7.aksara = R.drawable.aksara_bali_17;
        que7.optionOne = "Barna";
        que7.optionTwo = "Karna";
        que7.optionThree = "Narta";
        que7.correctAnswer = 2;
        questionList.add(que7);

        AksaraBaliQuestion que8 = new AksaraBaliQuestion();
        que8.id = 1;
        que8.aksara = R.drawable.aksara_bali_18;
        que8.optionOne = "Bit";
        que8.optionTwo = "Pit";
        que8.optionThree = "Lin";
        que8.correctAnswer = 2;
        questionList.add(que8);

        AksaraBaliQuestion que9 = new AksaraBaliQuestion();
        que9.id = 1;
        que9.aksara = R.drawable.aksara_bali_19;
        que9.optionOne = "Duluk";
        que9.optionTwo = "Bulub";
        que9.optionThree = "Kuluk";
        que9.correctAnswer = 3;
        questionList.add(que9);

        AksaraBaliQuestion que10 = new AksaraBaliQuestion();
        que10.id = 1;
        que10.aksara = R.drawable.aksara_bali_20;
        que10.optionOne = "Lanang";
        que10.optionTwo = "Danang";
        que10.optionThree = "Manang";
        que10.correctAnswer = 1;
        questionList.add(que10);

        return questionList;
    }

    public static ArrayList<AksaraBaliQuestion> getAksaraQuestion3() {
        ArrayList<AksaraBaliQuestion> questionList = new ArrayList<>();

        AksaraBaliQuestion que1 = new AksaraBaliQuestion();
        que1.id = 1;
        que1.aksara = R.drawable.aksara_bali_21;
        que1.optionOne = "Tiang mejalan";
        que1.optionTwo = "Kiang bejalan";
        que1.optionThree = "Tiang mekaran";
        que1.correctAnswer = 1;
        questionList.add(que1);

        AksaraBaliQuestion que2 = new AksaraBaliQuestion();
        que2.id = 1;
        que2.aksara = R.drawable.aksara_bali_22;
        que2.optionOne = "Bai biang";
        que2.optionTwo = "Cai liang";
        que2.optionThree = "Cai ilang";
        que2.correctAnswer = 2;
        questionList.add(que2);

        AksaraBaliQuestion que3 = new AksaraBaliQuestion();
        que3.id = 1;
        que3.aksara = R.drawable.aksara_bali_23;
        que3.optionOne = "Kadek getaken";
        que3.optionTwo = "Badek ketakon";
        que3.optionThree = "Kadek metaken";
        que3.correctAnswer = 3;
        questionList.add(que3);

        AksaraBaliQuestion que4 = new AksaraBaliQuestion();
        que4.id = 1;
        que4.aksara = R.drawable.aksara_bali_24;
        que4.optionOne = "Sitra ngawang";
        que4.optionTwo = "Kitra mawang";
        que4.optionThree = "Citra nawang";
        que4.correctAnswer = 3;
        questionList.add(que4);

        AksaraBaliQuestion que5 = new AksaraBaliQuestion();
        que5.id = 1;
        que5.aksara = R.drawable.aksara_bali_25;
        que5.optionOne = "Cai ningal";
        que5.optionTwo = "Cai mingal";
        que5.optionThree = "Dai singal";
        que5.correctAnswer = 1;
        questionList.add(que5);

        AksaraBaliQuestion que6 = new AksaraBaliQuestion();
        que6.id = 1;
        que6.aksara = R.drawable.aksara_bali_26;
        que6.optionOne = "Biang nginum ceh";
        que6.optionTwo = "Tiang nginem teh";
        que6.optionThree = "Tiang nginem yeh";
        que6.correctAnswer = 2;
        questionList.add(que6);

        AksaraBaliQuestion que7 = new AksaraBaliQuestion();
        que7.id = 1;
        que7.aksara = R.drawable.aksara_bali_27;
        que7.optionOne = "Nyoman lunga ke Denpasar";
        que7.optionTwo = "Nyoman kesah ke Singaraja";
        que7.optionThree = "Nyoman miteken ka Denpasar";
        que7.correctAnswer = 1;
        questionList.add(que7);

        AksaraBaliQuestion que8 = new AksaraBaliQuestion();
        que8.id = 1;
        que8.aksara = R.drawable.aksara_bali_28;
        que8.optionOne = "Ketut nawang kuwit";
        que8.optionTwo = "Ketut ngawang duit";
        que8.optionThree = "Ketut ngemaang duwit";
        que8.correctAnswer = 3;
        questionList.add(que8);

        AksaraBaliQuestion que9 = new AksaraBaliQuestion();
        que9.id = 1;
        que9.aksara = R.drawable.aksara_bali_29;
        que9.optionOne = "Cai melalian gamelan";
        que9.optionTwo = "Cai meplalian gamelan";
        que9.optionThree = "Bai ngelalaian damelan";
        que9.correctAnswer = 2;
        questionList.add(que9);

        AksaraBaliQuestion que10 = new AksaraBaliQuestion();
        que10.id = 1;
        que10.aksara = R.drawable.aksara_bali_30;
        que10.optionOne = "Tiang majeng ge";
        que10.optionTwo = "Biang majeng ge";
        que10.optionThree = "Tiang ngajeng be";
        que10.correctAnswer = 3;
        questionList.add(que10);

        return questionList;
    }
}
