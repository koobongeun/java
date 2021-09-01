package kingkoo.brd00;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Date;

public class ArticleVO {
	private int level;
	private int articleNO1;
	private int parentNO1;
	private String title1;
	private String content1;
	private String imageFileName1;
	private String id;
	private Date writedate1;
	
	public ArticleVO() {
		
	}


	public ArticleVO(int level, int articleNO1, int parentNO1, String title1, String content1, String imageFileName1,
			String id) {
		super();
		this.level = level;
		this.articleNO1 = articleNO1;
		this.parentNO1 = parentNO1;
		this.title1 = title1;
		this.content1 = content1;
		this.imageFileName1 = imageFileName1;
		this.id = id;
	}




	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public int getarticleNO1() {
		return articleNO1;
	}


	public void setarticleNO1(int articleNO1) {
		this.articleNO1 = articleNO1;
	}


	public int getparentNO1() {
		return parentNO1;
	}


	public void setparentNO1(int parentNO1) {
		this.parentNO1 = parentNO1;
	}


	public String gettitle1() {
		return title1;
	}


	public void settitle1(String title1) {
		this.title1 = title1;
	}


	public String getcontent1() {
		return content1;
	}


	public void setcontent1(String content1) {
		this.content1 = content1;
	}
	
	public String getimageFileName1() {
		try {
			if (imageFileName1 != null && imageFileName1.length() != 0) {
				imageFileName1 = URLDecoder.decode(imageFileName1, "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return imageFileName1;
	}

	public void setimageFileName1(String imageFileName1) {
		try {
			if(imageFileName1!=null && imageFileName1.length()!=0) {
				this.imageFileName1 = URLEncoder.encode(imageFileName1, "UTF-8");  //파일이름에 특수문자가 있을 경우 인코딩합니다.
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Date getWriteDate1() {
		return writedate1;
	}


	public void setWriteDate1(Date writedate1) {
		this.writedate1 = writedate1;
	}
	
	
	
	
	

}
