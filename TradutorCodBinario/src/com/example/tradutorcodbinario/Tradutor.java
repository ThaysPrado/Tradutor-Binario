package com.example.tradutorcodbinario;

public class Tradutor {
	
public char asc[];
	
	public Tradutor(){
		asc = new char[226];
		int x = 31; int y = 0;
		while(y < 226){
			asc[y]=(char)x;
			x++; y++;
		} 
	}
	
	public String code(String txt){
		String word = ""; 
		int comp = txt.length();
		int w = 0;
		int z = 0;
		while (z < comp){
			for(int i = 0; i < 226; i++){
				if(txt.charAt(z)==asc[i]){
					String letra = Integer.toBinaryString(asc[i]);
					w = Integer.parseInt(letra);
					letra = String.format("%08d", w);
					word = word + " " + letra;
				}	
			}
			z++;
		}
		
		return word;
	}
	
	public String decode(String txt){
		String text = "";
		String[]values = txt.split(" "); 
		int i = 0;
		while(i<values.length){
				int a = Integer.parseInt(values[i], 2);
				char c = ((char)a);
				text = text + c;
				i++;
		}
		return text;
	}
	
}
