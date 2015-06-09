package com.hispeed.producerConsumer.distinct;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.hispeed.producerConsumer.util.LRULinkedHashMap;

/**
 * 
 * ������ȥ�ع��ܵ�������-������ģʽ �����߳�����
 * @author liyong
 */

public abstract class DistinctConsumer<T> implements Runnable {
	
	private static final Logger alert = Logger.getLogger("alert");
	private static final Logger msg = Logger.getLogger("thread");
	private static final Logger err = Logger.getLogger("thread_error");
	
	private String consumerid;
	private BlockingQueue<T> queue;
	//�����е���Դ�б�
	private ConcurrentHashMap<String,Long> dealingmap;
	//���ط�����Դ�б�
	private BlockingQueue<T> reofferqueue;
	//����ɹ�����Դ�б�
	private LRULinkedHashMap<String, Long> succmap;
	
	private boolean isNeedReOffer;//����ʧ���Ƿ���Ҫ���²�����б�ʶ
	
	
	public final void run() {
		try{
			while(!Thread.interrupted()){
				//�Ӷ����л�ȡ��Դ�����Ӷ����Ƴ�����Դ
				T t = queue.take();
				
				msg.debug("������"+consumerid+"��ȡ����������Դ"+getObjectKeyId(t));
				boolean consumeresult = false;
				try{
					consumeresult = consume(t);
				}catch (Exception e) {
					err.info("",e);
				}
				if(consumeresult){
					//������ѳɹ��������,��ӵ��ѳɹ����У������Ѵ��ڵ���Դ�б���ɾ��
					succmap.put(getObjectKeyId(t), System.currentTimeMillis());
					dealingmap.remove(getObjectKeyId(t));
					msg.debug("������"+consumerid+"���"+getObjectKeyId(t)+"����");
				}else{
					//���Ѳ��ɹ�ʱ
					if(isNeedReOffer){
						//��Ҫ���²�����б�ʶʱ�������¼�����еȴ�����
						//�˴�����ȡ�����ȴ���ʽ����Ϊ���ܲ�������������������һ����Ҫ����offer��Map,��Map����һ�̸߳���reoffer
						reofferqueue.put(t);
						err.debug("������"+consumerid+"δ���"+getObjectKeyId(t)+"����,����Դ����reoffer����");
						
					}else{
						//����Ҫ���²�����б�ʶʱ���Ӵ��ڵ���Դ�б���ɾ��
						dealingmap.remove(getObjectKeyId(t));
						err.debug("������"+consumerid+"δ���"+getObjectKeyId(t)+"����,�Ӵ��ڵ���Դ�б���ɾ��");
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


	public void setDealingmap(ConcurrentHashMap<String, Long> dealingmap) {
		this.dealingmap = dealingmap;
	}

	public void setReofferqueue(BlockingQueue<T> reofferqueue) {
		this.reofferqueue = reofferqueue;
	}


	public void setNeedReOffer(boolean isNeedReOffer) {
		this.isNeedReOffer = isNeedReOffer;
	}


	public void setSuccmap(LRULinkedHashMap<String, Long> succmap) {
		this.succmap = succmap;
	}

}
