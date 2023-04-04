package org.example.custom_exceptions;

public class PlayersExceedLimit extends Exception {
    public PlayersExceedLimit(String message){
        super(message);
    }
}
