package net.wustudio.codezone;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScoreData {
    private String rank;
    private String username;
    private int score;
    private String created;

    public ScoreData(String rank, String username, int score) {
        this.rank = rank;
        this.username = username;
        this.score = score;
        this.created = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }

    public ScoreData(String rank, String username, int score, String created) {
        this.rank = rank;
        this.username = username;
        this.score = score;
        this.created = created;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
