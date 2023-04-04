package com.chap02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIO {
	public static void main(String[] args) {
		FileIO io = new FileIO();
		io.fileIOCopy();
	}
	/**
	 * 파일 복사하기
	 * 
	 * A_File.java 파일을 읽어서
	 *  A_File_Copy.java 파일을 생성합니다. 
	 */
	
	public void fileIOCopy() {  
		
		long startTime, endTime;
		startTime = System.currentTimeMillis();
		
		//파일생성, 유리한점 : 파일이 존재유무 파악할 수 있음
		File file = new File("C:\\Users\\user\\git\\InputOutput\\IOEx\\src\\com\\chap01\\A_File.java");     
		// 파일의 존재여부를 확인 후 존재하지 않으면 종료
		if(!file.exists()) {
			System.out.print("파일이 존재하지 않습니다.");
			return;
		}      
		
		try (FileInputStream fis = new FileInputStream(file);
				FileOutputStream fos = new FileOutputStream("A_File_Copy.java")){
			int value = 0;
			//.read를 하게되면 1바이트씩 읽어옴.
			// -1 은 파일의 끝을 의미 (EndOfFile)
			int i = 0;
			byte[] byteArr = new byte[100];   //i = 바이트 배열에 읽어온 개수를 반환!
			while( (i = fis.read(byteArr)) != -1) {
				// 읽어온 개수만큼 출력!
				// 마지막에 출력할 때 배열의 개수를 채우지 못하면 이전에 읽어들인 내용이 출력
				fos.write(byteArr, 0,i);       
			}
//			while( (value = fis.read()) != -1) {
//				//System.out.print((char)value);
//				fos.write(value);
//			}
			
			fos.flush();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     //파일 읽어오는 것 
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		   endTime = System.currentTimeMillis();
		   System.out.println("소요시간 : " + (endTime-startTime));
	} 

	/**
	 * 복사하기 - 복사할 파일을 준비
	 * FileInputStream으로 열어서 FileOutputStream으로 저장할거임
	 * 결론적으로 파일 복사할거임
	 */
		public void fileCopy() {
			System.out.println("복사");
			try (
					FileInputStream fis = new FileInputStream("14_2_보조스트림.pptx");
					FileOutputStream fos = new FileOutputStream("14_2_보조스트림_copy.pptx");
					){
				int value = 0; 
				while((value = fis.read()) != -1) {
					fos.write(value);
				}
				fos.flush();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			}
			
		}
