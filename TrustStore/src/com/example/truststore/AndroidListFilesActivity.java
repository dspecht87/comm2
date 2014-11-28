package com.example.truststore;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ArrayAdapter;

public class AndroidListFilesActivity extends ListActivity {
	  
	 private List<String> file_List = new ArrayList<String>();
	 
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	         
	        File root = new File(Environment
	          .getExternalStorageDirectory()
	          .getAbsolutePath());
	        ListDir(root);
	 
	    }
	     
	    void ListDir(File f){
	     File[] files = f.listFiles();
	     file_List.clear();
	     for (File file : files){
	      file_List.add(file.getPath()); 
	     }
	      
	     ArrayAdapter<String> directoryList
	     = new ArrayAdapter<String>(this,
	       android.R.layout.simple_list_item_1, file_List);
	     setListAdapter(directoryList);
	    }
	 
	}