import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RunLengthTester
{
	public static void main(String[] args) throws IOException 
	{
		int totalNumber, remainder = 0, timesDivisible;


		BufferedReader br = new BufferedReader(new FileReader("RLEtest.txt"));



		//		BufferedReader br = new BufferedReader(new FileReader("testfile.txt"));


		FileWriter fw = new FileWriter("output.txt");

		while(br.ready())
		{
			int currentChar = br.read();
			int nextChar = br.read();
			timesDivisible = 0;
			


			if(currentChar == nextChar)
			{
				//continue counting how many times a character repeats
				while (currentChar == nextChar)
				{
					nextChar = br.read();
					
					//255*x if over 255, and get the remainder
					if(nextChar > 255)
					{
						totalNumber = nextChar;
						timesDivisible = totalNumber / 255;
						remainder = timesDivisible % 255;
					}
					else
					{
						remainder = nextChar % 255;
					}
				}
			}

			//for characters that are repeated more than 255 
			if(timesDivisible != 0)
			{
				for(int counter = 0; counter < timesDivisible; counter++)
				{
					fw.write(currentChar + currentChar + (char)255);
				}
			}

			//printing characters that are repeated less than 255 (mostly all cases)
			fw.write(currentChar + currentChar + (char)remainder);
		}

		br.close();
		fw.close();
	}
}


