/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.i9factory.relatorio.print_emprestimo;
 
import br.com.easynet.easyportal.transfer.Usu_usuarioT;
import br.com.easynet.gwt.i9factory.jb.Funcoes;
import br.com.easynet.gwt.i9factory.relatorio.RelatorioBase;
import br.com.easynet.gwt.i9factory.transfer.Cli_clienteT;
import br.com.easynet.gwt.i9factory.transfer.Dep_dependenteT;
import br.com.easynet.gwt.i9factory.transfer.Emp_emprestimoT;
import br.com.easynet.gwt.i9factory.transfer.Ple_parcelaemprestimoT;
import br.com.easynet.gwt.i9factory.transfer.Ref_referenciaT;
import br.com.easynet.gwt.i9factory.transfer.Tmp_tipomensalidadeT;
import br.com.easynet.gwt.i9factory.transfer.Vw_parcelasT;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcoa
 */
public class Print_emprestimo extends RelatorioBase {

    private List<Vw_parcelasT> list;
    private Emp_emprestimoT emp_emprestimoT = new Emp_emprestimoT();
    private Cli_clienteT cli_clienteT = new Cli_clienteT();
    private List<Dep_dependenteT> listDp = new ArrayList<Dep_dependenteT>();
    private Dep_dependenteT dep_dependenteT = new Dep_dependenteT();
    private Ref_referenciaT ref_referenciaT = new Ref_referenciaT();
    private List<Ref_referenciaT> listRef = new ArrayList<Ref_referenciaT>();
    private List<Ple_parcelaemprestimoT> listParcelas = new ArrayList<Ple_parcelaemprestimoT>();
    private Tmp_tipomensalidadeT t;
    private double vl_ultima_men;

    
    public void imprimir() {
        try {
//"/home/marcoa/projetos/I9Factory/src/java/br/com/easynet/gwt/i9factory/relatorio/print_emprestimo/"
            list = getVw_parcelasDAO().getByEmp_nr_idAll(emp_emprestimoT);
            emp_emprestimoT = getEmp_emprestimoDAO().getByPK(emp_emprestimoT).get(0);
            cli_clienteT.setCli_nr_id(emp_emprestimoT.getCli_nr_id());
            cli_clienteT = getCli_clienteDAO().getByCli_nr_id(cli_clienteT).get(0);
            cli_clienteT.setCli_tx_logradouro(cli_clienteT.getCli_tx_tipologradouro() + ", " + cli_clienteT.getCli_tx_logradouro());
            ref_referenciaT.setCli_nr_id(cli_clienteT.getCli_nr_id());
            listRef = getRef_referenciaDAO().getByCli_cliente(ref_referenciaT);
            dep_dependenteT.setCli_nr_id(cli_clienteT.getCli_nr_id());
            listDp = getDep_dependenteDAO().getByCli_cliente(dep_dependenteT);
            jRDataSource = new JRBeanCollectionDataSource(list);

            Vw_parcelasT vw_parcelasT = new Vw_parcelasT();
            List<Vw_parcelasT> lstpar = getVw_parcelasDAO().getByValorMen(cli_clienteT.getCli_nr_id());
            if(lstpar != null){
                vl_ultima_men = lstpar.get(0).getPle_nr_valorparcela();
            }
           

            if (!getTipo().equalsIgnoreCase("XLS")) {
                is = Print_emprestimo.class.getResourceAsStream("print_emprestimo2.jasper");
            } else {
                url = Print_emprestimo.class.getResource("print_emprestimo2.jasper");
            }
            
            SimpleDateFormat formatdia = new SimpleDateFormat("dd");
            SimpleDateFormat formatmes = new SimpleDateFormat("MM");
            SimpleDateFormat formatano = new SimpleDateFormat("yyyy");

            String dia = formatdia.format(emp_emprestimoT.getEmp_dt_emprestimo());
            String mes = formatmes.format(emp_emprestimoT.getEmp_dt_emprestimo());
            String ano = formatano.format(emp_emprestimoT.getEmp_dt_emprestimo());
            String data = "Aracaju,SE " + Funcoes.formatarFloat("00", Integer.parseInt(dia));
            data += " de " + getMesExtenso(Integer.parseInt(mes));
            data += " de " + ano;
            if (emp_emprestimoT.getEmp_nr_proposta() == 1) {
                getParameters().put("novo", "X");
            } else {
                getParameters().put("renovacao", "X");
            }
            getParameters().put("complemento_endereco", cli_clienteT.getCli_tx_complemento());
            getParameters().put("primeiro_pagamento", list.get(0).getPle_dt_vencimento());

            getParameters().put("data", data);
            getParameters().put("convenio", "103 e 104");
            getParameters().put("quant_debitos", "Conforme Planos");

            String path = application.getRealPath("/jasper/verso_emprestimo.jasper");
            path = path.substring(0, path.indexOf("verso"));
            System.out.println(path);
            
            getParameters().put("SUBREPORT_DIR", path);
            getParameters().put("identificador", cli_clienteT.getCli_tx_cpf());
            getParameters().put("testo_plano", getTestoPlano());
            getParameters().put("testo_debito", getTestodebito());
            url = Print_emprestimo.class.getResource("logomarca.jpg");
            getParameters().put("pathlogoSistema", url.toString());
            setParamRef();
            setParamDependente();
            setParamMensalidade();
            getParameters().put("valor_emp", emp_emprestimoT.getEmp_nr_valor());
            getParameters().put("inicio", getInicio());
            getParameters().put("testo_confissao", getTestoConfissao());

            print("emprestimo", "");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }
    
    public String getInicio(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
        String mes = dateFormat.format(list.get(0).getPle_dt_vencimento());
        dateFormat = new SimpleDateFormat("yyyy");
        mes += "/"+dateFormat.format(list.get(0).getPle_dt_vencimento());
        return mes;
    }

    public void setParamMensalidade() {

        double valor = 0;
        double men = 0;
        int numero_par = 0;
        int numero_men = 0;
        for (Vw_parcelasT par : list) {
            par.setCli_tx_logradouro(cli_clienteT.getCli_tx_tipologradouro() + " " + par.getCli_tx_logradouro());
            if (par.getPle_tx_tipo().equalsIgnoreCase("M")) {
                men = par.getPle_nr_valorparcela();
                numero_men++;
            } else {
                valor = par.getPle_nr_valorparcela();
                numero_par++;
            }
        }

        
        getParameters().put("mensalidade", vl_ultima_men);
        getParameters().put("aux_financeiro", valor);
        getParameters().put("numero_par_men", 999);
        getParameters().put("numero_par", numero_par);
        

    }

    public void setParamDependente() {
        int c = 1;
        for (Dep_dependenteT dep : listDp) {
            if (c < 3) {
                getParameters().put("dependente" + c, dep.getDep_tx_nome());
                getParameters().put("parentesco" + c, dep.getDep_tx_grauparentesco());
                c++;
            }
        }

    }

    public void setParamRef() {
        int c = 1;
        for (Ref_referenciaT ref : listRef) {
            if (c < 3) {
                getParameters().put("referencia" + c, ref.getRef_tx_nome());
                getParameters().put("fone_ref" + c, ref.getRef_tx_telefone() != null ? ref.getRef_tx_telefone() : "" + " - " + ref.getRef_tx_celular() != null ? ref.getRef_tx_celular() : "");
                c++;
            }
        }

    } 

    public String getTestoPlano() {
        StringBuffer sb = new StringBuffer();
        sb.append("Ílmo __________________________________________________, eu ").append(getSr());

//        sb.append(", eu " + getUser());
        sb.append(", funcionário no verso qualificado, sirvo-me desta para autorizar a consignação em folha ou débito");
        sb.append(" em conta corrente dos valores acima indicados a favor da CASSERP - Caixa de assistência, sendo que estes descontos");
        sb.append(" somente poderão ser cancelados por minha solicitação e devidamente obonado pela CASSERP. Em tempo autorizo também ");
        sb.append(" em caso de inadimplência a CASEERP a refinanciar o meu saldo devedor nos valores a prazos possíveis de acordo com o que ");
        sb.append("a minha margem permitir, acrescido de juros e correção por ela praticados quando do refinanceamento.");
        return sb.toString();
    }

    public String getTestodebito() {
        StringBuffer sb = new StringBuffer();
        sb.append("AO BANCO BANESE S/A AGÊNCIA 058\n");
        sb.append("1 - Pelo presente instrumento, firmado em caracter irrevogavél autorizo a cadastrar e debitar em minha conta corrente as obrigações em favor da CASSERP - Caixa de Assistência, somente se houver previsões suficientes. \n");
        sb.append("2 - Comprometo-me, desde já, a manter saldo suficiente para a finalidade, ficando o Banco isento de qualquer responsabilidade caso a conta não comporte o valor do documento a liquidar.\n");
        sb.append("3 - A não quitação do compromisso na data doINFO vencimento dará o direito à CASSERP -Caixa de Assistência, a repetir o débito no prazo que achar oportuna, acrescidos de juros e encargos que houver, como também a refinanciar o saldo.\n");
        sb.append("4 - Declaro estar ciente que só poderei cancelar os débitos diretamente ao Banco, após o cumprimento total das minhas obrigações, autorizo desde já o setor Pessoal de minha repartição pagadora e/ou agẽncia do convênio a fornecer o novo número como também a transferir todos os débitos para a nova conta.\n");
        sb.append("5 - Em caso de cancelamento desta autorização junto ao Banco, o devedor será responsabilizado criminalmente de acordo com o artigo 171 do código Penal Brasileiro(obter para si, ou para outro meio fraudulento).\n");
        sb.append("*Paragrafo único: caso haja inobservância quanto ao item citado acima, a CASEERP - Caixa de Assistência, ingressará imediatamente com a Ação Penal própria por pratica de estelionato.\n");
        
        return sb.toString();
    }
    public String getTestoConfissao(){
        StringBuffer sb = new StringBuffer();
        sb.append("1.0 - Por este instrumento e da melhor forma de direito, declaro dever a importância aqui registrada, responsabilizando-me pela liquidação do valor confessado, de acordo com a programação aprovada na proposta de adesão de sócio da CASSERP. \n\n");
        sb.append("1.1 - Como fiel depositário do valor de assistência recebida nesta data, comprometo-me restituir integralmente, no prazo por min programado, estando ciente que o mesmo pertence a constituição das Reservas Técnicas dos planos de Benefícios do quadro de associados CASSERP, do qual sou participante. \n\n");
        sb.append("1.2 Como garantia da liquidação deste crédito, autorizo, em caráter irrevogavél, a consignação em folha de pagamento junto à minha fonte pagadora e/ou o débito em minha conta corrente, ficando desde já autorizados a debitar o valor das parcelas, a cada vencimento, em favor da CASSERP, até a sua liquidação total, mediante abono neste instrumento.\n\n");
        sb.append("1.3 - Para fiel cumprimento desta Confissão de Dívida, firmo o presente em três vias, ficando a CASSERP com o privilégio da escolha do Foro Jurídico para fazer cumprir este instrumento em defesa dos direitos do Quadro de Associados participantes dos Planos de Assistência CASSERP.");
        return sb.toString();
    }
    
    
    public String getUser() {

        Usu_usuarioT usu = getUsuarioLogado();
        return usu.getUsu_tx_nome();

    }

    public String getSr() {
        return cli_clienteT.getCli_tx_nome();
    }

    /**
     * @return the emp_emprestimoT
     */
    public Emp_emprestimoT getEmp_emprestimoT() {
        return emp_emprestimoT;
    }

    public String getMesExtenso(int mes) {
        String strmes = "";
        switch (mes) {
            case 1:
                strmes = "Janeiro";
                break;
            case 2:
                strmes = "Fevereiro";
                break;
            case 3:
                strmes = "Março";
                break;
            case 4:
                strmes = "Abril";
                break;
            case 5:
                strmes = "Maio";
                break;
            case 6:
                strmes = "Junho";
                break;
            case 7:
                strmes = "Julho";
                break;
            case 8:
                strmes = "Agosto";
                break;
            case 9:
                strmes = "Setembro";
                break;
            case 10:
                strmes = "Outubro";
                break;
            case 11:
                strmes = "Novembro";
                break;
            case 12:
                strmes = "Dezembro";
                break;
            default:
                return "null";
        }
        return strmes;
    }

    /**
     * @param emp_emprestimoT the emp_emprestimoT to set
     */
    public void setEmp_emprestimoT(Emp_emprestimoT emp_emprestimoT) {
        this.emp_emprestimoT = emp_emprestimoT;
    }
}
