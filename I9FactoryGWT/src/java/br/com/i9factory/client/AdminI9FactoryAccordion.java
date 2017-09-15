/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client;

import br.com.easyportal.gwt.client.accordionModel.AMenuHandlerAccordion;
import br.com.i9factory.client.i9factory.factory.age_agenciador.Age_agenciadorConsultGWT;
import br.com.i9factory.client.i9factory.factory.arb_arquivobanco.Arb_arquivobancoConsultGWT;
 
import br.com.i9factory.client.i9factory.factory.bco_banco.Bco_bancoConsultGWT;
import br.com.i9factory.client.i9factory.factory.car_cartao.Car_cartaoConsultGWT;
import br.com.i9factory.client.i9factory.factory.cli_cliente.Cli_clienteConsultGWT;
import br.com.i9factory.client.i9factory.factory.cor_corretora.Cor_corretoraConsultGWT;
import br.com.i9factory.client.i9factory.factory.ctp_conta_pagar.Ctp_conta_pagarConsultGWT;
import br.com.i9factory.client.i9factory.factory.emp_emprestimo.Emp_emprestimoConsultGWT;
import br.com.i9factory.client.i9factory.factory.eqp_equipe.Eqp_equipeConsultGWT;
import br.com.i9factory.client.i9factory.factory.for_fornecedor.For_fornecedorConsultGWT;
import br.com.i9factory.client.i9factory.factory.idc_indice.Idc_indiceConsultGWT;
import br.com.i9factory.client.i9factory.factory.org_orgao.Org_orgaoConsultGWT;
import br.com.i9factory.client.i9factory.factory.par_parametro.Par_parametroConsultGWT;
import br.com.i9factory.client.i9factory.factory.ped_percentual_desconto.Ped_percentual_descontoConsultGWT;
import br.com.i9factory.client.i9factory.factory.per_perfil.Per_perfilConsultGWT;
import br.com.i9factory.client.i9factory.factory.relatorio.AniversariantesGWT;
import br.com.i9factory.client.i9factory.factory.relatorio.AniversariantesGWT1;
import br.com.i9factory.client.i9factory.factory.relatorio.CarteiraGWT;
import br.com.i9factory.client.i9factory.factory.relatorio.ClientesGWT;
import br.com.i9factory.client.i9factory.factory.relatorio.ClientesIdadesAcimaGWT;
import br.com.i9factory.client.i9factory.factory.relatorio.Clientes_dois_orgaos;
import br.com.i9factory.client.i9factory.factory.relatorio.Clientes_novosGWT;
import br.com.i9factory.client.i9factory.factory.relatorio.Clientes_orgaos;
import br.com.i9factory.client.i9factory.factory.relatorio.ComissaoCorretorGWT;
import br.com.i9factory.client.i9factory.factory.relatorio.ContaAPagar_PagasRelGWT;
import br.com.i9factory.client.i9factory.factory.relatorio.CorretorGWT;
import br.com.i9factory.client.i9factory.factory.relatorio.Decima_segunda_parcGWT;
import br.com.i9factory.client.i9factory.factory.relatorio.FornecedorGWT;
import br.com.i9factory.client.i9factory.factory.relatorio.InadimplentesGWT;
import br.com.i9factory.client.i9factory.factory.relatorio.MalaDireta;
import br.com.i9factory.client.i9factory.factory.relatorio.OrgaoGWT;
import br.com.i9factory.client.i9factory.factory.relatorio.SeguroMensalidadeGWT;
import br.com.i9factory.client.i9factory.factory.relatorio.SituacaofinanceiraGWT;
import br.com.i9factory.client.i9factory.factory.remessa.RemessaConsultGWT;
import br.com.i9factory.client.i9factory.factory.tic_tipo_credito.Tic_tipo_creditoConsultGWT;
import br.com.i9factory.client.i9factory.factory.tid_tipo_despesa.Tid_tipo_despesaConsultGWT;
import br.com.i9factory.client.i9factory.factory.tmp_tipomensalidade.Tmp_tipomensalidadeConsultGWT;
import br.com.i9factory.client.i9factory.factory.usuario_sistema.Usuario_sistemaConsultGWT;
import br.com.i9factory.client.i9factory.factory.vw_arquivo_retorno_banco.Vw_arquivo_retorno_bancoConsultGWT;
import br.com.i9factory.client.i9factory.factory.vw_parcelas.Vw_parcelasConsultGWT;
import br.com.i9factory.client.i9factory.factory.welcome.WelCome;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class AdminI9FactoryAccordion extends AMenuHandlerAccordion {

    private HashMap<String, TabItem> itens = new HashMap<String, TabItem>();

    public AdminI9FactoryAccordion() {
        setSystem("I9FACTORY");
    }

    @Override
    public void actionEventMenu(Object me, String acao) {
        actionEventMenu(me, acao, "");
    }

    @Override
    public void actionEventMenu(Object me, String acao, String page) {
        TabItem tabItem = null;
        tabItem = itens.get(acao);

        if (tabItem == null) {
            tabItem = new TabItem();
            tabItem.setClosable(true);
            tabItem.setLayout(new FitLayout());
            ContentPanel cp = new ContentPanel();
            cp.setFrame(false);
            cp.setBorders(false);
            cp.setHeaderVisible(false);
            cp.setBodyBorder(false);
            cp.setLayout(new FitLayout());
            if ("I9FACTORY.usuario".equalsIgnoreCase(acao)) {
                tabItem.setText("Usuários");
                cp.add(new Usuario_sistemaConsultGWT());
            } else if ("I9FACTORY.perfil".equalsIgnoreCase(acao)) {
                tabItem.setText("Perfil");
                cp.add(new Per_perfilConsultGWT());
            } else if ("I9FACTORY.Teb".equalsIgnoreCase(acao)) {
                tabItem.setText("Transferencias");
                cp.add(new Vw_arquivo_retorno_bancoConsultGWT());
                //cp.add(new Teb_transmissao_empresa_bancoConsultGWT());
            } else if ("I9FACTORY.bancos".equalsIgnoreCase(acao)) {
                tabItem.setText("Bancos");
                cp.add(new Bco_bancoConsultGWT());
            } else if ("I9FACTORY.tipomensalidade".equalsIgnoreCase(acao)) {
                tabItem.setText("Tipo de Mensalidades");
                cp.add(new Tmp_tipomensalidadeConsultGWT());
            } else if ("I9FACTORY.tipodespesa".equalsIgnoreCase(acao)) {
                tabItem.setText("Tipo de Despesas");
                cp.add(new Tid_tipo_despesaConsultGWT());
            } else if ("I9FACTORY.corretora".equalsIgnoreCase(acao)) {
                tabItem.setText("Corretora");
                cp.add(new Cor_corretoraConsultGWT());
            } else if ("I9FACTORY.equipes".equalsIgnoreCase(acao)) {
                tabItem.setText("Equipe");
                cp.add(new Eqp_equipeConsultGWT());
            } else if ("I9FACTORY.agenciador".equalsIgnoreCase(acao)) {
                tabItem.setText("Agênciador");
                cp.add(new Age_agenciadorConsultGWT());
            } else if ("I9FACTORY.indices".equalsIgnoreCase(acao)) {
                tabItem.setText("Indices");
                cp.add(new Idc_indiceConsultGWT());
            } else if ("I9FACTORY.orgaos".equalsIgnoreCase(acao)) {
                tabItem.setText("Orgãos");
                cp.add(new Org_orgaoConsultGWT());
            } else if ("I9FACTORY.fornecedor".equalsIgnoreCase(acao)) {
                tabItem.setText("Fornecedor");
                cp.add(new For_fornecedorConsultGWT());
            } else if ("I9FACTORY.contasapagar".equalsIgnoreCase(acao)) {
                tabItem.setText("Contas A Pagar");
                cp.add(new Ctp_conta_pagarConsultGWT());
            } else if ("I9FACTORY.relCTP".equalsIgnoreCase(acao)) {
                tabItem.setText("Relatório Contas A Pagar/Pagas");
                cp.add(new ContaAPagar_PagasRelGWT());
            } else if ("I9FACTORY.clientes".equalsIgnoreCase(acao)) {
                tabItem.setText("Clientes");
                cp.add(new Cli_clienteConsultGWT());
            } else if ("I9FACTORY.emprestimo".equalsIgnoreCase(acao)) {
                tabItem.setText("Proposta/Emprestimo");
                cp.add(new Emp_emprestimoConsultGWT());
            } else if ("I9FACTORY.relClientes".equalsIgnoreCase(acao)) {
                tabItem.setText("Relação Clientes");
                cp.add(new ClientesGWT());
            } else if ("I9FACTORY.rel_orgaos".equalsIgnoreCase(acao)) {
                tabItem.setText("Relação Orgãos");
                cp.add(new OrgaoGWT());
            } else if ("I9FACTORY.relCorretor".equalsIgnoreCase(acao)) {
                tabItem.setText("Relação Corretor");
                cp.add(new CorretorGWT());
            } else if ("I9FACTORY.relFornecedor".equalsIgnoreCase(acao)) {
                tabItem.setText("Relação Forcecedor");
                cp.add(new FornecedorGWT());
            } else if ("I9FACTORY.potlet".equalsIgnoreCase(acao)) {
                tabItem.setText("Bem Vindo");
                tabItem.setClosable(false);
                cp.add(new WelCome());
            } else if ("I9FACTORY.baixaParcelas".equalsIgnoreCase(acao)) {
                tabItem.setText("Baixa das Parcelas");
                cp.add(new Vw_parcelasConsultGWT());
            } else if ("I9FACTORY.parametros".equalsIgnoreCase(acao)) {
                tabItem.setText("Parametros");
                cp.add(new Par_parametroConsultGWT());
            } else if ("I9FACTORY.remessa".equalsIgnoreCase(acao)) {
                tabItem.setText("Remessa");
                cp.add(new RemessaConsultGWT());
            } else if ("I9FACTORY.retorno".equalsIgnoreCase(acao)) {
                tabItem.setText("Arquivos Bancos");
                cp.add(new Arb_arquivobancoConsultGWT());
            } else if ("I9FACTORY.comissao".equalsIgnoreCase(acao)) {
                tabItem.setText("Comissão");
                cp.add(new ComissaoCorretorGWT());
            } else if ("I9FACTORY.carteira".equalsIgnoreCase(acao)) {
                tabItem.setText("Carteira");
                cp.add(new CarteiraGWT());
            } else if ("I9FACTORY.seguro_mensalidade".equalsIgnoreCase(acao)) {
                tabItem.setText("Seguros/Mensalidades");
                cp.add(new SeguroMensalidadeGWT());
            } else if ("I9FACTORY.idade_acima".equalsIgnoreCase(acao)) {
                tabItem.setText("Clientes com idade superior");
                cp.add(new ClientesIdadesAcimaGWT());
            }else if ("I9FACTORY.cliente_inadimplentes".equalsIgnoreCase(acao)) {
                tabItem.setText("Inadimplentes");
                cp.add(new InadimplentesGWT());
            } else if ("I9FACTORY.clientes_novos".equalsIgnoreCase(acao)) {
                tabItem.setText("Novos Clientes");
                cp.add(new Clientes_novosGWT());
            } else if ("I9FACTORY.descPar".equalsIgnoreCase(acao)) {
                tabItem.setText("Desconto Parcelas");
                cp.add(new Ped_percentual_descontoConsultGWT());
            } else if ("I9FACTORY.decima".equalsIgnoreCase(acao)) {
                tabItem.setText("Décima Segunda Parcelas.");
                cp.add(new Decima_segunda_parcGWT());
            } else if ("I9FACTORY.aniver".equalsIgnoreCase(acao)) {
                tabItem.setText("Aniversariantes");
                cp.add(new AniversariantesGWT());
            }  else if ("I9FACTORY.tipo_cred".equalsIgnoreCase(acao)) {
                tabItem.setText("Tipo Crédito Emprestimo");
                cp.add(new Tic_tipo_creditoConsultGWT());
            }  else if ("I9FACTORY.cli_dois_orgao".equalsIgnoreCase(acao)) {
                tabItem.setText("Clientes com mais de um Orgão");
                cp.add(new Clientes_dois_orgaos());
            }  else if ("I9FACTORY.cli_orgao".equalsIgnoreCase(acao)) {
                tabItem.setText("Clientes por Orgão");
                cp.add(new Clientes_orgaos());
            } else if ("I9FACTORY.mala".equalsIgnoreCase(acao)) {
                tabItem.setText("Mala Direta");
                cp.add(new MalaDireta());
            }else if ("I9FACTORY.situacaoFin".equalsIgnoreCase(acao)) {
                tabItem.setText("Situação Financeira");
                cp.add(new SituacaofinanceiraGWT());
            }else if ("I9FACTORY.cartao".equalsIgnoreCase(acao)) {
                tabItem.setText("Consulta Cartão");
                cp.add(new Car_cartaoConsultGWT());
            }else {
                MessageBox.alert("Opcao ainda nao implementada", "Em breve esta opcao estara disponivel!", null);
            }
            if (cp != null) {
                tabItem.add(cp);
                //Adiciona o tabitem se nÃ£o existir no tabPanel
                getPortalAccordionGWT().getTabPanel().add(tabItem);
                itens.put(acao, tabItem);
            }
        } else {
            TabItem tabTemp = getPortalAccordionGWT().getTabPanel().getItemByItemId(acao);
            if (tabTemp == null) {
                getPortalAccordionGWT().getTabPanel().add(tabItem);
            }
        }
        getPortalAccordionGWT().getTabPanel().setSelection(tabItem);
        getPortalAccordionGWT().layout();
    }
}
