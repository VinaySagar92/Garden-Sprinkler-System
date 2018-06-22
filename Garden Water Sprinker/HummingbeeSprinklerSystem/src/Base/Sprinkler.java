/**
 * @date 12/07/2016
 */
package Base;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 
 * @author VINAY SAGAR GONABAVI and SHIVAM VARMA
 *
 */
public class Sprinkler extends Group {

	public String status = "OFF";
	public String functional = "OK";
	String name;
	String groupId;
	int duration, rate, day, hr, min;
	int waterUsage=0;
	GregorianCalendar gC = new GregorianCalendar();
	int h=gC.get(Calendar.HOUR_OF_DAY);
	int m=gC.get(Calendar.MINUTE);
	int d=gC.get(Calendar.DAY_OF_WEEK);
	
	public Sprinkler(String groupId, String name, int day, int hr, int min, int duration, int rate){
		
		//super(groupId);
		//this.nameString=name;
		//this.groupId=id;
		this.name = name;
		this.groupId = groupId;
		this.duration = duration;
		this.rate = rate;
		this.day = day;
		this.hr = hr;
		this.min = min;
		
	}
	
	/**
	 * @param null
	 */
	public void setStatus(){
		status=name+" is on";
	}

	/**
	 * @param null
	 */
	@Override
	public void setSprinklerOn(){
		status = "ON";
	}
	/**
	 * @param null
	 */
	public void setSprinklerOff(){
		status = "OFF";
	}
	/**
	 * @param null
	 */
	public String getStatus(){
		return this.status;
	}
	/**
	 * @param null
	 */
	public void showStatus(){
		System.out.println(name +" is " +status);
	}
	/**
	 * @param null
	 */
	public int getWaterUsage(){
		
		if(d>day){
			waterUsage = waterUsage + duration*rate;
		}
		
		
		
		
		if(d==day){
			
			if(h>hr){
				waterUsage = waterUsage + duration*rate;
			}
			
			if(h<=hr){
		   if(getStatus() == "ON"){		
				if(min+duration<60){
					if(h==hr && m>=min && m<=(min+duration)){
						int x=m-min;
						waterUsage = waterUsage + x*rate;
					}
					
				}
				
				if(min+duration>60){
					if(h==hr){
						if(m>=min){
							int x=m-min;
							waterUsage = waterUsage + x*rate;
						    
						}
					}
					if(h==(hr+1)){
						if(m<=(min+duration-60)){
							int x=m-min+60;
							waterUsage = waterUsage + x*rate;
						}
					}
				}
		    }
		   
		   
		   
		   else{
			   if(min+duration<60){
					if(h==hr && m>=min && m<=(min+duration)){
						//int x=m-min;
						waterUsage = waterUsage + duration*rate;
					}
					
				}
				
				if(min+duration>60){
					if(h==hr){
						if(m>=min){
							//int x=m-min;
							waterUsage = waterUsage + duration*rate;
						    
						}
					}
					if(h==(hr+1)){
						if(m<=(min+duration-60)){
							//int x=m-min+60;
							waterUsage = waterUsage + duration*rate;
						}
					}
				}
		   }
			}
		
		}
		
		return waterUsage;
	}
	/**
	 * @param null
	 */
	public void showWaterUsage(){
		System.out.println("Water usage by "+name+" is "+waterUsage);
	}
	
	/**
	 * @param null
	 */
	public void setSprinklerFunctional(){
		this.functional="OK";
		
	}
	/**
	 * @param null
	 */
	public void setSprinklerDisFunctional(){
		this.functional="NOT";
	}
	/**
	 * @param null
	 */
	public void showSprinklerFunctional(){
		System.out.println(name +" is " +functional);
	}
	/**
	 * @param null
	 */
	public String getFunctional(){
		return this.status;
	}
	
}


