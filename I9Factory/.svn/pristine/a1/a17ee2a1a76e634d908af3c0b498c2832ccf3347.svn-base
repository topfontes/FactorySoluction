package br.com.easynet.gwt.i9factory.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

public class Ped_percentual_descontoDAO extends ObjectDAO { 
	 public Ped_percentual_descontoDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Ped_percentual_descontoT ped_percentual_descontoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into factory.ped_percentual_desconto  ( ped_nr_parcela, ped_nr_desconto) values ( ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, ped_percentual_descontoT.getPed_nr_parcela());
			 pStmt.setObject(2, ped_percentual_descontoT.getPed_nr_desconto());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Ped_percentual_descontoT ped_percentual_descontoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update factory.ped_percentual_desconto set  ped_nr_parcela=?, ped_nr_desconto=?  where  ped_nr_id=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, ped_percentual_descontoT.getPed_nr_parcela());
			 pStmt.setObject(2, ped_percentual_descontoT.getPed_nr_desconto());
			 pStmt.setObject(3, ped_percentual_descontoT.getPed_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Ped_percentual_descontoT ped_percentual_descontoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from factory.ped_percentual_desconto where  ped_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, ped_percentual_descontoT.getPed_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Ped_percentual_descontoT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Ped_percentual_descontoT> objs = new Vector();
		 while (rs.next()) { 
 			 Ped_percentual_descontoT ped_percentual_descontoT = new Ped_percentual_descontoT();
			 ped_percentual_descontoT.setPed_nr_id(rs.getInt("ped_nr_id"));
			 ped_percentual_descontoT.setPed_nr_parcela(rs.getInt("ped_nr_parcela"));
			 ped_percentual_descontoT.setPed_nr_desconto(rs.getFloat("ped_nr_desconto"));
			 objs.add(ped_percentual_descontoT);
 		 }
 		 return objs; 
 	 }
	 public List<Ped_percentual_descontoT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.ped_percentual_desconto"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Ped_percentual_descontoT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Ped_percentual_descontoT> getByPK(Ped_percentual_descontoT ped_percentual_descontoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.ped_percentual_desconto where  ped_nr_id=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, ped_percentual_descontoT.getPed_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Ped_percentual_descontoT> getByPed_nr_id(Ped_percentual_descontoT ped_percentual_descontoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.ped_percentual_desconto where  ped_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, ped_percentual_descontoT.getPed_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Ped_percentual_descontoT> getByPed_nr_parcela(Ped_percentual_descontoT ped_percentual_descontoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.ped_percentual_desconto where  ped_nr_parcela = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, ped_percentual_descontoT.getPed_nr_parcela());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Ped_percentual_descontoT> getByPed_nr_desconto(Ped_percentual_descontoT ped_percentual_descontoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.ped_percentual_desconto where  ped_nr_desconto = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, ped_percentual_descontoT.getPed_nr_desconto());
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