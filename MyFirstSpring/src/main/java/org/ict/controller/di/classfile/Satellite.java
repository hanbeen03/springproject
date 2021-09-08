package org.ict.controller.di.classfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Satellite {

	private Broadcast broadcast;
	
	@Autowired
	public Satellite(Broadcast broadcast) {
		this.broadcast = broadcast;
	}
	
	public void satelliteBroadcast() {
		System.out.print("������� ");
		broadcast.broadcast();
	}
	
	
}
