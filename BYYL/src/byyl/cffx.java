package byyl;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class cffx extends JFrame
{
	JTextArea ret=new JTextArea();
	String str="";
	public cffx()
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
	 public void CiFa(String s)
	{
		 int iq=0;
		 String[] st = s.split("\r|\n");
		 String cifaend="";
		 for(iq=0;iq<st.length;iq++)
		{
				char[] ch = st[iq].toCharArray();
				  int n=ch.length;
				  int i=0;
				  String str="";
				  for(int j=0;j<n;j++)
				    {
				        if(ch[i]==' ')
				        {
				        	i++;
				            continue;
				        }
				        else if(ch[i]=='{'||ch[i]=='}'||ch[i]=='('||ch[i]==')'||ch[i]==','||ch[i]==';')
				        {
				        	cifaend=cifaend+"(boundary,"+ch[i]+')'+'\n';
				            i++;
				            j=i-1;
				        }
				        
				        else if(isDight(ch[i])==1)
				        {
				            while(isDight(ch[i])==1)
				            {
				                str=str+ch[i];
				                i++;
				            }
				            cifaend=cifaend+"(integer,"+str+')'+'\n';
				            j=i-1;
				            str="";
				        }
				        
				        else if(isCharacter(ch[i])==1)
				        {
				            while(isCharacter(ch[i])==1||isDight(ch[i])==1)
				            {
				            	str=str+ch[i];      
				                i++;
				            }
				            if(isKey(str)==1)
				            {
				            	cifaend=cifaend+"(keyword,"+str+')'+'\n';
				            }
				            else cifaend=cifaend+"(identifier,"+str+')'+'\n';	
				            j=i-1;
				            str="";
				        }
				        
				         else if (isOperator(ch[i])==1)
				         {
				            while(isOperator(ch[i])==1)
				            {
				            	str=str+ch[i];      
				                i++;
				            }
				            cifaend=cifaend+"(operator,"+str+')'+'\n';
				            j=i-1;
				            str="";
				          }
				    }
			}
		 ret.setText(cifaend);
	}
	 
	 static int isDight(char ch)
		{
		    if(ch>='0'&&ch<='9')
		    {
		        return 1;
		    }
		    else return 0;
		}

		static int isCharacter(char ch)
		{
		    if(ch>='a'&&ch<='z'||ch>='A'&&ch<='Z'||ch=='_')
		    {
		        return 1;
		    }
		    else return 0;
		}

		static int isKey(String str)
		{
		    if(str.compareTo("main")==0||str.compareTo("if")==0||str.compareTo("else")==0||str.compareTo("for")==0||str.compareTo("int")==0||str.compareTo("while")==0)
		    {
		        return 1;
		    }
		    else return 0;
		}

		static int isOperator(char ch)
		{
		    if(ch == '+'|| ch == '-'||ch == '*'|| ch == '/'||ch == '>'|| ch == '<'||ch == '!'|| ch == '=')
		        {return 1;}
		    else return 0;
		}
}