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


package org.implementation.pso_osnr;


import org.apache.commons.math3.random.RandomDataGenerator;

import org.model.osnr.OSNR_Create_Species_Variables;
import org.model.osnr.OSNR_Model;
import org.model.osnr.OSNR_Solution;


/**
 * A class for made a exploration the Optimal Selection of a Natural Reserve.
 */
public class PSO_OSNR_Random_Position
{

    public OSNR_Solution create(OSNR_Model osnr_model)
    {
        int num_areas = osnr_model.getNum_areas();
        int num_species = osnr_model.getNum_species();
        int[] area_variable = new int[num_areas];
        int[] species_variable;

        RandomDataGenerator random = new RandomDataGenerator();
        random.reSeedSecure(osnr_model.getSeed());

        while (true)
        {
            // Create a vector with random value, in other words, create a random solution.
            for (int i = 0; i < num_areas; i++)
            {
                if (random.nextUniform(0, 1) < 0.8)
                {
                    area_variable[i] = 0;
                }
                else
                {
                    area_variable[i] = 1;
                }
            }

            // Create matrix species x variables
            species_variable = OSNR_Create_Species_Variables.createSpeciesVariable(area_variable, num_areas,
                    num_species, osnr_model.getA());

            // Check the constraints
            boolean flag = OSNR_Model.check_constraint(area_variable, species_variable);

            // If the constraints are all valid, the process for create a random solution it's completed.
            if (flag == true)
            {
                break;
            }
        }

        // Create and return OSNR solution
        return new OSNR_Solution(area_variable, species_variable);
    }

}
