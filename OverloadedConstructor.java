
public class OverloadedConstructor
{

	
	OverloadedConstructor()
		{
			
			this("Sravani");
			System.out.println("Inside constructor1");
		}
	OverloadedConstructor(String name)
		{
			System.out.println("The name is : "+name);
			System.out.println("Inside overloaded constructor");
		}

	public static void main(String[] args) {
		
		OverloadedConstructor overloaded = new OverloadedConstructor();

	}

}
