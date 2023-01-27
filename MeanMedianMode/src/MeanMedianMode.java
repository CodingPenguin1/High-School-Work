/**
 * Title: Mean Median and Mode
 * Author: Ryan Slater
 * Date: 10/4/2017
 */

import java.util.Arrays;

public class MeanMedianMode {
	
	private int[] intArray;
	
	public MeanMedianMode(int[] array){
		intArray = array;
	}
	
	public double findMean(){
		double mean = 0;
		int i = 0;
		for(int x:intArray){
			mean += x;
		}
		mean /= intArray.length;
		return mean;
	}
	
	public double findMedian(){
		double median;
		int[] sorted = new int[intArray.length];
		for(int i=0; i<intArray.length; i++){
			sorted[i] = intArray[i];
		}
		Arrays.sort(sorted);
		if(sorted.length % 2 != 0){
			median = sorted[sorted.length/2];
		}
		else{
			median = sorted[sorted.length/2];
			median += sorted[sorted.length/2-1];
			median /= 2;
		}
		return median;
	}
	
	public String findModes(){
		String modes = new String("");
		//Duplicate Array
		int[] modeArray = new int[intArray.length];
		for(int i=0; i<intArray.length; i++){
			modeArray[i] = intArray[i];
		}

		int numUnique = modeArray.length;
		for(int i=0; i<numUnique; i++){
			for (int j = i+1; j < numUnique; j++)
            {
                if(modeArray[i] == modeArray[j])
                {
                	modeArray[j] = modeArray[numUnique-1];
                	numUnique--;
                    j--;
                }
            }
		}
		
		int[] newModeArray = new int[numUnique];
		for(int i=0; i<numUnique; i++){
			newModeArray[i] = modeArray[i];
		}
		
		//create count array
		int[] count = new int[newModeArray.length];
		
		for(int i=0; i<count.length; i++){
			int countVal = 0;
			for(int j=0; j<intArray.length; j++){
				if(newModeArray[i] == intArray[j]){
					countVal += 1;
				}
			}
			count[i] = countVal;
		}
		
		int max = 0;
		for(int i=0; i<count.length; i++){
			if(count[i] > max){
				max = count[i];
			}
		}
		
		for(int i=0; i<count.length; i++){
			if(count[i] == max){
				modes = modes + newModeArray[i] + " ";
			}
		}
		
		return modes;
	}
	
}