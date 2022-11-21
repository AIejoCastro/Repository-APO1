package model;

import java.util.ArrayList;

public class PlayList {

    private String name;
    private ArrayList<Audio> audios;
    private String code;

    public PlayList(String name) {
        this.name = name;
        this.audios = new ArrayList<Audio>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Audio> getAudios() {
        return audios;
    }

    public void setAudios(ArrayList<Audio> audios) {
        this.audios = audios;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "PlayList: " +
                "\nName: " + name +
                "\nAudios: " + audios +
                "\nCode: " + code;
    }

    public boolean addAudio(Audio audio) {
        return audios.add(audio);
    }

    public boolean deleteAudio(Audio audio) {
        for (int i = 0; i < audios.size(); i++) {
            if (audio.getName().equalsIgnoreCase(audios.get(i).getName())) {
                return audios.remove(audios.get(i));
            }
        }
        return false;
    }

    public String reproduceAudio(String audioName) {
        for (int i = 0; i < audios.size(); i++) {
            if (audioName.equalsIgnoreCase(audios.get(i).getName())) {
                audios.get(i).setReproductions(audios.get(i).getReproductions() + 1);
                return audios.get(i).getName();
            }
        }
        return "";
    }

}
