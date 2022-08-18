package com.prueba1.servicios;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NumeroServiceImpl implements NumeroService{

    @Override
    public Optional<String> resultado() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i<=100; i++){
            if (esMultiplo(i,3) && esMultiplo(i,5)){
                str.append("VINCLE ");
            }else if (esMultiplo(i,3)){
                str.append("VIN ");
            }else if (esMultiplo(i,5)){
                str.append("CLE ");
            }else{
                str.append( i+" " );
            }

        }


        return Optional.ofNullable(str.toString());
    }


    public static boolean esMultiplo(int n1,int n2){
        if (n1%n2==0)
            return true;
        else
            return false;
    }
}
