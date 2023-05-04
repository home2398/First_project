package Music;

import java.util.Scanner;

import javazoom.jl.player.MP3Player;

public class MusicMain2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isPlay = true;

		MusicPlayer mPlayer = new MusicPlayer();

		// 노래르 재생시켜 주는 라이브러리
		MP3Player mp3 = new MP3Player();

		System.out.println("======[ 음악 재생]======");

		while (isPlay) {
			System.out.print("[1]재생 [2]중지  [3]이전곡  [4] 다음곡 [5] 종료 : >");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				System.out.println(mPlayer.play());
				mp3.play(mPlayer.play().getPath());
				break;

			case 2:

				System.out.println(mPlayer.stop());
				mp3.stop();
				break;

			case 3:
				Music m = mPlayer.prePlay();
				if (m == null) {
					System.out.println("이전곡을 재생할 수 없습니다.");
				} else {
					System.out.println(m);
				}

				break;

			case 4:
				m = mPlayer.nextPlay();
				if (m == null) {
					System.out.println("다음곡을 재생할 수 없습니다.");
				} else {
					System.out.println(m);
				}
				break;

			case 5:
				System.out.println("프로그램이 종료되었습니다.");
				isPlay = false;
				break;

			default:
				System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
				break;
			}
		}

	}
}
