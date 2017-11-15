package top.cuihp.autobahnwebsocket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.crossbar.autobahn.websocket.WebSocketConnection;
import io.crossbar.autobahn.websocket.WebSocketConnectionHandler;
import io.crossbar.autobahn.websocket.exceptions.WebSocketException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebSocketConnection webSocketConnection = new WebSocketConnection();
        try {
            webSocketConnection.connect("ws://app.app.cc/", new WebSocketConnectionHandler() {
                @Override
                public void onOpen() {
                    Log.d(TAG, "onOpen");
                }

                @Override
                public void onMessage(String payload) {
                    Log.d(TAG, payload);
                }

                @Override
                public void onClose(int code, String reason) {
                    Log.d(TAG, code + ":" + reason);
                }
            });
        } catch (WebSocketException e) {
            e.printStackTrace();
        }
    }
}
