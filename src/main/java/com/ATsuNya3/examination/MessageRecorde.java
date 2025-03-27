package com.ATsuNya3.examination;

public class MessageRecorde {
    private static String lastMessage = "";

    public static void recordMessage(String message) {
        lastMessage = message;
    }

    public static String getLastMessage() {
        return lastMessage;
    }
}
