package br.com.easynet.gwt.i9factory.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

public class Tic_tipo_creditoDAO extends ObjectDAO { 
	 public Tic_tipo_creditoDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Tic_tipo_creditoT tic_tipo_creditoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into factory.tic_tipo_credito  ( tic_tx_nome) values ( ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tic_tipo_creditoT.getTic_tx_nome());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Tic_tipo_creditoT tic_tipo_creditoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update factory.tic_tipo_credito set  tic_tx_nome=?  where  tic_nr_id=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tic_tipo_creditoT.getTic_tx_nome());
			 pStmt.setObject(2, tic_tipo_creditoT.getTic_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Tic_tipo_creditoT tic_tipo_creditoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from factory.tic_tipo_credito where  tic_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tic_tipo_creditoT.getTic_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Tic_tipo_creditoT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Tic_tipo_creditoT> objs = new Vector();
		 while (rs.next()) { 
 			 Tic_tipo_creditoT tic_tipo_creditoT = new Tic_tipo_creditoT();
			 tic_tipo_creditoT.setTic_nr_id(rs.getInt("tic_nr_id"));
			 tic_tipo_creditoT.setTic_tx_nome(rs.getString("tic_tx_nome"));
			 objs.add(tic_tipo_creditoT);
 		 }
 		 return objs; 
 	 }
	 public List<Tic_tipo_creditoT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.tic_tipo_credito"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Tic_tipo_creditoT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Tic_tipo_creditoT> getByPK(Tic_tipo_creditoT tic_tipo_creditoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.tic_tipo_credito where  tic_nr_id=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tic_tipo_creditoT.getTic_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Tic_tipo_creditoT> getByTic_nr_id(Tic_tipo_creditoT tic_tipo_creditoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.tic_tipo_credito where  tic_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tic_tipo_creditoT.getTic_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Tic_tipo_creditoT> getByTic_tx_nome(Tic_tipo_creditoT tic_tipo_creditoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.tic_tipo_credito where  Upper(tic_tx_nome) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + tic_tipo_creditoT.getTic_tx_nome()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 

 }