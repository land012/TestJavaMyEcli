package com.prj.anonymousclass;

public class MyService {
	
	public int i;
	
	/**
	 * 模板方法
	 * @param cb
	 */
	private void execute(MyCallBack cb, String str) {
		// 公共部分开始
		cb.callback(str);
		// 公共部分结束
	}
	
	/**
	 * 在这个方法里，确定各自不同的内容
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
