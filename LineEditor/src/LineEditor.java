/*
 * Title: Line Editor
 * Author: Ryan Slater
 * Date: 9/11/2017
 * Purpose: Line Editor class AP Question
 */
public class LineEditor{
	
	private String myLine;
	
	public LineEditor(String str){
		
		myLine = new String(str);
		
	}
	
	public void insert(String str, int index){
		
		String s1 = "", s2 = "", s3 = "";
		
		if(index == 0){
			myLine = new String(str+myLine);
		}else if(index == myLine.length()){
			myLine = new String(myLine+str);
		}else{
			s1 = new String(myLine.substring(0, index));
			s2 = str;
			s3 = new String(myLine.substring(index, myLine.length()));
			myLine = new String(s1+s2+s3);
		}
		
		//System.out.println(myLine);
		
	}
	
	public void delete(String str){
		
		String s1 = "", s2 = "";
		
		for(int i=0; i<myLine.length()-str.length(); i++){
			if(myLine.substring(i, i+str.length()).contains(str)){
				s1 = myLine.substring(0, i);
				s2 = myLine.substring(i+str.length());
				myLine = new String(s1+s2);
				break;
			}
		}
		
	}
	
	public void deleteAll(String str){
		
		int l = 0;
		//run delete a shitton of times
		while(l < myLine.length()){
			String s1 = "", s2 = "";
			
			for(int i=0; i<myLine.length()-str.length()+1; i++){
				if(myLine.substring(i, i+str.length()).contains(str)){
					s1 = myLine.substring(0, i);
					s2 = myLine.substring(i+str.length());
					myLine = new String(s1+s2);
					break;
				}
			}
		l++;
		}
		
	}
	
	public String toString(){
		
		return(myLine);
		
	}
	
}