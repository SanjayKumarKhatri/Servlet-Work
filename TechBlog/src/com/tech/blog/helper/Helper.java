package com.tech.blog.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class Helper {

	
	public static boolean deleteFile(String path) {
		boolean f = false;
		
		try {
			File file = new File(path);
			f = file.delete();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return f;
	}
	
	public static boolean saveFile(InputStream is, String path) {
		boolean f = false;
		try {	
			byte[] b = new byte[is.available()];
			is.read(b);
			FileOutputStream fout = new FileOutputStream(path);
			System.out.println("fout " + fout);
			fout.write(b);
			fout.flush();
			fout.close();
			f = true;
			System.out.println("f" + f + " fout2 " + fout);
		}catch(Exception exe) {
			exe.printStackTrace();
		}
		
		return f;
		
	}
}
