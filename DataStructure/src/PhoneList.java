import java.util.Scanner;
import java.util.ArrayList;

public class PhoneList{

	public static class DirectoryEntry {
		  String name;
		  String number;
		  DirectoryEntry(String name,String number){
			  this.name=name;
			  this.number=number;
		  }
	}
	
	public Integer equals(String type,String searchStr) {
		int k;
		A:
		for (k =0; k<theDirectory.size()+1;k++) {
			if (k<theDirectory.size()) {
				String check="";
				if (type.equals("name")) check=theDirectory.get(k).name;		
				else if (type.equals("number"))	 check=theDirectory.get(k).number;	
				else { System.out.println("wrong type"); return k=-1;}
				if (check.equals(searchStr)) break A;
				}
			else{
				System.out.println("not found");
				return k=-1;
			}
		}
		return k;
	}
	private ArrayList<DirectoryEntry> theDirectory = new ArrayList<DirectoryEntry>();	//private : applicable to inner class
	
	public PhoneList() {}	//Constructors
	public String search() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Please enter type and search string.(EX.name Minnie chen) ");
		String type =sc.next();
		String searchStr=sc.nextLine();
		searchStr=searchStr.substring(1,searchStr.length());

		int index=equals(type,searchStr);
		String dE;
		if (index != -1) {
			if (type.equals("name")) dE=searchStr+" number : "+(theDirectory.get(index)).number;
			else dE=searchStr+" name : "+(theDirectory.get(index)).name;
		}
		else	dE=null;
		
		sc.close();
		return dE;
	}
	public static void main(String[] args) {	//run
		 PhoneList p1= new  PhoneList();	
		 p1.theDirectory.add(new DirectoryEntry("Jane Smith", "555-1212"));
		 p1.theDirectory.add(new DirectoryEntry("Dua Lipa", "000-9090"));
		 p1.theDirectory.add(new DirectoryEntry("Ariana Grande", "888-7777"));
		 p1.theDirectory.add(new DirectoryEntry("Ketty Perry", "666-4545"));
		 p1.theDirectory.add(new DirectoryEntry("Minnie chen", "999-8888"));
		 System.out.println(p1.search());
	}
}