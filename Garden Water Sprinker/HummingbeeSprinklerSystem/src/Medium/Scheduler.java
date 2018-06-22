/**
 * @date 12/07/2016
 */
package Medium;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import Base.Group;


/**
* 
* @author VINAY SAGAR GONABAVI and SHIVAM VARMA
*
**/
public class Scheduler {
	public boolean status;
	GregorianCalendar gCalendar=new GregorianCalendar();
	String dayString,sprinklerName;
	int hour,minute,rate,duration,day;
	String fileName;
	int index = 0;
	String split[] = new String[6];
	String d[] = new String[7];
	String hrs[] = new String[7];
	String min[] = new String[7];
	String dur[] = new String[7];
	String r[] = new String[7];
	String group[] = new String[7];
	public String sup[] = new String[7];
	int count = 0;
	static int a=0;
	String s;
	public Group g;
	String groupString;
	
	int groupWaterUsage; 
	
	
	
	public Scheduler(String name){
		groupString=name;
		//System.out.println(name);
		switch(name){
		case "N": fileName = ".\\Text\\N.txt";
		break;
		case "E": fileName = ".\\Text\\E.txt";
		break;
		case "S": fileName = ".\\Text\\S.txt";
		break;
		case "W": fileName = ".\\Text\\W.txt";
		break;
		}
		
		}
	
	
	/**
	 * @param null
	 * @throws FileNotFoundException
	 */
	public void setSchedule() throws FileNotFoundException{
		
		String line = null;
		FileReader fR = new FileReader(fileName);
		BufferedReader bR = new BufferedReader(fR);
		try {
			while((line = bR.readLine()) != null){
				
				split = line.split(",");
			//	System.out.println(split[0]+"."+split[1]+"."+split[2]+"."+split[3]+"."+split[4]+"."+split[5]+".");
				group[index]=split[0];
				d[index]=split[1];
				hrs[index]=split[2];
				min[index]=split[3];
				dur[index]=split[4];
				//System.out.println(d[index]+hrs[index]+min[index]+dur[index]);
				r[index]=split[5];
				System.out.println(r[index]);
				sup[index]=line;
				index++;
				count++;
				
			}
			
			bR.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int v = 0; v < count; v++){
			int b=Integer.parseInt(hrs[v]);
			int c=Integer.parseInt(min[v]);
			int e = Integer.parseInt(dur[v]);
			int rate = Integer.parseInt(r[v]);
			
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
			
			switch (groupString) {
			case "N":
				
				g = new Group(groupString, a, b, c, e, rate);
				break;
			case "E":
				
				g = new Group(groupString, a, b, c, e, rate);
				break;
			case "S":
				
				g = new Group(groupString, a, b, c, e, rate);
				break;
			case "W":
				
				g = new Group(groupString, a, b, c, e, rate);
				break;

			default:
				break;
			}
			
		
			//System.out.println(gCalendar.get(Calendar.HOUR_OF_DAY));
			g.setSprinklerFunctional();
			if(gCalendar.get(Calendar.DAY_OF_WEEK)==a){
				
				
				if(c+e<60){
					if(gCalendar.get(Calendar.HOUR_OF_DAY)==b && (gCalendar.get(Calendar.MINUTE)>=c && gCalendar.get(Calendar.MINUTE)<=(c+e))){
						
						g.setSprinklerOn();
					    g.showSprinklerStatus();
					    
					    
					    
					    
					    //System.out.println(g.groupN[3].status + " " + g.groupN[0].functional);
					    g.setSprinklerFunctional();
					    groupWaterUsage =g.getWaterUsage();
					    g.showWaterUsage();
					}
					
				}
				
				if(c+e>60){
					if(gCalendar.get(Calendar.HOUR_OF_DAY)==b){
						if(gCalendar.get(Calendar.MINUTE)>=c){
							//status=true;
							g.setSprinklerOn();
							g.setSprinklerFunctional();
						    g.showSprinklerStatus();
						    groupWaterUsage = g.getWaterUsage();
						    //System.out.println(g.groupN[3].status + " " + g.groupN[0].functional);

						    g.showWaterUsage();
						    
						}
					}
					if(gCalendar.get(Calendar.HOUR_OF_DAY)==(b+1)){
						if(gCalendar.get(Calendar.MINUTE)<=(c+e-60)){
							
							g.setSprinklerOn();
							g.setSprinklerFunctional();
						    g.showSprinklerStatus();
						    groupWaterUsage =g.getWaterUsage();
						    g.showWaterUsage();
						    //System.out.println(g.groupN[3].status + " " + g.groupN[0].functional);

						}
					}
				}
		    }
			
			else {
				g.setSprinklerOff();
				g.setSprinklerFunctional();
				groupWaterUsage = g.getWaterUsage();
				g.showSprinklerStatus();
			}
		}
	}
}
	


