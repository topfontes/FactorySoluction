package br.com.easynet.gwt.i9factory.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

public class Cor_corretoraDAO extends ObjectDAO { 
	 public Cor_corretoraDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Cor_corretoraT cor_corretoraT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into factory.cor_corretora  ( cor_tx_cnpj, cor_tx_razaosocial, cor_tx_nomefantasia, cor_tx_inscestadual, cor_tx_responsavel, cor_tx_tipologradouro, cor_tx_logradouro, cor_tx_numero, cor_tx_cep, cor_tx_complemento, cor_tx_bairro, cor_tx_municipio, cor_tx_uf, cor_tx_telefone1, cor_tx_telefone2) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, cor_corretoraT.getCor_tx_cnpj());
			 pStmt.setObject(2, cor_corretoraT.getCor_tx_razaosocial());
			 pStmt.setObject(3, cor_corretoraT.getCor_tx_nomefantasia());
			 pStmt.setObject(4, cor_corretoraT.getCor_tx_inscestadual());
			 pStmt.setObject(5, cor_corretoraT.getCor_tx_responsavel());
			 pStmt.setObject(6, cor_corretoraT.getCor_tx_tipologradouro());
			 pStmt.setObject(7, cor_corretoraT.getCor_tx_logradouro());
			 pStmt.setObject(8, cor_corretoraT.getCor_tx_numero());
			 pStmt.setObject(9, cor_corretoraT.getCor_tx_cep());
			 pStmt.setObject(10, cor_corretoraT.getCor_tx_complemento());
			 pStmt.setObject(11, cor_corretoraT.getCor_tx_bairro());
			 pStmt.setObject(12, cor_corretoraT.getCor_tx_municipio());
			 pStmt.setObject(13, cor_corretoraT.getCor_tx_uf());
			 pStmt.setObject(14, cor_corretoraT.getCor_tx_telefone1());
			 pStmt.setObject(15, cor_corretoraT.getCor_tx_telefone2());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Cor_corretoraT cor_corretoraT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update factory.cor_corretora set  cor_tx_cnpj=?, cor_tx_razaosocial=?, cor_tx_nomefantasia=?, cor_tx_inscestadual=?, cor_tx_responsavel=?, cor_tx_tipologradouro=?, cor_tx_logradouro=?, cor_tx_numero=?, cor_tx_cep=?, cor_tx_complemento=?, cor_tx_bairro=?, cor_tx_municipio=?, cor_tx_uf=?, cor_tx_telefone1=?, cor_tx_telefone2=?  where  cor_nr_id=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, cor_corretoraT.getCor_tx_cnpj());
			 pStmt.setObject(2, cor_corretoraT.getCor_tx_razaosocial());
			 pStmt.setObject(3, cor_corretoraT.getCor_tx_nomefantasia());
			 pStmt.setObject(4, cor_corretoraT.getCor_tx_inscestadual());
			 pStmt.setObject(5, cor_corretoraT.getCor_tx_responsavel());
			 pStmt.setObject(6, cor_corretoraT.getCor_tx_tipologradouro());
			 pStmt.setObject(7, cor_corretoraT.getCor_tx_logradouro());
			 pStmt.setObject(8, cor_corretoraT.getCor_tx_numero());
			 pStmt.setObject(9, cor_corretoraT.getCor_tx_cep());
			 pStmt.setObject(10, cor_corretoraT.getCor_tx_complemento());
			 pStmt.setObject(11, cor_corretoraT.getCor_tx_bairro());
			 pStmt.setObject(12, cor_corretoraT.getCor_tx_municipio());
			 pStmt.setObject(13, cor_corretoraT.getCor_tx_uf());
			 pStmt.setObject(14, cor_corretoraT.getCor_tx_telefone1());
			 pStmt.setObject(15, cor_corretoraT.getCor_tx_telefone2());
			 pStmt.setObject(16, cor_corretoraT.getCor_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Cor_corretoraT cor_corretoraT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from factory.cor_corretora where  cor_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, cor_corretoraT.getCor_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Cor_corretoraT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Cor_corretoraT> objs = new Vector();
		 while (rs.next()) { 
 			 Cor_corretoraT cor_corretoraT = new Cor_corretoraT();
			 cor_corretoraT.setCor_nr_id(rs.getInt("cor_nr_id"));
			 cor_corretoraT.setCor_tx_cnpj(rs.getString("cor_tx_cnpj"));
			 cor_corretoraT.setCor_tx_razaosocial(rs.getString("cor_tx_razaosocial"));
			 cor_corretoraT.setCor_tx_nomefantasia(rs.getString("cor_tx_nomefantasia"));
			 cor_corretoraT.setCor_tx_inscestadual(rs.getString("cor_tx_inscestadual"));
			 cor_corretoraT.setCor_tx_responsavel(rs.getString("cor_tx_responsavel"));
			 cor_corretoraT.setCor_tx_tipologradouro(rs.getString("cor_tx_tipologradouro"));
			 cor_corretoraT.setCor_tx_logradouro(rs.getString("cor_tx_logradouro"));
			 cor_corretoraT.setCor_tx_numero(rs.getString("cor_tx_numero"));
			 cor_corretoraT.setCor_tx_cep(rs.getString("cor_tx_cep"));
			 cor_corretoraT.setCor_tx_complemento(rs.getString("cor_tx_complemento"));
			 cor_corretoraT.setCor_tx_bairro(rs.getString("cor_tx_bairro"));
			 cor_corretoraT.setCor_tx_municipio(rs.getString("cor_tx_municipio"));
			 cor_corretoraT.setCor_tx_uf(rs.getString("cor_tx_uf"));
			 cor_corretoraT.setCor_tx_telefone1(rs.getString("cor_tx_telefone1"));
			 cor_corretoraT.setCor_tx_telefone2(rs.getString("cor_tx_telefone2"));
			 objs.add(cor_corretoraT);
 		 }
 		 return objs; 
 	 }
	 public List<Cor_corretoraT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.cor_corretora"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Cor_corretoraT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cor_corretoraT> getByPK(Cor_corretoraT cor_corretoraT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.cor_corretora where  cor_nr_id=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, cor_corretoraT.getCor_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cor_corretoraT> getByCor_nr_id(Cor_corretoraT cor_corretoraT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.cor_corretora where  cor_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, cor_corretoraT.getCor_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cor_corretoraT> getByCor_tx_cnpj(Cor_corretoraT cor_corretoraT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.cor_corretora where  Upper(cor_tx_cnpj) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + cor_corretoraT.getCor_tx_cnpj()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cor_corretoraT> getByCor_tx_razaosocial(Cor_corretoraT cor_corretoraT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.cor_corretora where  Upper(cor_tx_razaosocial) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + cor_corretoraT.getCor_tx_razaosocial()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cor_corretoraT> getByCor_tx_nomefantasia(Cor_corretoraT cor_corretoraT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.cor_corretora where  Upper(cor_tx_nomefantasia) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + cor_corretoraT.getCor_tx_nomefantasia()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cor_corretoraT> getByCor_tx_inscestadual(Cor_corretoraT cor_corretoraT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.cor_corretora where  Upper(cor_tx_inscestadual) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + cor_corretoraT.getCor_tx_inscestadual()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cor_corretoraT> getByCor_tx_responsavel(Cor_corretoraT cor_corretoraT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.cor_corretora where  Upper(cor_tx_responsavel) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + cor_corretoraT.getCor_tx_responsavel()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cor_corretoraT> getByCor_tx_tipologradouro(Cor_corretoraT cor_corretoraT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.cor_corretora where  Upper(cor_tx_tipologradouro) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + cor_corretoraT.getCor_tx_tipologradouro()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cor_corretoraT> getByCor_tx_logradouro(Cor_corretoraT cor_corretoraT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.cor_corretora where  Upper(cor_tx_logradouro) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + cor_corretoraT.getCor_tx_logradouro()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cor_corretoraT> getByCor_tx_numero(Cor_corretoraT cor_corretoraT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.cor_corretora where  Upper(cor_tx_numero) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + cor_corretoraT.getCor_tx_numero()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cor_corretoraT> getByCor_tx_cep(Cor_corretoraT cor_corretoraT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.cor_corretora where  Upper(cor_tx_cep) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + cor_corretoraT.getCor_tx_cep()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cor_corretoraT> getByCor_tx_complemento(Cor_corretoraT cor_corretoraT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.cor_corretora where  Upper(cor_tx_complemento) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + cor_corretoraT.getCor_tx_complemento()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cor_corretoraT> getByCor_tx_bairro(Cor_corretoraT cor_corretoraT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.cor_corretora where  Upper(cor_tx_bairro) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + cor_corretoraT.getCor_tx_bairro()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cor_corretoraT> getByCor_tx_municipio(Cor_corretoraT cor_corretoraT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.cor_corretora where  Upper(cor_tx_municipio) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + cor_corretoraT.getCor_tx_municipio()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cor_corretoraT> getByCor_tx_uf(Cor_corretoraT cor_corretoraT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.cor_corretora where  Upper(cor_tx_uf) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + cor_corretoraT.getCor_tx_uf()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cor_corretoraT> getByCor_tx_telefone1(Cor_corretoraT cor_corretoraT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.cor_corretora where  Upper(cor_tx_telefone1) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + cor_corretoraT.getCor_tx_telefone1()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cor_corretoraT> getByCor_tx_telefone2(Cor_corretoraT cor_corretoraT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from factory.cor_corretora where  Upper(cor_tx_telefone2) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + cor_corretoraT.getCor_tx_telefone2()+'%' );
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