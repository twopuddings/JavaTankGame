package com.test2;
/**
 * 
 * 1.��com.test2.Members.java��
1)	����̹����Tank��
���ԣ�����(x,y)����Ͳ����(direct��0���ϣ�1���£�2����3����)���ٶ�(speed)��
          ��ɫ(int color��0-��ɫ-yellow  1-ǳ��-cyan)��
���������췽������ʼ������ֵ��ÿ�����Ե�gets\ sets������
2)	�����ҵ�̹����Hero���̳���̹���ࡣ
 ���������췽�������ø���Ĺ��췽����ʼ������
           moveUp(){}�ȵȣ�д�����ĸ������ƶ��ķ�����

3)	������˵�̹���ࣺ�̳���̹���ࡣ
���������췽�������ø���Ĺ��췽����ʼ������
 */
public class Menbers {
}

/**
 * ����̹����Tank
 */
class Tank
{
	//̹�˵ĺ����ꡢ������
	int x=0;
	int y=0;
	
	//̹�˷���:0�ϣ�1�£� 2��3�� 
	int direct=0;
	//̹�˵��ٶ�
	int speed=4;
	//̹�˵���ɫ
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
  //���췽��-��ʼ������ֵ,ÿ�����Ե�gets\ sets����
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
 * �����ҵ�̹����Hero
 */
class Hero extends Tank
{
	//��д���룿���췽�������ø���Ĺ��췽����ʼ������

	
	//̹�������ƶ�
	public void moveUp()
	{
		//��д���룿

	}
	//̹�������ƶ�
	public void moveDown()
	{
		//��д���룿
	}
	//̹�������ƶ�
	public void moveLeft()
	{
		//��д���룿
	}
	//̹�������ƶ�
	public void moveRight()
	{
		//��д���룿
	}
}

/**
 * ������˵�̹����EnemyTank
 */
class EnemyTank extends Tank
{

	public EnemyTank(int x,int y)
	{
		super(x,y);
	}
}
