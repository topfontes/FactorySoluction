/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.i9factory.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author geoleite
 */
public class BaixaBancaria {
    public static void main(String[] param) {
        try {
            BaixaBancaria bb = new BaixaBancaria();
            //String linha = "A200104               CASSERP BENEFICIOS  047BANCO DE SERGIPE    2010062900082904DEBITO AUTOMATICO                                                   0";
            //linha += "\r\n";
            String[] linhas = new String[10];
            linhas[0] = "A200104               CASSERP BENEFICIOS  047BANCO DE SERGIPE    2010062900082904DEBITO AUTOMATICO                                                   0";
            linhas[1] = "B36084530591              00080000001008603220100628                                                                                                 1";
            linhas[2] = "B23459654520              00110000001015282920100628                                                                                                 1";
            linhas[3] = "B55609090504              00110000001015287020100628                                                                                                 1";
            linhas[4] = "B12697346520              00110000001019364920100626                                                                                                 1";
            linhas[5] = "B58573216549              00290000001012054620100628                                                                                                 1";
            linhas[6] = "B00450154491              00290000001012389820100628                                                                                                 1";
            linhas[7] = "F33043183568              0056000000100020872010062800000000003874000P79031960000504PARCELA                                                          0";
            linhas[8] = "F42560829568              0057000000100421762010062800000000006384400P79021820000704PARCELA                                                          0";
            linhas[9] = "Z00027700000000009464179                                                                                                                             0";
            //^\\S+@\\S+$
            //.+@.+\\.[a-z]+
            for (int i = 0; i < linhas.length; i++) {
                String linha = linhas[i];
                if (bb.getLinhaTipoA(linha)) {
                    System.out.println("Tipo A");
                    System.out.println(bb.getBanco(linha));
                    System.out.println(bb.getDataBaixa(linha));
                }
                if (bb.getLinhaTipoB(linha)) {
                    System.out.println("Tipo B");
                    System.out.println(bb.getIdentificacaoClienteEmpresa(linha));
                    System.out.println(bb.getDataOpcaoExclusao(linha));
                    System.out.println(bb.getCodigoMovimento(linha));
                }
                if (bb.getLinhaTipoF(linha)) {
                    System.out.println("Tipo F");
                    System.out.println(bb.getIdentificacaoClienteEmpresa(linha));
                    System.out.println(bb.getDataOpcaoExclusao(linha));
                    System.out.println(bb.getValorDebitado(linha));
                    System.out.println(bb.getUsoEmpresa(linha));
                    System.out.println(bb.getTipoIdentificacao(linha));
                    System.out.println(bb.getCPFCNPJ(linha));
                    System.out.println(bb.getCodigoRetorno(linha));
                }
                if (bb.getLinhaTipoZ(linha)) {
                    System.out.println("Tipo Z");
                    System.out.println(bb.getTotalRegistros(linha));
                    System.out.println(bb.getValorTotalRegistros(linha));
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getConteudo(String linha, int i, int f) {
        return linha != null?linha.substring(i, f):null;
    }
    public boolean getLinhaTipoA (String linha) {
        return linha!= null && linha.matches("^A.*$");
    }
    public String getBanco(String linha) {
        return getConteudo(linha, 42, 45);
    }
    public String getDataBaixa(String linha) {
        return getConteudo(linha, 65, 73);
    }
    public boolean getLinhaTipoB (String linha) {
        return linha!= null && linha.matches("^B.*[1,2]$");
    }
    public String getIdentificacaoClienteEmpresa(String linha) {
        return getConteudo(linha, 1, 26);
    }
    public String getCodigoMovimento(String linha) {
        return getConteudo(linha, 149, 150);
    }
    public String getDataOpcaoExclusao(String linha) {
        return getConteudo(linha, 44, 52);
    }
    public boolean getLinhaTipoF (String linha) {
        return linha!= null && linha.matches("^F.*[0,1]$");
    }
    public String getValorDebitado(String linha) {
        return getConteudo(linha, 52, 67);
    }
    public String getCodigoRetorno(String linha) {
        return getConteudo(linha, 67, 69);
    }
    public String getUsoEmpresa(String linha) {
        return getConteudo(linha, 69, 129);
    }
    public String getTipoIdentificacao(String linha) {
        return getConteudo(linha, 129, 130);
    }
    public String getCPFCNPJ(String linha) {
        return getConteudo(linha, 130, 145);
    }
    public boolean getLinhaTipoZ (String linha) {
        return linha!= null && linha.matches("^Z.*[0,1]$");
    }
    public String getTotalRegistros(String linha) {
        return getConteudo(linha, 1, 7);
    }
    public String getValorTotalRegistros(String linha) {
        return getConteudo(linha, 7, 24);
    }
}
