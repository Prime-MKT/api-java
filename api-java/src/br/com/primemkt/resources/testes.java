/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.primemkt.resources;

import java.io.IOException;

/**
 *
 * @author Jocinardo Rodrigues
 */
public class testes {

    public static void main(String[] args) throws IOException {

        Send s = new Send();
        String result = s.To("+5522999465572", "+5522999465572", "Testes API", "F801D7E0AF1965BF2A6D41B7023FE5D29DCDA602", "E10ADC3949BA59ABBE56E057F20F883E");
        
        System.out.println(result);

    }
}
