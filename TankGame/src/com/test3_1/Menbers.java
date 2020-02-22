package com.test3_1;
/**
 * 1.在com.test2.Members.java中
1)	定义子弹类：实现Runnable接口（实现按发射键后，使子弹继续向前飞行）
属性：
----坐标(x,y)
----发射方向 (direct：0向上，1向下，2向左，3向右)，（与坦克类的炮筒方向同）
----飞行速度(speed)
----是否还有效(isLive)
方法：
----构造方法-初始化坐标值、方向
----每个属性的gets\ sets方法
----run（）方法的书写：
（子弹生成后）睡眠50秒。让子弹向前飞行（根据方向）。判断该子弹是否碰到边缘，若碰到边缘，让其作废。
2)	修改我的坦克类Hero：
属性：
   ----（添加）子弹Bomn  bomn=null;
方法：
 ----（添加）射击的方法（向敌人开火）shotEnemy（） 的书写：
        创建子弹（根据方向）、启动子弹飞行（线程）
 *
 */
public class Menbers {
}
/*定义子弹类--V3_1*/
class Bomn implements Runnable
{
	int x;
	int y;
	int direct;
	int speed=3;
	// 子弹是否还活着
	boolean isLive=true;
	
	public Bomn(int x,int y,int direct)
	{
		this.x=x;
		this.y=y;
		this.direct=direct;
	}
	
	public void run() {
		
		while(true)
		{
			try {

                            //填写代码？（子弹生成后）睡眠50 毫秒。
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switch(direct)
			{
			case 0://子弹向上
				y=y-speed;
				break;
			case 1://子弹向下
				y=y+speed;
				break;
			case 2://子弹向左
				x=x-speed;
				break;
			case 3://子弹向右
				x=x+speed;
				break;
			}
			System.out.println("子弹坐标：x=("+x+", y="+y+")");
			//子弹何时死亡？死亡了就该不再在run里向前飞着循环了。
			//填写代码？判断该子弹是否碰到边缘
			if()
			{
				this.isLive=false;
				break;
			}
		}
	}
}

//坦克类
class Tank
{
	//坦克的横坐标、纵坐标
	int x=0;
	int y=0;
	
	//坦克方向
	//0上，1下， 2左，3右 
	int direct=0;
	//坦克的速度
	int speed=4;
	
	// 坦克是否还活着
	boolean isLive=true;
	int color;
	
	public boolean isLive() {
		return isLive;
	}

	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}

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

//我的坦克
class Hero extends Tank
{
	//--V3_1 填写代码？添加属性：子弹
	
	
	public Hero(int x,int y)
	{
		super(x,y);
	}
	
	//--V3_1 写一个方法，开火（射击敌人）启动子弹的发射
	public void shotEnemy()
	{
		//创建子弹
		switch(this.direct)
		{
		case 0://坦克向上
			bomn=new Bomn(x+10,y,0);
			break;
		case 1://坦克向下
			bomn=new Bomn(x+10,y+30,1);
			break;
		case 2://坦克向左
			bomn=new Bomn(x,y+10,2);
			break;
		case 3://坦克向右
			bomn=new Bomn(x+30,y+10,3);
			break;
		}
		//填写代码？启动子弹线程
		
	}
	
	//坦克向上移动
	public void moveUp()
	{
		y-=speed;
	}
	//坦克向下移动
	public void moveDown()
	{
		y+=speed;
	}
	//坦克向左移动
	public void moveLeft()
	{
		x-=speed;
	}
	//坦克向右移动
	public void moveRight()
	{
		x+=speed;
	}
}

/**
 * 敌人的坦克
 *
 */
class EnemyTank extends Tank
{

	public EnemyTank(int x,int y)
	{
		super(x,y);
	}
}


