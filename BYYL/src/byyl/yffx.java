package byyl;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class yffx extends JFrame 
{
	JTextArea ret=new JTextArea();
	String str="";
	int flag=10086;
	int i=0;
	int shu=1;
	String yufaend="";
	char[] ch;
	public yffx()
	{
		JScrollPane js=new JScrollPane(ret);
		js.setBounds(250,50,400,640);
		js.setVerticalScrollBarPolicy(
		JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		ret.setLineWrap(true);        //激活自动换行功能 
		ret.setWrapStyleWord(true);   // 激活断行不断字功能
		this.setTitle("结果");//设置标题
		this.setSize(400,640);//设置窗口大小
		this.setResizable(false);//禁止用户改变窗口大小
		this.setLocationRelativeTo(null);//设置窗口居中
		this.setVisible(true);//设置窗口是否可见
		this.repaint();
		ret.setBounds(250,50,580,500);
		this.add(js);
	}
	public void getString(String s)
	{
		s=s+'#';
		s = s.replace("\n", "");
		s = s.replace(" ", "");
		char[] c= s.toCharArray();
		ch=c;
	}
	public void YuFa()
	{
		E();
		if (flag!=0)
		{
			yufaend += "\n"+"accept\n";
		} 
		else {
			yufaend+= "\n"+"error\n";
		}
		ret.setText(yufaend);
	}
	
	public  void E() 
	{
		if (flag == 0) return;
		if (ch[i]=='m')
		{
			i++;
			if(ch[i++]=='a'&&ch[i++]=='i'&&ch[i++]=='n'&&ch[i++]=='('&&ch[i++]==')'&&ch[i++]=='{')
			{
				yufaend+=shu++ + "   程序--->main关键字(){声明序列 语句序列}";
							
				A();
				B();
				if (ch[i]=='}') 
				{
					i++;
				}
				else 
				{
					flag=0;
					yufaend+= "\n" + "errorE";
				}
				System.out.println(i);
			}
			else 
			{
				flag=0;
				yufaend+= "\n" + "errorE";
			}
		} 
	}
	
	public  void A()
	{
		if (flag == 0)
			return;
		if (ch[i]=='i')
		{
			if(ch[i+1]=='n'&&ch[i+2]=='t')
			{
				yufaend += "\n" + shu++ + "   声明序列--->声明语句  声明序列";
				C();
				A();
			}
		} 
		else {
			yufaend += "\n" + shu++ + "   声明序列--->空";
		}
	}
	public void B()
	{
		if (flag == 0)
			return;
		if((ch[i]>='a'&&ch[i]<='z')||(ch[i]>='A'&&ch[i]<='Z')||ch[i]=='_'||ch[i]=='{')// 下划线开头也算标识符
		{
			yufaend += "\n" + shu++ + "   语句序列--->语句  语句序列";
			H();
			B();
		}
		else {
			yufaend += "\n" + shu++ + "   语句序列---> 空";
			
		}
	}
	public void C()
	{
		if (flag == 0)
			return;
		if (ch[i]=='i') 
		{i++;
			if(ch[i++]=='n'&&ch[i++]=='t')
			{
				yufaend += "\n" + shu++ + "   声明语句 --->int关键字   标识符表;";
				F();
				if (ch[i]==';') 
				{
					i++;
				} 
				else 
				{
					// System.out.println("errorC");
					yufaend += "\n" + "errorC";
					flag = 0;
				}
			}		
		}
		else 
		{
			yufaend += "\n" + "errorC";
			flag = 0;
		}
	}
	public void F()
	{
		if (flag == 0)
			return;
		if ((ch[i]>='a'&&ch[i]<='z')||(ch[i]>='A'&&ch[i]<='Z')||ch[i]=='_') 
		{
			yufaend+="\n" + shu++ + "   标识符表--->标识符 FF";
			G();
			FF();
		} 
		else {
			flag = 0; 
			yufaend += "\n" + "errorF";
			return;
		}
	}
	public void FF()
	{
		if (flag == 0)
			return;
		if(ch[i]==',') 
		{
			i++;
			yufaend+="\n" + shu++ + "   FF--->, 标识符表";
			F();
		}
		else {
			yufaend+="\n" +shu++ +"   FF--->&";
		}
	}
	public void H()
	{
		if (flag == 0)
			return;
		if (ch[i]=='i')
		{
			if(ch[i+1]=='f')
			{
				yufaend += "\n" + shu++ + "   语句--->if语句";
				I();
			}
			else 
			{
				yufaend += "\n" + "errorH";
				flag = 0;
				return;
			}
		} 
		
		else if (ch[i]=='w') 
		{
			if(ch[i+1]=='h')
			{
				if(ch[i+2]=='i')
				{
					if(ch[i+3]=='l')
					{
						if(ch[i+4]=='e')
						{
							yufaend += "\n" + shu++ + "   语句--->while语句";
							W();
						}
						else 
						{
							yufaend += "\n" + "errorH";
							flag = 0;
							return;
						}
					}
					else 
					{
						yufaend += "\n" + "errorH";
						flag = 0;
						return;
					}
				}
				else 
				{
					yufaend += "\n" + "errorH";
					flag = 0;
					return;
				}
			}
			else 
			{
				yufaend += "\n" + "errorH";
				flag = 0;
				return;
			}
			
		} 
		else if (ch[i]=='{') 
		{
			yufaend += "\n" + shu++ + "   语句--->复合语句";
			J();
		} 
		else if ((ch[i]>='a'&&ch[i]<='z')||(ch[i]>='A'&&ch[i]<='Z')||ch[i]=='_'||(ch[i]<='9'&&ch[i]>='0') ) 
		{
			yufaend += "\n" + shu++ + "   语句--->赋值语句";
			K();
		} 
		else 
		{
			yufaend += "\n" + "errorH";
			flag = 0;
			return;
		}
	}
	public void I()
	{
		if (flag == 0)
			return;
		if (ch[i]=='i'&&ch[i+1]=='f'&&ch[i+2]=='(') 
		{
			i += 3;
			yufaend += "\n" + shu++ + "   IF语句--->if(表达式) 复合语句";
			L();
			if (ch[i]==')') 
			{
				i++;
				J();
			} 
			else 
			{
				flag = 0;
				yufaend += "\n" + "errorI";
				return;
			}
		} 
		else 
		{
			yufaend += "\n" + "errorI";
			flag = 0;
			return;
		}
	}
	
	public void J()
	{
		if (flag == 0)
			return;
		if (ch[i]=='{') 
		{
			i++;
			yufaend += "\n" + shu++ + "   复合语句--->{语句序列}";
			B();
			if (ch[i]=='}') 
			{
				i++;
			} 
			else 
			{
				yufaend += "\n" + "errorJ1";
				flag = 0;
				return;
			}
		} 
		else 
		{
			flag = 0;
			yufaend += "\n" + "errorJ2";
			return;
		}
	}
	
	public void W()
	{
		if (flag == 0)
			return;
		if (ch[i]=='w'&&ch[i+1]=='h'&&ch[i+2]=='i'&&ch[i+3]=='l'&&ch[i+4]=='e'&&ch[i+5]=='(') 
		{
			i += 6;
			yufaend += "\n" + shu++ + "   While--->(表达式) 复合语句";
			L();
			if (ch[i]==')') 
			{
				i++;
				J();
			} 
			else {
				flag = 0;
				yufaend += "\n" + "errorW";
				return;
			}
		} 
		else {
			flag = 0;
			yufaend += "\n" + "errorW";
			return;
		}
	}
	
	public void K()
	{
		if (flag == 0)
			return;
		if ((ch[i]>='a'&&ch[i]<='z')||(ch[i]>='A'&&ch[i]<='Z')||ch[i]=='_' ||(ch[i]<='9'&&ch[i]>='0') ) 
		{
			yufaend += "\n" + shu++ + "   赋值语句--->表达式";
			L();
			if (ch[i]==';') 
			{
				i++;
			} 
			else 
			{
				flag = 0;
				yufaend += "\n" + "errorK";
				return;
			}
		} 
		else 
		{
			flag = 0;
			yufaend += "\n" + "errorK";
			return;
		}
	}
	public void L()
	{
		if (flag == 0)
			return;
		if (((ch[i]>='a'&&ch[i]<='z')||(ch[i]>='A'&&ch[i]<='Z')||ch[i]=='_'||(ch[i]<='9'&&ch[i]>='0'))&& ch[i+1]=='>' || ch[i+1]=='<') 
		{
			yufaend += "\n" + shu++ + "   表达式--->布尔表达式";
			S();
		} 
		else if ((ch[i]>='a'&&ch[i]<='z')||(ch[i]>='A'&&ch[i]<='Z')||ch[i]=='_') 
		{
			yufaend += "\n" + shu++ + "   表达式--->标识符=算术表达式";
			G();
			if (ch[i]=='=') 
			{
				i++;
				M();
			} 
			else 
			{
				flag = 0;
				yufaend += "\n" + "errorL1";
				return;
			}
		} 
		else 
		{
			flag = 0;
			yufaend += "\n" + "errorL";
			return;
		}
	}
	public void S()
	{
		if (flag == 0)
			return;
		if ((ch[i]>='a'&&ch[i]<='z')||(ch[i]>='A'&&ch[i]<='Z')) 
		{
			yufaend += "\n" + shu++ + "   布尔表达式--->字母    关系运算符    算术表达式";
			R();
			T();
			M();
		}
		else if(ch[i]>='0'&&ch[i]<='9') 
		{
			yufaend += "\n" + shu++ + "   布尔表达式--->无符号整数   关系运算符    算术表达式";
			Q();
			T();
			M();
		}
		else {
			flag = 0;// System.out.println("errorL");
			yufaend += "\n" + "errorS";
			return;
		}
	}
	public void T()
	{
		if (flag == 0)
			return;
		if (ch[i]=='>'||ch[i]=='<') 
		{
			 
				yufaend += "\n" + shu++ + "   关系运算符--->" + ch[i];
				i++;
		} 
		else 
		{
			flag = 0;
			yufaend += "\n" + "errorT";
			return;
		}
	}
	public void M()
	{
		if (flag == 0)
			return;
		if ((ch[i]>='a'&&ch[i]<='z')||(ch[i]>='A'&&ch[i]<='Z')||ch[i]=='_' ||(ch[i]<='9'&&ch[i]>='0') ) 
		{
			yufaend += "\n" + shu++ + "   算术表达式--->项MM";
			
			N();
			
			MM();
		} 
		else 
		{
			flag = 0;
			yufaend += "\n" + "errorM";
			return;
		}
	}
	public void MM()
	{
		if (flag == 0)
			return;
		if (ch[i]=='+'||ch[i]=='-') 
		{
			yufaend += "\n" + shu++ + "   MM--->" + ch[i] + "项  MM";
			i++;
			N();
			MM();
		}
		else {
			yufaend += "\n" + shu++ + "   MM--->&";
		}
	}
	public void N()
	{
		if (flag == 0)
			return;
		if ((ch[i]>='a'&&ch[i]<='z')||(ch[i]>='A'&&ch[i]<='Z')||ch[i]=='_' ||(ch[i]<='9'&&ch[i]>='0') ) 
		{
			
			yufaend += "\n" + shu++ + "   项--->因子  NN";
			P();
			NN();
		} 
		else 
		{
			flag = 0;
			yufaend += "\n" + "errorN";
			return;
		}
	}
	public void NN()
	{
		if (flag == 0)
			return;
		if (ch[i]=='*'||ch[i]=='/') 
		{
			yufaend += "\n" + shu++ + "   NN--->" + ch[i] + "因子  NN";
			i++;
			N();
			NN();
		}
		else 
		{
			yufaend+="\n" + shu++ + "   NN-->&";
		}
	}
	public void P()
	{
		if (flag == 0)
			return;
		if ((ch[i]>='a'&&ch[i]<='z')||(ch[i]>='A'&&ch[i]<='Z')||ch[i]=='_') 
		{
			
			yufaend += "\n" + shu++ + "   因子--->标识符";
			G();
		} 
		else if (ch[i]<='9'&&ch[i]>='0') 
		{
			
			yufaend += "\n" + shu++ + "   因子--->无符号整数";
			Q();
		}  
		 else
		 {
			flag = 0;
			yufaend += "\n" + "errorP";
			return;
		}
	}
	public void Q()
	{
		if (flag == 0)
		{return;}
		yufaend += "\n" + shu++ + "   无符号整数--->"+ch[i];	
		i++;
	}
	public void G()
	{
		if (flag == 0)
			return;
		if ((ch[i]>='a'&&ch[i]<='z')||(ch[i]>='A'&&ch[i]<='Z')) 
		{
			yufaend += "\n" + shu++ + "   标识符--->字母   GG";
			R();
			GG();
		} 
		else if (ch[i]=='_') 
		{
			i++;
			yufaend += "\n" + shu++ + "   标识符--->_ GG";
			GG();
		} 
		else 
		{
			yufaend += "\n" + "errorG";
			flag = 0;
			return;
		}
	}
	public void GG()
	{
		if (flag == 0)
			return;
		if ((ch[i]>='a'&&ch[i]<='z')||(ch[i]>='A'&&ch[i]<='Z')) 
		{
			yufaend += "\n" + shu++ + "   GG--->字母 GG";
			R();
			GG();
		} 
		else if (ch[i]<='9'&&ch[i]>='0') 
		{
			yufaend += "\n" + shu++ + "   GG--->数字 GG";
			Q();
			GG();
		} 
		else 
		{
			yufaend += "\n" + shu++ + "   GG--->&";
		}
	}
	public void R()
	{
		if (flag == 0)
			return;
		if ((ch[i]>='a'&&ch[i]<='z')||(ch[i]>='A'&&ch[i]<='Z')) 
		{
			yufaend += "\n" + shu++ + "   字母--->" + ch[i];
			i++;
		} 
		else 
		{
			flag = 0;
			yufaend += "\n" + "errorR";
			return;
		}
	}
}
