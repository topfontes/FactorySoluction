package br.com.easynet.gwt.i9factory.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

public class Idc_indiceDAO extends ObjectDAO { 
	 public Idc_indiceDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Idc_indiceT idc_indiceT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into factory.idc_indice  ( idc_nr_diainicial, idc_nr_diafinal, idc_nr_qtdparcelas, idc_nr_valor) values ( ? , ? , ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, idc_indiceT.getIdc_nr_diainicial());
			 pStmt.setObject(2, idc_indiceT.getIdc_nr_diafinal());
			 pStmt.setObject(3, idc_indiceT.getIdc_nr_qtdparcelas());
			 pStmt.setObject(4, idc_indiceT.getIdc_nr_valor());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Idc_indiceT idc_indiceT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update factory.idc_indice set  idc_nr_diainicial=?, idc_nr_diafinal=?, idc_nr_qtdparcelas=?, idc_nr_valor=?  where  idc_nr_id=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, idc_indiceT.getIdc_nr_diainicial());
			 pStmt.setObject(2, idc_indiceT.getIdc_nr_diafinal());
			 pStmt.setObject(3, idc_indiceT.getIdc_nr_qtdparcelas());
			 pStmt.setObject(4, idc_indiceT.getIdc_nr_valor());
			 pStmt.setObject(5, idc_indiceT.getIdc_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Idc_indiceT idc_indiceT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from factory.idc_indice where  idc_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, idc_indiceT.getIdc_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Idc_indiceT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Idc_indiceT> objs = new Vector();
		 while (rs.next()) { 
 			 Idc_indiceT idc_indiceT = new Idc_indiceT();
			 idc_indiceT.setIdc_nr_id(rs.getInt("idc_nr_id"));
			 idc_indiceT.setIdc_nr_diainicial(rs.getInt("idc_nr_diainicial"));
			 idc_indiceT.setIdc_nr_diafinal(rs.getInt("idc_nr_diafinal"));
			 idc_indiceT.setIdc_nr_qtdparcelas(rs.getInt("idc_nr_qtdparcelas"));
			 idc_indiceT.setIdc_nr_valor(rs.getFloat("idc_nr_valor"));
			 objs.add(idc_indiceT);
 		 }
 		 return objs; 
 	 }
	 public List<Idc_indiceT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.idc_indice"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Idc_indiceT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Idc_indiceT> getByPK(Idc_indiceT idc_indiceT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.idc_indice where  idc_nr_id=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, idc_indiceT.getIdc_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Idc_indiceT> getByIdc_nr_id(Idc_indiceT idc_indiceT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.idc_indice where  idc_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, idc_indiceT.getIdc_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Idc_indiceT> getByIdc_nr_diainicial(Idc_indiceT idc_indiceT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.idc_indice where  idc_nr_diainicial = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, idc_indiceT.getIdc_nr_diainicial());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Idc_indiceT> getByIdc_nr_diafinal(Idc_indiceT idc_indiceT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.idc_indice where  idc_nr_diafinal = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, idc_indiceT.getIdc_nr_diafinal());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Idc_indiceT> getByIdc_nr_qtdparcelas(Idc_indiceT idc_indiceT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.idc_indice where  idc_nr_qtdparcelas = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, idc_indiceT.getIdc_nr_qtdparcelas());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Idc_indiceT> getByIdc_nr_valor(Idc_indiceT idc_indiceT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.idc_indice where  idc_nr_valor = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, idc_indiceT.getIdc_nr_valor());
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