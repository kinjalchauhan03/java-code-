import java.awt.*;
import java.applet.*;
/*
<applet code="ckk154" width=600 height=100>
</applet>
*/
public class ck154 extends Applet implements Runnable
{
        String msg1="Department of Computer Science";
        String msg2="Department of Computer Science";
		Thread t=null;
		int s;
		boolean stopflag;
        	public void init()
        	{
                		//setBackground(Color.red);
                		//setForeground(Color.cyan);
        	}
        	public void start()
        	{
				t=new Thread(this);
				stopflag=false;
				t.start();
        	}
	public void run()
	{
		char ch1,ch2;
		for(;;)
		{
			try
			{	
				repaint();
				Thread.sleep(250);
				
				ch1=msg1.charAt(0);//left to right
				msg1=msg1.substring(1,msg1.length());
				msg1+=ch1;
				
				ch2=msg2.charAt(msg2.length()-1);//right to left
				msg2=msg2.substring(0,msg2.length()-1);
				msg2=ch2+msg2;
				
				if(stopflag)
					break;
			}
			catch(InterruptedException e)
			{}
		}
	}
	
      public void paint(Graphics g)
      {
              g.drawString(msg1,10,10);
              g.drawString(msg2,10,100);
      }
	public void stop()
	{
                		stopflag=true;
		t=null;
	}		
}
