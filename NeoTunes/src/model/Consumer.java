package model;

import java.time.LocalDate;

public abstract class Consumer {

    private String nickname;
    private String id;
    private LocalDate date;

    public Consumer(String nickname, String id, LocalDate date) {
        this.nickname = nickname;
        this.id = id;
        this.date = date;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Consumer: " +
                "\nNickname: " + nickname +
                "\nID: " + id +
                "\nDate: " + date;
    }
}
