package com.jpm.socket;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

// http://localhost:8081/WebSocket020_Alert/index.html
@ServerEndpoint(value = "/cricketScore", decoders = MessageDecoder.class, encoders = MessageEncoder.class)
public class PushMessage {
	
	@OnMessage
    public void onMessage(String message, final Session session) {
		
        System.out.println("Control in onMessage()");
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
            	int random = (int)(Math.random() * 1000);
                try {
                	System.out.println("Random: " + random);
                	System.out.println(session.getId());
                	Message msg = new Message();
                	msg.setNumber(random);
                    session.getBasicRemote().sendObject(msg);
                } catch (IOException ex) {
                    Logger.getLogger(PushMessage.class.getName()).log(Level.SEVERE, null, ex);
                } catch (EncodeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        };
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 3 * 1000);
    }
	
	@OnOpen
	public void open(Session session)
			throws IOException {
		System.out.println("Socket opened at server side.");
	}
}
