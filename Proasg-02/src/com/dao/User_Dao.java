package com.dao;

import com.info.Data_Connect;
import com.info.User;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class User_Dao {
    
	Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    // Get photo from database
    private String getBasephoto(Blob blob) throws SQLException, IOException {
        
    	InputStream inputStream = blob.getBinaryStream();
        ByteArrayOutputStream byteAOS = new ByteArrayOutputStream();
        
        byte[] buffer = new byte[4096];
        int bytesRead = -1;

        while ((bytesRead = inputStream.read(buffer)) != -1) 
        {
            byteAOS.write(buffer, 0, bytesRead);
        }
        
        byte[] photoBytes = byteAOS.toByteArray();

        return Base64.getEncoder().encodeToString(photoBytes);
    }

    // Get User querry
    private User queryGetUser(String query) {
        User user = new User();
        try 
        {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            conn = new Data_Connect().getConnection();
            psmt = conn.prepareStatement(query);
            rs = psmt.executeQuery();
            
            if (rs.next()) 
            {
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setUsername(rs.getString(4));
                user.setPassword(rs.getString(5));
                user.setContactno(rs.getString(6));
                

                // Get photo from database.
                if (rs.getBlob(7) == null) 
                {
                    user.setBasephoto(null);
                } 
                else 
                {
                    user.setBasephoto(getBasephoto(rs.getBlob(7)));
                }

                return user;
            }
        } 
        catch (ClassNotFoundException | SQLException | IOException e) 
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static Connection getConnection(){  
    	
        Connection con=null;  
        try
        {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/asignment2", "root", "root");  
        }
        catch(Exception e)
        {System.out.println(e);}  
        	return con;  
    }  
    
    // get user byId
    public static User getUserById(int id){  
        User e=new User();  
          
        try{  
            Connection conn= User_Dao.getConnection();  
            PreparedStatement ps=conn.prepareStatement("select * from userdata where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setEmail(rs.getString(3));
                e.setPhoto(rs.getBytes(4));
                // how to get file name?
            }  
            conn.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    
    // Get user Id.
    public User getUser(int userdataId) 
    {
        String query = "SELECT * FROM userdata WHERE id = " + userdataId;
        return queryGetUser(query);
    }

    // Check login
    public User checkLoginUser(String username, String password) 
    {
        String query = "SELECT * FROM userdata WHERE username = '" + username + "' AND password = '" + password + "'";
        return queryGetUser(query);
    }

    // Check username is exist?
    public boolean checkUsernameExists(String username) 
    {
        String query = "SELECT * FROM userdata WHERE username = '" + username + "'";
        return (queryGetUser(query) != null);
    }

    // Create an user account.
    public void createUserAccount(String name, String email, String username, String password, String contactno, InputStream photo) 
    {
        String query = "INSERT INTO userdata (name, email, username, password, contactno, photo) VALUES (?, ?, ?, ?, ?, ?)";
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = new Data_Connect().getConnection();
            psmt = conn.prepareStatement(query);
            
            psmt.setString(1, name);
            psmt.setString(2, email);
            psmt.setString(3, username);
            psmt.setString(4, password);
            psmt.setString(5, contactno);
            psmt.setBinaryStream(6, photo);
            
            psmt.executeUpdate();
            
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }

    // Edit profile.
    public void editProfileInformation(int userdataId, String name, String username, String password, String email, String contactno, InputStream photo, InputStream file, String comment) {
        String query = "UPDATE userdata SET " +
                "name = ?, " +
                "email = ?, " +
                "username = ?, " +
                "password = ?, " +
                "contactno = ?, " +
                "photo = ?, " +
                "file = ?, " +
                "comment = ?" +
                "WHERE id = ?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = new Data_Connect().getConnection();
            psmt = conn.prepareStatement(query);
            
            psmt.setString(1, name);
            psmt.setString(2, email);
            psmt.setString(3, username);
            psmt.setString(4, password);
            psmt.setString(5, contactno);
            psmt.setBinaryStream(6, photo);
            psmt.setBinaryStream(7, file);
            psmt.setString(8, comment);
            psmt.setInt(9, userdataId);
            
            psmt.executeUpdate();
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            System.out.println("Update profile catch: " + e.getMessage());
        }
    }
    
    // Delete user from admin
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection conn = User_Dao.getConnection();  
            PreparedStatement ps=conn.prepareStatement("delete from userdata where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            conn.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  

    // Update profil
    public void updateProfileInformation(int userdataId, InputStream file, String comment) {
        String query = "UPDATE userdata SET " +
        		"file = ?, " +
                "comment = ?" +
                "WHERE id = ?";
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = new Data_Connect().getConnection();
            psmt = conn.prepareStatement(query);
            
            psmt.setBinaryStream(1, file);
            psmt.setString(2, comment);
            psmt.setInt(3, userdataId);
            
            psmt.executeUpdate();
            
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            System.out.println("Update profile catch: " + e.getMessage());
        }
    }
    
    // Get all user data in admin
    public static List<User> getAllUsers(){  
        List<User> list = new ArrayList<User>();  
          
        try{  
            Connection conn = User_Dao.getConnection();  
            PreparedStatement ps=conn.prepareStatement("select * from userdata");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                User e=new User();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setEmail(rs.getString(3));
                e.setUsername(rs.getString(4));
                e.setContactno(rs.getString(6));
                list.add(e);  
            }  
            conn.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }
    
    public static User getEmployeeById(int id){  
        User e=new User();  
          
        try{  
            Connection con=User_Dao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from userdata where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setEmail(rs.getString(3));
                e.setUsername(rs.getString(4));
                e.setContactno(rs.getString(5));
                
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    
    public static List<User> getAllUserDatas(){  
        List<User> list = new ArrayList<User>();  
          
        try{  
            Connection conn = User_Dao.getConnection();  
            PreparedStatement ps=conn.prepareStatement("select * from userdata2");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                User e=new User();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setEmail(rs.getString(3));
                e.setFilename(rs.getString(4));
            
                list.add(e);  
            }  
            conn.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }
    
    public static User getUsersBySId(int id){  
        User e=new User();  
          
        try{  
            Connection con=User_Dao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from userdata2 where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setEmail(rs.getString(3));
                e.setFilename(rs.getString(4));
                
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
}