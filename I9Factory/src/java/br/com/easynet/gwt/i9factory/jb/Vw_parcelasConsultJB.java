package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.sound.midi.Soundbank;

/**
 * Classe Criada Automaticamente pelo "EasyNet Generate JDragon"
 */
public class Vw_parcelasConsultJB extends SystemBase {

    // Atributos e propriedades
    private Vw_parcelasT vw_parcelasT = new Vw_parcelasT();
    private int cli_nr_id;
    private String dt_inicio;
    private String dt_fim;
    private String status;
    private String dtEnvio;
    private String id_orgaos;

    public void setVw_parcelasT(Vw_parcelasT vw_parcelasT) {
        this.vw_parcelasT = vw_parcelasT;
    }

    public Vw_parcelasT getVw_parcelasT() {
        return vw_parcelasT;
    }
    private List<Vw_parcelasT> list;

    public List<Vw_parcelasT> getList() {
        return list;
    }

    public void setList(List<Vw_parcelasT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void consult() throws Exception {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date inicio = format.parse(dt_inicio);
            Date fim = format.parse(dt_fim);
            Vw_parcelasDAO vw_parcelasDAO = getVw_parcelasDAO();
            if (vw_parcelasT.getPle_tx_tipo().equalsIgnoreCase("G")) {
                list = vw_parcelasDAO.getAll(vw_parcelasT, inicio, fim, status);
            } else {
                list = vw_parcelasDAO.getByPle_tx_tipo(vw_parcelasT, inicio, fim, status);
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }
    
    

    public void consultarParcelasRemessa() throws Exception {
        try {
            id_orgaos = id_orgaos.replace("-", ",");
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            list = getVw_parcelasDAO().getByRemessaBanco(vw_parcelasT, id_orgaos);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultarComissao() throws Exception {
        try {
        } catch (Exception e) {
        }
    }

//    public void gerarNovasMensalidade() {
//        try {
//            Vw_parcelasDAO vdao = getVw_parcelasDAO();
//            java.util.Date d_i = new java.util.Date();
//            SimpleDateFormat sdfAno = new SimpleDateFormat("yyyy");
//            SimpleDateFormat sdfDias = new SimpleDateFormat("dd");
//            SimpleDateFormat sdfdate = new SimpleDateFormat("dd/MM/yyyy");
//            int anoAtual = Integer.parseInt(sdfAno.format(d_i));            
//            
//            for (int i = 9; i < 13; i++) {
//                list = vdao.getBydecimaSegunda(i, anoAtual);
//                System.out.println("mes = " +i+ " anoAtual = "+anoAtual);
//                if(i==12){
//                    int s =2;
//                }
//                if (list != null) {
//                    for (Vw_parcelasT parcelasT : list) {
//                        int ano = anoAtual;
//                        System.out.println("ano iniciado " + ano);
//                        if(parcelasT.getCli_nr_id() == 1138){
//                            int a = 3;
//                        }
//                        List<Vw_parcelasT> existePar = getVw_parcelasDAO().existeMensalidadesFuturas(parcelasT.getCli_nr_id(), i - 1, ano + 1);
//                        if (existePar == null) {
//                            Emp_emprestimoT emp_emprestimoT = new Emp_emprestimoT();
//                            emp_emprestimoT.setEmp_nr_id(parcelasT.getEmp_nr_id());
//                            emp_emprestimoT = getEmp_emprestimoDAO().getByEmp_nr_id(emp_emprestimoT).get(0);
//                            emp_emprestimoT.setCli_nr_id(parcelasT.getCli_nr_id());
//                            emp_emprestimoT.setEmp_dt_aprovacao(new Date());
//                            emp_emprestimoT.setEmp_dt_liberacao(new Date());
//                            emp_emprestimoT.setEmp_dt_emprestimo(new Date());
//                            
//                            int proposta = getEmp_emprestimoDAO().maxPropostaCli(parcelasT.getCli_nr_id());
//                            
//                            emp_emprestimoT.setEmp_nr_proposta(proposta);
//                            
//                            emp_emprestimoT.setEmp_nr_valor(parcelasT.getEmp_nr_valor());
//                            emp_emprestimoT.setEmp_nr_valor_afin_bruto(parcelasT.getEmp_nr_valor() * 12);
//                            emp_emprestimoT.setEmp_nr_valor_afin_liquido(parcelasT.getEmp_nr_valor() * 12);
//                            emp_emprestimoT.setEmp_tx_observacoes("Geração Mensalidades automática");
//                            emp_emprestimoT.setEmp_tx_status("A");
//                            emp_emprestimoT.setIdc_nr_id(4);
//                            emp_emprestimoT.setUsu_nr_id(getUsuarioLogado().getUsu_nr_id());
//
//                            emp_emprestimoT.setOrg_nr_id(parcelasT.getOrg_nr_id());
//                            getEmp_emprestimoDAO().insert(emp_emprestimoT);
//
//                            int mesini = i;
//                            for (int cont = 1; cont < 13; cont++) {
//                                mesini++;
//                                if (mesini > 12) {
//                                    mesini = 1;
//                                    ano++;
//                                }
//                                System.out.println("ano par "+ano);
//                                Ple_parcelaemprestimoT ple_parcelaemprestimoT = new Ple_parcelaemprestimoT();
//                                ple_parcelaemprestimoT.setEmp_nr_id(emp_emprestimoT.getEmp_nr_id());
//                                
//                                String dia = sdfDias.format(parcelasT.getPle_dt_vencimento());
//                                String vencimento = dia+"/"+Funcoes.formatarFloat("00", mesini)+"/"+ano;
//                                
//                                ple_parcelaemprestimoT.setPle_dt_vencimento(sdfdate.parse(vencimento));
//                                ple_parcelaemprestimoT.setPle_nr_valorparcela(parcelasT.getPle_nr_valorparcela());
//                                ple_parcelaemprestimoT.setPle_tx_historico("Geração automátiva");
//                                ple_parcelaemprestimoT.setPle_tx_parcela(Funcoes.formatarFloat("00", cont) + "12");
//                                ple_parcelaemprestimoT.setPle_tx_tipo("M");
//                                getPle_parcelaemprestimoDAO().insert(ple_parcelaemprestimoT);
//                            }
//                        }
//                    }
//                }
//            }
//
//            System.out.println("ok, gerado");
//setMsg("Operação realizada com sucesso!");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally{
//            close();
//        }
//    }

    public void consultar_11_Mensalidade() throws Exception {
        try {
            Vw_parcelasDAO vdao = getVw_parcelasDAO();
            vw_parcelasT.setPle_tx_parcela("12/12");
            list = vdao.getByPle_tx_parcela(vw_parcelasT);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }

    public void delete() throws Exception {
        try {
            Vw_parcelasDAO vw_parcelasDAO = getVw_parcelasDAO();
            vw_parcelasDAO.delete(vw_parcelasT);
            setMsg("Exclusao efetuada com sucesso!");
            vw_parcelasT = new Vw_parcelasT();
            consult();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar exclusao!");
        } finally {
            close();
        }
    }

    public void insert() throws Exception {
        // TODO Insert
        try {
            String page = "vw_parcelasInsert.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the cli_nr_id
     */
    public int getCli_nr_id() {
        return cli_nr_id;
    }

    /**
     * @param cli_nr_id the cli_nr_id to set
     */
    public void setCli_nr_id(int cli_nr_id) {
        this.cli_nr_id = cli_nr_id;
    }

    /**
     * @return the dt_inicio
     */
    public String getDt_inicio() {
        return dt_inicio;
    }

    /**
     * @param dt_inicio the dt_inicio to set
     */
    public void setDt_inicio(String dt_inicio) {
        this.dt_inicio = dt_inicio;
    }

    /**
     * @return the dt_fim
     */
    public String getDt_fim() {
        return dt_fim;
    }

    /**
     * @param dt_fim the dt_fim to set
     */
    public void setDt_fim(String dt_fim) {
        this.dt_fim = dt_fim;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the dtEnvio
     */
    public String getDtEnvio() {
        return dtEnvio;
    }

    /**
     * @param dtEnvio the dtEnvio to set
     */
    public void setDtEnvio(String dtEnvio) {
        this.dtEnvio = dtEnvio;
    }

    /**
     * @return the id_orgaos
     */
    public String getId_orgaos() {
        return id_orgaos;
    }

    /**
     * @param id_orgaos the id_orgaos to set
     */
    public void setId_orgaos(String id_orgaos) {
        this.id_orgaos = id_orgaos;
    }

}
