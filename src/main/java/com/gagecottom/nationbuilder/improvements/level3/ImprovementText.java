package com.gagecottom.nationbuilder.improvements.level3;

public class ImprovementText {
	private String text;
	private String link;
	private String generate;
	public ImprovementText() {
		
	}
	public ImprovementText(String text, String link, String generate) {
		this.text=text;
		this.link=link;
		this.generate=generate;
	}
	
	public String getGenerate() {
		return generate;
	}
	public void setGenerate(String generate) {
		this.generate = generate;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
}
