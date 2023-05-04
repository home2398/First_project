package First_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import First_project.MainDTO;
import First_project.GameDTO;

public class MainDAO {

//========================================= [1] INTRO 부분 ==========================================

	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement psmt = null;

	private void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "cgi_2_0306_1";
			String password = "smhrd1";
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getClose() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 회원가입
	public int Join(MainDTO dto) {
		int row = 0;
		try {
			getConn();
			String sql = "insert into user_info(user_id,user_pw) values(?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			row = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return row;
	}

	// login
	public String login(MainDTO dto) {
		String uName = null;
		int row = 0;
		try {
			getConn();
			String sql = "select * from user_info where user_id = ? and user_pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			rs = psmt.executeQuery();
			if (rs.next() == true) {
				uName = rs.getString("user_id");
				System.out.println(uName + "님 환영합니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

		return uName;
	}

	// 랭킹 조회
	public ArrayList<MainDTO> rank() {
		MainDTO dto = null;
		ArrayList<MainDTO> list = new ArrayList<MainDTO>();
		try {
			getConn();
			String sql = "SELECT ROWNUM, A.user_id, A.score FROM (SELECT user_id, score FROM score ORDER BY score DESC) A";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next() == true) {// 몇등인지가 안나옴
				int rownum = rs.getInt("rownum");
				String id = rs.getString("user_id");
				int score = rs.getInt("score");
				dto = new MainDTO(rownum, id, score);
				list.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return list;
	}

//========================================= [2] GAME 부분 ==========================================

	private Connection conn1 = null;
	private PreparedStatement psmt1 = null;
	private ResultSet rs1 = null;

	private void getConn1() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "cgi_2_0306_1";
			String password = "smhrd1";
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void getClose1() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 곡 설명
	public GameDTO musicInfo(GameDTO dto) {
		GameDTO dto2 = null;
		String title = null;
		String info = null;
		try {
			getConn();
			String sql = "SELECT * FROM MUSIC WHERE MUSIC_SEQ=?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getSeq());
			rs = psmt.executeQuery();

			if (rs.next() == true) {

				title = rs.getString("MUSIC_TITLE");
				info = rs.getString("MUSIC_INFO");

				dto2 = new GameDTO(title, info);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();

		}
		return dto2;

	}

	// F_R_205 글자 수 공개
	public int musicNum(GameDTO dto) {
		int Mnum = 0;
		try {
			getConn();
			String sql = "SELECT * FROM MUSIC WHERE MUSIC_SEQ=?";

			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getSeq());

			rs = psmt.executeQuery();
			if (rs.next() == true) {
				Mnum = rs.getInt("MUSIC_NUM");
			}
		} catch (Exception e) {
		} finally {
			getClose();
		}

		return Mnum;
	}

	// F_R_301 정답 여부 확인
	public boolean answerCheck(GameDTO dto1) {

		boolean check = false;

		try {
			getConn();
			String sql = "SELECT * FROM MUSIC WHERE MUSIC_ANSWER=? and music_seq=?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto1.getAnswer());
			psmt.setInt(2, dto1.getSeq());
			// psmt.setInt(1, dto1.getSeq());
			rs = psmt.executeQuery();

			if (rs.next() == true) {
				check = true;
			}

		} catch (Exception e) {
		} finally {
			getClose();
		}

		return check;
	}

	// 정답확인
	public String answer(GameDTO dto) {
		String answer = null;
		try {
			getConn();
			String Spl = "select music_answer from music where music_seq=?";
			psmt = conn.prepareStatement(Spl);
			psmt.setInt(1, dto.getSeq());
			rs = psmt.executeQuery();
			if (rs.next() == true) {
				answer = rs.getString("MUSIC_ANSWER");
			}
		} catch (Exception e) {
		} finally {
			getClose();
		}

		return answer;
	}

	// 힌트 언더바
	public String hintUnder(GameDTO dto) {
		String under = null;

		getConn();
		String sql = "select * from music where music_seq = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getSeq());
			rs = psmt.executeQuery();
			if (rs.next() == true) {
				under = rs.getString("music_under");
			}

		} catch (Exception e) {
		} finally {
			getClose();
		}
		return under;
	}

	// 힌트 한 글자
	public String hintCheck(GameDTO dto) {

		String str = null;

		try {
			getConn();
			String sql = "SELECT * FROM MUSIC WHERE MUSIC_SEQ = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getSeq());
			rs = psmt.executeQuery();

			if (rs.next() == true) {

				str = rs.getString("MUSIC_ANSWER");

			}
		} catch (Exception e) {
		} finally {
			getClose();
		}

		return str;
	}

	// 점수 저장
	public int score(MainDTO dto) {
		int row = 0;
		try {
			getConn();
			String sql = "insert into score(user_id,score,s_date) values(?,?,sysdate)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setInt(2, dto.getScore());
			row = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return row;

	}

}
