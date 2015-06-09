package com.umbrella.designpattern.state;

import java.util.ArrayList;
import java.util.List;

public class Television {
	private Channel currentChannel; // ��ǰƵ��
	private List<Channel> channels; // Ƶ���б�
	
	public Television(Channel currentChannel) {
		this.currentChannel = currentChannel;
		channels = new ArrayList<Channel>();
		this.channels.add(currentChannel);
	}
	
	public void showVision() {
		currentChannel.show();
	}
	
	public void prev() {
		int cur = channels.indexOf(this.currentChannel);
		if(cur==0) {
			this.currentChannel = channels.get(this.channels.size()-1);
		} else {
			this.currentChannel = channels.get(cur-1);
		}
	}
	
	public void next() {
		int cur = channels.indexOf(this.currentChannel);
		if(cur==this.channels.size()-1) {
			this.currentChannel = channels.get(0);
		} else {
			this.currentChannel = channels.get(cur+1);
		}
	}
	
	public void addChannel(Channel channel) {
		this.channels.add(channel);
	}
}
