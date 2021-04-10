package Controller;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Main.RunEditor;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Globals 
{
	
	public static String INI_FILE = System.getProperty("user.dir") + "\\data.ini";
	
	
	public static byte[] readFileInByteArray(String filePath) 
	{
		byte[] fileBytes = null;
	    File file = new File(filePath);
	    FileInputStream fin = null;

	    try 
	    {
	    		// create FileInputStream object
	            fin = new FileInputStream(file);
	            fileBytes = new byte[(int)file.length()];

            // Reads up to certain bytes of data from this input stream into an array of bytes.
	        fin.read(fileBytes);

	        //create string from byte array
	       // String s = new String(fileBytes);
	        //System.out.println("File content: " + s);
	    }

	    catch (FileNotFoundException e) 
	    {
	        System.out.println("File not found" + e);
	        
	    }

	    catch (IOException ioe) 
	    {
	        System.out.println("Exception while reading file " + ioe);
	    }

	    finally 
	    {
	        // close the streams using close method
	        try {

	            if (fin != null) 
	            {
	                fin.close();
	            }
	        }
	        catch (IOException ioe) 
	        {
	            System.out.println("Error while closing stream: " + ioe);
	        }
	    }
	    return fileBytes;
	}
	
	
	public static String replaceCharAt(String inString, int index, char newChar)
	{
		String returnString = "";
		
		for(int i = 0; i < index; i++)
		{
			returnString += inString.charAt(i);
		}
		
		returnString += newChar;
		
		for(int i = index + 1; i < inString.length(); i++)
		{
			returnString += inString.charAt(i);
		}
		
		return returnString;
	}
	
	public static void addTextLimiter(final TextField tf, final int maxLength) 
	{
	    tf.textProperty().addListener(new ChangeListener<String>() 
	    {
	        @Override
	        public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) 
	        {
	            if (tf.getText().length() > maxLength) 
	            {
	                String s = tf.getText().substring(0, maxLength);
	                tf.setText(s);
	            }
	        }
	    });
	}
	
	public static void addFileChoserToButton(Button button, FileChooser fileChooser)
	{

		button.setOnAction(new EventHandler<ActionEvent>() 
		{
            @Override
            public void handle(ActionEvent event) 
            {
            	
            	File savedFile = new File(RunEditor.filePath);
            	
            	try
            	{
	            	if(savedFile.isDirectory())
	            	{
	            		fileChooser.setInitialDirectory(savedFile);
	            	}
	            	else
	            	{
	            		fileChooser.setInitialDirectory(savedFile.getParentFile());
	            	}
            	}
            	catch (Exception e)
            	{
            		e.printStackTrace();
            	}
            	
            	
            	File file = fileChooser.showOpenDialog(new Stage());
            	
            	if (file != null)
            	{
            		RunEditor.filePath = file.toString();
            		RunEditor.pathField.setText(RunEditor.filePath);
            	}
            }
        });
	}
	
	public static ArrayList<String> fileToArrayList(String filePath, boolean newLineCharacters)
	{
		ArrayList<String> returnArray = new ArrayList<String>();
		
		try {
  			File file = new File(filePath);
  			FileReader fileReader = new FileReader(file);
  			BufferedReader bufferedReader = new BufferedReader(fileReader);
  			String line;
  			while ((line = bufferedReader.readLine()) != null) 
  			{
  				
  				if(newLineCharacters)
  				{
  					line += "\n";
  				}
  				returnArray.add(line);
  				
  			}
  			fileReader.close();
  		} catch (IOException e) 
		{
  			e.printStackTrace();
  		}
		
		return returnArray;
	}
	
	public static void StringToFile(String fileData, String filePath)
	{
		try {
            
			File newTextFile = new File(filePath);

            FileWriter fw = new FileWriter(newTextFile);
            
        	fw.write(fileData);
            
            fw.close();

        } 
		catch (IOException iox) 
		{
            //do stuff with exception
            iox.printStackTrace();
        }
	}
	
	/**
	 * Takes in a hex string and converts it to a byte array
	 * @param s
	 * @return
	 */
	public static byte[] hexStringToByteArray(String s) 
	{
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) 
	    {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}
	
}
