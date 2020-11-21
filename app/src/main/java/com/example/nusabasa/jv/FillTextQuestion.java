package com.example.nusabasa.jv;

import android.os.Parcel;
import android.os.Parcelable;

public class FillTextQuestion implements Parcelable {
    int id;
    String question;
    String answer;


    protected FillTextQuestion(Parcel in) {
        id = in.readInt();
        question = in.readString();
        answer = in.readString();
    }
    public FillTextQuestion() {

    }

    public static final Creator<FillTextQuestion> CREATOR = new Creator<FillTextQuestion>() {
        @Override
        public FillTextQuestion createFromParcel(Parcel in) {
            return new FillTextQuestion(in);
        }

        @Override
        public FillTextQuestion[] newArray(int size) {
            return new FillTextQuestion[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(question);
        dest.writeString(answer);
    }
}
