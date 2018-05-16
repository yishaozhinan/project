package cn.jxufe.domain;

public class Literature {
	private Integer id;
	private String literatureName;
	private String author;
	private String abstractText;
	private String publish;
	private String publishTime;
	private String useNumber;
	private Integer favoriteNumber;
	@Override
	public String toString() {
		return "User [id=" + id + ", literatureName="
				+ literatureName +",author=" + author + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLiteratureName() {
		return literatureName;
	}
	public void setLiteratureName(String literatureName) {
		this.literatureName = literatureName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAbstractText() {
		return abstractText;
	}
	public void setAbstractText(String abstractText) {
		this.abstractText = abstractText;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public String getUseNumber() {
		return useNumber;
	}
	public void setUseNumber(String useNumber) {
		this.useNumber = useNumber;
	}
	public Integer getFavoriteNumber() {
		return favoriteNumber;
	}
	public void setFavoriteNumber(Integer favoriteNumber) {
		this.favoriteNumber = favoriteNumber;
	}
	
	
	
}

