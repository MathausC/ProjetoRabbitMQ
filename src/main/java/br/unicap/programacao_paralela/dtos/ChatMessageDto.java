package br.unicap.programacao_paralela.dtos;

import java.io.Serializable;

public class ChatMessageDto implements Serializable {
    public String message;
    public int hour;
    public int minutes;
    public float seconds;
    public String destine;
}
