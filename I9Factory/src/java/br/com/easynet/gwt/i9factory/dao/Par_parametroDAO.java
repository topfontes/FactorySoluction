package br.com.easynet.gwt.i9factory.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

public class Par_parametroDAO extends ObjectDAO {

    public Par_parametroDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Par_parametroT par_parametroT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into factory.par_parametro  ( par_tx_nome, par_tx_valor, par_tx_descricao) values ( ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, par_parametroT.getPar_tx_nome());
            pStmt.setObject(2, par_parametroT.getPar_tx_valor());
            pStmt.setObject(3, par_parametroT.getPar_tx_descricao());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void update(Par_parametroT par_parametroT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.par_parametro set  par_tx_nome=?, par_tx_valor=?, par_tx_descricao=?  where  par_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, par_parametroT.getPar_tx_nome());
            pStmt.setObject(2, par_parametroT.getPar_tx_valor());
            pStmt.setObject(3, par_parametroT.getPar_tx_descricao());
            pStmt.setObject(4, par_parametroT.getPar_nr_id());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void delete(Par_parametroT par_parametroT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from factory.par_parametro where  par_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, par_parametroT.getPar_nr_id());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    private List<Par_parametroT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Par_parametroT> objs = new Vector();
        while (rs.next()) {
            Par_parametroT par_parametroT = new Par_parametroT();
            par_parametroT.setPar_nr_id(rs.getInt("par_nr_id"));
            par_parametroT.setPar_tx_nome(rs.getString("par_tx_nome"));
            par_parametroT.setPar_tx_valor(rs.getString("par_tx_valor"));
            par_parametroT.setPar_tx_descricao(rs.getString("par_tx_descricao"));
            objs.add(par_parametroT);
        }
        return objs;
    }

    public List<Par_parametroT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.par_parametro order by par_tx_nome";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Par_parametroT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Par_parametroT> getByPK(Par_parametroT par_parametroT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.par_parametro where  par_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, par_parametroT.getPar_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Par_parametroT> getByPar_nr_id(Par_parametroT par_parametroT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.par_parametro where  par_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, par_parametroT.getPar_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public Par_parametroT getByPar_tx_nome(String parTxNome) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.par_parametro where  Upper(par_tx_nome) = Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, parTxNome);
            rs = pStmt.executeQuery();
            List<Par_parametroT> list = resultSetToObjectTransfer(rs);
            return list.size()>0?list.get(0):null;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }
    public List<Par_parametroT> getByPar_tx_nome(Par_parametroT par_parametroT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.par_parametro where  Upper(par_tx_nome) = Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, par_parametroT.getPar_tx_nome());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public List<Par_parametroT> getByPar_tx_valor(Par_parametroT par_parametroT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.par_parametro where  Upper(par_tx_valor) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + par_parametroT.getPar_tx_valor() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Par_parametroT> getByPar_tx_descricao(Par_parametroT par_parametroT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.par_parametro where  Upper(par_tx_descricao) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + par_parametroT.getPar_tx_descricao() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }
}
