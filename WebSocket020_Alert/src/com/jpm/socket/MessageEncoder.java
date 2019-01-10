package com.jpm.socket;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

public class MessageEncoder implements Encoder.Text<Message> {
	
	private Gson gson = new Gson();
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String encode(Message msg) throws EncodeException {
		// TODO Auto-generated method stub
		return gson.toJson(msg);
	}
	
}
