package test.com.umbrella.produconsu.produconsu2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class PCTest {
	
	@Test
	public void testCreateResources() {
		File file = new File("files/file3.db");
		if(!file.exists()) {
			FileWriter fw = null;
			try {
				file.createNewFile();
				fw = new FileWriter(file);
				fw.write("1\n");
				fw.write("2\n");
				fw.write("3\n");
				fw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if(fw != null) {
					try {
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					fw = null;
				}
			}
		}
	}
}
