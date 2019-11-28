package tasks;

public class Driver 
{
	public static String func1(String name,String phone,String email,String hname,String hphone,String hemail)throws Exception
	{
		Sendmail.sendemail1(hemail, email, name, phone);
		Updatedb.updatedb1(name, phone, email, hname,hphone,hemail);
		Sendsms.sendsms(email, name, phone,hphone);
		return "Done";
	}
	public static String func2(String phone)throws Exception
	{
		Updatedb.updatedb2(phone);
		return "Done";
	}
	public static void main(String args[])
	{
		
	}
}


