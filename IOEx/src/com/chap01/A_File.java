package com.chap01;

import java.io.File;
import java.io.IOException;

public class A_File {
	public static void main(String[] args) {
		//객체 생성
		A_File a = new A_File();
		// 메소드 실행 : 래퍼런스변수에 주소접근연산자(.)를 이용!
		//a.method1();
		a.method2();
	}
	
	public void method2() {
		File file = new File("d:/test/test.txt");
		File dir = new File("d:/test");
		try {
			//디렉토리 만들기
			dir.mkdir();    // => 경로 내 한개의 디렉토리 생성
			//dir.mkdirs();    => 경로 내 디렉토리가 여러개 생성되어야 할 경우
			
			//파일 생성
			file.createNewFile();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public void method1() {
		// 경로를 지정하지 않으면 현재 프로젝트 폴더에 파일을 생성합니다.
		// 메모리 상에만 존재(File)
		File file = new File("test.txt");
		
		System.out.println("파일명 : " + file.getName());
		System.out.println("절대 경로 : " + file.getAbsolutePath());
		System.out.println("상대 경로 : " + file.getPath());
		System.out.println("파일 용량 : " + file.length());
		System.out.println("파일 존재 여부 : " + file.exists());
		
		
		// 실제 파일 생성
		try {
			file.createNewFile();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		System.out.println("파일존재 여부 : " + file.exists());
	}
}
