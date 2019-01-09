package com.jpm.socket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.*;
import javax.websocket.server.*;

@ServerEndpoint(value = "/chat/{username}", decoders = MessageDecoder.class, encoders = MessageEncoder.class)
public class ChatEndpoint {
	
	private Session session;
	private static Set<ChatEndpoint> chatEndpoints = new CopyOnWriteArraySet<>();
	private static HashMap<String, String> users = new HashMap<>();

	@OnOpen
	public void open(Session session, @PathParam("username") String user)
			throws IOException {
		this.session = session;  // Container creates a Websocket session.
		chatEndpoints.add(this); 
		users.put(session.getId(), user);
		Message message = new Message();
		message.setFrom(user);
		message.setText("Connected!");
		broadcast(message);
	}

	@OnMessage
	public void onMessage(Session session, Message message) throws IOException {
		message.setFrom(message.getFrom());
		System.out.println("Got message " + message.getText());
		broadcast(message);
	}

	@OnClose
	public void close(Session session) {
		chatEndpoints.remove(this);
		Message message = new Message();
		message.setFrom(users.get(session.getId()));
		message.setText("Disconnected!");
		broadcast(message);
	}

	private static void broadcast(Message message) {
		for (ChatEndpoint endpoint : chatEndpoints) {
			synchronized (endpoint) {
				try {
					endpoint.session.getBasicRemote().sendObject(message);
				} catch (IOException | EncodeException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
