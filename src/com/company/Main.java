package com.company;

import controller.Controller;
import model.dao.ConexaoBD;
import view.ViewConcreta;
public class Main {

    public static void main(String[] args) {
        new Controller(new ConexaoBD(), new ViewConcreta()).init();
    }
}
