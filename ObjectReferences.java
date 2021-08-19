
class Demo {
	
	Demo(String name)
	{
		System.out.println("The name is : "+name);
	}
}
public class ObjectReferences
{
	public static void main(String[] args) {
	
		Demo[] obj =new Demo[3];
		obj[0]=new Demo("Sravani");
		obj[1]=new Demo("Sweety");
		obj[2]= new Demo("Minnu");

	}

}
