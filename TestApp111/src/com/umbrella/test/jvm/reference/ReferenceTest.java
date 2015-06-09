package com.umbrella.test.jvm.reference;



import org.junit.Assert;
import org.junit.Test;

public class ReferenceTest {
	
	@Test
	public void testStrongReference() {
		Object obj1 = new Object();
		Object obj2 = obj1;
		
		System.out.println(obj1 == obj2);
		Assert.assertSame(obj1, obj2);
		
		obj1 = null;
		System.gc();
		Assert.assertNotNull(obj2);
	}
	
	/**
	 * 这种引用不是弱引用
	 */
	@Test
	public void testWeakReference() {
		Object obj1 = new Object();
		WeakRefVo wrVo = new WeakRefVo();
		wrVo.setObj(obj1);
		obj1 = null;
		System.gc();
		Assert.assertNotNull(wrVo.getObj());
	}

}
