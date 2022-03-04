/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tabela_nba.persistencia.interfac;

import tabela_nba.controle.tabela_NBA;
import tabela_nba.controle.tabela_NBA.conferencia;

/**
 *
 * @author artur
 */
public interface ITabelaDAO {
    
    tabela_NBA getTabela(conferencia nome);
    
}
