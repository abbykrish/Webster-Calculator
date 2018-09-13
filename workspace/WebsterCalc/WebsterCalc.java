import java.util.*; 



public class WebsterCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in); 
		
		System.out.print("Number of Seats: "); 
		int seats = in.nextInt(); 
		
		System.out.print("Number of Parties: "); 
		int parties = in.nextInt(); 
		
		in.nextLine(); 
		TreeMap<String, Integer> partyMap = new TreeMap<String, Integer>(); 
		TreeMap<String, Integer> seatMap = new TreeMap<String, Integer>(); 
		
		for(int i = 0; i < parties; i++)
		{
			System.out.print("Party Name: "); 
			String pName = in.nextLine(); 
			
			//System.out.println(); 
			
			System.out.print("Party Votes: "); 
			int votes = in.nextInt(); 
			
			partyMap.put(pName, votes); 
			seatMap.put(pName, 0); 
			in.nextLine(); 
		}
		
		ArrayList<String> calc = new ArrayList<String>(); 
		
		
		for(int i = 0; i < parties; i++)
		{
			for(String s: partyMap.keySet())
			{
				int n = partyMap.get(s) / ((2*i)+1);
				String out = n + " " + s; 
				calc.add(out); 
			}
		}
		
		
		Collections.sort(calc, new Comparing());
		
		
		
		for(int i = 0; i < seats; i++)
		{
			String s = calc.get(i).substring(calc.get(i).indexOf(" ")+1); 
			seatMap.put(s, seatMap.get(s)+1); 
			
		}
		
		for(String s: seatMap.keySet())
		{
			System.out.println(s + ": " + seatMap.get(s)); 
		}
		
	}

}

class Comparing implements Comparator {
    public int compare(Object o1, Object o2) {
        String s1 = (String)o1;
        String s2 = (String)o2;
        
        int n1 =  Integer.parseInt(s1.substring(0, s1.indexOf(" ")));
        int n2 = Integer.parseInt(s2.substring(0, s2.indexOf(" ")));
        
        return n2-n1; 
    }
}
