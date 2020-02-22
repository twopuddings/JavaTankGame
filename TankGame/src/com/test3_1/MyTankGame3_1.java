package com.test3_1;
/**
 * ���ܣ�̹����Ϸ��3.0
 * 1.����̹��
 * 2.��̹�����������ƶ�
 * 3.�����ӵ�������J���ܷ���һ���ӵ� 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
/**
 * 2)	�޸�MyPanel�� implements KeyListener:
a.����һ���ҵ�̹�ˣ�������˵�̹�ˣ�3������
b.������
���췽����
---��ʼ���ҷ�̹��
---��ʼ�����˵�̹��
paint����������
---���Լ���̹��
   ---�����˵�̹�ˡ�����д�û�̹�˵ķ���drawTank(int x, int y, Graphics g, int direct, int type )����
   ---�����ӵ�:����ӵ���Ч�����ӵ���Ȼ������(g.drawOval)�ӵ���
�¼����������¼���keyPressed��������������룺
---ֻҪȥ�жϰ��µ���ʲô����ļ�������Ϊ����direct=0;moveUp();repaint()����
      ---�����ж�����Ƿ���F����������£������hero.shotEnemy�������������ӵ���
  
дrun������while(true){ÿ��100�룬ȥ�ػ档}
 */
public class MyTankGame3_1 extends JFrame {

	MyPanel mp=null;
	
	public static void main(String[] args) {
		MyTankGame3_1 myTankGame2=new MyTankGame3_1();
	}
	
	//���췽��
	public MyTankGame3_1()
	{
		mp=new MyPanel();
		////��д���룿����mp�߳�--V3_1
		
		
		this.add(mp);
		this.addKeyListener(mp);
		
		this.setSize(400,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}

//�ҵ����--V3.1����������߳��ࣨʵ��Runnalbe�ӿڣ�
class MyPanel extends JPanel  implements KeyListener //��д���룿
{
	
	//����һ���ҵ�̹��
	Hero hero=null;
    //������˵�̹��
	Vector<EnemyTank> ets=new Vector<EnemyTank>();
	
	int enSize=3;
	
	//���췽��
	public MyPanel()
	{
		hero=new Hero(200,200);
		
		//��ʼ�����˵�̹��
		for(int i=0;i<enSize;i++)
		{
			//����һ�����˵�̹�˶���
			EnemyTank et=new EnemyTank((i+1)*50,0);
			et.setColor(0);
			et.setDirect(1);
			//����
			ets.add(et);
		}
	}
	//����paint 
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0,0,400,300);
		
		//�����Լ���̹��
		this.drawTank(hero.getX(), hero.getY(), g, this.hero.direct, 1);
		//�����ӵ�--V3.0
		if(hero.bomn!=null && hero.bomn.isLive==true)
		{
			g.setColor(Color.red);
			g.draw3DRect(hero.bomn.x, hero.bomn.y, 1, 1, false);
		}
		
		//�������˵�̹��
		for(int i=0;i<ets.size();i++)
		{
			this.drawTank(ets.get(i).getX(), ets.get(i).getY(), g, this.ets.get(i).direct, 0);
		}
		
		
		
	}
	
	//����̹�˵ķ���
	public void drawTank(int x,int y,Graphics g,int direct,int type)
	{
		//�ж���ʲô���͵�̹��
		switch(type)
		{
		case 0:
			g.setColor(Color.cyan);
			break;
		case 1:
			g.setColor(Color.yellow);
			break;
		}
		
		//�жϷ���
		switch(direct)
		{/*�����ҵ�̹�ˣ���ʱ�ٷ�װ��һ��������*/
		//����
		case 0:
			
			//1.������ߵľ���
			g.fill3DRect(x,y,5,30,false);
			//2.�����ұߵľ���
			g.fill3DRect(x+15,y,5 , 30,false);
			//3.�����м�ľ���
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//4.�����м��Բ
			g.fillOval(x+5, y+10, 10, 10);
			//4.����ֱ��
			g.drawLine(x+10,y,x+10,y+15);
			break;
		case 1:
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
			g.drawLine(x+10,y+30,x+10,y+15);
			break;
		case 2:
			/*���������̹��*/
	        g.fill3DRect(x,y,30,5,false);
	        g.fill3DRect(x,y+15,30,5,false);
	        g.fill3DRect(x+5,y+5,20,10,false);
	        g.fillOval(x+10, y+5, 10, 10);
	        g.drawLine(x+15,y+10, x,y+10);
	        break;
		case 3:
			/*�������ҵ�̹��*/
			g.fill3DRect(x,y,30,5,false);
	        g.fill3DRect(x,y+15,30,5,false);
	        g.fill3DRect(x+5,y+5,20,10,false);
	        g.fillOval(x+10, y+5, 10, 10);
	        g.drawLine(x+15,y+10, x+30,y+10);
	        break;
		}
	}
	
	//�����´���a���� s���� w���� d����
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_W)
		{
		    //��д���룿����
			
		
		}else if(e.getKeyCode()==KeyEvent.VK_S)
		{
			//��д���룿����
			
			
		}else if(e.getKeyCode()==KeyEvent.VK_A)
		{
			//��д���룿����
		
			
		}else if(e.getKeyCode()==KeyEvent.VK_D)
		{
			//��д���룿����
				
		}
		
		//��д���룿���ж�����Ƿ���J�����ǣ������hero.shotEnemy()---V3.0
		if()
		{
			this.hero.shotEnemy();
		}
		
		//�����ػ洰��
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
		//ÿ��100����ȥ�ػ�
		while(true)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//�ػ�
			this.repaint();
		}
		
	}
}


