import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapExercise {
	private static File file = new File("Number");
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int enter;
		int count = 0;
		String value;
		String yn;
		boolean complete = false;
		HashMap<Integer, String> myMap = new HashMap<Integer, String>();
		

		try{
			PrintWriter pw = new PrintWriter(file);
			
			Scanner input = new Scanner(file);
			while (input.hasNextLine()) {
				int tempKey = input.nextInt();
				String tempValue = input.nextLine();
				myMap.put(tempKey, tempValue);
			}
			input.close();
			
			while (complete == false) {
				System.out.println("Please enter a number");
				enter = sc.nextInt();
				value = myMap.get(enter);
				if (value == null) {
					System.out.println("Please enter the reading of the number");
					value = sc.next();
					myMap.put(enter, value);
				} else {
					System.out.println("You entered " + value);
				}
				count++;
				if (count != 0 && count % 5 == 0) {
					System.out.println("Are you done?(enter y to finish,enter whatever else to continue)");
					yn = sc.next();
					if (yn.toLowerCase().equals("y")) {
						complete = true;
					} else {

					}
				}
			}
			

			for (int name : myMap.keySet()) {

				String read = myMap.get(name).toString();
				pw.println(name + "   " + read);
			}
			pw.flush();
			pw.close();
            Scanner output=new Scanner(file);
			while (output.hasNextLine()) {
				String line = output.nextLine();
                System.out.println(line);

			}
			output.close();
			sc.close();}catch(IOException e){
				System.out.println("Error!");
			}finally{
				System.out.println("This is the end");
			}
	}

}
