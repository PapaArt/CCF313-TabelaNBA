/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabela_nba.modelo;

import tabela_nba.persistencia.interfac.IJogadorDAO;

/**
 *
 * @author artur
 */
public class jogadorModelo implements IJogadorDAO{
    
    private int idJog;
    private String nomeJog;
    private double altura;
    private double peso;
    private double PPG;
    private double RPG;
    private double APG;
    private double TS;

    public jogadorModelo(int idJog, String nomeJog, double altura, double peso, double PPG, double RPG, double APG, double TS) {
        this.idJog = idJog;
        this.nomeJog = nomeJog;
        this.altura = altura;
        this.peso = peso;
        this.PPG = PPG;
        this.RPG = RPG;
        this.APG = APG;
        this.TS = TS;
    }

    @Override
    public String getName() {
        return this.nomeJog;
    }

    @Override
    public double getAltura() {
        return this.altura;
    }

    @Override
    public double peso() {
        return this.peso;
    }

    @Override
    public double getPPG() {
        return this.PPG;
    }

    @Override
    public double getRPG() {
        return this.RPG;
    }

    @Override
    public double getAPG() {
        return this.APG;
    }

    @Override
    public double getTS() {
        return this.TS;
    }    
}
