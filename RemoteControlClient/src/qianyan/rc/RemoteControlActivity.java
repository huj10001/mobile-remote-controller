package qianyan.rc;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RemoteControlActivity extends Activity {
    EditText ipET;
    EditText socketET;
    Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ipET = (EditText)findViewById(R.id.IpEditText);
        socketET = (EditText)findViewById(R.id.SocketEditText);
        button = (Button)findViewById(R.id.ConnectButton);
        
        /******* add ***********/
        
        /************************/
        
        button.setOnClickListener(new OnClickListener() { 
        	@Override 
        	public void onClick(View v) { 
//        		String ipnum = ipET.getText().toString(); 
        		int socketnum = Integer.parseInt(socketET.getText().toString());
//        		Settings.ipnum =ipnum;
        		Settings.scoketnum = socketnum;
        		try {
        			//首先创建一个DatagramSocket对象
        			DatagramSocket socket = new DatagramSocket();
        			//创建一个InetAddree
//        			InetAddress serverAddress = InetAddress.getByName(ipnum);    			
        			Intent intent = new Intent(RemoteControlActivity.this,GestureActivity.class);
        			RemoteControlActivity.this.startActivity(intent);
        			RemoteControlActivity.this.finish();
        			Toast.makeText(RemoteControlActivity.this, "连接成功", Toast.LENGTH_SHORT).show();
        		} catch (Exception e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        		
        	} 
        }); 
    }

    /************ add ****************/    
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    	Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
//        if(null != bundle)
        {
	        String ipnum = "192.168.1.111";//bundle.getString("key");
	        ipET.setText(ipnum);
	        Settings.ipnum = ipnum;
	        try {
				InetAddress serverAddress = InetAddress.getByName(ipnum);
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
    }
    /***************************/
}