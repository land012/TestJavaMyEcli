package com.umbrella.calculate.sort;

import java.util.Arrays;

/**
 * ��������
 * @author ����
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 3, 1, 4, 5, 2};
		System.out.println("����ǰ:" + Arrays.toString(arr));
		QuickSort qs = new QuickSort();
		
//		qs.qs1(arr, 0, arr.length-1);
		qs.qs2(arr, 0, arr.length-1);
		
		System.out.println("�����:" + Arrays.toString(arr));
	}
	
	/**
	 * ��һ�ֿ�������ʵ�ַ�ʽ
	 * @param arr
	 * @param i
	 * @param j
	 * @return
	 */
	public int sort1(int[] arr, int i, int j) {
		if(i>=j) return -1;
		int temp;
		while(i<j) {
			while(arr[j]>=arr[i] && i<j) j--;
			temp = arr[j];
			arr[j] = arr[i];
			arr[i] = temp;
			while(arr[i]<=arr[j] && i<j) i++;
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		return i;
	}
	
	public void qs1(int[] arr, int i, int j) {
		int pivotkey = sort1(arr, i, j);
		if(pivotkey != -1) {
			qs1(arr, i, pivotkey-1);
			qs1(arr, pivotkey+1, j);
		}
	}
	
	/**
	 * �ڶ������򷽷�
	 * ʵ���Ϻ͵�һ��һ��
	 * @param arr
	 * @param i
	 * @param j
	 * @return
	 */
	public int sort2(int[] arr, int i, int j) {
		int temp;
		int pivot = arr[i];
		while(i<j) {
			while(arr[j]>pivot && i<j) j--;
			while(arr[i]<pivot && i<j) i++;
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		return i;
	}
	
	public void qs2(int[] arr, int i, int j) {
		if(i<j) {
			int pivotkey = sort2(arr, i, j);
			qs2(arr, i, pivotkey-1);
			qs2(arr, pivotkey+1, j);
		}
	}

}
