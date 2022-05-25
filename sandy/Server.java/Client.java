package sandy.Dcn;

import java.io.*;
import java.net.*;
public class Client {
	public static void main(String aafhbasgj[])throws Exception
	{
	Socket s=new Socket("localhost",6483);
	String opmsg;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	DataInputStream in=new DataInputStream(s.getInputStream());
	PrintStream dos=new PrintStream(s.getOutputStream());
	int iterations=Integer.parseInt(in.readLine());
	String msg=in.readLine();
	int no=Integer.parseInt(msg);
	int i=0,intr=0,iframe=0;
	int framecounter=0;
	while(intr<iterations)
	{
	msg=in.readLine();
	System.out.println(msg);
	i++;
	framecounter++;
	if(framecounter%no==0)
	{
	System.out.println("sending ack to server");
	opmsg="ACK : FRAME "+iframe+" RECIEVED";
	dos.println(opmsg);
	iframe++;
	}
	if(i==8)
	{
	i=0;
	intr++;
	}
	}
	s.close();
	}
}
