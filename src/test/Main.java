package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class Main {
	public static String DataFilePath = null;
	public static String XmlFilePath = null;
	public static String Chrome_ConfigFilePath = null;
	public static String IE_ConfigFilePath = null;

	public static void main(String[] args) {

		try {

			Properties properties = new Properties();
			String path = System.getProperty("user.dir");
			System.out.println(path);
		    FileInputStream fileInput = new FileInputStream(path + "/resource.properties");
			properties.load(fileInput);
			DataFilePath = path + properties.getProperty("proj.data.sheet");
			XmlFilePath = path + properties.getProperty("proj.xml.path");
			Chrome_ConfigFilePath = path + properties.getProperty("proj.chromedriver.path");
			IE_ConfigFilePath = path + properties.getProperty("proj.iedriver.path");
			System.out.println(Chrome_ConfigFilePath);
			System.out.println(DataFilePath);
			System.out.println(XmlFilePath);
		    fileInput.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		suites.add(XmlFilePath);
		testng.setTestSuites(suites);
		testng.run();
	}

}
