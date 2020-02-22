package com.test3_1;
/**
 * 功能：坦克游戏的3.0
 * 1.画出坦克
 * 2.让坦克上下左右移动
 * 3.画出子弹，按下J键能发射一颗子弹 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
/**
 * 2)	修改MyPanel类 implements KeyListener:
a.定义一个我的坦克；定义敌人的坦克（3个）；
b.方法：
构造方法：
---初始化我方坦克
---初始化敌人的坦克
paint（）方法：
---画自己的坦克
   ---画敌人的坦克。（先写好画坦克的方法drawTank(int x, int y, Graphics g, int direct, int type )）、
   ---画出子弹:如果子弹有效并且子弹仍然存活，画出(g.drawOval)子弹。
事件处理（键盘事件）keyPressed（）方法处理代码：
---只要去判断按下的是什么方向的键（向上为例：direct=0;moveUp();repaint()）。
      ---增加判断玩家是否按下F键，如果按下，则调用hero.shotEnemy（）方法发射子弹。
  
写run方法：while(true){每隔100秒，去重绘。}
 */
public class MyTankGame3_1 extends JFrame {

	MyPanel mp=null;
	
	public static void main(String[] args) {
		MyTankGame3_1 myTankGame2=new MyTankGame3_1();
	}
	
	//构造方法
	public MyTankGame3_1()
	{
		mp=new MyPanel();
		////填写代码？启动mp线程--V3_1
		
		
		this.add(mp);
		this.addKeyListener(mp);
		
		this.setSize(400,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}

//我的面板--V3.1：把面板变成线程类（实现Runnalbe接口）
class MyPanel extends JPanel  implements KeyListener //填写代码？
{
	
	//定义一个我的坦克
	Hero hero=null;
    //定义敌人的坦克
	Vector<EnemyTank> ets=new Vector<EnemyTank>();
	
	int enSize=3;
	
	//构造方法
	public MyPanel()
	{
		hero=new Hero(200,200);
		
		//初始化敌人的坦克
		for(int i=0;i<enSize;i++)
		{
			//创建一辆敌人的坦克对象
			EnemyTank et=new EnemyTank((i+1)*50,0);
			et.setColor(0);
			et.setDirect(1);
			//加入
			ets.add(et);
		}
	}
	//重新paint 
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0,0,400,300);
		
		//画出自己的坦克
		this.drawTank(hero.getX(), hero.getY(), g, this.hero.direct, 1);
		//画出子弹--V3.0
		if(hero.bomn!=null && hero.bomn.isLive==true)
		{
			g.setColor(Color.red);
			g.draw3DRect(hero.bomn.x, hero.bomn.y, 1, 1, false);
		}
		
		//画出敌人的坦克
		for(int i=0;i<ets.size();i++)
		{
			this.drawTank(ets.get(i).getX(), ets.get(i).getY(), g, this.ets.get(i).direct, 0);
		}
		
		
		
	}
	
	//画出坦克的方法
	public void drawTank(int x,int y,Graphics g,int direct,int type)
	{
		//判断是什么类型的坦克
		switch(type)
		{
		case 0:
			g.setColor(Color.cyan);
			break;
		case 1:
			g.setColor(Color.yellow);
			break;
		}
		
		//判断方向
		switch(direct)
		{/*画出我的坦克（到时再封装成一个函数）*/
		//向上
		case 0:
			
			//1.画出左边的矩形
			g.fill3DRect(x,y,5,30,false);
			//2.画出右边的矩形
			g.fill3DRect(x+15,y,5 , 30,false);
			//3.画出中间的矩形
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//4.画出中间的圆
			g.fillOval(x+5, y+10, 10, 10);
			//4.画出直线
			g.drawLine(x+10,y,x+10,y+15);
			break;
		case 1:
			/*画出向下的坦克*/
			//1.画出左边的矩形
			g.fill3DRect(x,y,5,30,false);
			//2.画出右边的矩形
			g.fill3DRect(x+15,y,5 , 30,false);
			//3.画出中间的矩形
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//4.画出中间的圆
			g.fillOval(x+5, y+10, 10, 10);
			//4.画出直线
			g.drawLine(x+10,y+30,x+10,y+15);
			break;
		case 2:
			/*画出向左的坦克*/
	        g.fill3DRect(x,y,30,5,false);
	        g.fill3DRect(x,y+15,30,5,false);
	        g.fill3DRect(x+5,y+5,20,10,false);
	        g.fillOval(x+10, y+5, 10, 10);
	        g.drawLine(x+15,y+10, x,y+10);
	        break;
		case 3:
			/*画出向右的坦克*/
			g.fill3DRect(x,y,30,5,false);
	        g.fill3DRect(x,y+15,30,5,false);
	        g.fill3DRect(x+5,y+5,20,10,false);
	        g.fillOval(x+10, y+5, 10, 10);
	        g.drawLine(x+15,y+10, x+30,y+10);
	        break;
		}
	}
	
	//键按下处理a向左 s向右 w向上 d向下
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_W)
		{
		    //填写代码？向上
			
		
		}else if(e.getKeyCode()==KeyEvent.VK_S)
		{
			//填写代码？向下
			
			
		}else if(e.getKeyCode()==KeyEvent.VK_A)
		{
			//填写代码？向左
		
			
		}else if(e.getKeyCode()==KeyEvent.VK_D)
		{
			//填写代码？向右
				
		}
		
		//填写代码？？判断玩家是否按下J，若是，则调用hero.shotEnemy()---V3.0
		if()
		{
			this.hero.shotEnemy();
		}
		
		//必须重绘窗口
		this.repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	//--v3
	public void run() {
		//每隔100豪秒去重绘
		while(true)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//重绘
			this.repaint();
		}
		
	}
}


