package DataManupulation;

import java.io.FileNotFoundException;

public class FileUpload implements Runnable{

	//To Declare Variables
	private String file="";
		
	 public FileUpload(String filePath){
	      this.file = filePath;
	   }
	 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			UploadFile(file);
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Unable to launch AutoIT script. Please validate");
		}
	}
	
	public static synchronized boolean UploadFile(String userFilePath) throws FileNotFoundException
	{
		boolean result = false;
		String filepath="";
		if(!userFilePath.isEmpty()) {
			filepath=userFilePath.replace("\\\\", "\\");
			System.out.println("File Path is - "+userFilePath);
		}
		else {
			filepath = System.getProperty("user.home")
					+"\\RESOURCES\\DSG\\TEMPLATES\\Dummy Resume.docx";
			System.out.println("File Path is - "+filepath);
		}

		try {
			String[] parms = {System.getProperty("user.home")
					+"\\RESOURCES\\DSG\\TEMPLATES\\FileUpload.exe",filepath};
			//String[] parms = {"C:\\AutoIT\\FileUpload.exe",filepath};
			Process p = Runtime.getRuntime().exec(parms);
			p.waitFor(); 
			result=true;
		}
		catch(Exception unabletorunscript) {
			result =false;
			unabletorunscript.printStackTrace();
			System.out.println("Unable to launch AutoIT script. Please validate");
		}
		return result;
	}
}
