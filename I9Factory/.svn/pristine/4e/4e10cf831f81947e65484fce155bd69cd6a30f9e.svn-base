package br.com.easynet.gwt.i9factory.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

public class Org_orgaoDAO extends ObjectDAO {

    public Org_orgaoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Org_orgaoT org_orgaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into factory.org_orgao  ( org_tx_cnpj, org_tx_razaosocial, org_tx_nomefantasia, org_tx_inscestadual, org_tx_tipologradouro, org_tx_logradouro, org_tx_numero, org_tx_cep, org_tx_complemento, org_tx_bairro, org_tx_municipio, org_tx_uf, org_tx_telefone1, org_tx_telefone2) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, org_orgaoT.getOrg_tx_cnpj());
            pStmt.setObject(2, org_orgaoT.getOrg_tx_razaosocial());
            pStmt.setObject(3, org_orgaoT.getOrg_tx_nomefantasia());
            pStmt.setObject(4, org_orgaoT.getOrg_tx_inscestadual());
            pStmt.setObject(5, org_orgaoT.getOrg_tx_tipologradouro());
            pStmt.setObject(6, org_orgaoT.getOrg_tx_logradouro());
            pStmt.setObject(7, org_orgaoT.getOrg_tx_numero());
            pStmt.setObject(8, org_orgaoT.getOrg_tx_cep());
            pStmt.setObject(9, org_orgaoT.getOrg_tx_complemento());
            pStmt.setObject(10, org_orgaoT.getOrg_tx_bairro());
            pStmt.setObject(11, org_orgaoT.getOrg_tx_municipio());
            pStmt.setObject(12, org_orgaoT.getOrg_tx_uf());
            pStmt.setObject(13, org_orgaoT.getOrg_tx_telefone1());
            pStmt.setObject(14, org_orgaoT.getOrg_tx_telefone2());
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

    public void update(Org_orgaoT org_orgaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.org_orgao set  org_tx_cnpj=?, org_tx_razaosocial=?, org_tx_nomefantasia=?, org_tx_inscestadual=?, org_tx_tipologradouro=?, org_tx_logradouro=?, org_tx_numero=?, org_tx_cep=?, org_tx_complemento=?, org_tx_bairro=?, org_tx_municipio=?, org_tx_uf=?, org_tx_telefone1=?, org_tx_telefone2=?  where  org_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, org_orgaoT.getOrg_tx_cnpj());
            pStmt.setObject(2, org_orgaoT.getOrg_tx_razaosocial());
            pStmt.setObject(3, org_orgaoT.getOrg_tx_nomefantasia());
            pStmt.setObject(4, org_orgaoT.getOrg_tx_inscestadual());
            pStmt.setObject(5, org_orgaoT.getOrg_tx_tipologradouro());
            pStmt.setObject(6, org_orgaoT.getOrg_tx_logradouro());
            pStmt.setObject(7, org_orgaoT.getOrg_tx_numero());
            pStmt.setObject(8, org_orgaoT.getOrg_tx_cep());
            pStmt.setObject(9, org_orgaoT.getOrg_tx_complemento());
            pStmt.setObject(10, org_orgaoT.getOrg_tx_bairro());
            pStmt.setObject(11, org_orgaoT.getOrg_tx_municipio());
            pStmt.setObject(12, org_orgaoT.getOrg_tx_uf());
            pStmt.setObject(13, org_orgaoT.getOrg_tx_telefone1());
            pStmt.setObject(14, org_orgaoT.getOrg_tx_telefone2());
            pStmt.setObject(15, org_orgaoT.getOrg_nr_id());
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

    public void delete(Org_orgaoT org_orgaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from factory.org_orgao where  org_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, org_orgaoT.getOrg_nr_id());
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

    private List<Org_orgaoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Org_orgaoT> objs = new Vector();
        while (rs.next()) {
            Org_orgaoT org_orgaoT = new Org_orgaoT();
            org_orgaoT.setOrg_nr_id(rs.getInt("org_nr_id"));
            org_orgaoT.setOrg_tx_cnpj(rs.getString("org_tx_cnpj"));
            org_orgaoT.setOrg_tx_razaosocial(rs.getString("org_tx_razaosocial"));
            org_orgaoT.setOrg_tx_nomefantasia(rs.getString("org_tx_nomefantasia"));
            org_orgaoT.setOrg_tx_inscestadual(rs.getString("org_tx_inscestadual"));
            org_orgaoT.setOrg_tx_tipologradouro(rs.getString("org_tx_tipologradouro"));
            org_orgaoT.setOrg_tx_logradouro(rs.getString("org_tx_logradouro"));
            org_orgaoT.setOrg_tx_numero(rs.getString("org_tx_numero"));
            org_orgaoT.setOrg_tx_cep(rs.getString("org_tx_cep"));
            org_orgaoT.setOrg_tx_complemento(rs.getString("org_tx_complemento"));
            org_orgaoT.setOrg_tx_bairro(rs.getString("org_tx_bairro"));
            org_orgaoT.setOrg_tx_municipio(rs.getString("org_tx_municipio"));
            org_orgaoT.setOrg_tx_uf(rs.getString("org_tx_uf"));
            org_orgaoT.setOrg_tx_telefone1(rs.getString("org_tx_telefone1"));
            org_orgaoT.setOrg_tx_telefone2(rs.getString("org_tx_telefone2"));
            objs.add(org_orgaoT);
        }
        return objs;
    }

    public List<Org_orgaoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.org_orgao order by org_tx_nomefantasia";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Org_orgaoT> list = resultSetToObjectTransfer(rs);
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

    public List<Org_orgaoT> getByPK(Org_orgaoT org_orgaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.org_orgao where  org_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, org_orgaoT.getOrg_nr_id());
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

    public List<Org_orgaoT> getByOrg_nr_id(Org_orgaoT org_orgaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.org_orgao where  org_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, org_orgaoT.getOrg_nr_id());
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

    public List<Org_orgaoT> getByOrg_tx_cnpj(Org_orgaoT org_orgaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.org_orgao where  Upper(org_tx_cnpj) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + org_orgaoT.getOrg_tx_cnpj() + '%');
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

    public List<Org_orgaoT> getByOrg_tx_razaosocial(Org_orgaoT org_orgaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.org_orgao where  Upper(org_tx_razaosocial) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + org_orgaoT.getOrg_tx_razaosocial() + '%');
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

    public List<Org_orgaoT> getByOrg_tx_nomefantasia(Org_orgaoT org_orgaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.org_orgao where  Upper(org_tx_nomefantasia) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + org_orgaoT.getOrg_tx_nomefantasia() + '%');
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

    public List<Org_orgaoT> getByOrg_tx_inscestadual(Org_orgaoT org_orgaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.org_orgao where  Upper(org_tx_inscestadual) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + org_orgaoT.getOrg_tx_inscestadual() + '%');
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

    public List<Org_orgaoT> getByOrg_tx_tipologradouro(Org_orgaoT org_orgaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.org_orgao where  Upper(org_tx_tipologradouro) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + org_orgaoT.getOrg_tx_tipologradouro() + '%');
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

    public List<Org_orgaoT> getByOrg_tx_logradouro(Org_orgaoT org_orgaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.org_orgao where  Upper(org_tx_logradouro) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + org_orgaoT.getOrg_tx_logradouro() + '%');
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

    public List<Org_orgaoT> getByOrg_tx_numero(Org_orgaoT org_orgaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.org_orgao where  Upper(org_tx_numero) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + org_orgaoT.getOrg_tx_numero() + '%');
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

    public List<Org_orgaoT> getByOrg_tx_cep(Org_orgaoT org_orgaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.org_orgao where  Upper(org_tx_cep) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + org_orgaoT.getOrg_tx_cep() + '%');
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

    public List<Org_orgaoT> getByOrg_tx_complemento(Org_orgaoT org_orgaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.org_orgao where  Upper(org_tx_complemento) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + org_orgaoT.getOrg_tx_complemento() + '%');
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

    public List<Org_orgaoT> getByOrg_tx_bairro(Org_orgaoT org_orgaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.org_orgao where  Upper(org_tx_bairro) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + org_orgaoT.getOrg_tx_bairro() + '%');
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

    public List<Org_orgaoT> getByOrg_tx_municipio(Org_orgaoT org_orgaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.org_orgao where  Upper(org_tx_municipio) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + org_orgaoT.getOrg_tx_municipio() + '%');
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

    public List<Org_orgaoT> getByOrg_tx_uf(Org_orgaoT org_orgaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.org_orgao where  Upper(org_tx_uf) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + org_orgaoT.getOrg_tx_uf() + '%');
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

    public List<Org_orgaoT> getByOrg_tx_telefone1(Org_orgaoT org_orgaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.org_orgao where  Upper(org_tx_telefone1) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + org_orgaoT.getOrg_tx_telefone1() + '%');
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

    public List<Org_orgaoT> getByOrg_tx_telefone2(Org_orgaoT org_orgaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.org_orgao where  Upper(org_tx_telefone2) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + org_orgaoT.getOrg_tx_telefone2() + '%');
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
