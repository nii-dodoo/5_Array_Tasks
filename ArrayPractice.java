import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {

    public static void main(String[] args){
        int[] nums={2,5,8,3,4,6,10,15,20,1,11};
        int firstVal=0;
        int secondVal=0;
        int[] ascending = new int[nums.length];
        int[] descending = new int[nums.length];
        Scanner input = new Scanner(System.in);


        //swapping values
        System.out.println("What is the value you want to swap");
        firstVal=input.nextInt();
        System.out.println("What are you swapping with?");
        secondVal=input.nextInt();
        int index1=-1, index2=-1;
        for(int i=0;i<nums.length;i++){
            if (nums[i]==firstVal) index1=i;
            if (nums[i]==secondVal) index2=i;
        }
        if (index1!=-1 && index2!=-1){
            int temp=nums[index1];
            nums[index1]=nums[index2];
            nums[index2]=temp;
        }
        //ascending order
        ascending = Arrays.copyOf(nums, nums.length);
        Arrays.sort(ascending);
        //descending
        for (int i = 0; i < nums.length; i++) {
            descending[i] = ascending[nums.length - 1 - i];//reversing the ascending array
        }

        System.out.println("Ascending: " + Arrays.toString(ascending));
        System.out.println("Descending: " + Arrays.toString(descending));

        //linear search
        System.out.println("What index do you want to know(linear search)");
        int val= input.nextInt();
        boolean found=false;
        for(int i=0;i<nums.length;i++){
            if (nums[i]==val){
                System.out.println("Index is "+i);
                found=true;
            }
        }
        if (!found) System.out.println("Value not found");

        //binary search
        System.out.println("Enter a value to search using Binary Search");
        int searchVal = input.nextInt();
        int low = 0, high = ascending.length - 1;
        boolean binFound = false;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (ascending[mid] == searchVal) {
                System.out.println("Binary Search -> Index in ascending array: " + mid);
                binFound = true;
                break;
            } else if (ascending[mid] < searchVal) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (!binFound) System.out.println("Value not found in ascending array");
    }
}
