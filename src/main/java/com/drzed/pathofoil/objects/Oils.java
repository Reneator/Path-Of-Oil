package com.drzed.pathofoil.objects;

import java.util.ArrayList;
import java.util.List;

public class Oils {

    public final String[] oilNames = new String[]{"Clear Oil", "Sepia Oil", "Amber Oil", "Verdant Oil", "Teal Oil", "Azure Oil", "Indigo Oil", "Violet Oil", "Crimson Oil", "Black Oil", "Opalescent Oil", "Silver Oil", "Golden Oil"};

    public final List<Oil> oilsList = new ArrayList<>();

    public Oils() {
        initializeOils();
    }

    private void initializeOils() {
        for (String oilName: oilNames){
            Oil oil = new Oil(oilName);

            oilsList.add(oil);
        }
    }

    public Oil getOil(String oilSearchName) {
        oilSearchName = oilSearchName.trim();
        for (Oil oil: oilsList){
            if (oil.name.equalsIgnoreCase(oilSearchName)){
                return oil;
            }
        }
        return null;
    }

}
