/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.i9factory.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author geoleite
 */
public class downloadArquivo {
    public static void main(String[] p) {
        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://www.casserp.com.br/casserp";
        String user = "casserp";
        String pass = "i9factory2012";
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);
            con.prepareStatement("set bytea_output='escape'").execute();

            //String sql = "select * from factory.arb_arquivobanco where arb_nr_id=581";
            String sql = "select * from factory.arb_arquivobanco  where arb_tx_tipo='RET' and arb_nr_id in (196,197,200,201,202,203,208,209,210,211)";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                FileOutputStream fos = new FileOutputStream("arq" + rs.getString("arb_nr_seq") + ".ret");
                fos.write(rs.getBytes("arb_by_arquivo"));
                fos.flush();
                fos.close();
                //ByteArrayInputStream bais = new ByteArrayInputStream(rs.getBytes("arb_by_arquivo"));
//                BufferedReader br = new BufferedReader(new InputStreamReader(bais));
//                while (br.ready()) {
//                    System.out.println(br.readLine());
//                }
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
