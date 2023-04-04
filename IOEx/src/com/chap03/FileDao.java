package com.chap03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDao {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new FileReader("bookList.txt"));) {
			String str = "";
			
			
			while( (str = br.readLine()) != null) {
//				String str = "1/제목1/작가1/false";
				// 책을 생성하는데 필요한 값들을 구분자를 이용하여 배열에 저장
				// 파라메터로 입력된 구분자(split안에들어있는거)를 이용하여 문자열을 자르고 배열로 반환
				String[] strArray = str.split("/");
				
				//타입변환
				int no = Integer.parseInt(strArray[0]);
				String title = strArray[1];
				String author = strArray[2];
				boolean isRent = Boolean.parseBoolean(strArray[3]);
				Book book = new Book(no, title, author, isRent);
				System.out.println("책정보 출력");
				System.out.println(book.toString());
				
//		split테스트
				int i = 0;
				for(String s : strArray) {
					System.out.println("방번호 : " + i + "  값 : " + s);
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
		// 파일을 읽어서 책리스트를 생성
		public void fileRead() {
			
			try (BufferedReader bf = BufferedReader(new FileReader("booklist.txt"));){
				String str = "";
				List<Book> list = new ArrayList<>();
				while((str = bf.readLine()) != null){
					// 공백으로 끊어서 배열에 담습니다.
					String[] strArray = str.split(" ");
					// 책을 생성
					
					list.add(new Book(Integer.parseInt(strArray[0]), strArray[1], strArray[2], Boolean.parseBoolean(strArray[3])));
				}
				System.out.println("생성된 리스트 출력");
				for(Book book : list) {
					System.out.println(list.toString());
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
			
			String str = "1 제목1 작가1 false";
			//구분자로 끊어서 배열로 반환
			//{1, 타이틀1, 작가1, false}
			String[] strArry = str.split(" ");
			//new Book(strArry[0], "제목1", "작가1", false);
			new Book(Integer.parseInt(strArry[0]), strArry[1], strArry[2], Boolean.parseBoolean(strArry[3]));
		}
		
		private BufferedReader BufferedReader(FileReader fileReader) {
			// TODO Auto-generated method stub
			return null;
		}
		// 리스트에 담겨있던 책의 정보를 출력
		public void fileSave() {
			//데이터 생성
			List<Book> list = new ArrayList<>();
			list.add(new Book(1, "제목1", "작가1", false));
			list.add(new Book(2, "제목2", "작가2", false));
			list.add(new Book(3, "제목3", "작가3", false));

			//파일출력
			try (BufferedWriter bw = new BufferedWriter(new FileWriter("booklist.txt"));) {
				for(Book book : list) {
					bw.write(book.toString());
					bw.newLine();
				}
				bw.flush();
				
				System.out.println("파일출력 완료");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

		
