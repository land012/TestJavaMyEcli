package com.my.main;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author asdf
 * ��java WebApp�У�����SVN����ȡ java �ļ���Ӧ�� Class �ļ�
 */
public class ExportClassSVN {
	private List<String> fileNamels = new ArrayList<String>();
	private String filesp = System.getProperty("file.separator");
	private String[] javaRoot = { "src", "test" };// Ҫ��ȡclass�ļ���Ŀ¼
	private String currentJavaRoot;
	private List<String> javaSourceDirectory = new ArrayList<String>();
	private List<String> javaRootLs = new ArrayList<String>();
	// �Ƿ���ȡjavaRootĿ¼�����е��ļ���false:ֻ��ȡjava�ļ����Ӧ��.class�ļ���true:��ȡjava�ļ����Ӧ��.class�ļ��������ļ�
	private boolean isExportAll = false;
	
//	private String wwwroot = "WebContent"; // webӦ�ø�Ŀ¼������
	private String wwwroot = "wwwroot";
//	private String wwwroot = "WebRoot";
	
	// src �� wwwroot ���ڵ�Ŀ¼��Log Message �� Export ��Ŀ¼
	private static String exportPath = "C:\\Documents and Settings\\xudz\\����\\cardSpeed2";
	// ����Ŀ¼
	private static String workspacePath = "D:\\sys_update\\cardSpeed";

	public static void main(String[] args) {

		// ��svn�������µ��ļ�����ŵ�d:\svnupdate��
		// ִ�г���󣬰�javaRootĿ¼�����Ӧ��java�ļ���ȡ��Ŀ�����Ӧ��.class�ļ�
		// ��ŵ�D:\\svnupdate\\WebRoot\\WEB-INF\\classes
		// ��,WebRoot�µ��ļ���Ϊ��Ҫ���µ������ļ�

		ExportClassSVN exportClass = new ExportClassSVN();
		exportClass.exportAll(exportPath ,workspacePath ,true);
		// �ļ�Ŀ¼������Ŀ¼���Ӧ��class�ļ�
		// exportClass.exportAllByJavaRoot("D:\\svnupdate",
		// "F:\\myproject\\wys2", true);//��ȡjavaRoot��ָ��Ŀ¼�µ����Ӧ��class�ļ�
	}

	/*
	 * �г�svn ����ʱ�������ļ��� srcĿ¼�������ļ����ļ������������src��ȫ·����java�ļ�����Ϊ���Ӧ��class�ļ�����
	 */
	public void listFile(File f) {

		if (!f.exists()) {
			System.err.println("�ļ���Ŀ¼��" + f.getAbsolutePath() + "������");
			return;
		}
		String fileName = f.getAbsolutePath();
		if (f.isDirectory()) {
			// System.out.println("directory:"+f.getPath()+"--parent:"+f.getParent());
			// System.out.println("directory:"+f.getPath()+"--parent:"+f.getParent());
			String directoryName;
			if (fileName.indexOf(filesp + currentJavaRoot + filesp) != -1) {
				directoryName = fileName.substring(fileName.indexOf(this.filesp + this.currentJavaRoot + this.filesp) + this.currentJavaRoot.length() + 1);
				javaSourceDirectory.add(directoryName);
			}
			File[] t = f.listFiles();
			for (int i = 0; i < t.length; i++) {
				listFile(t[i]);
			}
		} else {
			// System.out.println("fileName:"+f.getAbsolutePath()+"--parent:"+f.getParent());

			if (fileName.indexOf(filesp + currentJavaRoot + filesp) != -1) {
				int index = fileName.indexOf(filesp + currentJavaRoot + filesp);
				if (fileName.lastIndexOf(".java") != -1) {
					String javaFile = fileName.substring(index + this.currentJavaRoot.length() + 1, fileName.lastIndexOf(".java")) + ".class";
					this.fileNamels.add(javaFile);
					System.out.println("fileName:" + javaFile);
				} else {
					if (this.isExportAll) {
						String otherFile = fileName.substring(index + this.currentJavaRoot.length() + 1);
						this.fileNamels.add(otherFile);
						System.out.println("fileName:" + otherFile);

					}
				}

			}
		}

	}

	/*
	 * svn ����ʱ�������ļ��У�����JAVA�ļ�Ŀ¼�ṹ����ȡ��Ŀ����Ӧ��.class�ļ��� srcRoot ����svn
	 * ��ȡ�����ļ�����ŵ�Ŀ¼������ȡ�ļ���javaԴ�ļ����ڵĸ�Ŀ¼ projectRoot�� ��Ŀ���ڵ�·�� desRoot
	 * ����ȡ���Ӧ�ļ���classes�ļ������ڵ�Ŀ¼��������ȡ���ļ������Ŀ¼
	 */
	public void exportClass(String srcRoot, String projectRoot, String desRoot) {
		this.fileNamels.clear();
		this.initJavaRoot();
		if (this.javaRootLs.size() < 1) {
			System.out.println("������Ҫ��ȡclass�ļ���Ŀ¼��");
			return;
		}
		for (int i = 0; i < this.javaRootLs.size(); i++) {
			this.currentJavaRoot = this.javaRootLs.get(i);
			this.listFile(new File(srcRoot + this.filesp + this.currentJavaRoot));
		}
		getInnerClass(projectRoot);
		String src = null;
		String des = null;
		for (String fileName : fileNamels) {
			//src = projectRoot + this.filesp + "wwwroot" + this.filesp + "WEB-INF" + this.filesp + "classes" + fileName;
			src = projectRoot + this.filesp + wwwroot + this.filesp + "WEB-INF" + this.filesp + "classes" + fileName;
			des = desRoot + this.filesp + "classes" + fileName;
			copyFile(src, des);
		}

	}

	/*
	 * ��ʼ��Ҫ��ȡclass�ļ���javaԴ�ļ�Ŀ¼
	 */
	private void initJavaRoot() {
		if (this.javaRootLs.size() > 0) {// javaRootLs�Ѿ���ֵ��ֱ�ӷ���
			return;
		}
		for (int i = 0; i < javaRoot.length; i++) {
			if (!wwwroot.equalsIgnoreCase(javaRoot[i])) {
				this.javaRootLs.add(javaRoot[i]);
			} else {
				System.out.println("javaRoot�в��ܰ���wwwroot��");
			}
		}
	}

	/*
	 * ����svn��ȡ���ļ�Ŀ¼��������ȡ���Ӧ��class�ļ� �浽ָ����desRoot/classes Ŀ¼��
	 * java�ļ�Ŀ¼ΪjavaRoot����ָ����Ŀ¼ isExportOtherFile �Ƿ���ȡjava�ļ�����Ŀ¼�������ļ� �磬java
	 * �����ļ� .xml
	 */
	public void exportAllByJavaRoot(String srcRoot, String projectRoot, String desRoot, boolean isExportOtherFile) {
		this.isExportAll = isExportOtherFile;
		exportClass(srcRoot, projectRoot, desRoot);
	}

	/*
	 * ����svn��ȡ���ļ�Ŀ¼��������ȡ���Ӧ��class�ļ� �浽srcRoot/WebRoot/WEB-INF/classes Ŀ¼��
	 * java�ļ�Ŀ¼ΪjavaRoot����ָ����Ŀ¼ isExportOtherFile �Ƿ���ȡjava�ļ�����Ŀ¼�������ļ� �磬java
	 * �����ļ� .xml
	 */
	public void exportAllByJavaRoot(String srcRoot, String projectRoot, boolean isExportOtherFile) {
		exportAllByJavaRoot(srcRoot, projectRoot, srcRoot + this.filesp + wwwroot + this.filesp + "WEB-INF", isExportOtherFile);
	}

	/*
	 * ����svn��ȡ���ļ�Ŀ¼��������ȡ���Ӧ��class�ļ� java�ļ�����Ŀ¼Ĭ��Ϊ��WebRootĿ¼ ֮���Ŀ¼
	 * isExportOtherFile �Ƿ���ȡjava�ļ�����Ŀ¼�������ļ� �磬�����ļ� .xml
	 */
	public void exportAll(String srcRoot, String projectRoot, boolean isExportOtherFile) {

		File root = new File(srcRoot);
		if (!root.exists()) {
			System.out.println("�ļ���Ŀ¼��" + root.getAbsolutePath() + "������");
			return;
		}
		this.javaRootLs.clear();
		File[] t = root.listFiles();

		for (int i = 0; i < t.length; i++) {
			if (!wwwroot.equalsIgnoreCase(t[i].getName())) {
				this.javaRootLs.add(t[i].getName());
			}
		}
		exportAllByJavaRoot(srcRoot, projectRoot, isExportOtherFile);

	}

	/*
	 * �ļ�����
	 */
	private void copyFile(String oldPath, String newPath) { // �����ļ�
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPath);

			File newfile = new File(newPath);

			if (!newfile.getParentFile().exists()) {// Ŀ¼������ʱ������Ŀ¼
				newfile.getParentFile().mkdirs();
			}

			if (oldfile.exists()) { // �ļ�����ʱ
				InputStream inStream = new FileInputStream(oldPath); // ����ԭ�ļ�
				FileOutputStream fs = new FileOutputStream(newPath);

				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; // �ֽ��� �ļ���С
					// System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
				System.out.println("�ļ���" + oldfile.getName() + " ���ƴ�С��" + (double) bytesum / 1024 + " KB");
			} else {
				System.err.println("�ļ���" + oldfile.toString() + "�����ڣ�����");
			}
		} catch (Exception e) {
			System.out.println("���Ƶ����ļ���������");
			e.printStackTrace();

		}

	}

	/*
	 * ������ȡ�ļ����Ƿ�����ڲ��࣬��������ȡ����
	 */
	private void getInnerClass(String projectRoot) {
		for (int i = 0; i < javaSourceDirectory.size(); i++) {
			String temp_javaSourceDirectory = javaSourceDirectory.get(i);
			String directory = projectRoot + this.filesp + wwwroot + this.filesp + "WEB-INF" + this.filesp + "classes" + temp_javaSourceDirectory;
			File temp_directory = new File(directory);
			File[] fs = temp_directory.listFiles();
			for (int j = 0; j < fs.length; j++) {
				File file = fs[j];
				if (!file.isDirectory()) {
					if (file.getName().indexOf("$") != -1 && file.getName().indexOf(".class") != -1) {
						String innerClassFather = javaSourceDirectory.get(i) + this.filesp + file.getName().substring(0, file.getName().indexOf("$")) + ".class";
						if (this.fileNamels.contains(innerClassFather)) {
							this.fileNamels.add(temp_javaSourceDirectory + this.filesp + file.getName());
							System.out.println("fileName:" + temp_javaSourceDirectory + this.filesp + file.getName());
						}
					}
				}
			}
		}

	}
}