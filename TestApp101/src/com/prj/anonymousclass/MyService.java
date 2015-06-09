package com.prj.anonymousclass;

public class MyService {
	
	public int i;
	
	/**
	 * ģ�巽��
	 * @param cb
	 */
	private void execute(MyCallBack cb, String str) {
		// �������ֿ�ʼ
		cb.callback(str);
		// �������ֽ���
	}
	
	/**
	 * ����������ȷ�����Բ�ͬ������
	 */
	public void fn1(String str){
		execute(new MyCallBack(){
			@Override
			public void callback(String str) {
				System.out.println(str);
			}
		}, str);
	}
	
	public void fn2(String str){
		execute(new MyCallBack(){
			@Override
			public void callback(String str) {
				System.out.println(str);
			}
		}, str);
	}
}
