package com.example.nusabasa.jv;

import android.os.Parcel;
import android.os.Parcelable;

public class AksaraJawaQuestion implements Parcelable {
    int id;
    int aksara;
    String optionOne;
    String optionTwo;
    String optionThree;

    public AksaraJawaQuestion() {

    }

    protected AksaraJawaQuestion(Parcel in) {
        id = in.readInt();
        aksara = in.readInt();
        optionOne = in.readString();
        optionTwo = in.readString();
        optionThree = in.readString();
        correctAnswer = in.readInt();
    }

    public static final Creator<AksaraJawaQuestion> CREATOR = new Creator<AksaraJawaQuestion>() {
        @Override
        public AksaraJawaQuestion createFromParcel(Parcel in) {
            return new AksaraJawaQuestion(in);
        }

        @Override
        public AksaraJawaQuestion[] newArray(int size) {
            return new AksaraJawaQuestion[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAksara() {
        return aksara;
    }

    public void setAksara(int aksara) {
        this.aksara = aksara;
    }

    public String getOptionOne() {
        return optionOne;
    }

    public void setOptionOne(String optionOne) {
        this.optionOne = optionOne;
    }

    public String getOptionTwo() {
        return optionTwo;
    }

    public void setOptionTwo(String optionTwo) {
        this.optionTwo = optionTwo;
    }

    public String getOptionThree() {
        return optionThree;
    }

    public void setOptionThree(String optionThree) {
        this.optionThree = optionThree;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    int correctAnswer;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(aksara);
        dest.writeString(optionOne);
        dest.writeString(optionTwo);
        dest.writeString(optionThree);
        dest.writeInt(correctAnswer);
    }
}
