package me.jezza.oc.api.network.exceptions;

public class NetworkRemoveException extends NetworkException {
    public NetworkRemoveException(String message, Object... data) {
        super(message, data);
    }
}
