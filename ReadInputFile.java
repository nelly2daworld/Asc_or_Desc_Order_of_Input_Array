package readInput;
import java.io.*;
import java.util.*;
/**
@author Shaunelle Thomas

Reads the input file as string, splits the string, converts string to integer, store integers from each line in separate ArrayList and use the isAscending and isDescending function on each list to find out its order
***/

public class ReadInputFile {
 /**
Function gets the file and prints to the screen the order of each list
@return void
***/
 public void orderOfInputFile() {
  OrderChecker order = new OrderChecker();
  File fileName = new File("input.txt");
  try {
   Scanner scanLine = new Scanner(fileName);
   while (scanLine.hasNextLine()) {
    String line = scanLine.nextLine();
    //Arraylist  to store string equivalent of input integers w/o delimiter
    ArrayList <String> arrayInputList = new ArrayList<> (Arrays.asList(line.split(", ")));
    int size = arrayInputList.size();
     if(size == 0){
        System.out.println("Empty array!");
        return;
      }    
    //Arraylist to store each of the integers from string arraylist
    ArrayList <Integer> myList = new ArrayList <Integer> (size);
    //Iterate through arrayInputList & store each temporary stringVal to myList
    for (String stringVal: arrayInputList) {
     myList.add(Integer.parseInt(stringVal));
    }
    // System.out.println("Array:" + myList);

    if (order.isAscending(myList)) {
     System.out.println("--> Array " + myList + " is in ascending order\n");
    } else {
     System.out.println("--> Array " + myList + " is NOT in ascending order\n");
    }

    if (order.isDescending(myList)) {
     System.out.println("--> Array " + myList + " is in descending order\n");
    } else {
     System.out.println("--> Array " + myList + " is NOT in descending order\n");
    }
   }
   scanLine.close();
  } catch (FileNotFoundException e) {
   e.printStackTrace();
  }
 }
}

/**
Checks the order (Ascending or Descending) of the input arrayList
***/
class OrderChecker {
 /**
@param myArray - the interger arrayList converted input 

@return boolean - list is Ascending or not
***/
 public boolean isAscending(List <Integer> myArray) {
  boolean ascendingList = true;
  for (int i = 0; i < myArray.size() - 1; ++i) {
   if (myArray.get(i) > myArray.get(i + 1)) {
    ascendingList = false;
   }
  }
  return ascendingList;
 }
 /**
@param myArray - the interger arrayList converted input 

@return boolean - list is Descending or not
***/
 public boolean isDescending(List < Integer > myArray) {
  boolean descendingList = true;
  for (int i = 0; i < myArray.size() - 1; ++i) {
   if (myArray.get(i) < myArray.get(i + 1)) {
    descendingList = false;
   }
  }
  return descendingList;
 }
}
