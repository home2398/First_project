package First_project;

public class GameDTO {

	private int seq;
	private String title;
	private String answer;
	private String info;
	private int num;
	private String under;

	public GameDTO(int seq, String title, String answer, String info, int num, String under) {
		this.seq = seq;
		this.title = title;
		this.answer = answer;
		this.info = info;
		this.num = num;
		this.under = under;
	}

	public GameDTO(int seq) {
		this.seq = seq;
	}

	public int getSeq() {
		return seq;
	}

	public String getAnswer() {
		return answer;
	}

	public String getInfo() {
		return info;
	}

	public int getNum() {
		return num;
	}

	public String getUnder() {
		return under;
	}

	public GameDTO(String under) {
		this.under = under;

	}

	public GameDTO(String title, String info) {
		this.title = title;
		this.info = info;
	}

	public GameDTO(String answer, int seq) {
		this.answer =answer;
		this.seq = seq;
		
	}

	public String getTitle() {
		return title;
	}




}
