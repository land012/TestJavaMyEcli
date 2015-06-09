package com.land.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ��֤��
 * @author asdf
 *
 */
public class VeriCode {
	
	private int width = 50;  // ��֤��ͼƬ���
	private int height = 26; // ��֤��ͼƬ�߶�
	
	private String originStrs = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // �����������Դ����
	private int vericodeNum = 4; // ��֤���ַ�����
	private int vericodeR = 255;
	private int vericodeG = 255;
	private int vericodeB = 255;
	private int vericodeFontSize = 18;
	private Font vericodeFont = new Font("Courier New", Font.BOLD, this.vericodeFontSize);
	
	private String vericodeKey = "VERICODEKEY";
	
	private Color interferLineColor = Color.BLACK; // ��������ɫ
	private int interferLineNum = 5; // ����������
	
	private Random random = new Random();
	
	public void getVeriCode(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		BufferedImage image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();
		g.fillRect(0, 0, this.width, this.height);
		g.setFont(this.vericodeFont);
		
		drawInterferLine(g);
		String vericode = drawVericode(g);
		session.removeAttribute(this.vericodeKey);
		session.setAttribute(this.vericodeKey, vericode);
		g.dispose();
		try {
			ImageIO.write(image, "JPG", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��������
	 * @param g
	 */
	private void drawInterferLine(Graphics g) {
		g.setColor(this.interferLineColor);
		for(int i=0; i<this.interferLineNum; i++) {
			int x1 = this.random.nextInt(this.width);
			int y1 = this.random.nextInt(this.height);
			int x2 = this.random.nextInt(this.width);
			int y2 = this.random.nextInt(this.height);
			g.drawLine(x1, y1, x2, y2);
		}
	}
	
	/**
	 * ����֤�ַ�
	 * @param g
	 */
	private String drawVericode(Graphics g) {
		String res = "";
		int useWidth = this.width - 4;
		int distance = useWidth/this.vericodeNum;
		int top = (this.height-this.vericodeFontSize)/2 + this.vericodeFontSize;
		System.out.println("top=" + top);
		for(int i=0; i<this.vericodeNum; i++) {
			int index = random.nextInt(this.originStrs.length());
			String chr = this.originStrs.substring(index, index+1);
			g.drawString(chr, 2 + distance*i + (distance-this.vericodeFontSize)/2, top);
			res += chr;
		}
		System.out.println("��֤�룺" + res);
		return res;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getOriginStrs() {
		return originStrs;
	}

	public void setOriginStrs(String originStrs) {
		this.originStrs = originStrs;
	}

	public int getVericodeNum() {
		return vericodeNum;
	}

	public void setVericodeNum(int vericodeNum) {
		this.vericodeNum = vericodeNum;
	}

	public int getVericodeR() {
		return vericodeR;
	}

	public void setVericodeR(int vericodeR) {
		this.vericodeR = vericodeR;
	}

	public int getVericodeG() {
		return vericodeG;
	}

	public void setVericodeG(int vericodeG) {
		this.vericodeG = vericodeG;
	}

	public int getVericodeB() {
		return vericodeB;
	}

	public void setVericodeB(int vericodeB) {
		this.vericodeB = vericodeB;
	}

	public Font getVericodeFont() {
		return vericodeFont;
	}

	public void setVericodeFont(Font vericodeFont) {
		this.vericodeFont = vericodeFont;
	}

	public String getVericodeKey() {
		return vericodeKey;
	}

	public void setVericodeKey(String vericodeKey) {
		this.vericodeKey = vericodeKey;
	}

	public Color getInterferLineColor() {
		return interferLineColor;
	}

	public void setInterferLineColor(Color interferLineColor) {
		this.interferLineColor = interferLineColor;
	}

	public int getInterferLineNum() {
		return interferLineNum;
	}

	public void setInterferLineNum(int interferLineNum) {
		this.interferLineNum = interferLineNum;
	}

	public int getVericodeFontSize() {
		return vericodeFontSize;
	}

	public void setVericodeFontSize(int vericodeFontSize) {
		this.vericodeFontSize = vericodeFontSize;
	}

	/*public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}*/
	
}
