
class VampireNumber 
{
	Boolean isVampire = false;
	
	//breaking the number into individual integers and storing in an array.
	
	public int[] breakNumber(int number)
	{
		int remainder= 0;
		int i=0;
		//used to find the number of digits in a number
		int length = (int) (Math.log10(number) + 1);
		int integerArray[] = new int[length];
		while (number != 0)
		{
			remainder = number % 10;
			integerArray[i] = remainder;
			number = number / 10;
			i++;
		}
		return integerArray;
	}
	
	//converting the array into two equal parts and finding  the vampire number if the two parts when multiplied equals the given number

	Boolean checkVampireNumber(int[] integerArray,  int number)
	{
		int firstPart = 0;
		int secondPart = 0;
		for (int i = 0; i< (integerArray.length) / 2; i++)
		{
			//firstpart can be formed from the firstpart of array
			firstPart += integerArray[i] * Math.pow(10, (integerArray.length) / 2 - i - 1);
		}
		for (int i= (integerArray.length) / 2; i< integerArray.length; i++) 
		{
			//secondpart can be formed from secondpart of array
			secondPart += integerArray[i] * Math.pow(10, (integerArray.length - i - 1));
		}
		if (firstPart * secondPart == number)
		{
			return true;
		}
		return false;
	}

	//finding all permutations of the given input array 
	
	void findPermutations(int[] integerArray, int index, int number)
	{
		if (index>= integerArray.length - 1)
		{
			if (this.checkVampireNumber(integerArray, number))
			{
				isVampire=true;
			}
		}
		//used to find all permutations
		
		for (int i = index; i < integerArray.length; i++)
		{ 
			int temp = integerArray[index];
			integerArray[index] = integerArray[i];
			integerArray[i] = temp;
			findPermutations(integerArray, index + 1, number);
			temp = integerArray[index];
			integerArray[index] = integerArray[i];
			integerArray[i] = temp;
		}
	}
}
public class Vampire
{

	public static void main(String[] args) {
		VampireNumber vampire = new VampireNumber();
		int number = 1000;
		int count = 0;
		while (count < 100) 
		{
			//checking the numbers with even number of digits
			if (((int) (Math.log10(number) + 1))%2 == 0)
			{
				int[] integerArray = vampire.breakNumber(number);
				vampire.findPermutations(integerArray , 0, number);
				if (vampire.isVampire) 
				{
					
					System.out.println((count+1)+" "+number);
					count++;
					vampire.isVampire = false;
				}

			}
			number++;
		}
		
	}
}
