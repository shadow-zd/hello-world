package byyl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;




public class gui {
	public static void main(String[] args) {
		new jiemian();
	}

}


class jiemian extends JFrame
{
	public jiemian()
	{
		this.setTitle("����ԭ��");//���ñ���
		this.setLayout(new BorderLayout());
		this.setSize(900,640);//���ô��ڴ�С
		this.setResizable(false);//��ֹ�û��ı䴰�ڴ�С
		this.setLocationRelativeTo(null);//���ô��ھ���
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ��ڽ��̽���
		
		Jli Li=new Jli();//Jli
		this.setContentPane(Li);//����С���
		this.setVisible(true);//���ô����Ƿ�ɼ�
		this.repaint();
	}
	
	class Jli extends JPanel
	{
		public Jli()
		{
			JLabel zhong=new JLabel("C���Ա������");
			JButton jb1 =new JButton("�ʷ�����");
			JButton jb2 =new JButton("�﷨����");
			//JButton jb0 =new JButton("�˳�");
			JTextArea jta=new JTextArea();
			
			
			zhong.setFont(new Font("����", Font.BOLD, 20));
			zhong.setBounds(370,0,900,50);
			zhong.setOpaque(true);//��͸��
			
			//zhong.setBorder(BorderFactory.createLineBorder(Color.red));//����ɫȷ��λ��
			
			jb1.setBounds(20, 70, 200, 50);
			jb1.setFont(new Font("����", Font.BOLD, 20));
			jb1.setContentAreaFilled(false);
			jb1.setBorderPainted(true);
			jb1.addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							 try {
								 cffx re=new cffx();
								 String s=jta.getText();
								 re.CiFa(s);
							} 
							 catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}	
					}
				);
			
			
			
			
			jb2.setBounds(20, 170, 200, 50);
			jb2.setFont(new Font("����", Font.BOLD, 20));
			jb2.setContentAreaFilled(false);
			jb2.setBorderPainted(true);
			jb2.addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							 try {
								 yffx re=new yffx();
								 String s=jta.getText();
								 re.getString(s);
								 re.YuFa();
							} 
							 catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}	
					}
				);
			
			
			
			
			
			JScrollPane js=new JScrollPane(jta);
			js.setBounds(250,50,580,500);
			js.setVerticalScrollBarPolicy(
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			this.add(js);
			jta.setLineWrap(true);        //�����Զ����й��� 
			jta.setWrapStyleWord(true);   // ������в����ֹ���
			
			
		
			this.setLayout(null);
			this.add(jb1);
			this.add(zhong);
			this.add(jb2);
		}
	}
	
}


