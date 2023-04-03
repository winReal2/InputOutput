package com.chap01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileByteStreamEx {
	//작동되는 순서 알기 (FileInputStream > read > FileOutputStream > flush
	public static void main(String[] args) {
		FileByteStreamEx ex = new FileByteStreamEx();
		
		ex.fileSave();
	}
	public void fileRead() {
		// 사용한 자원을 닫아주기 위해서 상단에 선언합니다.
		FileInputStream fis = null;
		try {
			fis =new FileInputStream("a_byte.dat");
			/*
			 * 파일로부터 데이터를 읽어올 때는 read() 메소드를 사용
			 * 하지만 실제로 파일에는 얼마만큼의 데이터가 있는지 모른다
			 * read()메소드는 더 이상 읽어올 데이터가 없으면 -1을 리턴
			 * 따라서 반복문을 사용해서 read() 메소드에서 -1이 리턴되기 전까지
			 * 데이터를 읽어오면 된다.
			 */
			int value = 0;
			// value = fis.read();
			// System.out.println(value);
			
			// 데이터를 읽어서 value 변수에 저장
			// -1 : 문장의 끝
			//while((value=fis.read()) != -1) {
			//	System.out.println((char)value);
			//}
			
			while(true) {
				value = fis.read();
				if(value == -1) {
					break;
				}
				System.out.println((char)value);
			}
			
		}	catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}	catch (IOException e) {
				System.out.println(e.getMessage()); 
		}	finally {
			}
	}
	
	
	public void fileSave() {
		FileOutputStream fos = null;
		System.out.println("파일 저장 실행");
		try {
			// 프로젝트 내부에 파일이 생성
			fos = new FileOutputStream("a_byte.dat");
			fos.write(97);  // a 저장
			fos.write('b'); // b 저장
			fos.write(10);
			// fos.write('한');
			
			byte[] byteArry = {'a', 'b', 'c', 'd'};
			fos.write(byteArry);
			fos.write(10);
			fos.write(byteArry, 1, 2);  //(배열, 시작index, 개수)
			
			fos.flush();			
			//버퍼라는 공간에 저장만 되어있을 뿐 파일에 저장되지 않은 상태애서
			//fos.flush(); 하면 파일에 저장됨
			
			
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			//사용중인 자원이 있다면 종료시켜줍니다
				try {
					fos.close();    //스트림을 이용했으면 닫아주어야 합니다.
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				
			}
		}
	}
}
