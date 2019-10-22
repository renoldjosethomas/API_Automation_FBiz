package flobiz.servicecontracts;

public class ModifyIssueModel {
	
	private String title;
    
    public String getTitle() { return this.title; }
    
    public String setTitle(String title) { this.title = title; return title; }
    
    @Override
    public String toString() { return "{title=" + title + "}"; }
}