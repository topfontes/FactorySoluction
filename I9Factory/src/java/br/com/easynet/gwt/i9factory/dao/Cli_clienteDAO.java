package br.com.easynet.gwt.i9factory.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.easynet.gwt.i9factory.tmp.cli_casserpTemp;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

public class Cli_clienteDAO extends ObjectDAO {

    public Cli_clienteDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }
    private Object sinal = "sinal";

    public int maxId() throws Exception {
        ResultSet rs = null;
        Statement st = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select max(cli_nr_id) cli_nr_id from factory.cli_cliente");
            int id = 0;
            if (rs.next()) {
                id = rs.getInt("cli_nr_id");
            }
            return id;

        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
            }
            try {
                st.close();
            } catch (Exception e) {
            }
        }
    }

    public void setMatricula(Cli_clienteT cli_clienteT) throws Exception {
        ResultSet rs = null;
        Statement st = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT max(cli.cli_tx_matricula::int)matricula from factory.cli_cliente cli where cli_tx_matricula like'79%'");
            int mat = 0;
            if (rs.next()) {
                mat = rs.getInt("matricula");
            }
            mat++;
            cli_clienteT.setCli_tx_matricula(mat + "");

        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
            }
            try {
                st.close();
            } catch (Exception e) {
            }

        }
    }

    public void insert(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            synchronized (sinal) {
                if (cli_clienteT.getCli_tx_matricula().equalsIgnoreCase("AUTOMATICO")) {
                    setMatricula(cli_clienteT);
                }
                String sql = "insert into factory.cli_cliente  ( cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, cli_tx_salario_minimo) values ( ?, ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";
                pStmt = con.prepareStatement(sql);
                pStmt.setObject(1, cli_clienteT.getCli_tx_nome());
                pStmt.setObject(2, cli_clienteT.getCli_tx_cpf());
                pStmt.setObject(3, cli_clienteT.getCli_tx_rg());
                pStmt.setObject(4, cli_clienteT.getCli_tx_matricula());
                pStmt.setObject(5, cli_clienteT.getCli_tx_sexo());
                pStmt.setObject(6, cli_clienteT.getCli_tx_estadocivil());
                pStmt.setObject(7, cli_clienteT.getCli_tx_tipologradouro());
                pStmt.setObject(8, cli_clienteT.getCli_tx_logradouro());
                pStmt.setObject(9, cli_clienteT.getCli_tx_numero());
                pStmt.setObject(10, cli_clienteT.getCli_tx_cep());
                pStmt.setObject(11, cli_clienteT.getCli_tx_complemento());
                pStmt.setObject(12, cli_clienteT.getCli_tx_bairro());
                pStmt.setObject(13, cli_clienteT.getCli_tx_municipio());
                pStmt.setObject(14, cli_clienteT.getCli_tx_uf());
                pStmt.setObject(15, cli_clienteT.getCli_tx_email());
                pStmt.setObject(16, cli_clienteT.getCli_tx_telefone1());
                pStmt.setObject(17, cli_clienteT.getCli_tx_telefone2());
                pStmt.setObject(18, cli_clienteT.getCli_tx_celular());
                pStmt.setObject(19, cli_clienteT.getCli_tx_ramal());
                java.sql.Date dt20 = new java.sql.Date(cli_clienteT.getCli_dt_nascimento().getTime());
                pStmt.setObject(20, dt20);
                pStmt.setObject(21, cli_clienteT.getCli_bt_foto());
                java.sql.Date dt22 = new java.sql.Date(System.currentTimeMillis());
                pStmt.setObject(22, dt22);
                pStmt.setObject(23, cli_clienteT.getCli_tx_socio());
                pStmt.setObject(24, cli_clienteT.getCli_tx_salario_minimo());

                pStmt.execute();
                cli_clienteT.setCli_nr_id(maxId());
            }
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public void insertNotImage(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            synchronized (sinal) {
                if (cli_clienteT.getCli_tx_matricula().equalsIgnoreCase("AUTOMATICO")) {
                    setMatricula(cli_clienteT);
                }
                String sql = "insert into factory.cli_cliente  ( cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_dt_cadastro, cli_tx_socio, cli_tx_salario_minimo) values ( ?,  ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
                pStmt = con.prepareStatement(sql);
                pStmt.setObject(1, cli_clienteT.getCli_tx_nome());
                pStmt.setObject(2, cli_clienteT.getCli_tx_cpf());
                pStmt.setObject(3, cli_clienteT.getCli_tx_rg());
                pStmt.setObject(4, cli_clienteT.getCli_tx_matricula());
                pStmt.setObject(5, cli_clienteT.getCli_tx_sexo());
                pStmt.setObject(6, cli_clienteT.getCli_tx_estadocivil());
                pStmt.setObject(7, cli_clienteT.getCli_tx_tipologradouro());
                pStmt.setObject(8, cli_clienteT.getCli_tx_logradouro());
                pStmt.setObject(9, cli_clienteT.getCli_tx_numero());
                pStmt.setObject(10, cli_clienteT.getCli_tx_cep());
                pStmt.setObject(11, cli_clienteT.getCli_tx_complemento());
                pStmt.setObject(12, cli_clienteT.getCli_tx_bairro());
                pStmt.setObject(13, cli_clienteT.getCli_tx_municipio());
                pStmt.setObject(14, cli_clienteT.getCli_tx_uf());
                pStmt.setObject(15, cli_clienteT.getCli_tx_email());
                pStmt.setObject(16, cli_clienteT.getCli_tx_telefone1());
                pStmt.setObject(17, cli_clienteT.getCli_tx_telefone2());
                pStmt.setObject(18, cli_clienteT.getCli_tx_celular());
                pStmt.setObject(19, cli_clienteT.getCli_tx_ramal());
                java.sql.Date dt20 = new java.sql.Date(cli_clienteT.getCli_dt_nascimento().getTime());
                pStmt.setObject(20, dt20);
//            pStmt.setObject(21, cli_clienteT.getCli_bt_foto());
                java.sql.Date dt21 = new java.sql.Date(System.currentTimeMillis());
                pStmt.setObject(21, dt21);
                pStmt.setObject(22, "S");
                pStmt.setObject(23, cli_clienteT.getCli_tx_salario_minimo());
                pStmt.execute();
                cli_clienteT.setCli_nr_id(maxId());
            }
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void update(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.cli_cliente set  cli_tx_nome=?, cli_tx_cpf=?, cli_tx_rg=?, cli_tx_matricula=?, cli_tx_sexo=?, cli_tx_estadocivil=?, cli_tx_tipologradouro=?, cli_tx_logradouro=?, cli_tx_numero=?, cli_tx_cep=?, cli_tx_complemento=?, cli_tx_bairro=?, cli_tx_municipio=?, cli_tx_uf=?, cli_tx_email=?, cli_tx_telefone1=?, cli_tx_telefone2=?, cli_tx_celular=?, cli_tx_ramal=?, cli_dt_nascimento=?, cli_bt_foto=?,  cli_tx_socio=?, mtc_nr_id=?, cli_tx_salario_minimo=? where  cli_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cli_clienteT.getCli_tx_nome());
            pStmt.setObject(2, cli_clienteT.getCli_tx_cpf());
            pStmt.setObject(3, cli_clienteT.getCli_tx_rg());
            pStmt.setObject(4, cli_clienteT.getCli_tx_matricula());
            pStmt.setObject(5, cli_clienteT.getCli_tx_sexo());
            pStmt.setObject(6, cli_clienteT.getCli_tx_estadocivil());
            pStmt.setObject(7, cli_clienteT.getCli_tx_tipologradouro());
            pStmt.setObject(8, cli_clienteT.getCli_tx_logradouro());
            pStmt.setObject(9, cli_clienteT.getCli_tx_numero());
            pStmt.setObject(10, cli_clienteT.getCli_tx_cep());
            pStmt.setObject(11, cli_clienteT.getCli_tx_complemento());
            pStmt.setObject(12, cli_clienteT.getCli_tx_bairro());
            pStmt.setObject(13, cli_clienteT.getCli_tx_municipio());
            pStmt.setObject(14, cli_clienteT.getCli_tx_uf());
            pStmt.setObject(15, cli_clienteT.getCli_tx_email());
            pStmt.setObject(16, cli_clienteT.getCli_tx_telefone1());
            pStmt.setObject(17, cli_clienteT.getCli_tx_telefone2());
            pStmt.setObject(18, cli_clienteT.getCli_tx_celular());
            pStmt.setObject(19, cli_clienteT.getCli_tx_ramal());
            java.sql.Date dt20 = new java.sql.Date(cli_clienteT.getCli_dt_nascimento().getTime());
            pStmt.setObject(20, dt20);
            pStmt.setObject(21, cli_clienteT.getCli_bt_foto());
            pStmt.setObject(22, cli_clienteT.getCli_tx_socio());
            pStmt.setObject(23, cli_clienteT.getMtc_nr_id());
            pStmt.setObject(24, cli_clienteT.getCli_tx_salario_minimo());
            pStmt.setObject(25, cli_clienteT.getCli_nr_id());
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

    public void updateNotImage(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.cli_cliente set  cli_tx_nome=?, cli_tx_cpf=?, cli_tx_rg=?, cli_tx_matricula=?, cli_tx_sexo=?, cli_tx_estadocivil=?, cli_tx_tipologradouro=?, cli_tx_logradouro=?, cli_tx_numero=?, cli_tx_cep=?, cli_tx_complemento=?, cli_tx_bairro=?, cli_tx_municipio=?, cli_tx_uf=?, cli_tx_email=?, cli_tx_telefone1=?, cli_tx_telefone2=?, cli_tx_celular=?, cli_tx_ramal=?, cli_dt_nascimento=?,  cli_tx_socio=?, mtc_nr_id=?, cli_tx_salario_minimo=?  where  cli_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cli_clienteT.getCli_tx_nome());
            pStmt.setObject(2, cli_clienteT.getCli_tx_cpf());
            pStmt.setObject(3, cli_clienteT.getCli_tx_rg());
            pStmt.setObject(4, cli_clienteT.getCli_tx_matricula());
            pStmt.setObject(5, cli_clienteT.getCli_tx_sexo());
            pStmt.setObject(6, cli_clienteT.getCli_tx_estadocivil());
            pStmt.setObject(7, cli_clienteT.getCli_tx_tipologradouro());
            pStmt.setObject(8, cli_clienteT.getCli_tx_logradouro());
            pStmt.setObject(9, cli_clienteT.getCli_tx_numero());
            pStmt.setObject(10, cli_clienteT.getCli_tx_cep());
            pStmt.setObject(11, cli_clienteT.getCli_tx_complemento());
            pStmt.setObject(12, cli_clienteT.getCli_tx_bairro());
            pStmt.setObject(13, cli_clienteT.getCli_tx_municipio());
            pStmt.setObject(14, cli_clienteT.getCli_tx_uf());
            pStmt.setObject(15, cli_clienteT.getCli_tx_email());
            pStmt.setObject(16, cli_clienteT.getCli_tx_telefone1());
            pStmt.setObject(17, cli_clienteT.getCli_tx_telefone2());
            pStmt.setObject(18, cli_clienteT.getCli_tx_celular());
            pStmt.setObject(19, cli_clienteT.getCli_tx_ramal());
            java.sql.Date dt20 = new java.sql.Date(cli_clienteT.getCli_dt_nascimento().getTime());
            pStmt.setObject(20, dt20);
            pStmt.setObject(21, cli_clienteT.getCli_tx_socio());
            pStmt.setObject(22, cli_clienteT.getMtc_nr_id());
            pStmt.setObject(23, cli_clienteT.getCli_tx_salario_minimo());
            pStmt.setObject(24, cli_clienteT.getCli_nr_id());
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

    public void delete(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from factory.cli_cliente where  cli_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cli_clienteT.getCli_nr_id());
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

    private List<Cli_clienteT> resultSetToObjectTransferImage(ResultSet rs) throws Exception {
        List<Cli_clienteT> objs = new Vector();
        while (rs.next()) {
            Cli_clienteT cli_clienteT = new Cli_clienteT();
            cli_clienteT.setCli_nr_id(rs.getInt("cli_nr_id"));
            cli_clienteT.setCli_tx_nome(rs.getString("cli_tx_nome"));
            cli_clienteT.setCli_tx_cpf(rs.getString("cli_tx_cpf"));
            cli_clienteT.setCli_tx_rg(rs.getString("cli_tx_rg"));
            cli_clienteT.setCli_tx_matricula(rs.getString("cli_tx_matricula"));
            cli_clienteT.setCli_tx_sexo(rs.getString("cli_tx_sexo"));
            cli_clienteT.setCli_tx_estadocivil(rs.getString("cli_tx_estadocivil"));
            cli_clienteT.setCli_tx_tipologradouro(rs.getString("cli_tx_tipologradouro"));
            cli_clienteT.setCli_tx_logradouro(rs.getString("cli_tx_logradouro"));
            cli_clienteT.setCli_tx_numero(rs.getString("cli_tx_numero"));
            cli_clienteT.setCli_tx_cep(rs.getString("cli_tx_cep"));
            cli_clienteT.setCli_tx_complemento(rs.getString("cli_tx_complemento"));
            cli_clienteT.setCli_tx_bairro(rs.getString("cli_tx_bairro"));
            cli_clienteT.setCli_tx_municipio(rs.getString("cli_tx_municipio"));
            cli_clienteT.setCli_tx_uf(rs.getString("cli_tx_uf"));
            cli_clienteT.setCli_tx_email(rs.getString("cli_tx_email"));
            cli_clienteT.setCli_tx_telefone1(rs.getString("cli_tx_telefone1"));
            cli_clienteT.setCli_tx_telefone2(rs.getString("cli_tx_telefone2"));
            cli_clienteT.setCli_tx_celular(rs.getString("cli_tx_celular"));
            cli_clienteT.setCli_tx_ramal(rs.getString("cli_tx_ramal"));
            cli_clienteT.setCli_dt_nascimento(rs.getDate("cli_dt_nascimento"));
            cli_clienteT.setCli_bt_foto(rs.getBytes("cli_bt_foto"));
            cli_clienteT.setCli_dt_cadastro(rs.getDate("cli_dt_cadastro"));
            cli_clienteT.setCli_tx_socio(rs.getString("cli_tx_socio"));
            cli_clienteT.setCli_tx_salario_minimo(rs.getString("cli_tx_salario_minimo"));
            cli_clienteT.setTmp_nr_id(rs.getInt("tmp_nr_id"));
            objs.add(cli_clienteT);
        }
        return objs;
    }

    private List<Cli_clienteT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Cli_clienteT> objs = new Vector();
        while (rs.next()) {
            Cli_clienteT cli_clienteT = new Cli_clienteT();
            cli_clienteT.setCli_nr_id(rs.getInt("cli_nr_id"));
            cli_clienteT.setCli_tx_nome(rs.getString("cli_tx_nome"));
            cli_clienteT.setCli_tx_cpf(rs.getString("cli_tx_cpf"));
            cli_clienteT.setCli_tx_rg(rs.getString("cli_tx_rg"));
            cli_clienteT.setCli_tx_matricula(rs.getString("cli_tx_matricula"));
            cli_clienteT.setCli_tx_sexo(rs.getString("cli_tx_sexo"));
            cli_clienteT.setCli_tx_estadocivil(rs.getString("cli_tx_estadocivil"));
            cli_clienteT.setCli_tx_tipologradouro(rs.getString("cli_tx_tipologradouro"));
            cli_clienteT.setCli_tx_logradouro(rs.getString("cli_tx_logradouro"));
            cli_clienteT.setCli_tx_numero(rs.getString("cli_tx_numero"));
            cli_clienteT.setCli_tx_cep(rs.getString("cli_tx_cep"));
            cli_clienteT.setCli_tx_complemento(rs.getString("cli_tx_complemento"));
            cli_clienteT.setCli_tx_bairro(rs.getString("cli_tx_bairro"));
            cli_clienteT.setCli_tx_municipio(rs.getString("cli_tx_municipio"));
            cli_clienteT.setCli_tx_uf(rs.getString("cli_tx_uf"));
            cli_clienteT.setCli_tx_email(rs.getString("cli_tx_email"));
            cli_clienteT.setCli_tx_telefone1(rs.getString("cli_tx_telefone1"));
            cli_clienteT.setCli_tx_telefone2(rs.getString("cli_tx_telefone2"));
            cli_clienteT.setCli_tx_celular(rs.getString("cli_tx_celular"));
            cli_clienteT.setCli_tx_ramal(rs.getString("cli_tx_ramal"));
            cli_clienteT.setCli_dt_nascimento(rs.getDate("cli_dt_nascimento"));
            cli_clienteT.setCli_dt_cadastro(rs.getDate("cli_dt_cadastro"));
            cli_clienteT.setCli_tx_socio(rs.getString("cli_tx_socio"));
            cli_clienteT.setTmp_nr_id(rs.getInt("tmp_nr_id"));
            cli_clienteT.setMtc_nr_id(rs.getInt("mtc_nr_id"));
            cli_clienteT.setCli_tx_salario_minimo(rs.getString("cli_tx_salario_minimo"));
            objs.add(cli_clienteT);
        }
        return objs;
    }

    private List<Cli_clienteT> resultSetToObjectTransferNovos(ResultSet rs) throws Exception {
        List<Cli_clienteT> objs = new Vector();
        while (rs.next()) {
            Cli_clienteT cli_clienteT = new Cli_clienteT();
            cli_clienteT.setCli_nr_id(rs.getInt("cli_nr_id"));
            cli_clienteT.setCli_tx_nome(rs.getString("cli_tx_nome"));
            cli_clienteT.setCli_tx_cpf(rs.getString("cli_tx_cpf"));
            cli_clienteT.setCli_tx_rg(rs.getString("cli_tx_rg"));
            cli_clienteT.setCli_tx_matricula(rs.getString("cli_tx_matricula"));
            cli_clienteT.setCli_tx_sexo(rs.getString("cli_tx_sexo"));
            cli_clienteT.setCli_tx_estadocivil(rs.getString("cli_tx_estadocivil"));
            cli_clienteT.setCli_tx_tipologradouro(rs.getString("cli_tx_tipologradouro"));
            cli_clienteT.setCli_tx_logradouro(rs.getString("cli_tx_logradouro"));
            cli_clienteT.setCli_tx_numero(rs.getString("cli_tx_numero"));
            cli_clienteT.setCli_tx_cep(rs.getString("cli_tx_cep"));
            cli_clienteT.setCli_tx_complemento(rs.getString("cli_tx_complemento"));
            cli_clienteT.setCli_tx_bairro(rs.getString("cli_tx_bairro"));
            cli_clienteT.setCli_tx_municipio(rs.getString("cli_tx_municipio"));
            cli_clienteT.setCli_tx_uf(rs.getString("cli_tx_uf"));
            cli_clienteT.setCli_tx_email(rs.getString("cli_tx_email"));
            cli_clienteT.setCli_tx_telefone1(rs.getString("cli_tx_telefone1"));
            cli_clienteT.setCli_tx_telefone2(rs.getString("cli_tx_telefone2"));
            cli_clienteT.setCli_tx_celular(rs.getString("cli_tx_celular"));
            cli_clienteT.setCli_tx_ramal(rs.getString("cli_tx_ramal"));
            cli_clienteT.setCli_dt_nascimento(rs.getDate("cli_dt_nascimento"));
            cli_clienteT.setCli_dt_cadastro(rs.getDate("cli_dt_cadastro"));
            cli_clienteT.setCli_tx_socio(rs.getString("cli_tx_socio"));
            cli_clienteT.setCli_tx_salario_minimo(rs.getString("cli_tx_salario_minimo"));
            objs.add(cli_clienteT);
        }
        return objs;
    }

    private List<Cli_clienteT> resultSetToObjectTransferRelCLi(ResultSet rs) throws Exception {
        List<Cli_clienteT> objs = new Vector();
        while (rs.next()) {
            Cli_clienteT cli_clienteT = new Cli_clienteT();
            cli_clienteT.setCli_nr_id(rs.getInt("cli_nr_id"));
            cli_clienteT.setCli_tx_nome(rs.getString("cli_tx_nome"));
            cli_clienteT.setCli_tx_cpf(rs.getString("cli_tx_cpf"));
            cli_clienteT.setCli_tx_telefone1(rs.getString("cli_tx_telefone1"));
            cli_clienteT.setCli_tx_telefone2(rs.getString("cli_tx_telefone2"));
            cli_clienteT.setCli_tx_celular(rs.getString("cli_tx_celular"));
            cli_clienteT.setCli_tx_matricula(rs.getString("cli_tx_matricula"));
            objs.add(cli_clienteT);
        }
        return objs;
    }

    private List<Cli_clienteT> resultSetToObjectTransferMasQueUmOrgao(ResultSet rs) throws Exception {
        List<Cli_clienteT> objs = new Vector();
        while (rs.next()) {
            Cli_clienteT cli_clienteT = new Cli_clienteT();
            cli_clienteT.setCli_nr_id(rs.getInt("cli_nr_id"));
            cli_clienteT.setCli_tx_nome(rs.getString("cli_tx_nome"));
            cli_clienteT.setCli_tx_cpf(rs.getString("cli_tx_cpf"));
            cli_clienteT.setCli_tx_matricula(rs.getString("cli_tx_matricula"));
            cli_clienteT.setOrgao(rs.getString("org_tx_nomefantasia"));
            objs.add(cli_clienteT);
        }
        return objs;
    }

    public List<Cli_clienteT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id, mtc_nr_id, cli_tx_salario_minimo from factory.cli_cliente";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Cli_clienteT> list = resultSetToObjectTransfer(rs);
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

    public List<Cli_clienteT> getAllRelCLi() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf,  cli_tx_matricula, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular from factory.cli_cliente";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Cli_clienteT> list = resultSetToObjectTransferRelCLi(rs);
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

    public List<Cli_clienteT> getSituacaoFinanceira(java.sql.Date data_ini, java.sql.Date data_fim, boolean inadimplentes, String tipo) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            sb.append(" select cli_nr_id, cli_tx_nome, cli_tx_cpf,  cli_tx_matricula, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular from factory.cli_cliente");
            sb.append(inadimplentes ? " where cli_nr_id in( " : " where cli_nr_id not in( ");
            sb.append(" select emp.cli_nr_id from factory.ple_parcelaemprestimo  ple inner join factory.emp_emprestimo emp  on ple.emp_nr_id = emp.emp_nr_id");
            sb.append(" where ple.ple_tx_tipo = ? and ple_dt_vencimento between ? and ? and ple_dt_pagamento is null group by 1) order by cli_tx_nome");

            pStmt = con.prepareStatement(sb.toString());
            pStmt.setObject(1, tipo);
            pStmt.setObject(2, data_ini);
            pStmt.setObject(3, data_fim);
            rs = pStmt.executeQuery();
            List<Cli_clienteT> list = resultSetToObjectTransferRelCLi(rs);
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

    public List<Cli_clienteT> getAllRelCLiCorretor() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf,  cli_tx_matricula, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular from factory.cli_cliente";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Cli_clienteT> list = resultSetToObjectTransferRelCLi(rs);
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

    public List<Cli_clienteT> getAllMalaDireta() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id, cli_tx_salario_minimo from factory.cli_cliente where cli_nr_id in(select cli_nr_id from factory.emp_emprestimo)";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Cli_clienteT> list = resultSetToObjectTransfer(rs);
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

    public List<Cli_clienteT> getAllMalaDiretaParcelas() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append(" select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id, cli_tx_salario_minimo from factory.cli_cliente");
            sql.append("  where cli_nr_id in(select distinct cli_nr_id from factory.emp_emprestimo emp inner join factory.ple_parcelaemprestimo ple ");
            sql.append("  on(ple.emp_nr_id = emp.emp_nr_id) where ple.ple_dt_vencimento <? and ple_dt_pagamento is null or ple.ple_dt_vencimento >? and ple_dt_pagamento is null)");
            pStmt = con.prepareStatement(sql.toString());
            pStmt.setObject(1, new java.sql.Date(System.currentTimeMillis()));
            pStmt.setObject(2, new java.sql.Date(System.currentTimeMillis()));
            rs = pStmt.executeQuery();
            List<Cli_clienteT> list = resultSetToObjectTransfer(rs);
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

    public List<Cli_clienteT> getAllOrgao(int org_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select cli.* from factory.cli_cliente cli inner join factory.orcl_orgao_cliente org on cli.cli_nr_id = org.cli_nr_id where org.org_nr_id = ?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, org_nr_id);
            rs = pStmt.executeQuery();
            List<Cli_clienteT> list = resultSetToObjectTransfer(rs);
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

    public List<Cli_clienteT> getAllMasDeUmOrgao() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select cli.cli_nr_id,cli.cli_tx_matricula, cli.cli_tx_nome, cli.cli_tx_cpf, org.org_tx_nomefantasia from factory.cli_cliente cli ");
            sql.append(" inner join factory.orcl_orgao_cliente org_cli on cli.cli_nr_id = org_cli.cli_nr_id ");
            sql.append(" inner join factory.org_orgao org on org_cli.org_nr_id = org.org_nr_id ");
            sql.append(" where cli.cli_nr_id in(select cli_nr_id from factory.orcl_orgao_cliente group by 1 having count(cli_nr_id) >1)");
            sql.append(" order by cli.cli_nr_id");
            pStmt = con.prepareStatement(sql.toString());
            rs = pStmt.executeQuery();
            List<Cli_clienteT> list = resultSetToObjectTransferMasQueUmOrgao(rs);
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

    public TreeMap<String, List<cli_casserpTemp>> getAllCliCasserp() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        TreeMap<String, List<cli_casserpTemp>> tree = new TreeMap<String, List<cli_casserpTemp>>();
        try {

            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id from casserp.c_liente";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            int i = 0;
            while (rs.next()) {
                i++;
                if (rs.getString("cpf") != null & rs.getString("orgao") != null & rs.getString("banco") != null) {
                    cli_casserpTemp temp = new cli_casserpTemp();
                    temp.setCpf(rs.getString("cpf"));
                    temp.setOrgao(rs.getInt("orgao"));
                    temp.setBanco(rs.getInt("banco"));
                    temp.setAgencia(rs.getString("agencia"));
                    temp.setConta(rs.getString("conta_c"));
                    String key = temp.getCpf();
                    if (i == 749) {
                        int a = 0;
                    }

                    List<cli_casserpTemp> list = tree.get(key);
                    if (list == null) {
                        List<cli_casserpTemp> lis = new Vector<cli_casserpTemp>();
                        lis.add(temp);
                        tree.put(key, lis);
                    } else {
                        list.add(temp);
                    }
                }
            }
            return tree;
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

    public List<Cli_clienteT> getByPK(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            String sql = "select * from factory.cli_cliente where  cli_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cli_clienteT.getCli_nr_id());
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

    public List<Cli_clienteT> getByCli_nr_id(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            String sql = "select * from factory.cli_cliente where  cli_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cli_clienteT.getCli_nr_id());
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

    public List<Cli_clienteT> getByCli_tx_nome(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id, mtc_nr_id, cli_tx_salario_minimo from factory.cli_cliente where  Upper(cli_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_nome() + '%');
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

    public List<Cli_clienteT> getClienteIdadeAcima(int idade) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.cli_cliente where  extract (year from (age(cli_dt_nascimento))) > ?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, idade);
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

    public List<Cli_clienteT> getAniversariantes(int mes) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select *  from factory.cli_cliente where extract(month from cli_dt_nascimento) = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, mes);
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

    public List<Cli_clienteT> getByCli_tx_cpf(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id, mtc_nr_id, cli_tx_salario_minimo from factory.cli_cliente where  Upper(cli_tx_cpf) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_cpf() + '%');
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

    public List<Cli_clienteT> getByCli_tx_rg(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id, cli_tx_salario_minimo from factory.cli_cliente where  Upper(cli_tx_rg) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_rg() + '%');
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

    public List<Cli_clienteT> getByCli_tx_matricula(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id, mtc_nr_id, cli_tx_salario_minimo from factory.cli_cliente where  Upper(cli_tx_matricula) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_matricula() + '%');
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

    public List<Cli_clienteT> getByCli_tx_sexo(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id, cli_tx_salario_minimo from factory.cli_cliente where  Upper(cli_tx_sexo) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_sexo() + '%');
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

    public List<Cli_clienteT> getByCli_tx_estadocivil(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id, cli_tx_salario_minimo from factory.cli_cliente where  Upper(cli_tx_estadocivil) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_estadocivil() + '%');
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

    public List<Cli_clienteT> getByCli_tx_tipologradouro(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id, cli_tx_salario_minimo from factory.cli_cliente where  Upper(cli_tx_tipologradouro) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_tipologradouro() + '%');
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

    public List<Cli_clienteT> getByCli_tx_logradouro(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id, cli_tx_salario_minimo from factory.cli_cliente where  Upper(cli_tx_logradouro) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_logradouro() + '%');
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

    public List<Cli_clienteT> getByCli_tx_numero(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id,cli_tx_salario_minimo from factory.cli_cliente where  Upper(cli_tx_numero) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_numero() + '%');
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

    public List<Cli_clienteT> getByCli_tx_cep(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id, cli_tx_salario_minimo from factory.cli_cliente where  Upper(cli_tx_cep) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_cep() + '%');
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

    public List<Cli_clienteT> getByCli_tx_complemento(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id, cli_tx_salario_minimo from factory.cli_cliente where  Upper(cli_tx_complemento) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_complemento() + '%');
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

    public List<Cli_clienteT> getByCli_tx_bairro(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id, cli_tx_salario_minimo from factory.cli_cliente where  Upper(cli_tx_bairro) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_bairro() + '%');
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

    public List<Cli_clienteT> getByCli_tx_municipio(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id,cli_tx_salario_minimo from factory.cli_cliente where  Upper(cli_tx_municipio) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_municipio() + '%');
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

    public List<Cli_clienteT> getByCli_tx_uf(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id,cli_tx_salario_minimo from factory.cli_cliente where  Upper(cli_tx_uf) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_uf() + '%');
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

    public List<Cli_clienteT> getByCli_tx_email(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id, cli_tx_salario_minimo from factory.cli_cliente where  Upper(cli_tx_email) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_email() + '%');
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

    public List<Cli_clienteT> getByCli_tx_telefone1(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id,cli_tx_salario_minimo from factory.cli_cliente where  Upper(cli_tx_telefone1) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_telefone1() + '%');
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

    public List<Cli_clienteT> getByCli_tx_telefone2(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id, cli_tx_salario_minimo from factory.cli_cliente where  Upper(cli_tx_telefone2) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_telefone2() + '%');
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

    public List<Cli_clienteT> getByCli_tx_celular(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id, cli_tx_salario_minimo from factory.cli_cliente where  Upper(cli_tx_celular) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_celular() + '%');
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

    public List<Cli_clienteT> getByCli_tx_ramal(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id, cli_tx_salario_minimo from factory.cli_cliente where  Upper(cli_tx_ramal) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_ramal() + '%');
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

    public List<Cli_clienteT> getByCli_dt_nascimento(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id, cli_tx_salario_minimo from factory.cli_cliente where  cli_dt_nascimento = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(cli_clienteT.getCli_dt_nascimento().getTime());
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

    public List<Cli_clienteT> getByCli_bt_foto(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id, cli_tx_salario_minimo from factory.cli_cliente where  cli_bt_foto = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cli_clienteT.getCli_bt_foto());
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
    //2011134824901

    public List<Cli_clienteT> getByCli_dt_cadastro(java.util.Date inicio, java.util.Date fim) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            java.sql.Date dt_ini = new java.sql.Date(inicio.getTime());
            java.sql.Date dt_fim = new java.sql.Date(fim.getTime());
            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id, cli_tx_salario_minimo from factory.cli_cliente where  cli_dt_cadastro between ? and ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, dt_ini);
            pStmt.setObject(2, dt_fim);
            rs = pStmt.executeQuery();

            return resultSetToObjectTransferNovos(rs);

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

    public List<Cli_clienteT> getByCli_tx_socio(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id, cli_tx_salario_minimo from factory.cli_cliente where  Upper(cli_tx_socio) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_socio() + '%');
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

    public List<Cli_clienteT> getCamposCriterios(String criterios) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {

            String sql = "select cli_nr_id, cli_tx_nome, cli_tx_cpf, cli_tx_rg, cli_tx_matricula, cli_tx_sexo, cli_tx_estadocivil, cli_tx_tipologradouro, cli_tx_logradouro, cli_tx_numero, cli_tx_cep, cli_tx_complemento, cli_tx_bairro, cli_tx_municipio, cli_tx_uf, cli_tx_email, cli_tx_telefone1, cli_tx_telefone2, cli_tx_celular, cli_tx_ramal, cli_dt_nascimento, cli_bt_foto, cli_dt_cadastro, cli_tx_socio, tmp_nr_id, mtc_nr_id, cli_tx_salario_minimo from factory.cli_cliente ";
            sql += " where " + criterios;
            System.out.println(sql);
            pStmt = con.prepareStatement(sql);
            if (criterios.indexOf("?") > -1) {
                pStmt.setObject(1, new java.sql.Date(System.currentTimeMillis()));
            }
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