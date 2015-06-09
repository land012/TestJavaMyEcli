package com.my.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.my.base.BaseTest;

public class HttpClientTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url = "http://localhost:9999/wait_wait2.do?k1=ÄãºÃ";
		HttpClient hc = null;
		HttpGet httpGet = null;
		HttpResponse response = null;
		HttpEntity entity = null;
		BufferedReader br = null;
		StringBuffer res = null;
		try {
			hc = new DefaultHttpClient();
			httpGet = new HttpGet(url);
			response = hc.execute(httpGet);
			entity = response.getEntity();
			if(entity!=null) {
				br = new BufferedReader(new InputStreamReader(entity.getContent(), "utf-8"));
				res = new StringBuffer();
				String line = null;
				while((line=br.readLine())!=null) {
					res.append(line);
				}
				System.out.println(res);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
