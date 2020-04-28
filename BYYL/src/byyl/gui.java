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
		this.setTitle("编译原理");//设置标题
		this.setLayout(new BorderLayout());
		this.setSize(900,640);//设置窗口大小
		this.setResizable(false);//禁止用户改变窗口大小
		this.setLocationRelativeTo(null);//设置窗口居中
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口进程结束
		
		Jli Li=new Jli();//Jli
		this.setContentPane(Li);//加入小面板
		this.setVisible(true);//设置窗口是否可见
		this.repaint();
	}
	
	class Jli extends JPanel
	{
		public Jli()
		{
			JLabel zhong=new JLabel("C语言编译程序");
			JButton jb1 =new JButton("词法分析");
			JButton jb2 =new JButton("语法分析");
			//JButton jb0 =new JButton("退出");
			JTextArea jta=new JTextArea();
			
			
			zhong.setFont(new Font("宋体", Font.BOLD, 20));
			zhong.setBounds(370,0,900,50);
			zhong.setOpaque(true);//不透明
			
			//zhong.setBorder(BorderFactory.createLineBorder(Color.red));//看颜色确认位置
			
			jb1.setBounds(20, 70, 200, 50);
			jb1.setFont(new Font("宋体", Font.BOLD, 20));
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
			jb2.setFont(new Font("宋体", Font.BOLD, 20));
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
			jta.setLineWrap(true);        //激活自动换行功能 
			jta.setWrapStyleWord(true);   // 激活断行不断字功能
			
			
		
			this.setLayout(null);
			this.add(jb1);
			this.add(zhong);
			this.add(jb2);
		}
	}
	
}


