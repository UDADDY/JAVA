package fourteenth;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(FileReader fr = new FileReader("test.txt")){
			int ch;
			while((ch=fr.read())!=-1) {
				System.out.print((char)ch);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}