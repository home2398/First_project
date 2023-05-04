package First_project;

public class MainDTO {

	private String id;
	private String pw;
	private String date;
	private int score;
	private int rownum;

	public int getRownum() {
		return rownum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public MainDTO(String id, String pw) {
		this.id = id;
		this.pw = pw;

	}
	public MainDTO(String id, int score) {
		this.id = id;
		this.score = score;

	}
	public MainDTO(String id, int score, String date) {
		this.id = id;
		this.score = score;
		this.date = date;

	}

	public MainDTO(int rownum, String id, int score) {
		this.rownum = rownum;
		this.id = id;
		this.score = score;
	}
// ========================================= [2] GAME 부분 ==========================================

	public MainDTO(int score, String date, String id) {
		this.score = score;
		this.date = date;
		this.id = id;

	}

}
