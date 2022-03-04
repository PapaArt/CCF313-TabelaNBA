/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabela_nba.persistencia.mysql;

import tabela_nba.controle.tabela_NBA;
import tabela_nba.modelo.Time;
import tabela_nba.persistencia.interfac.ITimeDAO;

/**
 *
 * @author artur
 */
public class TimeDAOmysql implements ITimeDAO {

    @Override
    public Time getTime(Time id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Time getTimeDivisao(Time.divisao divisao) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Time getTimeConferencia(tabela_NBA.conferencia conferencia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
