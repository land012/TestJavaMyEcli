package com.umbrella.designpattern.state;
/**
 * ×´Ì¬Ä£Ê½
 * @author ´óÖÞ
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Channel c1 = new SportsChannel();
		Channel c2 = new MusicChannel();
		Channel c3 = new FilmChannel();
		Television tv = new Television(c1);
		tv.addChannel(c2);
		tv.addChannel(c3);
		
		tv.showVision();
		
		for(int i=0; i<6; i++) {
			int j = (int)(Math.random() * 100);
			System.out.println(j);
			if(j%2==0) {
				tv.prev();
				tv.showVision();
			} else {
				tv.next();
				tv.showVision();
			}
		}
	}
}
