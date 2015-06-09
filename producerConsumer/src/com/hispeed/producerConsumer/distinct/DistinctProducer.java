package com.hispeed.producerConsumer.distinct;

import java.util.List;
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

public abstract class DistinctProducer<T> implements Runnable {
	
	private static final Logger alert = Logger.getLogger("alert");
	private static final Logger msg = Logger.getLogger("thread");
	private static final Logger err = Logger.getLogger("thread_error");
	
	private String producerid;
	private BlockingQueue<T> queue;
	
	//�����е���Դ�б�
	private ConcurrentHashMap<String,Long> dealingmap;
	//����ɹ�����Դ�б�
	private LRULinkedHashMap<String, Long> succmap;
	
	private long noProductIdletimes;
	private long hasProductIdletimes;
	
	private long succtimeProtecttimes;
	public final void run() {
		try{
			while(!Thread.interrupted()){
				//��ȡ����
				List<T> list = getProducts();
				
				if(list!=null&&list.size()>0){
					Long currentTime = System.currentTimeMillis();
					//�����鵽��listȫ���ŵ�������
					msg.debug("������"+producerid+" �ѻ����Դlist size="+list.size());
					for(T t:list){	
						//��ȡ��Դ������id����ǰʱ�䣬����ConcurrentHashMap��putIfAbsent�������������ֵ�뵱ǰʱ�䲻һ�£���ʾ֮ǰ�Ѵ��ڸ���Դ�����������Դ
						String objectKeyId = getObjectKeyId(t);
						Long puttime = dealingmap.putIfAbsent(objectKeyId,currentTime);
						if(puttime!=null){
							//����ֵ����ȣ���ʾ֮ǰ�Ѵ��ڸ���Դ�����������Դ
							msg.debug("��Դ"+objectKeyId+"���ڴ�����,��������Դ������ѭ�� puttime="+puttime+" currentTime="+currentTime);
							continue;
						}
						Long succtime = succmap.get(objectKeyId);
						if(succtime!=null){
							//��������ڳɹ����У���Ƚ�ʱ��,�����ȡ��Դ��ʱ��С�ڵ��ڳɹ���ʱ�䣬˵������Ϣ�ѹ�ȥ��������,�����ȡ��Դ��ʱ����ڳɹ���ʱ�䣬���ʾ��Դ��Ҫ����
							if(currentTime<=succtime+succtimeProtecttimes){
								msg.debug("��Դ"+objectKeyId+"�ѳɹ�,��������Դ������ѭ�� succtime="+succtime+" currentTime="+currentTime);
								//ɾ��dealingmap�еĻ���
								dealingmap.remove(objectKeyId);
								continue;
							}else{
								succmap.remove(objectKeyId);
								msg.info("��Դ"+objectKeyId+"�ѳɹ�,����ȡ��Դ��ʱ����ڳɹ���ʱ��,��Ҫ�ٴη��� succtime="+succtime+" currentTime="+currentTime);
							}
						}
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


	public void setDealingmap(ConcurrentHashMap<String, Long> dealingmap) {
		this.dealingmap = dealingmap;
	}


	public void setNoProductIdletimes(long noProductIdletimes) {
		this.noProductIdletimes = noProductIdletimes;
	}
	
	public void setSuccmap(LRULinkedHashMap<String, Long> succmap) {
		this.succmap = succmap;
	}


	public void setHasProductIdletimes(long hasProductIdletimes) {
		this.hasProductIdletimes = hasProductIdletimes;
	}

	public void setSucctimeProtecttimes(long succtimeProtecttimes) {
		this.succtimeProtecttimes = succtimeProtecttimes;
	}

}
