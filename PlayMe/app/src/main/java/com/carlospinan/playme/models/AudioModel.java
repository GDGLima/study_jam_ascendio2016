package com.carlospinan.playme.models;

import java.io.Serializable;

/**
 * @author Carlos Piñan
 */
public class AudioModel implements Serializable {

    private String audio;
    private String description;
    private String title;
    private String bitmap;

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBitmap() {
        return bitmap;
    }

    public void setBitmap(String bitmap) {
        this.bitmap = bitmap;
    }
}
