package net.devsedge.filesystems.watchservice;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) throws IOException {
		
		/*
		 * Getting a watch service for a given file
		 */
		
		WatchService watchService = FileSystems.getDefault().newWatchService();
		
		Path file = Paths.get("src/main/java/net/devsedge/filesystems/watchservice/foo.dir");
		
		file.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
		
		while(true){
			WatchKey watchKey;
			
			System.out.println("Please, modify foo.txt");
			
			try{
				watchKey = watchService.take();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Modified!");
			break;
		}

	}

}
