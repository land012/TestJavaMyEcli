package com.hispeed.producerConsumer.nodistinct;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

/**
 * 
 * ������ȥ�ع��ܵ�������-������ģʽ �����߳�����
 * @author liyong
 */

public abstract class NoDistinctProducer<T> implements Runnable {
	
	private static final Logger alert = Logger.getLogger("alert");
	private static final Logger msg = Logger.getLogger("thread");
	private static final Logger err = Logger.getLogger("thread_error");
	
	private String producerid;
	private BlockingQueue<T> queue;
	private long noProductIdletimes;
	private long hasProductIdletimes;
	public final void run() {
		try{
			while(!Thread.interrupted()){
				//��ȡ����
				List<T> list = getProducts();
				
				if(list!=null&&list.size()>0){
					//�����鵽��listȫ���ŵ�������
					msg.debug("������"+producerid+" �ѻ����Դlist size="+list.size());
					for(T t:list){
						queue.put(t);
						msg.debug("������"+producerid+" ����Դ"+getObjectKeyId(t)+"�������");
					}
					msg.debug("������"+producerid+"����������,����"+hasProductIdletimes+"����");
					Thread.sleep(hasProductIdletimes);
				}else{
					msg.debug("������"+producerid+" û�л����Դlist,����"+noProductIdletimes+"����");
					Thread.sleep(noProductIdletimes);
				}
			}
		}catch (Exception e) {
			err.info("",e);
		}

	}
	

	//��ȡ��Դlist���󷽷�
	public abstract List<T> getProducts();
	public abstract String getObjectKeyId(T t);


	public void setProducerid(String producerid) {
		this.producerid = producerid;
	}


	public void setQueue(BlockingQueue<T> queue) {
		this.queue = queue;
	}


	public void setNoProductIdletimes(long noProductIdletimes) {
		this.noProductIdletimes = noProductIdletimes;
	}
	
	public void setHasProductIdletimes(long hasProductIdletimes) {
		this.hasProductIdletimes = hasProductIdletimes;
	}
}
