package com.main;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TestCodes {
	// Looping
	static void loop() {
		//Scanner in = new Scanner(System.in);
        //int t=in.nextInt();
        int t=2;
		for(int i=0;i<t;i++){
            //int a = in.nextInt();
            //int b = in.nextInt();
            //int n = in.nextInt();
			int a = 5;
            int b = 3;
            int n = 5;
            
            //System.out.println("t=" + t + " a=" + a + " b=" + b + " n=" + n);
            
            /*
            {a=0, b=2, n=3}
            (0 + 1^0*2), =2
            (0 + 1^0*2 + 2^1*2), =6
            (0 + 1^0*2 + 2^1*2 + 2^(n-1 or 2)*2), =14
            
            {a=5, b=3, n=5}
            (5 + 1^0*3), =8
            (5 + 1^0*3 + 2^1*3), =14
            (5 + 1^0*3 + 2^1*3 + 3^2*3), =26
            (5 + 1^0*3 + 2^1*3 + 3^2*3 + 4^3*3), =50
            (5 + 1^0*3 + 2^1*3 + 3^2*3 + 4^3*3 + 5^4*3), =98
            */
            
            int seqA = a;
            int seqB = 0;
            int base = 1;
            int seqRes = 0;
            for(int j=0;j<n;j++){
            	for(int rep=0;rep<j;rep++) {
            		int exponent = j;
                    int getPow = (int) Math.pow(base, exponent);
                    seqB += (getPow * b);
                    base++;
            	}
            	System.out.printf("%d ", (seqA + seqB));
            	
                //int exponent = j;
                //int getPow = (int) Math.pow(base, exponent);
                //seqB = (getPow * b);
                
                //System.out.println("b=" + base + " e=" + exponent);
                //System.out.println("sA=" + seqA + " sB=" + seqB + " sR=" + seqRes);
                //System.out.println();
                
                //System.out.printf("%d ", (seqA + seqB));
                //base++;
            }
            System.out.println();
        }
	}
	
	// Function for swapping two numbers 
    static void swap(int nums[], int l, int i) 
    { 
        int temp = nums[l]; 
        nums[l] = nums[i]; 
        nums[i] = temp; 
    } 
  
    // Function to find the possible 
    // permutations 
    static void permutations(ArrayList<int[]> res, 
                             int[] nums, int l, int h) 
    { 
        // Base case 
        // Add the array to result and return 
        if (l == h) { 
            res.add(Arrays.copyOf(nums, nums.length)); 
            return; 
        } 
  
        // Permutations made 
        for (int i = l; i <= h; i++) { 
            // Swapping 
            swap(nums, l, i); 
  
            // Calling permutations for 
            // next greater value of l 
            permutations(res, nums, l + 1, h); 
  
            // Backtracking 
            swap(nums, l, i); 
        } 
    } 
  
    // Function to get the permutations 
    static ArrayList<int[]> permute(int[] nums) 
    { 
        // Declaring result variable 
        ArrayList<int[]> res = new ArrayList<int[]>(); 
        int x = nums.length - 1; 
  
        // Calling permutations for the first 
        // time by passing l 
        // as 0 and h = nums.size()-1 
        permutations(res, nums, 0, x); 
        return res; 
    } 
	
	/*
	 * Factorial: 
	 */
	static void factorial(int n) {
		//Time complexity: O(n!)
		int factorial = 1;
		for(int i = 1; i <= n; i++) {
			factorial *= i;
		}
		System.out.printf("Factorial of %d is %d ", n, factorial);
		System.out.println();
		
		/*
		//Time complexity: O(n!)
		BigInteger factorial = BigInteger.ONE;
        for(int i = 1; i <= n; ++i) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        System.out.printf("Factorial of %d is %d ", n, factorial);
         */
		
		/*
		//Time Complexity: O(n)
		//Auxiliary Space: O(n)
		if(n == 0) 
			return 1;
		return n * factorial(n - 1);
		 */
		
		/*
		 * 3 elements: A, B, C
		 * Combinations: 6
		 * 	ABC, ACB
		 * 	BAC, BCA
		 * 	CBA, CAB
		 * 
		 * 4 elements: 1, 2, 3, 4
		 * Combinations: 24
		 * 	1234, 1324, 1423,
		 * 	2134, 2314
		 * 	3124, 
		 * 	4123, 
		 */
		int[] elements = new int[n];
		for(int i = 0; i < n; i++) {
			elements[i] = (i + 1);
		}
		System.out.println("Elements " + Arrays.toString(elements));
		
		ArrayList<int[]> res = permute(elements); 
		
		//printing result 
        for(int[] x : res) { 
            for(int y : x) { 
                System.out.print(y + " "); 
            } 
            System.out.println(); 
        }
	}
	
	/*
	 * Two Sum:
	 */
	static int[] getTwoSum(int[] nums, int target) {
		/*
		 * nums:	[2, 5, 4]
		 * target:	6
		 * 
		 * loop:
		 * target - num[n]:
		 * 6 - 2 = key:4 - map { 2=0 }
		 * 6 - 5 = key:1 - map { 2=0, 5=1 }
		 * 6 - 4 = key:2 - map { 2=0, 5=1 } 2:key exist, end loop
		 * 
		 * result:
		 * [0, 2]
		 * 
		 *********************************************************
		 * nums:	[3, 3, 4]
		 * target:	6
		 * 
		 * loop:
		 * target - num[n]:
		 * 6 - 3 = key:3 - map { 3=0 }
		 * 6 - 3 = key:3 - map { 3=0, 3=1 } 3:key exist, end loop
		 * 
		 * result:
		 * [0, 1]
	 	 */
		
		//Time complexity: O(n)
		Map<Integer, Integer> numMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            } else {
                numMap.put(nums[i], i);
            }
        }
        return new int[] {};
        
        /*
        //Time complexity: O(n^2)
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
         */
        
        /*
		//Time complexity: O(n*log(n))
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		while(left < right) {
			if(nums[left] + nums[right] == target) {
				return new int[] {nums[left], nums[right]};
			} else if (nums[left] + nums[right] < target) {
				left++;
			} else {
				right--;
			}
		}
		return new int[] {};
         */
	}
	
	/*
	 * Two Sum:
	 */
	static void twoSum() {
		int[] nums = new int[]{3, 3, 4};
		int target = 6;
		System.out.println("TwoSum of " + java.util.Arrays.toString(nums) + " is " + java.util.Arrays.toString(TestCodes.getTwoSum(nums, target)));
	}
	
	/*
	 * Comparing real numbers: Math.abs(value)
	 */
	static void mathAbs() {
		DecimalFormat df = new DecimalFormat("#.###########");
	    double a = 1.000001;
	    double b = 1.000002;

	    /*
	     * Without using Math.abs(value):
	     * 
	     * But that's not all we have to worry about, since the difference between the numbers may well turn out to be negative. 
	     * So for this approach to work, you need to compare not just the difference between the numbers, 
	     * but the absolute value of the difference between the numbers: |a-b|
	     */
		if((b - a) < 0.0001 )
	       System.out.println("The numbers are equal");
	    else
	       System.out.println("The numbers are not equal");
	    System.out.println(df.format((b-a)));
	    System.out.println();

	    /*
	     * With using Math.abs(value):
	     * 
	     * Java has a method for calculating the absolute value of a number: Math.abs():
	     */
	    if(Math.abs(b - a) < 0.0001 )
	       System.out.println("The numbers are equal");
	    else
	       System.out.println("The numbers are not equal");
	    System.out.println(df.format(Math.abs(b-a)));
	}
	
	/*
	 * BigDecimal for Precise Decimal Calculations:
	 */
	static void bigDecimal() {
		//Using BigDecimal for precise decimal calculation
        BigDecimal result = new BigDecimal("0.1").add(new BigDecimal("0.2"));
        System.out.println("Result using BigDecimal: " + result);
	}
	
	/*
	 * Empty Collection instead of Null:
	 * Using an empty Collection:
	 */
	static List<String> getNamesOrEmpty() {
		//Simulating a scenario where names are not available
        return Collections.emptyList();
	}
	
	/*
	 * Empty Collection instead of Null:
	 * Using null:
	 */
	static List<String> getNamesOrNull() {
		//Simulating a scenario where names are not available
		return null;
	}
	
	/*
	 * Empty Collection instead of Null:
	 */
	static void emptyCollectionInsteadOfNull() {
		//NamesOrNull
		List<String> namesOrNull = TestCodes.getNamesOrNull();
        if (namesOrNull != null) {
            for (String name : namesOrNull) {
                //Do something 
            }
        } else {
            System.out.println("No names available.");
        }
        
        //NamesOrEmpty
        List<String> namesOrEmpty = TestCodes.getNamesOrEmpty();
        for (String name : namesOrEmpty) {
            //This loop won't execute if the list is empty
            //No need for additional null check
        }
	}
	
	/*
	 * Java Output Formatting
	 * Java provides various mechanisms for output formatting, 
	 * allowing you to control the appearance of data when it’s printed.
	 */
	static void javaOutputFormatting() {
		double price = 49.83198374;
		System.out.printf("Price: $%.2f%n", price);
	}
	
	/*
	 * underscore in Numeric Literals:
	 */
	static void numericLiteralsExample() {
		//Using underscores in numeric literals for readability
        int million = 1_000_000;
        long billion = 1_000_000_000L;
        double pi = 3.141_592_653_589_793;

        //Printing values
        System.out.println("One million: " + million);
        System.out.println("One billion: " + billion);
        System.out.println("Value of pi: " + pi);
	}
	
	/*
	 * #2 Map.computeIfAbsent
	 */
	static int computeValue(String key) {
		//Simulating a complex computation based on the key
        System.out.println("Computing value for key: " + key);
        
        return key.length(); 
        //Just a simple example, the computation can be more complex
	}
	
	/*
	 * #1 Map.computeIfAbsent
	 */
	static void computeUfAbsentExample() {
		//Creating a map
        Map<String, Integer> numberMap = new HashMap<String, Integer>();
        
        //Default map data example
        //numberMap.put("one", 0);
        numberMap.put("two", 2);
        numberMap.put("three", 4);
        numberMap.put("four", 3);
        
        //Using computeIfAbsent to add a value if the key is absent
        String key = "one";
        numberMap.computeIfAbsent(key, k -> TestCodes.computeValue(k)); //Lambda expression for the computation
        
        //Printing the map
        System.out.println("Number Map: " + numberMap);
	}

	/*
	 * Iterator: = Iterator looping
	 * Wrapper Class = List<Integer> not List<int>
	 */
	static void testIterator() {
		List<Integer> numbers = new ArrayList<Integer>();
		Random rand = new Random();
		numbers.add(rand.nextInt(20));
		numbers.add(rand.nextInt(20));
		numbers.add(rand.nextInt(20));
		numbers.add(rand.nextInt(20));
		numbers.add(rand.nextInt(20));
		numbers.add(rand.nextInt(20));
	
		Collections.sort(numbers);
		
		System.out.print(Arrays.toString(numbers.toArray()));
		System.out.println(" :Generated numbers..");
		
		Iterator<Integer> itr = numbers.iterator();
		while(itr.hasNext()) {
			int itrValue = itr.next();
			if(itrValue < 10) {
				itr.remove();
			}
		}
		
		System.out.print(Arrays.toString(numbers.toArray()));
		System.out.println(" :Remove less than 10 value from generated numbers..");
	}
	
	/*
	 * Lambda Expression = .filter, .map, and etc.
	 */
	static List<Person> generatePersonData() {
		return List.of(
				new Person("Samuel John", "Smith", GENDER.MALE, 15),
				new Person("Jenny", "Kyoto", GENDER.FEMALE, 10),
				new Person("Riyota", "Uzuhimi", GENDER.MALE, 30),
				new Person("Princess", "Smith", GENDER.FEMALE, 28),
				new Person("Samantha Khim", "Smith", GENDER.FEMALE, 18),
				new Person("Johny", "Smurf", GENDER.MALE, 21));
	}
	
	/*
	 * MAIN
	 */
	public static void main(String[] args) {
		try {
			//Iterator:
			//TestCodes.testIterator();
			//System.out.println();
			
			/*
			 * Lambda Expression: and Enums for Constants:
			 * 
			 * Using enums for constants is another best practice in Java. Enums provide a way to represent a fixed set of named values, 
			 * making the code more readable, maintainable, and less error-prone compared to using raw constants. 
			 * Enums are especially useful when you have a small, well-defined set of related constants.
			 */
			//System.out.println("Generated Person object with filter for Gender=FEMALE, Surname=Smith only, and set it's Age=Age*2");
			/*List<Person> filteredPeople = generatePersonData().stream()
					.filter(thisPersonGender -> GENDER.FEMALE.equals((thisPersonGender.gender)))
					.filter(thisPersonSurname -> "Smith".equalsIgnoreCase(thisPersonSurname.sname))
					.map(thisPersonObj -> {
						Person updPersonBO = new Person();
						updPersonBO = thisPersonObj;
						updPersonBO.setAge(thisPersonObj.getAge() * 2);
						return updPersonBO;
					})
					.collect(Collectors.toList());
			filteredPeople.forEach(System.out::println);
			System.out.println();*/
			
			/*
			 * Use Map.computeIfAbsent (Java 8+) for avoiding explicit null checks:
			 * 
			 * The Map.computeIfAbsent method in Java (introduced in Java 8) is a convenient way 
			 * to compute a value for a given key if the key is not already associated with a value. 
			 * This method is useful for scenarios where you want to perform a computation 
			 * only if the key is not present in the map.
			 */
			//TestCodes.computeUfAbsentExample();
			//System.out.println();
			
			/*
			 * Underscore in Numeric Literals:
			 * 
			 * Use underscores in numeric literals in Java 7 and later to make your code easier to read. 
			 * The underscores are only there for visual separation; the compiler ignores them 
			 * and they have no bearing on the numerical value.
			 */
			//TestCodes.numericLiteralsExample();
			//System.out.println();
			
			//TestCodes.javaOutputFormatting();
			//System.out.println();
			
			/*
			 * Empty Collection instead of Null:
			 * 
			 * Prefer empty collections over null to denote the absence of elements. This practice offers multiple benefits. 
			 * Firstly, it mitigates the risk of null pointer exceptions, which can arise when operations are performed on null objects. 
			 * By utilizing empty collections, developers streamline code logic, eliminating the need for additional null checks 
			 * and resulting in cleaner and more readable code. The approach ensures consistent behavior throughout the code-base 
			 * and simplifies error handling, making the software more robust and less prone to unexpected runtime errors.
			 */
			//TestCodes.emptyCollectionInsteadOfNull();
			//System.out.println();
			
			/*
			 * BigDecimal for Precise Decimal Calculations:
			 * For accurate decimal computations in Java, BigDecimal is essential, particularly when dealing with critical accuracy. 
			 * Primitive data types like float and double have limited accuracy and might cause rounding mistakes; in contrast, 
			 * BigDecimal provides an accurate representation of decimal numbers and offers arbitrary precision arithmetic.
			 */
			//TestCodes.bigDecimal();
			//System.out.println();
			
			
			/*
	         * Comparing real numbers: Math.abs(value)
	         * 
	         * As mentioned earlier, you can't just grab real numbers and compare them. 
	         * There is always the possibility that some significant digits may be discarded, causing unexpected side effects. 
	         * That's why there is a time-tested approach. If two real numbers differ by a very small value, 
	         * then they can be considered to be equal.
	         */
			//TestCodes.mathAbs();
			//System.out.println();
			
			/*
			 * TwoSum: 
			 */
			//TestCodes.twoSum();
			//System.out.println();
			
			/*
			 * Factorial: 
			 */
			//TestCodes.factorial(new Random().nextInt(6));
			//System.out.println();
			
			TestCodes.loop();
			System.out.println();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Lambda Expression: and Enums for Constants:
	 */
	public enum GENDER {
		MALE, FEMALE, BISEXUAL, OTHERS;
	}
	
	/*
	 * Lambda Expression: and Enums for Constants:
	 */
	static class Person {
		//Fields
		private String fname;
		private String sname;
		private GENDER gender;
		private int age;
		
		//Constructors
		Person() {}
		Person(String fname, String sname, GENDER gender, int age) {
			this.fname = fname;
			this.sname = sname;
			this.gender = gender;
			this.age = age;
		}

		//Getters and Setters
		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public String getSname() {
			return sname;
		}

		public void setSname(String sname) {
			this.sname = sname;
		}

		public GENDER getGender() {
			return gender;
		}

		public void setGender(GENDER gender) {
			this.gender = gender;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		//Overrides function
		@Override
		public String toString() {
			return "Person [fname=" + fname + ", sname=" + sname + ", gender=" + gender + ", age=" + age + "]";
		}
		
	}
}
