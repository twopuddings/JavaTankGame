package com.test3_1;
/**
 * 1.��com.test2.Members.java��
1)	�����ӵ��ࣺʵ��Runnable�ӿڣ�ʵ�ְ��������ʹ�ӵ�������ǰ���У�
���ԣ�
----����(x,y)
----���䷽�� (direct��0���ϣ�1���£�2����3����)������̹�������Ͳ����ͬ��
----�����ٶ�(speed)
----�Ƿ���Ч(isLive)
������
----���췽��-��ʼ������ֵ������
----ÿ�����Ե�gets\ sets����
----run������������д��
���ӵ����ɺ�˯��50�롣���ӵ���ǰ���У����ݷ��򣩡��жϸ��ӵ��Ƿ�������Ե����������Ե���������ϡ�
2)	�޸��ҵ�̹����Hero��
���ԣ�
   ----����ӣ��ӵ�Bomn  bomn=null;
������
 ----����ӣ�����ķ���������˿���shotEnemy���� ����д��
        �����ӵ������ݷ��򣩡������ӵ����У��̣߳�
 *
 */
public class Menbers {
}
/*�����ӵ���--V3_1*/
class Bomn implements Runnable
{
	int x;
	int y;
	int direct;
	int speed=3;
	// �ӵ��Ƿ񻹻���
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

                            //��д���룿���ӵ����ɺ�˯��50 ���롣
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switch(direct)
			{
			case 0://�ӵ�����
				y=y-speed;
				break;
			case 1://�ӵ�����
				y=y+speed;
				break;
			case 2://�ӵ�����
				x=x-speed;
				break;
			case 3://�ӵ�����
				x=x+speed;
				break;
			}
			System.out.println("�ӵ����꣺x=("+x+", y="+y+")");
			//�ӵ���ʱ�����������˾͸ò�����run����ǰ����ѭ���ˡ�
			//��д���룿�жϸ��ӵ��Ƿ�������Ե
			if()
			{
				this.isLive=false;
				break;
			}
		}
	}
}

//̹����
class Tank
{
	//̹�˵ĺ����ꡢ������
	int x=0;
	int y=0;
	
	//̹�˷���
	//0�ϣ�1�£� 2��3�� 
	int direct=0;
	//̹�˵��ٶ�
	int speed=4;
	
	// ̹���Ƿ񻹻���
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

//�ҵ�̹��
class Hero extends Tank
{
	//--V3_1 ��д���룿������ԣ��ӵ�
	
	
	public Hero(int x,int y)
	{
		super(x,y);
	}
	
	//--V3_1 дһ������������������ˣ������ӵ��ķ���
	public void shotEnemy()
	{
		//�����ӵ�
		switch(this.direct)
		{
		case 0://̹������
			bomn=new Bomn(x+10,y,0);
			break;
		case 1://̹������
			bomn=new Bomn(x+10,y+30,1);
			break;
		case 2://̹������
			bomn=new Bomn(x,y+10,2);
			break;
		case 3://̹������
			bomn=new Bomn(x+30,y+10,3);
			break;
		}
		//��д���룿�����ӵ��߳�
		
	}
	
	//̹�������ƶ�
	public void moveUp()
	{
		y-=speed;
	}
	//̹�������ƶ�
	public void moveDown()
	{
		y+=speed;
	}
	//̹�������ƶ�
	public void moveLeft()
	{
		x-=speed;
	}
	//̹�������ƶ�
	public void moveRight()
	{
		x+=speed;
	}
}

/**
 * ���˵�̹��
 *
 */
class EnemyTank extends Tank
{

	public EnemyTank(int x,int y)
	{
		super(x,y);
	}
}


