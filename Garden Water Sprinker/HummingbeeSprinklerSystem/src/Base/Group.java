/**
 * date 12/07/2016
 */
package Base;

//import com.sun.java.util.jar.pack.Instruction.Switch;

/**
* 
* @author VINAY SAGAR GONABAVI and SHIVAM VARMA
*
**/
public class Group{
	public String groupId;
	int waterUsage[];
	public int groupWaterUsage;
	public Sprinkler groupN[] = new Sprinkler[4];
	public Sprinkler groupS[] = new Sprinkler[4];
	public Sprinkler groupE[] = new Sprinkler[4];
	public Sprinkler groupW[] = new Sprinkler[4];
	
	public Group(){
	}
	
	public Group(String id, int day, int hr, int min, int d, int r){
			this.groupId = id;
			for(int i=0;i<4;i++){
				groupN[i] = new Sprinkler("N", "N"+(i+1), day, hr, min, d, r);
			}
		
			for(int i=0;i<4;i++){
				groupE[i] = new Sprinkler("E", "E"+(i+1), day, hr, min, d, r);
			}
		
			for(int i=0;i<4;i++){
				groupS[i] = new Sprinkler("S", "S"+(i+1), day, hr, min, d, r);
			}
		
			for(int i=0;i<4;i++){
				groupW[i] = new Sprinkler("W", "W"+(i+1), day, hr, min, d, r);
			}
	}
	
	/**
	 * @param null
	 */
	public void setSprinklerOn(){
		
		switch (groupId) {
		case "N":
			for(int i=0;i<4;i++){
				groupN[i].status="ON";
			}
			break;
		case "E":
			for(int i=0;i<4;i++){
				groupE[i].status="ON";
			}
			break;
		case "S":
			for(int i=0;i<4;i++){
				groupS[i].status="ON";
			}
			break;
		case "W":
			for(int i=0;i<4;i++){
				groupW[i].status="ON";
			}
			break;
			

		default:
			break;
		}
		
	}
	
	/**
	 * @param null
	 */
	public void setSprinklerOff(){
		
		switch (groupId) {
		case "N":
			for(int i=0;i<4;i++){
				groupN[i].status="OFF";
			}
			break;
		case "E":
			for(int i=0;i<4;i++){
				groupE[i].status="OFF";
			}
			break;
		case "S":
			for(int i=0;i<4;i++){
				groupS[i].status="OFF";
			}
			break;
		case "W":
			for(int i=0;i<4;i++){
				groupW[i].status="OFF";
			}
			break;
			

		default:
			break;
		}
		
	}
	
	/**
	 * @param null
	 */
	public void showSprinklerStatus(){
		
		switch (groupId) {
		case "N":
			for(int i=0;i<4;i++){
				groupN[i].showStatus();
			}
			break;
		case "E":
			for(int i=0;i<4;i++){
				groupE[i].showStatus();
			}
			break;
		case "S":
			for(int i=0;i<4;i++){
				groupS[i].showStatus();
			}
			break;
		case "W":
			for(int i=0;i<4;i++){
				groupW[i].showStatus();
			}
			break;
			

		default:
			break;
		}
		
	}
	
	/**
	 * @param null
	 */
	public void showGardenStatus(){
	
	
		for(int i=0;i<4;i++)
			groupN[i].showStatus();
		
		for(int i=0;i<4;i++)
			groupE[i].showStatus();
		
	
		for(int i=0;i<4;i++)
			groupS[i].showStatus();
		
	
		for(int i=0;i<4;i++)
			groupW[i].showStatus();		
	
	}

	/**
	 * @param null
	 */
	public int getWaterUsage(){
		switch (groupId) {
		case "N":
			for(int i=0;i<4;i++){
				groupWaterUsage = groupN[i].getWaterUsage();
			}
			break;
		case "E":
			for(int i=0;i<4;i++){
				groupWaterUsage = groupE[i].getWaterUsage();
			}
			break;
		case "S":
			for(int i=0;i<4;i++){
				groupWaterUsage = groupS[i].getWaterUsage();
			}
			break;
		case "W":
			for(int i=0;i<4;i++){
				groupWaterUsage = groupW[i].getWaterUsage();
			}
		break;
		

		default:
		break;
		}
		return groupWaterUsage;
	}

	/**
	 * @param null
	 */
	public void showWaterUsage(){
	
		switch (groupId) {
		case "N":
			for(int i=0;i<4;i++){
				groupN[i].showWaterUsage();
				
			}
			break;
		case "E":
			for(int i=0;i<4;i++){
				groupE[i].showWaterUsage();
			}
			break;
		case "S":
			for(int i=0;i<4;i++){
				groupS[i].showWaterUsage();
			}
			break;
		case "W":
			for(int i=0;i<4;i++){
				groupW[i].showWaterUsage();
			}
			break;
			

		default:
			break;
		}
	
	}

	/**
	 * @param null
	 */
	public void setSprinklerFunctional(){
	
		switch (groupId) {
		case "N":
			for(int i=0;i<4;i++){
				groupN[i].functional="OK";
			}
			break;
		case "E":
			for(int i=0;i<4;i++){
				groupE[i].functional="OK";
			}
			break;
		case "S":
			for(int i=0;i<4;i++){
				groupS[i].functional="OK";
			}
			break;
		case "W":
			for(int i=0;i<4;i++){
				groupW[i].functional="OK";
			}
			break;
			

		default:
			break;
		}
	
	}

	/**
	 * @param null
	 */
	public void setSprinklerDisFunctional(){
	
		switch (groupId) {
		case "N":
			for(int i=0;i<4;i++){
				groupN[i].functional="NOT";
			}
			break;
		case "E":
			for(int i=0;i<4;i++){
				groupE[i].functional="NOT";
			}
			break;
		case "S":
			for(int i=0;i<4;i++){
				groupS[i].functional="NOT";
			}
			break;
		case "W":
			for(int i=0;i<4;i++){
				groupW[i].functional="NOT";
			}
			break;
			

		default:
			break;
		}
	
	}

	/**
	 * @param null
	 */
	public void showSprinklerFunctional(){
	
		switch (groupId) {
		case "N":
			for(int i=0;i<4;i++){
				groupN[i].showSprinklerFunctional();
			}
		break;
		case "E":
			for(int i=0;i<4;i++){
					groupE[i].showSprinklerFunctional();
			}
		break;
		case "S":
			for(int i=0;i<4;i++){
			groupS[i].showSprinklerFunctional();
			}
		break;
		case "W":
			for(int i=0;i<4;i++){
			groupW[i].showSprinklerFunctional();
			}
		break;
		

		default:
		break;
		}
	}
}
	