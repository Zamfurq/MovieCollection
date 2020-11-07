package com.example.nusabasa;

import java.util.ArrayList;

public class AchievementData {
    private static String[] achievementName = {"Saprapat Dalan",
    "Setengah Dalan",
    "Telung Prapat Dalan",
    "Sampun Sinau",
    "Seperempat Jalan",
    "Setengah Jalan",
    "Tiga perempat Jalan",
    "Sudah Belajar"
    };

    private static int[] achievementIcon = {
            R.drawable.javanese_1,
            R.drawable.javanese_2,
            R.drawable.javanese_3,
            R.drawable.javanese_4,
            R.drawable.balinese_1,
            R.drawable.balinese_2,
            R.drawable.balinese_3,
            R.drawable.balinese_4
    };

    private static String[] achievementdescription = {
            "Kamu telah menyelesaikan 25% pelajaran Bahasa Jawa",
    "Kamu telah menyelesaikan 50% pelajaran Bahasa Jawa",
    "Kamu telah menyelesaikan 75% pelajaran Bahasa Jawa",
    "Kamu telah menyelesaikan 100% pelajaran Bahasa Jawa",
    "Kamu telah menyelesaikan 25% pelajaran Bahasa Bali",
    "Kamu telah menyelesaikan 50% pelajaran Bahasa Bali",
    "Kamu telah menyelesaikan 75% pelajaran Bahasa Bali",
    "Kamu telah menyelesaikan 100% pelajaran Bahasa Bali"
    };

    static ArrayList<Achievement> getListData() {
        ArrayList<Achievement> achievements = new ArrayList<>();
        for (int position = 0; position < achievementName.length; position++){
            Achievement achievement = new Achievement();
            achievement.setName(achievementName[position]);
            achievement.setIcon(achievementIcon[position]);
            achievement.setDescription(achievementdescription[position]);
            achievements.add(achievement);
        }
        return achievements;
    }
}
