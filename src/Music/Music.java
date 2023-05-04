package Music;

public class Music {

	private String name;
	private String artist;
	private int playtime;
	private String path;

	public Music(String path) {

		this.path = path;
	}

	public Music(String name, String artist, int playtime) {
		super();
		this.name = name;
		this.artist = artist;
		this.playtime = playtime;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setPlaytime(int playtime) {
		this.playtime = playtime;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public String getArtist() {
		return artist;
	}

	public int getPlaytime() {
		return playtime;
	}

	public String getPath() {
		return path;
	}

}
