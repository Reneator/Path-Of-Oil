package com.drzed.pathofoil.objects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

public class Anointments {

    private List<Anointment> anointmentList;
    public Anointments(String filePath) {
        initialize(filePath);
    }

    private void initialize(String filePath) throws Exception {

        File anoints = new File(filePath);

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(anoints)));
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            String[] parts = line.split(",");
            // Ignore the header line of the spreadsheet IE (Oil #1, Oil #2, Oil #3, Enchantment, Description)
            if (!line.contains("#")) {
                // 3 oils of amulet anoints
                String ze_oils = parts[0] + ", " + parts[1] + ", " + parts[2];
                String name = parts[3].replace("Allocates", "").trim();
                // Was going to have it display what the anoint does but the window would need to be larger than I'd like
//                String descriptor = line.split(name)[1].replaceFirst(",", "");
                anointmentsMasterList.put(name, ze_oils /*+ " || " + descriptor*/);
            }
        }
        reader.close();
        anoints = new File("./data/Rings.csv");

        reader = new BufferedReader(new InputStreamReader(new FileInputStream(anoints)));
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            String[] parts = line.split(",");
            if (!line.contains("#")) {
                // 2 oils of ring anoints
                String ze_oils = parts[0] + ", " + parts[1];
                String name = parts[2];
                anointmentsMasterList.put(name, ze_oils /*+ " || " + descriptor*/);
            }
        }
        reader.close();
    }
}
