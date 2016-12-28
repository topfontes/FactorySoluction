package br.com.easynet.gwt.i9factory.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

public class Age_agenciadorDAO extends ObjectDAO {

    public Age_agenciadorDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Age_agenciadorT age_agenciadorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into factory.age_agenciador  ( age_tx_cpf, age_tx_nome, age_dt_cadastro, age_dt_nascimento, eqp_nr_id, age_tx_tipologradouro, age_tx_logradouro, age_tx_numero, age_tx_cep, age_tx_complemento, age_tx_bairro, age_tx_municipio, age_tx_uf, age_tx_telefone2, age_tx_telefone2_1, age_tx_celular, age_tx_email, age_nr_taxaemprestimo, age_nr_taxamensalidade) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, age_agenciadorT.getAge_tx_cpf());
            pStmt.setObject(2, age_agenciadorT.getAge_tx_nome());
            pStmt.setObject(3, new java.sql.Date(System.currentTimeMillis()));
            java.sql.Date dt4 = new java.sql.Date(age_agenciadorT.getAge_dt_nascimento().getTime());
            pStmt.setObject(4, dt4);
            pStmt.setObject(5, age_agenciadorT.getEqp_nr_id());
            pStmt.setObject(6, age_agenciadorT.getAge_tx_tipologradouro());
            pStmt.setObject(7, age_agenciadorT.getAge_tx_logradouro());
            pStmt.setObject(8, age_agenciadorT.getAge_tx_numero());
            pStmt.setObject(9, age_agenciadorT.getAge_tx_cep());
            pStmt.setObject(10, age_agenciadorT.getAge_tx_complemento());
            pStmt.setObject(11, age_agenciadorT.getAge_tx_bairro());
            pStmt.setObject(12, age_agenciadorT.getAge_tx_municipio());
            pStmt.setObject(13, age_agenciadorT.getAge_tx_uf());
            pStmt.setObject(14, age_agenciadorT.getAge_tx_telefone2());
            pStmt.setObject(15, age_agenciadorT.getAge_tx_telefone2_1());
            pStmt.setObject(16, age_agenciadorT.getAge_tx_celular());
            pStmt.setObject(17, age_agenciadorT.getAge_tx_email());
            pStmt.setObject(18, age_agenciadorT.getAge_nr_taxaemprestimo());
            pStmt.setObject(19, age_agenciadorT.getAge_nr_taxamensalidade());
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

    public void update(Age_agenciadorT age_agenciadorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.age_agenciador set  age_tx_cpf=?, age_tx_nome=?, age_dt_nascimento=?, eqp_nr_id=?, age_tx_tipologradouro=?, age_tx_logradouro=?, age_tx_numero=?, age_tx_cep=?, age_tx_complemento=?, age_tx_bairro=?, age_tx_municipio=?, age_tx_uf=?, age_tx_telefone2=?, age_tx_telefone2_1=?, age_tx_celular=?, age_tx_email=?, age_nr_taxaemprestimo=?, age_nr_taxamensalidade=?  where  age_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, age_agenciadorT.getAge_tx_cpf());
            pStmt.setObject(2, age_agenciadorT.getAge_tx_nome());
            java.sql.Date dt4 = new java.sql.Date(age_agenciadorT.getAge_dt_nascimento().getTime());
            pStmt.setObject(3, dt4);
            pStmt.setObject(4, age_agenciadorT.getEqp_nr_id());
            pStmt.setObject(5, age_agenciadorT.getAge_tx_tipologradouro());
            pStmt.setObject(6, age_agenciadorT.getAge_tx_logradouro());
            pStmt.setObject(7, age_agenciadorT.getAge_tx_numero());
            pStmt.setObject(8, age_agenciadorT.getAge_tx_cep());
            pStmt.setObject(9, age_agenciadorT.getAge_tx_complemento());
            pStmt.setObject(10, age_agenciadorT.getAge_tx_bairro());
            pStmt.setObject(11, age_agenciadorT.getAge_tx_municipio());
            pStmt.setObject(12, age_agenciadorT.getAge_tx_uf());
            pStmt.setObject(13, age_agenciadorT.getAge_tx_telefone2());
            pStmt.setObject(14, age_agenciadorT.getAge_tx_telefone2_1());
            pStmt.setObject(15, age_agenciadorT.getAge_tx_celular());
            pStmt.setObject(16, age_agenciadorT.getAge_tx_email());
            pStmt.setObject(17, age_agenciadorT.getAge_nr_taxaemprestimo());
            pStmt.setObject(18, age_agenciadorT.getAge_nr_taxamensalidade());
            pStmt.setObject(19, age_agenciadorT.getAge_nr_id());
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

    public void delete(Age_agenciadorT age_agenciadorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from factory.age_agenciador where  age_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, age_agenciadorT.getAge_nr_id());
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

    private List<Age_agenciadorT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Age_agenciadorT> objs = new Vector();
        while (rs.next()) {
            Age_agenciadorT age_agenciadorT = new Age_agenciadorT();
            age_agenciadorT.setAge_nr_id(rs.getInt("age_nr_id"));
            age_agenciadorT.setAge_tx_cpf(rs.getString("age_tx_cpf"));
            age_agenciadorT.setAge_tx_nome(rs.getString("age_tx_nome"));
            age_agenciadorT.setAge_dt_cadastro(rs.getTimestamp("age_dt_cadastro"));
            age_agenciadorT.setAge_dt_nascimento(rs.getDate("age_dt_nascimento"));
            age_agenciadorT.setEqp_nr_id(rs.getInt("eqp_nr_id"));
            age_agenciadorT.setAge_tx_tipologradouro(rs.getString("age_tx_tipologradouro"));
            age_agenciadorT.setAge_tx_logradouro(rs.getString("age_tx_logradouro"));
            age_agenciadorT.setAge_tx_numero(rs.getString("age_tx_numero"));
            age_agenciadorT.setAge_tx_cep(rs.getString("age_tx_cep"));
            age_agenciadorT.setAge_tx_complemento(rs.getString("age_tx_complemento"));
            age_agenciadorT.setAge_tx_bairro(rs.getString("age_tx_bairro"));
            age_agenciadorT.setAge_tx_municipio(rs.getString("age_tx_municipio"));
            age_agenciadorT.setAge_tx_uf(rs.getString("age_tx_uf"));
            age_agenciadorT.setAge_tx_telefone2(rs.getString("age_tx_telefone2"));
            age_agenciadorT.setAge_tx_telefone2_1(rs.getString("age_tx_telefone2_1"));
            age_agenciadorT.setAge_tx_celular(rs.getString("age_tx_celular"));
            age_agenciadorT.setAge_tx_email(rs.getString("age_tx_email"));
            age_agenciadorT.setAge_nr_taxaemprestimo(rs.getFloat("age_nr_taxaemprestimo"));
            age_agenciadorT.setAge_nr_taxamensalidade(rs.getFloat("age_nr_taxamensalidade"));
            objs.add(age_agenciadorT);
        }
        return objs;
    }

    public DataSet getAll() throws Exception {
        DataSet ds = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select agen.age_nr_id, agen.age_tx_cpf, agen.age_tx_nome, agen.age_dt_cadastro, agen.age_dt_nascimento, agen.eqp_nr_id , agen.age_tx_tipologradouro,");
            sql.append(" agen.age_tx_logradouro, agen.age_tx_numero, agen.age_tx_cep, agen.age_tx_complemento, agen.age_tx_bairro, agen.age_tx_municipio, agen.age_tx_uf,");
            sql.append(" agen.age_tx_telefone2, agen.age_tx_telefone2_1, agen.age_tx_celular, agen.age_tx_email, agen.age_nr_taxaemprestimo, agen.age_nr_taxamensalidade, eqp.eqp_tx_nome ");
            sql.append(" from factory.age_agenciador as agen inner join factory.eqp_equipe as eqp on(eqp.eqp_nr_id = agen.eqp_nr_id)");
            ds = executeQuery(sql.toString(), null);
            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    public List<Age_agenciadorT> getByPK(Age_agenciadorT age_agenciadorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.age_agenciador where  age_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, age_agenciadorT.getAge_nr_id());
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

    public List<Age_agenciadorT> getByAge_nr_id(Age_agenciadorT age_agenciadorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.age_agenciador where  age_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, age_agenciadorT.getAge_nr_id());
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

    public List<Age_agenciadorT> getByAge_tx_cpf(Age_agenciadorT age_agenciadorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.age_agenciador where  Upper(age_tx_cpf) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + age_agenciadorT.getAge_tx_cpf() + '%');
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

    public List<Age_agenciadorT> getByAge_tx_nome(Age_agenciadorT age_agenciadorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.age_agenciador where  Upper(age_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + age_agenciadorT.getAge_tx_nome() + '%');
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

    public List<Age_agenciadorT> getByAge_dt_cadastro(Age_agenciadorT age_agenciadorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.age_agenciador where  age_dt_cadastro = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, age_agenciadorT.getAge_dt_cadastro());
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

    public List<Age_agenciadorT> getByAge_dt_nascimento(Age_agenciadorT age_agenciadorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.age_agenciador where  age_dt_nascimento = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(age_agenciadorT.getAge_dt_nascimento().getTime());
            pStmt.setObject(1, dt1);
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

    public List<Age_agenciadorT> getByEqp_nr_id(Age_agenciadorT age_agenciadorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.age_agenciador where  eqp_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, age_agenciadorT.getEqp_nr_id());
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

    public List<Age_agenciadorT> getByAge_tx_tipologradouro(Age_agenciadorT age_agenciadorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.age_agenciador where  Upper(age_tx_tipologradouro) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + age_agenciadorT.getAge_tx_tipologradouro() + '%');
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

    public List<Age_agenciadorT> getByAge_tx_logradouro(Age_agenciadorT age_agenciadorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.age_agenciador where  Upper(age_tx_logradouro) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + age_agenciadorT.getAge_tx_logradouro() + '%');
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

    public List<Age_agenciadorT> getByAge_tx_numero(Age_agenciadorT age_agenciadorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.age_agenciador where  Upper(age_tx_numero) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + age_agenciadorT.getAge_tx_numero() + '%');
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

    public List<Age_agenciadorT> getByAge_tx_cep(Age_agenciadorT age_agenciadorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.age_agenciador where  Upper(age_tx_cep) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + age_agenciadorT.getAge_tx_cep() + '%');
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

    public List<Age_agenciadorT> getByAge_tx_complemento(Age_agenciadorT age_agenciadorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.age_agenciador where  Upper(age_tx_complemento) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + age_agenciadorT.getAge_tx_complemento() + '%');
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

    public List<Age_agenciadorT> getByAge_tx_bairro(Age_agenciadorT age_agenciadorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.age_agenciador where  Upper(age_tx_bairro) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + age_agenciadorT.getAge_tx_bairro() + '%');
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

    public List<Age_agenciadorT> getByAge_tx_municipio(Age_agenciadorT age_agenciadorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.age_agenciador where  Upper(age_tx_municipio) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + age_agenciadorT.getAge_tx_municipio() + '%');
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

    public List<Age_agenciadorT> getByAge_tx_uf(Age_agenciadorT age_agenciadorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.age_agenciador where  Upper(age_tx_uf) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + age_agenciadorT.getAge_tx_uf() + '%');
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

    public List<Age_agenciadorT> getByAge_tx_telefone2(Age_agenciadorT age_agenciadorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.age_agenciador where  Upper(age_tx_telefone2) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + age_agenciadorT.getAge_tx_telefone2() + '%');
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

    public List<Age_agenciadorT> getByAge_tx_telefone2_1(Age_agenciadorT age_agenciadorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.age_agenciador where  Upper(age_tx_telefone2_1) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + age_agenciadorT.getAge_tx_telefone2_1() + '%');
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

    public List<Age_agenciadorT> getByAge_tx_celular(Age_agenciadorT age_agenciadorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.age_agenciador where  Upper(age_tx_celular) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + age_agenciadorT.getAge_tx_celular() + '%');
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

    public List<Age_agenciadorT> getByAge_tx_email(Age_agenciadorT age_agenciadorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.age_agenciador where  Upper(age_tx_email) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + age_agenciadorT.getAge_tx_email() + '%');
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

    public List<Age_agenciadorT> getByAge_nr_taxaemprestimo(Age_agenciadorT age_agenciadorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.age_agenciador where  age_nr_taxaemprestimo = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, age_agenciadorT.getAge_nr_taxaemprestimo());
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

    public List<Age_agenciadorT> getByAge_nr_taxamensalidade(Age_agenciadorT age_agenciadorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.age_agenciador where  age_nr_taxamensalidade = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, age_agenciadorT.getAge_nr_taxamensalidade());
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

    /** Metodo FK */
    public List<Age_agenciadorT> getByEqp_equipe(Age_agenciadorT age_agenciadorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.age_agenciador where eqp_equipe.eqp_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, age_agenciadorT.getEqp_nr_id());
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
