import java.util.*;
class StudentManagementSystem{
	public static String [] stdId=new String[0];
	public static String [] stdName=new String[0];
	public static int [] prfMarks= new int [0];
	public static int [] dbmsMarks=new int [0];
	
	public static void main(String args []){
		mainScreen();	
		}

	public static void addNewStd(){
		Scanner input=new Scanner(System.in);
		stdId(stdId.length);	
		addNewName(stdName.length);
		addMarks();
		System.out.println("\nStudent has been added successfully !!\n");
		System.out.print("Do you want to add a new student(Y/N) : ");
		
		String s=input.nextLine();
		if(decision(s)){
			addNewStd();
			}else{
				clearConsole();
				mainScreen();
				}
				return;
			}				
				
	public static void addNewStdAndMarks(){
		Scanner input=new Scanner(System.in);
		stdId(stdId.length);
		addNewName(stdName.length);
		addMarks();
		prfMarks(prfMarks.length-1);
		dbmsMarks(dbmsMarks.length-1);
		System.out.println("\nStudent has been added successfully !!\n");
		System.out.print("Do you want to add a new student(Y/N) : ");
		String s=input.nextLine();
		if(decision(s)){
			addNewStdAndMarks();
		}else{
			clearConsole();
			mainScreen();
				}
				return;
		}			
				
	public static void addStdMarks(){
		Scanner input=new Scanner(System.in);
		System.out.print("\nInput Student ID : ");
		String s=input.nextLine();
		int i=searchIdIndex(s);
		if(i==stdId.length){
			System.out.println("\nThe Student ID you entered DOES NOT EXIST !! ");
			System.out.print("Do you want to try again(Y/N) : ");
			s=input.nextLine();
			if(decision(s)){
			addStdMarks();
			}else{
				clearConsole();
				mainScreen();
				}
			}else{
		System.out.print("\nStudent Name : "+stdName[i]);
		if(prfMarks[i]<0){
			prfMarks(i);
			dbmsMarks(i);
			System.out.println("\nStudent marks has been added successfully !!\n");
		
		}else{
			System.out.println("Student already has marks !!\nIf you want to update marks,choose option [5] from main menu");
		}
		System.out.print("Do you want to add new student marks(Y/N) : ");
		s=input.nextLine();
		if(decision(s)){
			addStdMarks();
			}else{
				clearConsole();
				mainScreen();
				}
			}
			return;
		}			
		
	public static void updateStd(){
		Scanner input=new Scanner(System.in);
		System.out.print("\nInput Student ID : ");
		String s=input.nextLine();
		int i=searchIdIndex(s);
		if(i==stdId.length){
			System.out.println("\nThe Student ID you entered DOES NOT EXIST !! ");
			System.out.print("Do you want to try again(Y/N) : ");
			s=input.nextLine();
			if(decision(s)){
			updateStd();
			}else{
				clearConsole();
				mainScreen();
				}
			}else{
		System.out.print("Student Name : "+stdName[i]+"\n\n");
		addNewName(i);
		System.out.print("\nStudent Detail has been successfully updated.\n");
		System.out.print("Do you want to update another student(Y/N) : ");
		s=input.nextLine();
		if(decision(s)){
		updateStd();
		}else{
			clearConsole();
			mainScreen();
			}
		}
	}
		
	public static void updateMarks(){
		Scanner input=new Scanner(System.in);
		System.out.print("\nInput Student ID : ");
		String s=input.nextLine();
		int i=searchIdIndex(s);
		if(i==stdId.length){
			System.out.println("\nThe Student ID you entered DOES NOT EXIST !! ");
			System.out.print("Do you want to try again(Y/N) : ");
			s=input.nextLine();
			if(decision(s)){
			updateMarks();
			}else{
				clearConsole();
				mainScreen();
				}
			}else{
		if(prfMarks[i]!=-1){
		System.out.println("\nStudent Name : "+stdName[i]);
		System.out.println("\nPRF marks : "+prfMarks[i]);
		System.out.println("DBMS marks : "+dbmsMarks[i]);
		prfMarks(i);
		dbmsMarks(i);
		System.out.print("\nStudent Marks has been successfully updated.\n");
			}else{
				System.out.print("\nStudent Doesn't have marks added.\n");
				}
		}
		System.out.print("Do you want to update another student marks(Y/N) : ");
		s=input.nextLine();
		if(decision(s)){
		updateMarks();
		}else{
			clearConsole();
			mainScreen();
			}
	}
		
	public static void deleteStd(){
		Scanner input=new Scanner(System.in);
		System.out.print("\nInput Student ID : ");
		String s=input.nextLine();
		int i=searchIdIndex(s);
		if(i==stdId.length){
			System.out.println("\nThe Student ID you entered DOES NOT EXIST !! ");
			System.out.print("Do you want to try again(Y/N) : ");
			s=input.nextLine();
			if(decision(s)){
			deleteStd();
			}else{
				clearConsole();
				mainScreen();
				}
			}else{
				delStd(i);
		System.out.print("\nStudent Detail has been successfully Deleted.\n");
		System.out.print("Do you want to delete another student(Y/N) : ");
		s=input.nextLine();
		if(decision(s)){
		deleteStd();
		}else{
			clearConsole();
			mainScreen();
			}
		}
	}	
		
	public static void stdDetails(){
		Scanner input=new Scanner(System.in);
		System.out.print("\nInput Student ID : ");
		String s=input.nextLine();
		int i=searchIdIndex(s);
		if(i==stdId.length){
			System.out.println("\nThe Student ID you entered DOES NOT EXIST !! ");
			System.out.print("Do you want to try again(Y/N) : ");
			s=input.nextLine();
			if(decision(s)){
			stdDetails();
			}else{
				clearConsole();
				mainScreen();
				}
				}else{
				System.out.println("Student Name :"+stdName[i]);	
					}
			if(prfMarks[i]==-1){
				System.out.print("\nYou haven't added marks.Add marks from option [3] in main menu ");
				}else{
					int num=searchIdIndex(s)+1;
					String rank="";
					if(num==stdId.length && num!=1 && num!=2 && num!=3){num=0;}
					switch(num){
						case 0:rank=stdId.length+"(last)";break;
						case 1:rank=num+"(first)";break;
						case 2:rank=num+"(second)";break;
						case 3:rank=num+"(third)";break;
						default:rank=num+"";break;
						}
					System.out.println("\n+------------------------------------------------------------+");
					System.out.printf("|%-44s|%15d|\n","prf marks",prfMarks[i]);  
					System.out.printf("|%-44s|%15d|\n","dbms marks",dbmsMarks[i]);
					System.out.printf("|%-44s|%15d|\n","Total",prfMarks[i]+dbmsMarks[i]);
					System.out.printf("|%-44s|%15.2f|\n","average",(double)(prfMarks[i]+dbmsMarks[i])/2); 
					System.out.printf("|%-44s|%15s|","rank",rank);
					System.out.println("\n+------------------------------------------------------------+");
					}
					System.out.print("Do you want to search another student (Y/N) : ");
					s=input.nextLine();
				if(decision(s)){
					stdDetails();
				}else{
					clearConsole();
					mainScreen();
				}
			return;
		}	
					
	public static void stdRanks(){
		Scanner input=new Scanner(System.in);
		System.out.println("+------------------------------------------------------------+");
		System.out.println("|Rank |Student ID |Name                       |Total |Average|");
		System.out.println("+------------------------------------------------------------+");
		L1:for (int i = 0; i < stdId.length; i++){
			if(prfMarks[i]==-1){
				continue L1;
				}else{
		System.out.printf("|%-5d|%-11s|%-27s|%6d|%7.2f|\n",(i+1),stdId[i],stdName[i],prfMarks[i]+dbmsMarks[i],(double)(prfMarks[i]+dbmsMarks[i])/2);  
				}
			}
		System.out.print("+------------------------------------------------------------+\n");
		System.out.print("Do you want to retrun to main menu (Y/N) : ");
		String s=input.nextLine();
			if(decision(s)){
				clearConsole();
				mainScreen();
			}else{
				clearConsole();
				System.out.println("\t\t ----------------------------------------------------------------------------------------- \n\t\t | \t\t\t\t\t STUDENT RANKING \t\t\t\t | \n\t\t -----------------------------------------------------------------------------------------");
				stdRanks();
			}
		return;
	}
				
	public static void bestPRF(){
		Scanner input=new Scanner(System.in);
		Rank(prfMarks);
		System.out.println("+------------------------------------------------------------+");
		System.out.println("|Student ID |Name                      |PRF Marks |DBMS marks|");
		System.out.println("+------------------------------------------------------------+");
		L1:for (int i = 0; i < stdId.length; i++){
			if(prfMarks[i]==-1){
				continue L1;
				}else{
		System.out.printf("|%-11s|%-26s|%10d|%10d|\n",stdId[i],stdName[i],prfMarks[i],dbmsMarks[i]);  
				}
			}
		System.out.print("+------------------------------------------------------------+\n");
		System.out.print("Do you want to retrun to main menu (Y/N) : ");
		String s=input.nextLine();
			if(decision(s)){
				clearConsole();
				mainScreen();
			}else{
				clearConsole();
				System.out.println("\t\t ----------------------------------------------------------------------------------------- \n\t\t | \t\t\t\t BEST OF PROGRAMMING FUNDAMENTALS \t\t\t | \n\t\t -----------------------------------------------------------------------------------------");
				bestPRF();
			}
		return;
		
		
		}		
		
	public static void bestDBMS(){
		Scanner input=new Scanner(System.in);
		Rank(dbmsMarks);
		System.out.println("+------------------------------------------------------------+");
		System.out.println("|Student ID |Name                      |DBMS Marks |PRF marks|");
		System.out.println("+------------------------------------------------------------+");
		L1:for (int i = 0; i < stdId.length; i++){
			if(prfMarks[i]==-1){
				continue L1;
				}else{
		System.out.printf("|%-11s|%-26s|%10d|%10d|\n",stdId[i],stdName[i],dbmsMarks[i],prfMarks[i]);  
				}
			}
		System.out.print("+------------------------------------------------------------+\n");
		System.out.print("Do you want to return to main menu (Y/N) : ");
		String s=input.nextLine();
			if(decision(s)){
				clearConsole();
				mainScreen();
			}else{
				clearConsole();
				System.out.println("\t\t ----------------------------------------------------------------------------------------- \n\t\t | \t\t\t\t BEST OF DATABASE MANAGEMENT SYSTEM \t\t\t | \n\t\t -----------------------------------------------------------------------------------------");
				bestDBMS();
			}
		return;
		}				
		
		
	public static void addMarks(){
		
		int [] temp = new int[prfMarks.length+1];
			for (int i = 0; i < prfMarks.length; i++){
				temp[i]=prfMarks[i];
			}		
			prfMarks=temp;
			prfMarks[prfMarks.length-1]=-1;
			
		int [] tem = new int[dbmsMarks.length+1];
			for (int i = 0; i < dbmsMarks.length; i++){
				tem[i]=dbmsMarks[i];
			}		
			dbmsMarks=tem;
			dbmsMarks[dbmsMarks.length-1]=-1;
			
			return;
	}
				
	public static boolean decision(String s){
		Scanner input=new Scanner(System.in);				
			for (int j = 0; j < 1; ){
				
				if(s.equals("Y") || s.equals("y")){
				j++;
				return true;
				}else if(s.equals("N") || s.equals("n")){
					return false;
					}else{
					System.out.print("\n\nInvalid Input !!\n\n");	
					System.out.print("Input only \"Y\" or \"N\" : ");
					s=input.nextLine();
					}
				}
		return false;
	}
	
	public static boolean searchId(int index){
		for (int i = 0; i < index; i++){
			if(stdId[index].equals(stdId[i])){
				System.out.println("\nThe Student ID you entered already EXIST !! ");
			return true;
				}
			}
		char result=stdId[index].charAt(0);
			if((result<(char)64 || result>(char)90) && (result<(char)97 || result>(char)122)){
				System.out.print("\nStudent ID must start with a LETTER !!\n\n");
				return true;
				}else if(stdId[index].length()!=4){
					System.out.print("\nStudent ID must have 4 CHARACTERS !!\n\n");
					return true;
					}
		for (int i = 1; i < stdId[index].length(); i++){
			result=stdId[index].charAt(i);
			if((result<(char)48 || result>(char)57)){
				System.out.print("\nStudent ID must have 3 NUMBERS !!\n\n");
				return true;
				}
		}
		
				
		return false;
	}
	
	public static void addNewName(int index){
		Scanner input=new Scanner(System.in);
		String [] temp = new String[stdName.length+1];
		if(index==stdName.length){
			for (int i = 0; i < stdName.length; i++){
			temp[i]=stdName[i];
				}
				stdName=temp;
			}
			L1:for (int i = 0; i < 1;){
				System.out.print("Enter new Student Name : ");
				stdName[index]=input.nextLine();
				for (int j = 0; j < stdName[index].length();j++){
				char result=stdName[index].charAt(j);
				if((result<(char)65 || result>(char)90) && (result<(char)97 || result>(char)122)){
					System.out.print("\nA name has only letters!!\n\n");
					continue L1;
					}else{
						
					}
				}
				i++;
			}
			return ;
	}
		
	public static void delStd(int index){
			String [] temp1 = new String[stdId.length-1];
			int j=0;
			int i = 0;
			for (; j < stdId.length; j++){
				if(j==index){
					}else{
					temp1[i]=stdId[j];
					i++;
				}
			}		
			stdId=temp1;
			
			String [] temp2 = new String[stdName.length-1];
			j=0;
			i=0;
			for (; j < stdName.length; j++){
				if(j==index){
					}else{
					temp2[i]=stdName[j];
					i++;
				}
			}		
			stdName=temp2;
			
			int [] temp3 = new int[prfMarks.length-1];
			j=0;
			i=0;
			for (; j < prfMarks.length; j++){
				if(j==index){
					}else{
					temp3[i]=prfMarks[j];
					i++;
				}
			}		
			prfMarks=temp3;
			
			int [] temp4 = new int[dbmsMarks.length-1];
			j=0;
			i=0;
			for (; j < dbmsMarks.length; j++){
				if(j==index){
					}else{
					temp4[i]=dbmsMarks[j];
					i++;
				}
			}		
			dbmsMarks=temp4;
			return ;
	}	
		
	public static void prfMarks(int index){
		Scanner input=new Scanner(System.in);
		
		do{
			
		System.out.print("\nInput PRF marks : ");
		prfMarks[index]=input.nextInt();
		if(searchMarks(prfMarks,index)){
				System.out.print("Invalid Marks !!\n");
				}
			}while(searchMarks(prfMarks,index));
			
		return;
	}
			
	public static void dbmsMarks(int index){		
		Scanner input=new Scanner(System.in);
		
		do{
		System.out.print("Input DBMS marks : ");
		dbmsMarks[index]=input.nextInt();
		if(searchMarks(dbmsMarks,index)){
				System.out.print(" Invalid Marks !!\n\n");
				}
			}while(searchMarks(dbmsMarks,index));
		
		return;
	}

	public static boolean searchMarks(int [] ar,int index){
		if(ar[index]>100 || ar[index]<0){
			return true;
			}
		return false;
		}

	public static int searchIdIndex(String s){
		int i = 0;
		for (; i < stdId.length; i++){
			if(stdId[i].equals(s)){
			return i;
				}
			}
		return i;
		
		}

	public static void stdId(int index){
		Scanner input=new Scanner(System.in);
				
		String [] temp = new String[stdId.length+1];
		int i = 0;
		for (; i < stdId.length; i++){
			temp[i]=stdId[i];
				}
		stdId=temp;
		
		do{
			System.out.print("\nInput Student ID : ");
			stdId[index]=input.nextLine();
		}while(searchId(i));
		return;
		}

	public static void mainScreen(){
		Scanner input=new Scanner(System.in);
		
		System.out.println("\t\t ----------------------------------------------------------------------------------------- \n\t\t | \t\t\t\t GDSE65 MARKS MANAGEMENT SYSTEM \t\t\t | \n\t\t -----------------------------------------------------------------------------------------");
						  
		System.out.println("\n\t\t[1] Add new student \t\t\t\t[2] Add new student with marks ");
		System.out.println("\n\t\t[3] Add marks       \t\t\t\t[4] Update student detail  ");
		System.out.println("\n\t\t[5] Update marks    \t\t\t\t[6] Delete student  ");
		System.out.println("\n\t\t[7] Print student detail \t\t\t[8] Print student Ranks  ");
		System.out.println("\n\t\t[9] Best of Programming Fundamentals \t\t[10] Best of Database Management System ");
		
		System.out.print("\n\nEnter an Option number : ");
		int num=input.nextInt();
		stdRank();
		clearConsole();
		switch(num){
		
		case 1 : System.out.println("\t\t ----------------------------------------------------------------------------------------- \n\t\t | \t\t\t\t\t ADD NEW STUDENT \t\t\t\t | \n\t\t -----------------------------------------------------------------------------------------");addNewStd(); break;
		case 2 : System.out.println("\t\t ----------------------------------------------------------------------------------------- \n\t\t | \t\t\t\t ADD NEW STUDENT AND MARKS \t\t\t\t | \n\t\t -----------------------------------------------------------------------------------------");addNewStdAndMarks(); break;
		case 3 : System.out.println("\t\t ----------------------------------------------------------------------------------------- \n\t\t | \t\t\t\t\t ADD STUDENT MARKS \t\t\t\t | \n\t\t -----------------------------------------------------------------------------------------");addStdMarks(); break;
		case 4 : System.out.println("\t\t ----------------------------------------------------------------------------------------- \n\t\t | \t\t\t\t\t UPDATE STUDENT DETAIL \t\t\t\t | \n\t\t -----------------------------------------------------------------------------------------");updateStd(); break;
		case 5 : System.out.println("\t\t ----------------------------------------------------------------------------------------- \n\t\t | \t\t\t\t\t UPDATE MARKS \t\t\t\t\t | \n\t\t -----------------------------------------------------------------------------------------");updateMarks(); break;
		case 6 : System.out.println("\t\t ----------------------------------------------------------------------------------------- \n\t\t | \t\t\t\t\t DELETE STUDENT \t\t\t\t | \n\t\t -----------------------------------------------------------------------------------------");deleteStd(); break;
		case 7 : System.out.println("\t\t ----------------------------------------------------------------------------------------- \n\t\t | \t\t\t\t\t STUDENT DETAIL \t\t\t\t | \n\t\t -----------------------------------------------------------------------------------------");stdDetails(); break;
		case 8 : System.out.println("\t\t ----------------------------------------------------------------------------------------- \n\t\t | \t\t\t\t\t STUDENT RANKING \t\t\t\t | \n\t\t -----------------------------------------------------------------------------------------");stdRanks(); break;
		case 9 : System.out.println("\t\t ----------------------------------------------------------------------------------------- \n\t\t | \t\t\t\t BEST OF PROGRAMMING FUNDAMENTALS \t\t\t | \n\t\t -----------------------------------------------------------------------------------------");bestPRF(); break;
		case 10: System.out.println("\t\t ----------------------------------------------------------------------------------------- \n\t\t | \t\t\t\t BEST OF DATABASE MANAGEMENT SYSTEM \t\t\t | \n\t\t -----------------------------------------------------------------------------------------");bestDBMS(); break;
		default :System.out.println("Invalid Input");clearConsole();mainScreen();break;	
			
			}
		return;
	}
	
	public static void stdRank(){
		int [] tot=new int[stdId.length];
		for (int i = 0; i < tot.length; i++){
			tot[i]=prfMarks[i]+dbmsMarks[i];
		}
		for (int i = 0; i < tot.length-1; i++){
			int max=tot[i];
			for (int j = i+1; j < tot.length; j++){
				if(max<=tot[j]){
					max=tot[j];
					tot[j]=tot[i];
					tot[i]=max;
					
					String temp=stdId[j];
					stdId[j]=stdId[i];
					stdId[i]=temp;
					
					int num=prfMarks[j];
					prfMarks[j]=prfMarks[i];
					prfMarks[i]=num;
					
					temp=stdName[j];
					stdName[j]=stdName[i];
					stdName[i]=temp;
					
					num=dbmsMarks[j];
					dbmsMarks[j]=dbmsMarks[i];
					dbmsMarks[i]=num;
					}
				}
			}
		}
	
	public static void Rank(int [] ar){
		int [] temp=new int [ar.length];
		for (int i = 0; i < ar.length; i++){
			temp[i]=ar[i];
		}
		
		for (int i = 0; i < stdId.length-1; i++){
			int max=temp[i];
			for (int j = i+1; j < stdId.length-1; j++){
				if(max<temp[j]){
					max=temp[j];
					temp[j]=temp[i];
					temp[i]=max;
					
					String tem=stdId[j];
					stdId[j]=stdId[i];
					stdId[i]=tem;
					
					int num=prfMarks[j];
					prfMarks[j]=prfMarks[i];
					prfMarks[i]=num;
					
					tem=stdName[j];
					stdName[j]=stdName[i];
					stdName[i]=tem;
					
					num=dbmsMarks[j];
					dbmsMarks[j]=dbmsMarks[i];
					dbmsMarks[i]=num;
					}
				}
			}
	}
		
	public final static void clearConsole(){ 
		try {
			final String os = System.getProperty("os.name"); 
				if (os.contains("Windows")) {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J"); 
				System.out.flush();
				}
		 } catch (final Exception e) {
			 e.printStackTrace();
			 // Handle any exceptions.
				}
		}
	
}	
