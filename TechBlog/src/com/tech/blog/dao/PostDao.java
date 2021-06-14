package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tech.blog.entities.Category;
import com.tech.blog.entities.Posts;
import com.tech.blog.helper.DBConnection;

public class PostDao {

	private Connection con = DBConnection.getmeconnect();
	
	
	public ArrayList<Category> getAllCategory(){
		ArrayList<Category> arr = new ArrayList<>();
		try {
			String query = "Select * from categories";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				String desc = rs.getString("description");
				Category c = new Category(cid,cname,desc);
				arr.add(c);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return arr;
		
	}
	
	public boolean savePost(Posts p) {
		boolean f = false;
		try {
			String query = "insert into posts (pTitle,pContent,pCode,pPic,catId,UserId) values (?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, p.getpTitle());
			pst.setString(2, p.getpContent());
			pst.setString(3, p.getpCode());
			pst.setString(4, p.getpPic());
			pst.setInt(5, p.getCid());
			pst.setInt(6, p.getUserId());
			pst.executeUpdate();
			f = true;
			}catch(Exception ex) {
			ex.printStackTrace();
		}
		return f;
		
	}
	
	public List<Posts> getallposts() {
		List<Posts> list = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement("select * from posts order by pid desc");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int pid = rs.getInt("pid");
				String ptitle = rs.getString("pTitle");
				String pContent = rs.getString("pContent");
				String pcode = rs.getString("pCode");
				String pPic = rs.getString("pPic");
				Timestamp pDate = rs.getTimestamp("pDate");
				int catid = rs.getInt("catId");
				int userid = rs.getInt("UserId");
				
				Posts p = new Posts(pid,ptitle,pContent,pcode,pPic,pDate,catid,userid);
				list.add(p);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return list;
		
	}
	public List<Posts> getallpostsbyCategory(int catId) {
		List<Posts> list = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement("select * from posts where catId = ?");
			pst.setInt(1, catId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int pid = rs.getInt("pid");
				String ptitle = rs.getString("pTitle");
				String pContent = rs.getString("pContent");
				String pcode = rs.getString("pCode");
				String pPic = rs.getString("pPic");
				Timestamp pDate = rs.getTimestamp("pDate");
				int catid = rs.getInt("catId");
				int userid = rs.getInt("UserId");
				
				Posts p = new Posts(pid,ptitle,pContent,pcode,pPic,pDate,catid,userid);
				list.add(p);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return list;
		
	}	
	
		public Posts getpostbypostId(int postid) {
			Posts posts = null;
			try {
			String query = "select * from posts where pid = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, postid);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				int pid = rs.getInt("pid");
				String ptitle = rs.getString("pTitle");
				String pContent = rs.getString("pContent");
				String pcode = rs.getString("pCode");
				String pPic = rs.getString("pPic");
				Timestamp pDate = rs.getTimestamp("pDate");
				int catid = rs.getInt("catId");
				int userid = rs.getInt("UserId");
				
				posts = new Posts(pid,ptitle,pContent,pcode,pPic,pDate,catid,userid);
				
			}
			
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			return posts;
			
		}
}
