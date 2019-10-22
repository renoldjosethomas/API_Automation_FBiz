package flobiz.servicecontracts;

public class CreateIssueModel {
	
	private String description;
	private String fromEmail;
	private String title;

    public String getDescription() { return this.description; }
    
    public String setDescription(String description) { this.description = description; return description; }
    
    public String getEmail() { return this.fromEmail; }
    
    public String setEmail(String fromEmail) { this.fromEmail = fromEmail; return fromEmail; }
    
    public String getTitle() { return this.title; }
    
    public String setTitle(String title) { this.title = title; return title; }
    
    @Override
    public String toString() {
        return "{description=" + description + ", fromemail=" + fromEmail + ", title=" + title + "}"; }
}