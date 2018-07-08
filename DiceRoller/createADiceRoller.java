import java.util.Scanner;
import java.util.ArrayList;

class createADiceRoller {

	static ArrayList<String> inputs = new ArrayList<String>();
	static int[] diceNum;
	static int[] diceType;
	static int sum = 0;

	public static void start() {
		System.out.println("Type 'd' if done with inputs");
		System.out.println("Type 'q' to quit");
		System.out.println("Enter dice rolls:");
	}

	public static void prompt() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		input = input.toLowerCase();
		if (input.equals("q"))
			System.exit(1);
		if (!input.equals("d")) {
			inputs.add(input);
			prompt();
		}
	}

	public static void split() {
		diceNum = new int[inputs.size()];
		diceType = new int[inputs.size()];
		for (int i = 0; i < inputs.size(); i++) {
			String[] split = inputs.get(i).split("d");
			diceNum[i] = Integer.parseInt(split[0]);
			diceType[i] = Integer.parseInt(split[1]);
		}
	}

	public static void calculate() {
		int roll;
		for (int i = 0; i < inputs.size(); i++) {
			System.out.print(diceType[i] + ": ");
			for (int j = 0; j < diceNum[i]; j++) {
				roll = (int)(Math.random() * diceType[i]) + 1;
				sum += roll;
				System.out.print(roll + " ");
			}
			System.out.println();
		}
		System.out.println("Total Sum: " + sum);
	}

	public static void reset() {
		sum = 0;
		inputs = new ArrayList<String>();
	}

	public static void main(String[] args) {
		while(true) {
			start();
			prompt();
			split();
			calculate();
			reset();
		}
	}
}