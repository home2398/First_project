package Music;

import java.util.ArrayList;

public class MusicPlayer {

	ArrayList<Music> musiclist;

	public MusicPlayer() {
		musiclist = new ArrayList<Music>();
		musiclist.add(new Music("music/오르트구름-윤하.mp3"));
		musiclist.add(new Music("music/삐삐_아이유.mp3"));
		musiclist.add(new Music("music/aespa-02-Savage.mp3"));
		musiclist.add(new Music("아이유-03-좋은 날.mp3"));
		musiclist.add(new Music("잔나비-08-주저하는 연인들을 위해.mp3"));
	}

	int pos;

	// 반환을 musiclist로 반환함 > 출력 자료형을 맞춰줌
	public Music play() {
		return musiclist.get(pos);

	}

	public String stop() {
		return "노래를 중지합니다.";
	}

	public Music prePlay() {
		if (pos == 0) {
			return null;
		} else {
			pos--;
			return musiclist.get(pos);
		}

	}

	public Music nextPlay() {
		if (pos == musiclist.size() - 1) {
			return null;
		} else {
			pos++;
			return musiclist.get(pos);
		}
	}
}
