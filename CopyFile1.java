package fourteenth;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFile1 {
	public static void main(String[] args) {
		try(FileReader fr = new FileReader("test.txt"); FileWriter fw = new FileWriter("copy.txt")){
			int ch;
			while((ch=fr.read())!=-1) {
				fw.write(ch);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
