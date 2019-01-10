package com.jpm.socket;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

public class MessageDecoder implements Decoder.Text<Message>{
	private Gson gson = new Gson();
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Message decode(String json) throws DecodeException {
		// TODO Auto-generated method stub
		return gson.fromJson(json, Message.class);
	}

	@Override
	public boolean willDecode(String arg0) {
		// TODO Auto-generated method stub
		return arg0!=null;
	}	
}
