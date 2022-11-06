/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package view;

import controller.Controller;
import model.dao.ConexaoBD;

/**
 *
 * @author Admin-PC
 */
public class Janelaaps {

    public static void main(String[] args) {
        new Controller(new ConexaoBD(), new ViewConcreta()).init();
    }
    }
