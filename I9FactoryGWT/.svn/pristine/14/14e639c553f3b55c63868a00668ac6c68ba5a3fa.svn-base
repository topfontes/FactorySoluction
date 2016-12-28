/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.per_perfil;

import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.i9factory.factory.transfer.Per_perfilTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Usuario_sistemaTGWT;
import br.com.i9factory.client.i9factory.factory.usuario_sistema.ListUsuarioSistemaGWT;
import com.extjs.gxt.ui.client.dnd.GridDragSource;
import com.extjs.gxt.ui.client.dnd.GridDropTarget;
import com.extjs.gxt.ui.client.event.DNDEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;



import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import br.com.i9factory.client.*; 

/**
 *
 * @author I9  
 */
public class Perfil_usuarioGWT extends BaseBorderLayoutGWT implements IListenetResponse {

    public static final String PAGE = "i9factory/factory/usuario_sistema/usuario_sistemaConsultGWT.jsp";
    Usuario_sistemaTGWT usuarioPerfil = new Usuario_sistemaTGWT();
    Usuario_sistemaTGWT usuarioNaoPerfil = new Usuario_sistemaTGWT();
    private ListUsuarioSistemaGWT listUsuarioVinculado = new ListUsuarioSistemaGWT();
    private ListUsuarioSistemaGWT listUsuarionaovincudo = new ListUsuarioSistemaGWT();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
//    private ConsultaGWT ConsultGWT = new ConsultaGWT();
    private final Perfil_usuarioGWT perfil_usuarioGWT = this;
    ContentPanel cpVinc = new ContentPanel(new FillLayout());
    ContentPanel cpNotVinc = new ContentPanel(new FillLayout());
    private GridDropTarget targetVinc;
    private GridDropTarget targetNotVinc;
    private Per_perfilTGWT per_perfilTGWT = new Per_perfilTGWT();
    private Per_perfilConsultGWT consultGWT = new Per_perfilConsultGWT();


    public Perfil_usuarioGWT() {
        try {
            this.setShadow(true);
            setHeading("Usuarios Perfil.");
            getCpMaster().setHeading("Usuários não vinculados");
            getCpRight().setHeading("Usuários vinculados");
            getCpRight().setWidth(230);
            getDataEAST().setSize(230);
            this.setSize(500, 250);

            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Usuario_sistemaTGWT>> numberRenderer = new NumberCellRenderer<Grid<Usuario_sistemaTGWT>>(currency);

        } catch (Exception e) {
        }
    }

    public List<ColumnConfig> createConfig() {
        List<ColumnConfig> config = new Vector();
        ColumnConfig column = new ColumnConfig("usu_nr_id", "usuario", 20);
        column.setHidden(true);
        config.add(column);
        column = new ColumnConfig("usu_tx_nome", "nome", 200);
        config.add(column);
        return config;
    }

    public void load(Per_perfilTGWT per_perfilTGWT) {
        try {
            listUsuarioVinculado.povoaUsuarioVinculado(per_perfilTGWT);
            listUsuarionaovincudo.povoaUsuarioNaoVinculado(per_perfilTGWT);
            this.per_perfilTGWT = per_perfilTGWT;
            setHeading("Usuários do Perfil "+per_perfilTGWT.getPer_tx_nome());
            montarTela();
            layout();
            doLayout();
        } catch (Exception e) {
        }

    }

    public void montarTela() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listUsuarionaovincudo.preechido || !listUsuarioVinculado.preechido) {
                    schedule(500);
                } else {
                    ListStore<Usuario_sistemaTGWT> storevinc = new ListStore<Usuario_sistemaTGWT>();
                    storevinc.add(listUsuarioVinculado.getList());

                    ListStore<Usuario_sistemaTGWT> storenotvinc = new ListStore<Usuario_sistemaTGWT>();
                    storenotvinc.add(listUsuarionaovincudo.getList());

                    ColumnModel cmnotvinc = new ColumnModel(createConfig());

                    Grid<Usuario_sistemaTGWT> grid_notvinc = new Grid<Usuario_sistemaTGWT>(storenotvinc, cmnotvinc);
                    grid_notvinc.setLoadMask(true);

                    grid_notvinc.setBorders(true);
                    grid_notvinc.setStripeRows(true);
                    getCpMaster().add(grid_notvinc);

                    final ColumnModel cmvinc = new ColumnModel(createConfig());
                    Grid<Usuario_sistemaTGWT> grid_vinc = new Grid<Usuario_sistemaTGWT>(storevinc, cmvinc);
                    grid_vinc.setLoadMask(true);
                    grid_vinc.setStripeRows(true);

                    grid_vinc.setBorders(true);

                    getCpRight().add(grid_vinc);

                    GridDragSource gridSourceVinc = new GridDragSource(grid_vinc);
                    GridDragSource gridSourceNotVinc = new GridDragSource(grid_notvinc);
                    GridDropTarget targetVinc = new GridDropTarget(grid_vinc) {
                        protected void onDragDrop(DNDEvent event) {
                            List<Usuario_sistemaTGWT> lis = event.getData();
                            if (!lis.isEmpty()) {
                                for (Usuario_sistemaTGWT usuario_sistemaTGWT : lis) {
                                    adicionarUsuarioAoPerfil(usuario_sistemaTGWT);
                                }
                            }
                            super.onDragDrop(event);
                        }
                    };
                    targetVinc.setAllowSelfAsSource(false);

                    GridDropTarget targetNotVinc = new GridDropTarget(grid_notvinc) {

                        protected void onDragDrop(DNDEvent event) {
                            List<Usuario_sistemaTGWT> lis = event.getData();
                            if (!lis.isEmpty()) {
                                for (Usuario_sistemaTGWT usuario_sistemaTGWT : lis) {
                                    removerUsuarioDoPerfil(usuario_sistemaTGWT);
                                }
                            }
                            super.onDragDrop(event);
                        }
                    };
                    targetNotVinc.setAllowSelfAsSource(false);
                    layout();
                    doLayout();
                }
            }
        };
        timer.schedule(500);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            if ("erro ao remover".equalsIgnoreCase(EasyContainer.clearAspas(jsonObject.get("resultado").toString()))
                    || "erro ao inserir".equalsIgnoreCase(EasyContainer.clearAspas(jsonObject.get("resultado").toString()))) {
                load(per_perfilTGWT);
                com.google.gwt.user.client.Window.alert("Result " + jsonObject.get("resultado").toString());
            }
        }
    }

    /**
     * @return the ConsultGWT
     */

    public void removerUsuarioDoPerfil(Usuario_sistemaTGWT usuario_sistemaTGWT) {
        try {

            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "removerUsuarioDoPerfil");
            param.put("pu_per_usuT.per_nr_id", per_perfilTGWT.getPer_nr_id() + "");
            param.put("pu_per_usuT.usu_nr_id", usuario_sistemaTGWT.getUsu_nr_id() + "");
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
        } catch (Exception ex) {
        }
    }

    public void adicionarUsuarioAoPerfil(Usuario_sistemaTGWT usuario_sistemaTGWT) {
        try {

            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "adicionarUsuarioAoPerfil");
            param.put("pu_per_usuT.per_nr_id", per_perfilTGWT.getPer_nr_id() + "");
            param.put("pu_per_usuT.usu_nr_id", usuario_sistemaTGWT.getUsu_nr_id() + "");

            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
        } catch (Exception ex) {
        }
    }

    /**
     * @return the consultGWT
     */
    public Per_perfilConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Per_perfilConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }
}
