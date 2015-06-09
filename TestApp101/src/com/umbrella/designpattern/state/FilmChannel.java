package com.umbrella.designpattern.state;

public class FilmChannel implements Channel {

	@Override
	public void show() {
		System.out.println("电影频道正在播放...");
	}

}
