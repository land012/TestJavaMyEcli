package test.com.my.enumpkg;



import org.junit.Test;

import com.umbrella.vo.Animal;
import com.umbrella.vo.Color;

public class EnumTest {
	
	@Test
	public void testColor() {
		System.out.println(Color.RED);
	}
	
	@Test
	public void testAnimal() {
		System.out.println(Animal.TIGER.getName());
	}
}
