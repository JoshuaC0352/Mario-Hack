package Controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import Main.RunEditor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class MainScene 
{
	
	public static String getFilePath()
	{
		
		
		try 
		{
			String filePath;
			filePath = Globals.fileToArrayList(Globals.INI_FILE, false).get(0);
			if(filePath.isEmpty())
			{
				return System.getProperty("user.dir");
			}
			else
			{
				return filePath;
			}
		}
		catch (Exception e)
		{
			return System.getProperty("user.dir");
		}
	}
	
	public static void addListenerToButton(Button button)
	{
		button.setOnAction(new EventHandler<ActionEvent>() 
		{
            @Override
            public void handle(ActionEvent event) 
            {
            	
            	Globals.StringToFile(RunEditor.filePath, Globals.INI_FILE );
            	
            	byte[] fileBytes;
            	if(new File(RunEditor.filePath).isFile())
            	{
            		fileBytes = Globals.readFileInByteArray(RunEditor.filePath);
            	}
            	else
            	{
            		Alert alert = new Alert(AlertType.WARNING, "Please Select The: \n \"Super Mario Bro.nes\" file before proceeding", ButtonType.OK);
            		alert.setHeaderText("");
            		alert.showAndWait();
            		return;
            	}
            	
            	int[] warpZones = new int[7];
            	
            	try
            	{
            		warpZones[0] = Integer.parseInt(RunEditor.wzOneOne.getText());
            		warpZones[1] = Integer.parseInt(RunEditor.wzOneTwo.getText());
            		warpZones[2] = Integer.parseInt(RunEditor.wzOneThree.getText());
            		warpZones[3] = Integer.parseInt(RunEditor.wzTwo.getText());
            		warpZones[4] = Integer.parseInt(RunEditor.wzThreeOne.getText());
            		warpZones[5] = Integer.parseInt(RunEditor.wzThreeTwo.getText());
            		warpZones[6] = Integer.parseInt(RunEditor.wzThreeThree.getText());
            		
            		for(int i = 0; i < warpZones.length; i++)
            		{
            			if(warpZones[i] > 255 || warpZones[i] < 0)
            			{
            				
            				Alert alert = new Alert(AlertType.ERROR, "ONLY VALUES FROM 0 - 255 ALLOWED", ButtonType.OK);
            				alert.setHeaderText("");
            				alert.showAndWait();
            				return;
            			}
            		}
            		
            	}
            	catch (NumberFormatException e1)
            	{
            		Alert alert = new Alert(AlertType.ERROR, "ONLY INTEGER VALUES ALLOWED \n (NO DECIMALS OR LETTERS)", ButtonType.OK);
            		alert.setHeaderText("");
            		alert.showAndWait();
            		return;
            	}
            	
            	
            	fileBytes[2050] = (byte) warpZones[0];
            	fileBytes[2051] = (byte) warpZones[1];
            	fileBytes[2052] = (byte) warpZones[2];
            	
            	fileBytes[2055] = (byte) warpZones[3];
            	
            	fileBytes[2058] = (byte) warpZones[4];
            	fileBytes[2059] = (byte) warpZones[5];
            	fileBytes[2060] = (byte) warpZones[6];
            	
    			Path path = Paths.get(System.getProperty("user.dir") + "\\Mario Hack.nes");
    			try 
    			{
					Files.write(path, fileBytes);
				} 
    			catch (IOException e) 
    			{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

    			Alert alert = new Alert(AlertType.INFORMATION, "NEW WARP ZONES SUCESSFULLY CREATED", ButtonType.OK);
        		alert.setHeaderText("");
        		alert.showAndWait();
            	
            }
        });
	}
}
