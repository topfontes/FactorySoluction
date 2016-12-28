package br.com.easynet.gwt.i9factory.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

public class Tid_tipo_despesaDAO extends ObjectDAO { 
	 public Tid_tipo_despesaDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Tid_tipo_despesaT tid_tipo_despesaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into factory.tid_tipo_despesa  ( tid_tx_nome) values ( ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tid_tipo_despesaT.getTid_tx_nome());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Tid_tipo_despesaT tid_tipo_despesaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update factory.tid_tipo_despesa set  tid_tx_nome=?  where  tid_nr_id=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tid_tipo_despesaT.getTid_tx_nome());
			 pStmt.setObject(2, tid_tipo_despesaT.getTid_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Tid_tipo_despesaT tid_tipo_despesaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from factory.tid_tipo_despesa where  tid_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tid_tipo_despesaT.getTid_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Tid_tipo_despesaT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Tid_tipo_despesaT> objs = new Vector();
		 while (rs.next()) { 
 			 Tid_tipo_despesaT tid_tipo_despesaT = new Tid_tipo_despesaT();
			 tid_tipo_despesaT.setTid_nr_id(rs.getInt("tid_nr_id"));
			 tid_tipo_despesaT.setTid_tx_nome(rs.getString("tid_tx_nome"));
			 objs.add(tid_tipo_despesaT);
 		 }
 		 return objs; 
 	 }
	 public List<Tid_tipo_despesaT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.tid_tipo_despesa"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Tid_tipo_despesaT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Tid_tipo_despesaT> getByPK(Tid_tipo_despesaT tid_tipo_despesaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.tid_tipo_despesa where  tid_nr_id=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tid_tipo_despesaT.getTid_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Tid_tipo_despesaT> getByTid_nr_id(Tid_tipo_despesaT tid_tipo_despesaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.tid_tipo_despesa where  tid_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tid_tipo_despesaT.getTid_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Tid_tipo_despesaT> getByTid_tx_nome(Tid_tipo_despesaT tid_tipo_despesaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.tid_tipo_despesa where  Upper(tid_tx_nome) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + tid_tipo_despesaT.getTid_tx_nome()+'%' );
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