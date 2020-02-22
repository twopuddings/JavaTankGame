package com.test2;
/**
 * 
 * 1.在com.test2.Members.java中
1)	定义坦克类Tank。
属性：坐标(x,y)，炮筒方向(direct：0向上，1向下，2向左，3向右)，速度(speed)，
          颜色(int color：0-黄色-yellow  1-浅蓝-cyan)。
方法：构造方法：初始化坐标值；每个属性的gets\ sets方法。
2)	定义我的坦克类Hero：继承自坦克类。
 方法：构造方法：调用父类的构造方法初始化坐标
           moveUp(){}等等：写出向四个方向移动的方法。

3)	定义敌人的坦克类：继承自坦克类。
方法：构造方法—调用父类的构造方法初始化坐标
 */
public class Menbers {
}

/**
 * 定义坦克类Tank
 */
class Tank
{
	//坦克的横坐标、纵坐标
	int x=0;
	int y=0;
	
	//坦克方向:0上，1下， 2左，3右 
	int direct=0;
	//坦克的速度
	int speed=4;
	//坦克的颜色
	int color;
	
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
  //构造方法-初始化坐标值,每个属性的gets\ sets方法
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
 * 定义我的坦克类Hero
 */
class Hero extends Tank
{
	//填写代码？构造方法：调用父类的构造方法初始化坐标

	
	//坦克向上移动
	public void moveUp()
	{
		//填写代码？

	}
	//坦克向下移动
	public void moveDown()
	{
		//填写代码？
	}
	//坦克向左移动
	public void moveLeft()
	{
		//填写代码？
	}
	//坦克向右移动
	public void moveRight()
	{
		//填写代码？
	}
}

/**
 * 定义敌人的坦克类EnemyTank
 */
class EnemyTank extends Tank
{

	public EnemyTank(int x,int y)
	{
		super(x,y);
	}
}
