package com.umbrella.commons.pool2;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Arrays;
import java.util.NoSuchElementException;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPool;

public class ReadUtil {
	private ObjectPool<StringBuffer> pool;
	
	private ReadUtil() { }
	
	private ReadUtil(ObjectPool<StringBuffer> pool) {
		this.pool = pool;
	}
	
	public static ReadUtil getInstance() {
		return ReadUtilHoder.instance;
	}
	
	public String readToString(Reader reader) {
		StringBuffer buf = null;
		try {
			buf = pool.borrowObject();
			char[] temp = new char[1024];
			for(int i=reader.read(temp); i!=-1; i=reader.read(temp)) {
				System.out.println(i);
				for(int j=0; j<temp.length; j++) {
					if((int)temp[j] == 0) break;
					System.out.print(temp[j] + "-" + (int)temp[j] + " ");
				}
				System.out.println();
//				System.out.println("temp=" + Arrays.toString(temp));
				buf.append(temp, 0, i);
				temp = new char[1024];
			}
			String res = buf.toString();
			System.out.println("res.getBytes().length=" + res.getBytes().length);
			System.out.println(Arrays.toString(res.getBytes()));
			res = new String(res.getBytes(), "utf-8");
			return res;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(reader != null) {
					reader.close();
					reader = null;
				}
				if(buf != null) {
					pool.returnObject(buf);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}
	
	public String readToString(InputStream is) {
		StringBuffer buf = null;
		try {
			buf = pool.borrowObject();
			/*
			 * 此处长度若为 1024，则不会乱码
			 * 若为4，则乱码
			 * 也就是说，要 byte[] 足够长才行
			 */
			byte[] temp = new byte[4];
			for(int i=is.read(temp); i!=-1; i=is.read(temp)) {
				buf.append(new String(temp, 0, i, "utf-8"));
			}
			return buf.toString();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(is != null) {
					is.close();
					is = null;
				}
				if(buf != null) {
					pool.returnObject(buf);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}
	
	static class ReadUtilHoder {
		public static ReadUtil instance = new ReadUtil(new GenericObjectPool<StringBuffer>(new StringBufferPooledObjectFactory()));
	}
	
	static class StringBufferPooledObjectFactory extends BasePooledObjectFactory<StringBuffer> {

		@Override
		public StringBuffer create() throws Exception {
			return new StringBuffer();
		}
		
		@Override
		public PooledObject<StringBuffer> wrap(StringBuffer arg0) {
			return new DefaultPooledObject<StringBuffer>(arg0);
		}
		
		@Override
		public void passivateObject(PooledObject<StringBuffer> p) throws Exception {
			p.getObject().setLength(0);
		}
	}
}
