package tasks;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
public class Sendsms
{
    public static final String ACCOUNT_SID =
            "/*Your Twilio Account SID*/";  //Your Twilio account SID that will be used to send sms
    public static final String AUTH_TOKEN =
            "/*Your Twilio account Auth Key*/"; //Twilio account auth key
    static void sendsms(String mail,String name,String phone,String to)
    {
    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber(to), // to
                        new PhoneNumber("+12055832644"), // from
                        "Name : "+name+"\n Phone Number : "+phone+"\n Email Address : "+mail+"\n")
                .create();
    }
    public static void main(String[] args) 
    {
    	
    }
}
