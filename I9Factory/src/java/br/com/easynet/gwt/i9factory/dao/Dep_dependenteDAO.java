package br.com.easynet.gwt.i9factory.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

public class Dep_dependenteDAO extends ObjectDAO { 
	 public Dep_dependenteDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Dep_dependenteT dep_dependenteT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into factory.dep_dependente  ( cli_nr_id, dep_tx_nome, dep_dt_nascimento, dep_tx_grauparentesco) values ( ? , ? , ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, dep_dependenteT.getCli_nr_id());
			 pStmt.setObject(2, dep_dependenteT.getDep_tx_nome());
		 java.sql.Date dt3= new java.sql.Date(dep_dependenteT.getDep_dt_nascimento().getTime());
			 pStmt.setObject(3, dt3);
			 pStmt.setObject(4, dep_dependenteT.getDep_tx_grauparentesco());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Dep_dependenteT dep_dependenteT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update factory.dep_dependente set  dep_tx_nome=?, dep_dt_nascimento=?, dep_tx_grauparentesco=?  where  dep_nr_id=? and cli_nr_id=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, dep_dependenteT.getDep_tx_nome());
		 java.sql.Date dt2= new java.sql.Date(dep_dependenteT.getDep_dt_nascimento().getTime());
			 pStmt.setObject(2, dt2);
			 pStmt.setObject(3, dep_dependenteT.getDep_tx_grauparentesco());
			 pStmt.setObject(4, dep_dependenteT.getDep_nr_id());
			 pStmt.setObject(5, dep_dependenteT.getCli_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Dep_dependenteT dep_dependenteT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from factory.dep_dependente where  dep_nr_id=? and cli_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, dep_dependenteT.getDep_nr_id());
			 pStmt.setObject(2, dep_dependenteT.getCli_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Dep_dependenteT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Dep_dependenteT> objs = new Vector();
		 while (rs.next()) { 
 			 Dep_dependenteT dep_dependenteT = new Dep_dependenteT();
			 dep_dependenteT.setDep_nr_id(rs.getInt("dep_nr_id"));
			 dep_dependenteT.setCli_nr_id(rs.getInt("cli_nr_id"));
			 dep_dependenteT.setDep_tx_nome(rs.getString("dep_tx_nome"));
			 dep_dependenteT.setDep_dt_nascimento(rs.getDate("dep_dt_nascimento"));
			 dep_dependenteT.setDep_tx_grauparentesco(rs.getString("dep_tx_grauparentesco"));
			 objs.add(dep_dependenteT);
 		 }
 		 return objs; 
 	 }
	 public List<Dep_dependenteT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.dep_dependente"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Dep_dependenteT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Dep_dependenteT> getByPK(Dep_dependenteT dep_dependenteT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.dep_dependente where  dep_nr_id=? and cli_nr_id=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, dep_dependenteT.getDep_nr_id());
			 pStmt.setObject(2, dep_dependenteT.getCli_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Dep_dependenteT> getByDep_nr_id(Dep_dependenteT dep_dependenteT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.dep_dependente where  dep_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, dep_dependenteT.getDep_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Dep_dependenteT> getByCli_nr_id(Dep_dependenteT dep_dependenteT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.dep_dependente where  cli_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, dep_dependenteT.getCli_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Dep_dependenteT> getByDep_tx_nome(Dep_dependenteT dep_dependenteT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.dep_dependente where  Upper(dep_tx_nome) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + dep_dependenteT.getDep_tx_nome()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Dep_dependenteT> getByDep_dt_nascimento(Dep_dependenteT dep_dependenteT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.dep_dependente where  dep_dt_nascimento = ? "; 
			 pStmt = con.prepareStatement(sql);
		 java.sql.Date dt1= new java.sql.Date(dep_dependenteT.getDep_dt_nascimento().getTime());
			 pStmt.setObject(1,dt1);
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Dep_dependenteT> getByDep_tx_grauparentesco(Dep_dependenteT dep_dependenteT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.dep_dependente where  Upper(dep_tx_grauparentesco) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + dep_dependenteT.getDep_tx_grauparentesco()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 
	 public List<Dep_dependenteT> getByCli_cliente(Dep_dependenteT dep_dependenteT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.dep_dependente where cli_nr_id=?  ";
			 pStmt = con.prepareStatement(sql);
		 pStmt.setObject(1, dep_dependenteT.getCli_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 
 }