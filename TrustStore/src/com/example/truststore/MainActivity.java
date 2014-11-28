package com.example.truststore;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.example.truststore.R;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Contacts;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    private static List<User> userlist = new ArrayList<User>();
    private static List<String> fileList = new ArrayList<String>();
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getContactList(this.findViewById(android.R.id.content));
        File root = new File(Environment
  	          .getExternalStorageDirectory()
  	          .getAbsolutePath());
        readFileList(root);
    }
	
	public void readFileList(File f){
		File[] files = f.listFiles();
	     fileList.clear();
	     for (File file : files){
	      fileList.add(file.getPath()); 
	     }
	}
	
	public void display_filelist(View view) {
		Intent intent = new Intent(this, AndroidListFilesActivity.class);
		startActivity(intent);
	}
    
    //get the phones contact list using the ContentProvider
    @SuppressLint("NewApi") public void getContactList(View view) {
    	ContentResolver contentResolver = getContentResolver();
    	//Create query data, URI:uri, String[]:projection, String:selection, String[]:selectionArgs, String:sortOrder
    	Uri uri = ContactsContract.Contacts.CONTENT_URI;
    	String[] projection = 	new String[]{
    			Contacts._ID,
    			Contacts.LOOKUP_KEY,
    			Contacts.DISPLAY_NAME
    			};
    	Cursor cursor = contentResolver.query(uri, projection, null, null, null);
    	//DatabaseUtils.dumpCursor(cursor);
    	if (cursor.moveToFirst()) {
    		do {
    			long id = cursor.getLong(0);
    			String key = cursor.getString(1);
    			String name = cursor.getString(2);
    			User user = new User(id, key, name, 0);
    			userlist.add(user);
    		} while (cursor.moveToNext());
    	}
    }
    
    
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
