package br.unicap.programacao_paralela.dtos;

import java.io.Serializable;

public class ChatMessageDto implements Serializable {
    private String _destine;
    private int _hour;
    private String _message;
    private int _minutes;
    private float _seconds;

    public ChatMessageDto() {}

    public String getDestine() {
        return _destine;
    }

    public int getHour() {
        return _hour;
    }

    public String getMessage() {
        return _message;
    }

    public int getMinutes() {
        return _minutes;
    }

    public float getSeconds() {
        return _seconds;
    }

    public void setDestine(String destine) {
        _destine = destine;
    }

    public void setHour(int hour) {
        _hour = hour;
    }

    public void setMessage(String message) {
        _message = message;
    }

    public void setMinutes(int minutes) {
        _minutes = minutes;
    }

    public void setSeconds(float seconds) {
        _seconds = seconds;
    }
}
