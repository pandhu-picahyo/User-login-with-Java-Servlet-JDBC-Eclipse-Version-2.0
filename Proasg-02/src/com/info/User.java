package com.info;

public class User {
    
	private int id;
	private String name; 
	private String email;
	private String username;
	private String password;
	private String contactno;
	private String comment;
	private String filename;
	
    private byte[] photo;
    private String basephoto;
    
    private byte[] file;
    private String basefile;

    public User() {

    }

    public User(int id, String name, String email, String username, String password, String contactno, String basephoto, String basefile, String comment, String filename) {
        
    	this.id = id;
    	this.name = name; 
    	this.email = email;
    	this.username = username;
    	this.password = password;
    	this.contactno = contactno;
        this.basephoto = basephoto;
        this.basefile = basefile;
        this.comment = comment;
        this.filename = filename;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getName()
    {
    	return name;
    }
    
    public void setName(String name)
    {
    	this.name = name;
    }
    
    public String getEmail()
    {
    	return email;
    }
    
    public void setEmail(String email)
    {
    	this.email = email;
    }
    
    public String getUsername() 
    {
        return username;
    }

    public void setUsername(String username) 
    {
        this.username = username;
    }
    
    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }
    
    public String getContactno() 
    {
        return contactno;
    }

    public void setContactno(String contactno) 
    {
        this.contactno = contactno;
    }

    public byte[] getPhoto() 
    {
        return photo;
    }

    public void setPhoto(byte[] photo) 
    {
        this.photo = photo;
    }

    public String getBasephoto() 
    {
        return basephoto;
    }

    public void setBasephoto(String basephoto) 
    {
        this.basephoto = basephoto;
    }
    
    public byte[] getFile() 
    {
        return file;
    }

    public void setFile(byte[] file) 
    {
        this.file = file;
    }

    public String getBasefile() 
    {
        return basefile;
    }

    public void setBasefile(String basefile) 
    {
        this.basefile = basefile;
    }

    public String getComment() 
    {
        return comment;
    }

    public void setComment(String comment) 
    {
        this.comment = comment;
    }
    
    public String getFilename() 
    {
        return filename;
    }

    public void setFilename(String filename) 
    {
        this.filename = filename;
    }
}