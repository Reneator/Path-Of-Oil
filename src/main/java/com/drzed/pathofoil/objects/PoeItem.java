package com.drzed.pathofoil.objects;

import java.util.List;
import java.util.Objects;

public class PoeItem {
    
    String clipBoardData;
    List<String> enchants;


    public PoeItem(String clipBoardData) {
        this.clipBoardData = clipBoardData;
        extractEnchants();
    }

    public void extractEnchants(){

        // Split New Lines to specifically grab the enchant tagged line
        for (String s : this.clipBoardData.split("\\r?\\n|\\r")) {
            if(!s.contains("(enchant)")){
                continue;
            }
            enchants.add(s);
        }


    }

    public boolean hasEnchant(String enchant){
        for(String enchantString: enchants){
            if(enchantString.contains(enchant)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PoeItem poeItem = (PoeItem) o;
        return Objects.equals(clipBoardData, poeItem.clipBoardData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clipBoardData);
    }
}
