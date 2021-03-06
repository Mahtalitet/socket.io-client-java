package io.socket.client.executions;

import io.socket.emitter.Emitter;
import io.socket.client.IO;
import io.socket.client.Socket;

import java.net.URISyntaxException;

public class ImmediateClose {

    public static void main(String[] args) throws URISyntaxException {
        IO.Options options = new IO.Options();
        options.forceNew = true;
        final Socket socket = IO.socket("http://localhost:" + System.getenv("PORT"), options);
        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                System.out.println("connect");
            }
        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                System.out.println("disconnect");
            }
        });
        socket.connect();
        socket.disconnect();
    }
}
