package com.test2;
/**
 * 功能：坦克游戏的2.0
 * 1.画出坦克
 * 2.让坦克上下左右移动
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
/**
 * 在com.test2.MyTankGame2.java中： 
1)	主类：
  main方法：
  构造方法：初始化面板；
                   把面板加入到框架；
                   给本框架类添加键盘事件监听器。
2)	MyPanel类： implements KeyListener
   a.定义一个我的坦克；定义敌人的坦克（3个）；
   b.构造方法：初始化我方坦克，初始化敌人的坦克，
   c.画图paint（）方法—画自己的坦克，画敌人的坦克。
     （先写好画坦克的方法drawTank(int x, int y, Graphics g, int direct, int type )）
   d.事件处理（键盘事件）：只要去判断按下的是什么方向的键
     （向上为例：direct=0;moveUp();repaint()）
 */
public class MyTankGame2 extends JFrame {


	MyPanel mp=null;
	
	public static void main(String[] args) {
		MyTankGame2 myTankGame2=new MyTankGame2();
	}
	
	/**
	 * 构造方法
	 */
	public MyTankGame2()
	{
		/**填写代码？？构造方法：初始化面板；
                   把面板加入到框架；
                   给本框架类添加键盘事件监听器。
		*/

		this.setSize(400,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}

/**
 * 我的面板
 */
class MyPanel extends JPanel  implements KeyListener
{
	//定义一个我的坦克
	Hero hero=null;
       //定义敌人的坦克3个
	Vector<EnemyTank> ets=new Vector<EnemyTank>();
	int enSize=3;
	
	//构造方法
	public MyPanel()
	{
		//初始化我方坦克
		hero=new Hero(200,200);
		
		//初始化敌人的坦克
		for(int i=0;i<enSize;i++)
		{
			//创建一辆敌人的坦克对象
			EnemyTank et=new EnemyTank((i+1)*50,0);
                       //填写代码？设置敌方坦克颜色、方向
			                   //敌、坦克：黄色int color：0-黄色-yellow  1-浅蓝-cyan
			                   //向下direct：0向上，1向下，2向左，3向右
			//加入
			ets.add(et);
		}
	}
	//重新paint 
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0,0,400,300);
		
		//填写代码？画出自己的坦克
		
		//填写代码？画出敌人的坦克
		
		
		
		
	}
	
	//画出坦克的方法
	public void drawTank(int x,int y,Graphics g,int direct,int type)
	{
		//判断是什么类型的坦克
		switch(type)
		{
		case 0:
			g.setColor(Color.cyan); //
			break;
		case 1:
			g.setColor(Color.yellow);
			break;
		}
		
		//判断坦克方向
		switch(direct)
		{/*画出我的坦克（到时再封装成一个函数）*/
		
		case 0://坦克向上
			
			//1.画出左边的矩形
			g.fill3DRect(x,y,5,30,false);
			//2.画出右边的矩形
			g.fill3DRect(x+15,y,5 , 30,false);
			//3.画出中间的矩形
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//4.画出中间的圆
			g.fillOval(x+5, y+10, 10, 10);
			//4.画出直线
			g.setColor(Color.red);
			g.drawLine(x+10,y,x+10,y+15);
			break;
		case 1://坦克向下
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
			g.setColor(Color.red);
			g.drawLine(x+10,y+30,x+10,y+15);
			break;
		case 2://坦克向左
			/*画出向左的坦克*/
	        g.fill3DRect(x,y,30,5,false);
	        g.fill3DRect(x,y+15,30,5,false);
	        g.fill3DRect(x+5,y+5,20,10,false);
	        g.fillOval(x+10, y+5, 10, 10);
	        g.setColor(Color.red);
	        g.drawLine(x+15,y+10, x,y+10);
	        break;
		case 3://坦克向右
			/*画出向右的坦克*/
			g.fill3DRect(x,y,30,5,false);
	        g.fill3DRect(x,y+15,30,5,false);
	        g.fill3DRect(x+5,y+5,20,10,false);
	        g.fillOval(x+10, y+5, 10, 10);
	        g.setColor(Color.red);
	        g.drawLine(x+15,y+10, x+30,y+10);
	        break;
		}
	}
	
	//键按下处理a向左 s向右 w向上 d向下
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_W)
		{
		    //w向上
			this.hero.setDirect(0);
			this.hero.moveUp();
		
		}else if(e.getKeyCode()==KeyEvent.VK_S)
		{
			//d向下
			this.hero.setDirect(1);
			this.hero.moveDown();
			
		}else if(e.getKeyCode()==KeyEvent.VK_A)
		{
			//a向左
			this.hero.setDirect(2);
			this.hero.moveLeft();
			
		}else if(e.getKeyCode()==KeyEvent.VK_D)
		{
			//s向右
			this.hero.setDirect(3);
			this.hero.moveRight();	
		}
		//填写代码？必须重绘窗口
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}


