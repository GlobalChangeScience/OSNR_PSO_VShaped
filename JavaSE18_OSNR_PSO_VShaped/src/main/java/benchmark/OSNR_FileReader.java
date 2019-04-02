/*
 * Resolving the Optimal Selection of a Natural Reserve
 * using the Particle Swarm Optimisation by Applying Transfer Functions
 * Copyright (C) 2019 Boris L. Almonacid, Global Change Science
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


package benchmark;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;


/**
 * A class for read a OSNR data.
 */
public class OSNR_FileReader
{
    /**
     *
     * @param filename
     * @return
     * @throws FileNotFoundException
     */
    public OSNR_Data read(String filename)
    {
        JSONParser parser = new JSONParser();

        int ids = 0;
        String name = "";
        int num_areas = 0;
        int num_species = 0;
        int budget_total = 0;
        int[] budget = null;
        int[][] A = null;

        try
        {
            // Get the real path in the system
            File real_path_filename = new File(ClassLoader.getSystemResource("osnr_set_A/" + filename).getFile());

            // Read the filename
            Object obj = parser.parse(new FileReader(real_path_filename.toString()));

            JSONObject jsonObject = (JSONObject) obj;

            ids = ((Long)jsonObject.get("ids")).intValue();

            name = (String) jsonObject.get("name");

            num_areas = ((Long)jsonObject.get("num_terrains")).intValue();

            num_species = ((Long)jsonObject.get("num_species")).intValue();

            budget_total = ((Long)jsonObject.get("budget_total")).intValue();

            budget = new int[num_areas];
            JSONArray JSON_budget = (JSONArray) jsonObject.get("budget");

            // Extract numbers from JSON array.
            for (int i = 0; i < num_areas; ++i)
            {
                budget[i] = ((Long)JSON_budget.get(i)).intValue();
            }

            A = new int[num_areas][num_species];
            JSONArray rows = (JSONArray) jsonObject.get("A");
            for (int i = 0; i < num_areas; i++)
            {
                JSONArray jsonArr = (JSONArray) rows.get(i);
                for (int j = 0; j < num_species; j++)
                {
                    A[i][j] = ((Long)jsonArr.get(j)).intValue();
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return new OSNR_Data(ids, name, num_areas, num_species, budget_total, budget, A);

    }

}
