package com.javaproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws IOException {

		int select;
		
		//0. Person만 받는 ArrayList 생성
		List<Person> list = new ArrayList<Person>();
		
		//1. 파일 빨대
		Reader fr = new FileReader("phoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		
		//2. 메뉴 선택
		System.out.println("**************************************************");
		System.out.println("*                전화번호 관리 프로그램                                        *");
		System.out.println("**************************************************");
		
		do {
		
			System.out.println(" ");
			System.out.println("      1.리스트     2.등록     3.삭제     4.검색     5.종료     ");
			System.out.println("-------------------------------------------------");
			
			//메뉴 번호 입력받을 스캐너 생성
			Scanner sc = new Scanner(System.in);
			System.out.print(">메뉴번호: ");
			select = sc.nextInt();
			
			switch (select) {
			
				//리스트 조회
				case 1: {
					
					//리스트 불러오기
					list = new ArrayList<Person>();
					fr = new FileReader("phoneDB.txt");
					br = new BufferedReader(fr);
					
					// 3. 파일 불러와서 구분해주기
					String line = "";
	
					// while문 안넣어주면 언제 끝까지 읽었는지 알 수 없음.
					while (true) {
						// 한 줄을 읽는다.
						line = br.readLine();
						if (line == null) {
							break;
						}
					
					// split로 ,단위로 내용을 구분해서 배열에 넣어준다. (배열 하나 당 사람 정보 하나)
					String[] personInfo = line.split(",");
	
					// 리스트에 정보를 넣어준다.
					Person person = new Person(personInfo[0], personInfo[1], personInfo[2]);
					list.add(person);
					} 
					
					// 리스트 내용을 출력한다.
					System.out.println(" ");
					System.out.println("<1.리스트>");
					for (Person ps : list) {
						System.out.println(list.indexOf(ps)+1+". "+ps.getName()+ "," + ps.getHp() + ","+ ps.getCompany());
					} 
					System.out.println(" ");
					break;
				} 
				
				//등록하기
				case 2 : {
					
					//리스트 불러오기
					list = new ArrayList<Person>();
					fr = new FileReader("phoneDB.txt");
					br = new BufferedReader(fr);
					
					// 3. 파일 불러와서 구분해주기
					String line = "";
	
					// while문 안넣어주면 언제 끝까지 읽었는지 알 수 없음.
					while (true) {
						// 한 줄을 읽는다.
						line = br.readLine();
						if (line == null) {
							break;
						}
					
					// split로 ,단위로 내용을 구분해서 배열에 넣어준다. (배열 하나 당 사람 정보 하나)
					String[] personInfo = line.split(",");
	
					// 리스트에 정보를 넣어준다.
					Person person = new Person(personInfo[0], personInfo[1], personInfo[2]);
					list.add(person);
					} 
					
					br.close(); 
					
					//입력값 받기
					System.out.println(" ");
					System.out.println("<2.등록>");
					System.out.print(">이름: ");
					String name = sc.next();
					System.out.print(">휴대전화: ");
					String hp = sc.next();
					System.out.print(">회사전화: ");
					String company = sc.next();
					
					System.out.println(" ");
					
					//파일로 내용 내보내기
					/*Writer fw = new FileWriter("phoneDB.txt");
					BufferedWriter bw = new BufferedWriter(fw);*/
					BufferedWriter bw = new BufferedWriter(new FileWriter("phoneDB.txt"));
	
					//person->list 저장
					Person person = new Person(name,hp,company);
					list.add(person); //person을 list에 넣는다.
					
					//for문 돌려 내용을 넣는다.
					for(int i=0; i<list.size(); i++) {
						bw.write(list.get(i).getName() + "," + list.get(i).getHp() + "," + list.get(i).getCompany());
						bw.newLine();
						//bw.flush();
						
					} bw.close();
					System.out.println("[등록되었습니다.]");
					break;
			    }
				
				//삭제하기
				case 3 : {
					
					System.out.println("<3.삭제>");
					
					//리스트 불러오기
					list = new ArrayList<Person>();
					fr = new FileReader("phoneDB.txt");
					br = new BufferedReader(fr);
					
					// 3. 파일 불러와서 구분해주기
					String line = "";
	
					// while문 안넣어주면 언제 끝까지 읽었는지 알 수 없음.
					while (true) {
						// 한 줄을 읽는다.
						line = br.readLine();
						if (line == null) {
							break;
						}
					
					// split로 ,단위로 내용을 구분해서 배열에 넣어준다. (배열 하나 당 사람 정보 하나)
					String[] personInfo = line.split(",");
	
					// 리스트에 정보를 넣어준다.
					Person person = new Person(personInfo[0], personInfo[1], personInfo[2]);
					list.add(person);
					} 
					
					for (Person ps : list) {
						System.out.println(list.indexOf(ps)+1+". "+ps.getName()+ "," + ps.getHp() + ","+ ps.getCompany());
					} 
					br.close(); 
					
					//삭제 번호 입력
					System.out.println(" ");
					System.out.print(">번호: ");
					int num = sc.nextInt();
					
					//리스트 정보 삭제
					list.remove(num-1);
					
					//파일 내보내기
					BufferedWriter bw = new BufferedWriter(new FileWriter("phoneDB.txt"));
					
					//for문 돌려 내용을 넣는다.
					for(int i=0; i<list.size(); i++) {
						bw.write(list.get(i).getName() + "," + list.get(i).getHp() + "," + list.get(i).getCompany());
						bw.newLine();
						
					} bw.close();
					System.out.println("[삭제되었습니다.]");
					break;
				}
				
				//검색하기
				case 4: {
					
					System.out.println("<4.검색>");
					
					//리스트 불러오기
					list = new ArrayList<Person>();
					fr = new FileReader("phoneDB.txt");
					br = new BufferedReader(fr);
					
					// 3. 파일 불러와서 구분해주기
					String line = "";
	
					// while문 안넣어주면 언제 끝까지 읽었는지 알 수 없음.
					while (true) {
						// 한 줄을 읽는다.
						line = br.readLine();
						if (line == null) {
							break;
						}
					
					// split로 ,단위로 내용을 구분해서 배열에 넣어준다. (배열 하나 당 사람 정보 하나)
					String[] personInfo = line.split(",");
	
					// 리스트에 정보를 넣어준다.
					Person person = new Person(personInfo[0], personInfo[1], personInfo[2]);
					list.add(person);
					} 
					
					br.close(); 
					
					//검색할 내용 입력
					System.out.println(">검색어 입력: ");
					String search = sc.next();
					
					for (int i=0; i<list.size(); i++) {
						//contains = 내가 입력한 문자와 동일한 애가 있는지 확인해라.
						boolean vs = list.get(i).getName().contains(search);
						
						if(vs==true) {
							System.out.println(list.get(i).getName() + "," + list.get(i).getHp() + "," + list.get(i).getCompany());
						}
					}
				}
			}
		} while(select!=5); {
			   System.out.println(" ");
			   System.out.println("**************************************************");
			   System.out.println("*                      감사합니다                                            *");
			   System.out.println("**************************************************");
		}
		br.close();
	}
}
