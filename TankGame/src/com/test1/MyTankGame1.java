package com.test1;
/**
 * 功能：坦克游戏的1.0
 * 1.画出坦克
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * 4.定义创建游戏框架类MyTankGame1(继承自一个框架)：
 * 4.1定义属性：游戏面板
 * 4.2写构造方法：
 *   a.进行基本设置；
 *   b.创建游戏面板MyPanel，并添加到游戏框架中。
 */
public class MyTankGame1 extends JFrame {

	MyPanel mp=null;
	
	public static void main(String[] args) {
		MyTankGame1 myTankGame=new MyTankGame1();
	}
	
	//构造方法
	public MyTankGame1()
	{
		//b.创建游戏面板MyPanel，并添加到游戏框架中。
		
		
		this.setSize(400,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}

/**
 * 3.定义游戏面板类MyPanel(继承自JPanel)
 * ｛
 *   3.1定义属性：定义一个我的坦克Hero
 *   3.2构造方法：初始化我的坦克（x=10,y=10）(任务仅仅是画一个坦克)
 *   3.3重写paint(g)方法:
 *      a初始化画笔、b画游戏背景、c调用画坦克方法画出坦克
 *   3.4写画坦克的方法drawTank(x,y,g,direct,type)：
 *      a判断坦克类型、b判断方向据此画出坦克
 * ｝
 *
 */
class MyPanel extends JPanel 
{
	//定义属性：一个我的坦克
	Hero hero=null;
	
	//构造方法：初始化我的坦克
	public MyPanel()
	{
		hero=new Hero(10,10);
	}
	/**
	 * 重写paint()方法:
	 * 初始化画笔、画游戏背景、调用画坦克方法画出坦克
	 */
	public void paint(Graphics g)
	{
		//填写代码？调用父类方法，初始化画笔
		
		//画游戏背景
		g.fillRect(0,0,400,300);
		//画出坦克：调用画坦克的方法drawTank(x,y,g,direct,type)
		this.drawTank(hero.getX(), hero.getY(), g, 0, 1);
		
	}
	
	/**
	 * 画坦克的方法drawTank(x,y,g,direct,type)
	 * @param x
	 * @param y
	 * @param g
	 * @param direct
	 * @param type
	 */
	public void drawTank(int x,int y,Graphics g,int direct,int type)
	{
		//判断是什么类型的坦克，用不同的颜色展示不同类型的坦克
		switch(type)
		{
		case 0:
			g.setColor(Color.cyan);
			break;
		case 1:
			//填写代码？
		}
		
		//判断坦克方向，画出坦克
		switch(direct)
		{
		//向上
		case 0:
			/*画出我的坦克*/
			//(1).画左边的矩形
			g.fill3DRect(hero.getX(),hero.getY(),5,30,false);
			//(2).画右边的矩形
			g.fill3DRect(hero.getX()+15,hero.getY(),5 , 30,false);
			//(3).画中间的矩形
			g.fill3DRect(hero.getX()+5, hero.getY()+5, 10, 20,false);
			//(4).画中间的圆
			g.fillOval(hero.getX()+5, hero.getY()+10, 10, 10);
		    //(5).重设画笔颜色，画直线：炮筒
			g.setColor(Color.red);
			g.drawLine(hero.getX()+10,hero.getY()-5,hero.getX()+10,hero.getY()+15);
			break;
		}
	}
}

/**
 * 1定义坦克类Tank
 * 1.1定义属性：坦克的横坐标int x=0、纵坐标int y=0
 * 1.2写构造方法:初始化坦克坐标
 * 1.3写get\set方法
 */
class Tank
{
	//坦克的横坐标、纵坐标
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
 * 2定义我的坦克Hero类
 * 2.1写构造方法：调用父类的构造方法初始化坦克坐标x,y
 */
class Hero extends Tank
{
	public Hero(int x,int y)
	{
		super(x,y);
	}
}

