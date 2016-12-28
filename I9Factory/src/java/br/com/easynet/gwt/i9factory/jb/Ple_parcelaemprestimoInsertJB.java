package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;

/**
 * Classe Criada Automaticamente pelo "EasyNet Generate JDragon"
 */
public class Ple_parcelaemprestimoInsertJB extends SystemBase {

    // Atributos e propriedades
    private Ple_parcelaemprestimoT ple_parcelaemprestimoT = new Ple_parcelaemprestimoT();
    private TreeMap<Integer,Integer> treeIdsGerados = new TreeMap<Integer, Integer>();

    public void setPle_parcelaemprestimoT(Ple_parcelaemprestimoT ple_parcelaemprestimoT) {
        this.ple_parcelaemprestimoT = ple_parcelaemprestimoT;
    }

    public Ple_parcelaemprestimoT getPle_parcelaemprestimoT() {
        return ple_parcelaemprestimoT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //

    }

    // Metodo de Eventos
    public void insert() throws Exception {

        try {
            Ple_parcelaemprestimoDAO ple_parcelaemprestimoDAO = getPle_parcelaemprestimoDAO();
            ple_parcelaemprestimoDAO.insert(ple_parcelaemprestimoT);
            setMsg(INFO, "Cadastro efetuado com sucesso!");
            clear();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar cadastro!");
        } finally {
            close();
        }
    }

    public void gerarNovasMensalidade() {
        try {
            Vw_parcelasDAO vdao = getVw_parcelasDAO();
            java.util.Date d_i = new java.util.Date();
            SimpleDateFormat sdfAno = new SimpleDateFormat("yyyy");
            SimpleDateFormat sdfDias = new SimpleDateFormat("dd");
            SimpleDateFormat sdfMes = new SimpleDateFormat("MM");
            SimpleDateFormat sdfdate = new SimpleDateFormat("dd/MM/yyyy");
            int anoAtual = Integer.parseInt(sdfAno.format(d_i));
            int mesAtual = Integer.parseInt(sdfMes.format(d_i));

            //for (int i = 9; i < 13; i++) {
                List<Vw_parcelasT> list = vdao.getBydecimaSegunda(mesAtual, anoAtual);
                if (list != null) {
                    
                    for (Vw_parcelasT parcelasT : list) {
                        int ano = anoAtual;
//                        System.out.println("ano iniciado " + ano);
                        if(parcelasT.getCli_nr_id() == 1056){
                            int a = 1;
                           
                        }

                        List<Vw_parcelasT> existePar = getVw_parcelasDAO().existeMensalidadesFuturas(parcelasT.getCli_nr_id(), mesAtual - 1, anoAtual + 1);
                        if (existePar == null) {
//                            System.out.println(parcelasT.getCli_tx_nome());
                            Emp_emprestimoT emp_emprestimoT = new Emp_emprestimoT();
                            emp_emprestimoT.setEmp_nr_id(parcelasT.getEmp_nr_id());
                            emp_emprestimoT = getEmp_emprestimoDAO().getByEmp_nr_id(emp_emprestimoT).get(0);
                            emp_emprestimoT.setCli_nr_id(parcelasT.getCli_nr_id());
                            emp_emprestimoT.setEmp_dt_aprovacao(new Date());
                            emp_emprestimoT.setEmp_dt_liberacao(new Date());
                            emp_emprestimoT.setEmp_dt_emprestimo(new Date());

                            int proposta = getEmp_emprestimoDAO().maxPropostaCli(parcelasT.getCli_nr_id());

                            emp_emprestimoT.setEmp_nr_proposta(proposta+1);

                            emp_emprestimoT.setEmp_nr_valor(parcelasT.getPle_nr_valorparcela()*12);
                            emp_emprestimoT.setEmp_nr_valor_afin_bruto(parcelasT.getPle_nr_valorparcela() * 12);
                            emp_emprestimoT.setEmp_nr_valor_afin_liquido(parcelasT.getPle_nr_valorparcela() * 12);
                            emp_emprestimoT.setEmp_tx_observacoes("Geração Mensalidades automática");
                            emp_emprestimoT.setEmp_tx_status("A");
                            emp_emprestimoT.setIdc_nr_id(4);
                            emp_emprestimoT.setUsu_nr_id(getUsuarioLogado().getUsu_nr_id());

                            emp_emprestimoT.setOrg_nr_id(parcelasT.getOrg_nr_id());
                            getEmp_emprestimoDAO().insert(emp_emprestimoT);

                            int mesini = mesAtual;
                            for (int cont = 1; cont < 13; cont++) {
                                mesini++;
                                if (mesini > 12) {
                                    mesini = 1;
                                    ano++;
                                }
//                                System.out.println("ano par " + ano +" cont = "+cont);
                                Ple_parcelaemprestimoT ple_parcelaemprestimoT = new Ple_parcelaemprestimoT();
                                ple_parcelaemprestimoT.setEmp_nr_id(emp_emprestimoT.getEmp_nr_id());

                                String dia = sdfDias.format(parcelasT.getPle_dt_vencimento());
                                String vencimento = dia + "/" + Funcoes.formatarFloat("00", mesini) + "/" + ano;

                                ple_parcelaemprestimoT.setPle_dt_vencimento(sdfdate.parse(vencimento));
                                ple_parcelaemprestimoT.setPle_nr_valorparcela(parcelasT.getPle_nr_valorparcela());
                                ple_parcelaemprestimoT.setPle_tx_historico("Geração automátiva");
                                ple_parcelaemprestimoT.setPle_tx_parcela(Funcoes.formatarFloat("00", cont) + "12");
                                ple_parcelaemprestimoT.setPle_tx_tipo("M");
                                getPle_parcelaemprestimoDAO().insert(ple_parcelaemprestimoT);
                            }
                        }
                    }
                }
//            }

            System.out.println("ok, gerado");
            setMsg("Operação realizada com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
// Method de lookup
// 
    private List<Emp_emprestimoT> listemp_emprestimo;

    public List<Emp_emprestimoT> getListemp_emprestimo() {
        return listemp_emprestimo;
    }

    public void setListemp_emprestimo(List<Emp_emprestimoT> list) {
        this.listemp_emprestimo = list;
    }

    public void clear() throws Exception {

        ple_parcelaemprestimoT = new Ple_parcelaemprestimoT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "ple_parcelaemprestimoConsult.jsp";// defina aqui a pagina que deve ser chamada  
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
