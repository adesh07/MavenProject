package in.co.rays.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import in.co.rays.bean.UserBean;
import in.co.rays.util.JdbcDataSource;

public class UserModel {

	public void add(UserBean bean) throws Exception {
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("insert into person values(?,?,?,?,?,?)");
		ps.setInt(1, nextPk());
		ps.setString(2, bean.getFirstName());
		ps.setString(3, bean.getLastName());
		ps.setString(4, bean.getLoginId());
		ps.setString(5, bean.getPassword());
		ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		int i = ps.executeUpdate();
		System.out.println("Data inserted : " + i);
		conn.close();
	}

	public void update(UserBean bean) throws Exception {
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn
				.prepareStatement("update person set firstName=?, lastName=?, loginId=?, password=?, dob=? where id=?");
		ps.setString(1, bean.getFirstName());
		ps.setString(2, bean.getLastName());
		ps.setString(3, bean.getLoginId());
		ps.setString(4, bean.getPassword());
		ps.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		ps.setInt(6, bean.getId());
		int i = ps.executeUpdate();
		System.out.println("Data Updated : " + i);
		conn.close();
	}

	public Integer nextPk() throws Exception {
		int pk = 0;
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select max(id) from person");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;
	}

	public List search() throws Exception {
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from person");
		ResultSet rs = ps.executeQuery();
		ArrayList list = new ArrayList();
		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			list.add(bean);
		}
		return list;
	}

	public void delete(int id) throws Exception {
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement stmt = conn.prepareStatement("delete from person where id = ?");
		stmt.setInt(1, id);
		int i = stmt.executeUpdate();
		conn.close();
		System.out.println("Data Deleted : " + i);
	}

	public UserBean findByPk(int id) throws Exception {
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from person where id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
		}
		return bean;
	}

	public UserBean authenticate(String loginId, String password) throws Exception {
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from person where loginId = ? and password = ?");
		ps.setString(1, loginId);
		ps.setString(2, password);
		ResultSet rSet = ps.executeQuery();
		UserBean bean = null;
		while (rSet.next()) {
			bean = new UserBean();
			bean.setId(rSet.getInt(1));
			bean.setFirstName(rSet.getString(2));
			bean.setLastName(rSet.getString(3));
			bean.setLoginId(rSet.getString(4));
			bean.setPassword(rSet.getString(5));
			bean.setDob(rSet.getDate(6));
		}
		return bean;
	}

}
