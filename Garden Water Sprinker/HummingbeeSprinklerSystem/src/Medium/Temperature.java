/**
 * date 12/07/2016
 */

package Medium;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Base.Group;


/**
* 
* @author VINAY SAGAR GONABAVI and SHIVAM VARMA
*
**/
public class Temperature extends Scheduler{
	
	int temperature;
	FileReader fR;
	int a;
	boolean enable;
	//String fileName;

	public Temperature(String name, int temperature, boolean enable) {
		super(name);
		this.temperature = temperature;
		this.enable = enable;
	}
	
	/**
	 * @param null
	 */
	@Override
	public void setSchedule(){
		
		String line = null;
		
		try {
			fR = new FileReader(fileName);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		BufferedReader bR = new BufferedReader(fR);
		try {
			while((line = bR.readLine()) != null){
				split = line.split(",");
				group[index]=split[0];
				d[index]=split[1];
				hrs[index]=split[2];
				min[index]=split[3];
				dur[index]=split[4];
				r[index]=split[5];
				index++;
				count++;
			}
			
			bR.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		for(int v = 0; v < count; v++){
			int b=Integer.parseInt(hrs[v]);
			int c=Integer.parseInt(min[v]);
			int e = Integer.parseInt(dur[v]);
			int rate = Integer.parseInt(r[v]);
			
			
			switch (groupString) {
			case "N":
				s="Sprinklers N1, N2, N3, N4";
				g = new Group(groupString, a, b, c, e, rate);
				break;
			case "E":
				s="Sprinklers E1, E2, E3, E4";
				g = new Group(groupString, a, b, c, e, rate);
				break;
			case "S":
				s="Sprinklers S1, S2, S3, S4";
				g = new Group(groupString, a, b, c, e, rate);
				break;
			case "W":
				s="Sprinklers W1, W2, W3, W4";
				g = new Group(groupString, a, b, c, e, rate);
				break;

			default:
				break;
			}
			
			switch (d[v]) {
			case "Sunday":
				a=1;
				break;
			case "Monday":
				a=2;
				break;
			case "Tuesday":
				a=3;
				break;
			case "Wednesday":
				a=4;
				break;
			case "Thursday":
				a=5;
				break;
			case "Friday":
				a=6;
				break;
			case "Saturday":
				a=7;
				break;

			default:
				break;
			}
			
			if(temperature>90){
			
			
							g.setSprinklerOn();
							g.setSprinklerFunctional();
							g.showGardenStatus();
						
					
			}
		
			if(temperature<55 || enable == false){
			
							g.setSprinklerOff();
							g.setSprinklerFunctional();
							g.showGardenStatus();
						
		
			}
		}
	}
}
