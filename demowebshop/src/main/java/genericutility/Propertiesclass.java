package genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Propertiesclass {
	public FileInputStream path ;
	public String  fetchProperties(String key)
	{
		try {
			 path=new FileInputStream("./src/test/resources/demo.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties pro=new Properties();
		try {
			pro.load(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 String fetch=pro.getProperty(key);
		return fetch;
		
	}
	public static void main(String[] args) {
		Propertiesclass fetch1=new Propertiesclass();
		String url = fetch1.fetchProperties("Url");
		System.out.println(url);
	}

}
