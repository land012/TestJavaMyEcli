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
 * 在java WebApp中，配置SVN，提取 java 文件对应的 Class 文件
 */
public class ExportClassSVN {
	private List<String> fileNamels = new ArrayList<String>();
	private String filesp = System.getProperty("file.separator");
	private String[] javaRoot = { "src", "test" };// 要提取class文件的目录
	private String currentJavaRoot;
	private List<String> javaSourceDirectory = new ArrayList<String>();
	private List<String> javaRootLs = new ArrayList<String>();
	// 是否提取javaRoot目录下所有的文件，false:只提取java文件相对应的.class文件，true:提取java文件相对应的.class文件与其它文件
	private boolean isExportAll = false;
	
//	private String wwwroot = "WebContent"; // web应用根目录的名字
	private String wwwroot = "wwwroot";
//	private String wwwroot = "WebRoot";
	
	// src 和 wwwroot 所在的目录，Log Message 中 Export 的目录
	private static String exportPath = "C:\\Documents and Settings\\xudz\\桌面\\cardSpeed2";
	// 工程目录
	private static String workspacePath = "D:\\sys_update\\cardSpeed";

	public static void main(String[] args) {

		// 用svn导出更新的文件，存放到d:\svnupdate中
		// 执行程序后，把javaRoot目录下相对应的java文件提取项目中相对应的.class文件
		// 存放到D:\\svnupdate\\WebRoot\\WEB-INF\\classes
		// 下,WebRoot下的文件即为所要更新的所有文件

		ExportClassSVN exportClass = new ExportClassSVN();
		exportClass.exportAll(exportPath ,workspacePath ,true);
		// 文件目录下其它目录相对应的class文件
		// exportClass.exportAllByJavaRoot("D:\\svnupdate",
		// "F:\\myproject\\wys2", true);//提取javaRoot中指定目录下的相对应的class文件
	}

	/*
	 * 列出svn 更新时导出的文件中 src目录下所有文件的文件名（包括相对src的全路径，java文件名变为相对应的class文件名）
	 */
	public void listFile(File f) {

		if (!f.exists()) {
			System.err.println("文件或目录：" + f.getAbsolutePath() + "不存在");
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
	 * svn 更新时导出的文件中，根据JAVA文件目录结构，提取项目中相应的.class文件； srcRoot ：用svn
	 * 提取更新文件所存放的目录，即提取文件后java源文件所在的父目录 projectRoot： 项目所在的路径 desRoot
	 * ：提取相对应文件后classes文件夹所在的目录，用于提取后文件保存的目录
	 */
	public void exportClass(String srcRoot, String projectRoot, String desRoot) {
		this.fileNamels.clear();
		this.initJavaRoot();
		if (this.javaRootLs.size() < 1) {
			System.out.println("不存在要提取class文件的目录！");
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
	 * 初始化要提取class文件的java源文件目录
	 */
	private void initJavaRoot() {
		if (this.javaRootLs.size() > 0) {// javaRootLs已经赋值，直接返回
			return;
		}
		for (int i = 0; i < javaRoot.length; i++) {
			if (!wwwroot.equalsIgnoreCase(javaRoot[i])) {
				this.javaRootLs.add(javaRoot[i]);
			} else {
				System.out.println("javaRoot中不能包含wwwroot！");
			}
		}
	}

	/*
	 * 根据svn提取的文件目录，进行提取相对应的class文件 存到指定的desRoot/classes 目录下
	 * java文件目录为javaRoot中所指定的目录 isExportOtherFile 是否提取java文件所在目录的其它文件 如，java
	 * 配置文件 .xml
	 */
	public void exportAllByJavaRoot(String srcRoot, String projectRoot, String desRoot, boolean isExportOtherFile) {
		this.isExportAll = isExportOtherFile;
		exportClass(srcRoot, projectRoot, desRoot);
	}

	/*
	 * 根据svn提取的文件目录，进行提取相对应的class文件 存到srcRoot/WebRoot/WEB-INF/classes 目录下
	 * java文件目录为javaRoot中所指定的目录 isExportOtherFile 是否提取java文件所在目录的其它文件 如，java
	 * 配置文件 .xml
	 */
	public void exportAllByJavaRoot(String srcRoot, String projectRoot, boolean isExportOtherFile) {
		exportAllByJavaRoot(srcRoot, projectRoot, srcRoot + this.filesp + wwwroot + this.filesp + "WEB-INF", isExportOtherFile);
	}

	/*
	 * 根据svn提取的文件目录，进行提取相对应的class文件 java文件所在目录默认为除WebRoot目录 之外的目录
	 * isExportOtherFile 是否提取java文件所在目录的其它文件 如，配置文件 .xml
	 */
	public void exportAll(String srcRoot, String projectRoot, boolean isExportOtherFile) {

		File root = new File(srcRoot);
		if (!root.exists()) {
			System.out.println("文件或目录：" + root.getAbsolutePath() + "不存在");
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
	 * 文件复制
	 */
	private void copyFile(String oldPath, String newPath) { // 复制文件
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPath);

			File newfile = new File(newPath);

			if (!newfile.getParentFile().exists()) {// 目录不存在时，创建目录
				newfile.getParentFile().mkdirs();
			}

			if (oldfile.exists()) { // 文件存在时
				InputStream inStream = new FileInputStream(oldPath); // 读入原文件
				FileOutputStream fs = new FileOutputStream(newPath);

				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; // 字节数 文件大小
					// System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
				System.out.println("文件：" + oldfile.getName() + " 复制大小：" + (double) bytesum / 1024 + " KB");
			} else {
				System.err.println("文件：" + oldfile.toString() + "不存在！！！");
			}
		} catch (Exception e) {
			System.out.println("复制单个文件操作出错");
			e.printStackTrace();

		}

	}

	/*
	 * 查找提取文件中是否存在内部类，存在则提取出来
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