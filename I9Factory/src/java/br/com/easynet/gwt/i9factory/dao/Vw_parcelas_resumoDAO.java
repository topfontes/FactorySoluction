/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.i9factory.dao;

import br.com.jdragon.dao.DAOFactory;
import br.com.jdragon.dao.ObjectDAO;

/**
 *
 * @author topfontes
 */
public class Vw_parcelas_resumoDAO extends ObjectDAO {

    public Vw_parcelas_resumoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }
    
    
    

}
