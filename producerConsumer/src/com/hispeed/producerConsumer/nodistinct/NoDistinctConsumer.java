package com.hispeed.producerConsumer.nodistinct;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

/**
 * 
 * ������ȥ�ع��ܵ�������-������ģʽ �����߳�����
 * @author liyong
 */

public abstract class NoDistinctConsumer<T> implements Runnable {
	
	private static final Logger alert = Logger.getLogger("alert");
	private static final Logger msg = Logger.getLogger("thread");
	private static final Logger err = Logger.getLogger("thread_error");
	
	private String consumerid;
	private BlockingQueue<T> queue;

	//���ط�����Դ�б�
	private BlockingQueue<T> reofferqueue;
	
	private boolean isNeedReOffer;//����ʧ���Ƿ���Ҫ���²�����б�ʶ
	
	
	public final void run() {
		try{
			while(!Thread.interrupted()){
				//�Ӷ����л�ȡ��Դ�����Ӷ����Ƴ�����Դ
				T t = queue.take();
				if(t ==null){
					msg.debug("������"+consumerid+"û�л�ȡ����������Դ");
					continue;
				}
				if(consume(t)){
					//������ѳɹ��������
					msg.debug("������"+consumerid+"���"+getObjectKeyId(t)+"����");
				}else{
					//���Ѳ��ɹ�ʱ
					if(isNeedReOffer){
						//��Ҫ���²�����б�ʶʱ�������¼�����еȴ�����
						//�˴�����ȡ�����ȴ���ʽ����Ϊ���ܲ�������������������һ����Ҫ����offer��Map,��Map����һ�̸߳���reoffer
						reofferqueue.put(t);
						err.info("������"+consumerid+"δ���"+getObjectKeyId(t)+"����,����Դ����reoffer����");
						
					}else{
						//����Ҫ���²�����б�ʶʱ���Ӵ��ڵ���Դ�б���ɾ��
						err.info("������"+consumerid+"δ���"+getObjectKeyId(t)+"����,�Ӵ��ڵ���Դ�б���ɾ��");
					}
				}
			}
		}catch (Exception e) {
			err.info("",e);
		}

	}
	
	
	//���ѳ��󷽷�
	public abstract boolean consume(T t);
	
	public abstract String getObjectKeyId(T t);


	public void setConsumerid(String consumerid) {
		this.consumerid = consumerid;
	}


	public void setQueue(BlockingQueue<T> queue) {
		this.queue = queue;
	}




	public void setReofferqueue(BlockingQueue<T> reofferqueue) {
		this.reofferqueue = reofferqueue;
	}


	public void setNeedReOffer(boolean isNeedReOffer) {
		this.isNeedReOffer = isNeedReOffer;
	}
	
	

}
