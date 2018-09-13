import java.util.Arrays;

public class RemoveDups {

	public static void main(String[] args) {
		
		
		
		
		String[] arr = {"13", "CAT","13", "CAT", "12", "12", "DOG", "13"};
		
		System.out.println(Arrays.toString(arr));
		
		System.out.println(removeDuplicates(arr)); 

		System.out.println(Arrays.toString(arr));
		
		Object set = new Object(); 
		
	}
	
	public static int removeDuplicates(String arr[]){
		
		int count = 0;
		for(int i = 0; i < arr.length-count; i++)
		{
			boolean contains = false; 
			for(int k = 0; k < i; k++)
			{
				if(arr[i].equals(arr[k]))
				{
					contains = true; 
				}
			}
			
			if(contains)
			{
				count++; 
				for(int k = i; k < arr.length-count; k++)
				{
					arr[k] = arr[k+1]; 
				}
				i--; 
			}
		}
		
		return count; 
		
	}

}
