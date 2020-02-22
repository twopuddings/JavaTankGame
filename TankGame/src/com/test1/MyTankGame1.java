package com.test1;
/**
 * ���ܣ�̹����Ϸ��1.0
 * 1.����̹��
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * 4.���崴����Ϸ�����MyTankGame1(�̳���һ�����)��
 * 4.1�������ԣ���Ϸ���
 * 4.2д���췽����
 *   a.���л������ã�
 *   b.������Ϸ���MyPanel������ӵ���Ϸ����С�
 */
public class MyTankGame1 extends JFrame {

	MyPanel mp=null;
	
	public static void main(String[] args) {
		MyTankGame1 myTankGame=new MyTankGame1();
	}
	
	//���췽��
	public MyTankGame1()
	{
		//b.������Ϸ���MyPanel������ӵ���Ϸ����С�
		
		
		this.setSize(400,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}

/**
 * 3.������Ϸ�����MyPanel(�̳���JPanel)
 * ��
 *   3.1�������ԣ�����һ���ҵ�̹��Hero
 *   3.2���췽������ʼ���ҵ�̹�ˣ�x=10,y=10��(��������ǻ�һ��̹��)
 *   3.3��дpaint(g)����:
 *      a��ʼ�����ʡ�b����Ϸ������c���û�̹�˷�������̹��
 *   3.4д��̹�˵ķ���drawTank(x,y,g,direct,type)��
 *      a�ж�̹�����͡�b�жϷ���ݴ˻���̹��
 * ��
 *
 */
class MyPanel extends JPanel 
{
	//�������ԣ�һ���ҵ�̹��
	Hero hero=null;
	
	//���췽������ʼ���ҵ�̹��
	public MyPanel()
	{
		hero=new Hero(10,10);
	}
	/**
	 * ��дpaint()����:
	 * ��ʼ�����ʡ�����Ϸ���������û�̹�˷�������̹��
	 */
	public void paint(Graphics g)
	{
		//��д���룿���ø��෽������ʼ������
		
		//����Ϸ����
		g.fillRect(0,0,400,300);
		//����̹�ˣ����û�̹�˵ķ���drawTank(x,y,g,direct,type)
		this.drawTank(hero.getX(), hero.getY(), g, 0, 1);
		
	}
	
	/**
	 * ��̹�˵ķ���drawTank(x,y,g,direct,type)
	 * @param x
	 * @param y
	 * @param g
	 * @param direct
	 * @param type
	 */
	public void drawTank(int x,int y,Graphics g,int direct,int type)
	{
		//�ж���ʲô���͵�̹�ˣ��ò�ͬ����ɫչʾ��ͬ���͵�̹��
		switch(type)
		{
		case 0:
			g.setColor(Color.cyan);
			break;
		case 1:
			//��д���룿
		}
		
		//�ж�̹�˷��򣬻���̹��
		switch(direct)
		{
		//����
		case 0:
			/*�����ҵ�̹��*/
			//(1).����ߵľ���
			g.fill3DRect(hero.getX(),hero.getY(),5,30,false);
			//(2).���ұߵľ���
			g.fill3DRect(hero.getX()+15,hero.getY(),5 , 30,false);
			//(3).���м�ľ���
			g.fill3DRect(hero.getX()+5, hero.getY()+5, 10, 20,false);
			//(4).���м��Բ
			g.fillOval(hero.getX()+5, hero.getY()+10, 10, 10);
		    //(5).���軭����ɫ����ֱ�ߣ���Ͳ
			g.setColor(Color.red);
			g.drawLine(hero.getX()+10,hero.getY()-5,hero.getX()+10,hero.getY()+15);
			break;
		}
	}
}

/**
 * 1����̹����Tank
 * 1.1�������ԣ�̹�˵ĺ�����int x=0��������int y=0
 * 1.2д���췽��:��ʼ��̹������
 * 1.3дget\set����
 */
class Tank
{
	//̹�˵ĺ����ꡢ������
	int x=0;
	int y=0;
	
	public Tank(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}

/**
 * 2�����ҵ�̹��Hero��
 * 2.1д���췽�������ø���Ĺ��췽����ʼ��̹������x,y
 */
class Hero extends Tank
{
	public Hero(int x,int y)
	{
		super(x,y);
	}
}

