
public class SumOfDigits {

	public static int sumOfDigitsIn(int num) {
		if (num == 0) return 0;
		return (num % 10 + sumOfDigitsIn(num/10));
	}
	
	public static void main(String[] args) {
		int number = 2348;
		System.out.println(sumOfDigitsIn(number));
	}

}
