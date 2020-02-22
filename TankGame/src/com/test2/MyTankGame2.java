package com.test2;
/**
 * ���ܣ�̹����Ϸ��2.0
 * 1.����̹��
 * 2.��̹�����������ƶ�
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
/**
 * ��com.test2.MyTankGame2.java�У� 
1)	���ࣺ
  main������
  ���췽������ʼ����壻
                   �������뵽��ܣ�
                   �����������Ӽ����¼���������
2)	MyPanel�ࣺ implements KeyListener
   a.����һ���ҵ�̹�ˣ�������˵�̹�ˣ�3������
   b.���췽������ʼ���ҷ�̹�ˣ���ʼ�����˵�̹�ˣ�
   c.��ͼpaint�������������Լ���̹�ˣ������˵�̹�ˡ�
     ����д�û�̹�˵ķ���drawTank(int x, int y, Graphics g, int direct, int type )��
   d.�¼����������¼�����ֻҪȥ�жϰ��µ���ʲô����ļ�
     ������Ϊ����direct=0;moveUp();repaint()��
 */
public class MyTankGame2 extends JFrame {


	MyPanel mp=null;
	
	public static void main(String[] args) {
		MyTankGame2 myTankGame2=new MyTankGame2();
	}
	
	/**
	 * ���췽��
	 */
	public MyTankGame2()
	{
		/**��д���룿�����췽������ʼ����壻
                   �������뵽��ܣ�
                   �����������Ӽ����¼���������
		*/

		this.setSize(400,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}

/**
 * �ҵ����
 */
class MyPanel extends JPanel  implements KeyListener
{
	//����һ���ҵ�̹��
	Hero hero=null;
       //������˵�̹��3��
	Vector<EnemyTank> ets=new Vector<EnemyTank>();
	int enSize=3;
	
	//���췽��
	public MyPanel()
	{
		//��ʼ���ҷ�̹��
		hero=new Hero(200,200);
		
		//��ʼ�����˵�̹��
		for(int i=0;i<enSize;i++)
		{
			//����һ�����˵�̹�˶���
			EnemyTank et=new EnemyTank((i+1)*50,0);
                       //��д���룿���õз�̹����ɫ������
			                   //�С�̹�ˣ���ɫint color��0-��ɫ-yellow  1-ǳ��-cyan
			                   //����direct��0���ϣ�1���£�2����3����
			//����
			ets.add(et);
		}
	}
	//����paint 
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0,0,400,300);
		
		//��д���룿�����Լ���̹��
		
		//��д���룿�������˵�̹��
		
		
		
		
	}
	
	//����̹�˵ķ���
	public void drawTank(int x,int y,Graphics g,int direct,int type)
	{
		//�ж���ʲô���͵�̹��
		switch(type)
		{
		case 0:
			g.setColor(Color.cyan); //
			break;
		case 1:
			g.setColor(Color.yellow);
			break;
		}
		
		//�ж�̹�˷���
		switch(direct)
		{/*�����ҵ�̹�ˣ���ʱ�ٷ�װ��һ��������*/
		
		case 0://̹������
			
			//1.������ߵľ���
			g.fill3DRect(x,y,5,30,false);
			//2.�����ұߵľ���
			g.fill3DRect(x+15,y,5 , 30,false);
			//3.�����м�ľ���
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//4.�����м��Բ
			g.fillOval(x+5, y+10, 10, 10);
			//4.����ֱ��
			g.setColor(Color.red);
			g.drawLine(x+10,y,x+10,y+15);
			break;
		case 1://̹������
			/*�������µ�̹��*/
			//1.������ߵľ���
			g.fill3DRect(x,y,5,30,false);
			//2.�����ұߵľ���
			g.fill3DRect(x+15,y,5 , 30,false);
			//3.�����м�ľ���
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//4.�����м��Բ
			g.fillOval(x+5, y+10, 10, 10);
			//4.����ֱ��
			g.setColor(Color.red);
			g.drawLine(x+10,y+30,x+10,y+15);
			break;
		case 2://̹������
			/*���������̹��*/
	        g.fill3DRect(x,y,30,5,false);
	        g.fill3DRect(x,y+15,30,5,false);
	        g.fill3DRect(x+5,y+5,20,10,false);
	        g.fillOval(x+10, y+5, 10, 10);
	        g.setColor(Color.red);
	        g.drawLine(x+15,y+10, x,y+10);
	        break;
		case 3://̹������
			/*�������ҵ�̹��*/
			g.fill3DRect(x,y,30,5,false);
	        g.fill3DRect(x,y+15,30,5,false);
	        g.fill3DRect(x+5,y+5,20,10,false);
	        g.fillOval(x+10, y+5, 10, 10);
	        g.setColor(Color.red);
	        g.drawLine(x+15,y+10, x+30,y+10);
	        break;
		}
	}
	
	//�����´���a���� s���� w���� d����
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_W)
		{
		    //w����
			this.hero.setDirect(0);
			this.hero.moveUp();
		
		}else if(e.getKeyCode()==KeyEvent.VK_S)
		{
			//d����
			this.hero.setDirect(1);
			this.hero.moveDown();
			
		}else if(e.getKeyCode()==KeyEvent.VK_A)
		{
			//a����
			this.hero.setDirect(2);
			this.hero.moveLeft();
			
		}else if(e.getKeyCode()==KeyEvent.VK_D)
		{
			//s����
			this.hero.setDirect(3);
			this.hero.moveRight();	
		}
		//��д���룿�����ػ洰��
		
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


