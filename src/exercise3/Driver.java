package exercise3;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Driver
{

	public static final int SIZE = 100;
	public static final int UPPER_BOUND = 1000;

	public static void main( String[] args )
	{

		Integer[] nums = new Integer[SIZE];
		Random rand = new Random();

		for( int i = 0; i < SIZE; i++ )
		{
			nums[i] = rand.nextInt( UPPER_BOUND );
			System.out.println( nums[i] );
		}

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter 'b','i','s' or 'q' to select your algorithm.");
		String choice = scanner.nextLine();
		scanner.close();

		long startTime, endTime;

		switch (choice)
		{
			case "b":
				startTime = System.nanoTime();
				bsort(nums);
				endTime = System.nanoTime();
				break;
			case "i":
				startTime = System.nanoTime();
				isort(nums);
				endTime = System.nanoTime();
				break;
			case "s":
				startTime = System.nanoTime();
				ssort(nums);
				endTime = System.nanoTime();
				break;
			case "q":
				startTime = System.nanoTime();
				nums = qsort(nums);
				endTime = System.nanoTime();
				break;
			default:
				System.out.println("Invalid input");
				return;
		}

		long time = endTime - startTime;
		System.out.println("\nSorted:");
		for (int i: nums) {System.out.print(i + " ");}
		System.out.println("\nTime: " + time + "nanoseconds");
	}

	public static void bsort(Integer[] nums)
	{
		int i, j, temp;
		boolean swapped;
		for (i = 0; i < nums.length - 1; i++)
		{
			swapped = false;
			for (j = 0; j < nums.length - 1 - i; j++)
			{
				if (nums[j] > nums[j + 1])
				{
					temp = nums[j];
					nums[j] = nums[j +1];
					nums[j + 1] = temp;
					swapped = true;
				}
			}
			if (!swapped) {break;}
		}
	}
	public static void isort(Integer[] nums)
	{
		for (int i = 1; i < nums.length; i++)
		{
			int marker = nums[i];
			int j = i - 1;
			while (j >= 0 && nums[j] > marker)
			{
				nums[j + 1] = nums[j];
				j--;
			}
			nums [j + 1] = marker;
		}
	}
	public static void ssort(Integer[] nums)
	{
		for (int i = 0; i < nums.length - 1; i++)
		{
			int min = i;

			for (int j = i + 1; j < nums.length; j++)
			{
				if (nums[j] < nums[min])
				{
					min = j;
				}
			}
			if (min != i)
			{
				int temp = nums[i];
				nums[i] = nums[min];
				nums[min] = temp;
			}
		}
	}
	public static Integer[] qsort(Integer[] nums)
	{
		return recursionQSort(nums);
	}
	public static Integer[] recursionQSort(Integer[] array)
	{
		if (array.length <= 1) {return array;}
		Random rand = new Random();
		int pivot = array[rand.nextInt(array.length)];
		ArrayList<Integer> left = new ArrayList<>();
		ArrayList<Integer> right = new ArrayList<>();
		for (Integer i : array)
		{
			if (i < pivot)
			{
				left.add(i);
			}
			else if (i > pivot)
			{
				right.add(i);
			}
		}

		Integer[] leftSort = recursionQSort(left.toArray(new Integer[0]));
		Integer[] rightSort = recursionQSort(right.toArray(new Integer[0]));

		Integer[] sorted = new Integer[leftSort.length + rightSort.length + 1];
		System.arraycopy(leftSort, 0, sorted, 0, leftSort.length);
		sorted[leftSort.length] = pivot;
		System.arraycopy(rightSort, 0, sorted, leftSort.length + 1, rightSort.length);

		return sorted;
	}
}

