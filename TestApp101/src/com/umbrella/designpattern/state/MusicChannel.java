package com.umbrella.designpattern.state;

public class MusicChannel implements Channel {

	@Override
	public void show() {
		System.out.println("音乐频道正在播放...");
	}

}
