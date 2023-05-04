package First_project;

public class ScoreDTO {

	private int score;
	private String id;
	private String date;

	public ScoreDTO(int score, String id, String date) {
		super();
		this.score = score;
		this.id = id;
		this.date = date;
	}

	public ScoreDTO(String id, int score) {
		this.score = score;
		this.id = id;
	}

	public ScoreDTO(int score, String id) {
		this.id = id;
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
