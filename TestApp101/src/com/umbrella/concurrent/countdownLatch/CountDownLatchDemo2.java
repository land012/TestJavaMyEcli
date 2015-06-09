package com.umbrella.concurrent.countdownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

public class CountDownLatchDemo2 {
	
	private static Logger log = Logger.getLogger(CountDownLatchDemo2.class);
	
	private static final int PLAYER_NUM = 3;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountDownLatch begin = new CountDownLatch(1);
		CountDownLatch end = new CountDownLatch(PLAYER_NUM);
		ExecutorService exec = Executors.newFixedThreadPool(PLAYER_NUM);
		Player[] players = new Player[PLAYER_NUM];
		
		try {
			for(int i=0; i<players.length; i++) {
				players[i] = new Player(i, begin, end);
				exec.execute(players[i]);
			}
			
			log.info("Race begin!");
			begin.countDown(); // 同时起跑
			
			end.await(); // 等待所有人跑完
			log.info("Race end!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			exec.shutdown();
		}
	}
	
	static class Player implements Runnable {
		
		int id;
		CountDownLatch begin;
		CountDownLatch end;

		public Player(int id, CountDownLatch begin, CountDownLatch end) {
			this.id = id;
			this.begin = begin;
			this.end = end;
		}

		@Override
		public void run() {
			try {
				begin.await();
				long period = (long)(Math.random() * 1000);
				Thread.sleep(period);
				log.info("player-" + id + " arrived! elapse " + period + "ms.");
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} finally {
				end.countDown();
			}
		}
	}

}
