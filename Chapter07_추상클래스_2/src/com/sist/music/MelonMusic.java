package com.sist.music;

import java.io.FileReader;

public class MelonMusic extends MusicSystem{

	@Override
	public void init() {
		try {
			FileReader fr=new FileReader("C:\\javaDev\\melon.txt");
			StringBuffer sb=new StringBuffer();
			int i=0;
			while((i=fr.read())!=-1) { // EOF
				sb.append((char)i);
			}
			fr.close();
			// Buffer => 임시 기억장소 => 누적
			String data=sb.toString();
			//String은 문자에 제한이 없다 
			String[] mdata=data.split("\n"); // 한 줄씩 저장하겠다는 뜻 
			i=0;
			for(String s:mdata) {
				//System.out.println(s);
				if(i>50) break;
				
				musics[i]=new Music();
				String[] temp=s.split("\\|"); // 정규식 => ^ $ . ?  | + * (//붙여서 써야한다)
				musics[i].setMno(temp[0]);
				musics[i].setTitle(temp[1]);
				musics[i].setSinger(temp[2]);;
				musics[i].setAlbum(temp[3]);
				musics[i].setPoster(temp[4]);
				i++;
			}
		}catch(Exception ex) {}
	}
}
