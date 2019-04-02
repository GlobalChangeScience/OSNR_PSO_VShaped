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


import org.implementation.pso_osnr.util.StandardDiscretization;
import org.implementation.pso_osnr.util.VShaped;
import org.model.osnr.OSNR_Create_Species_Variables;
import org.model.osnr.OSNR_Model;
import org.model.osnr.OSNR_Solution;
import org.model.osnr.OSNR_Velocity;


public class PSO_OSNR_Position_V2 implements PSO_OSNR_Position
{

    public OSNR_Solution position_shaped(OSNR_Model osnr_model,
                                         OSNR_Solution current_solution,
                                         OSNR_Velocity velocity)
    {
        int num_areas = osnr_model.getNum_areas();
        int num_species = osnr_model.getNum_species();
        int[] area_variable = new int[num_areas];
        int[] species_variable;

        // Create a empty area x variable
        for (int i = 0; i < num_areas; i++)
        {
            area_variable[i] = 0;
        }

        // This part if for the algorithm
        for (int i = 0; i < num_areas; i++)
        {
            // PSO movement
            double value = current_solution.getArea_variable()[i] + velocity.getArea_variable()[i];

            // Binarization and Discretization for the movement
            area_variable[i] = StandardDiscretization.StandardInt(VShaped.V2(value));
        }

        // Create matrix species x variables
        species_variable = OSNR_Create_Species_Variables.createSpeciesVariable(area_variable, num_areas, num_species, osnr_model.getA());

        return new OSNR_Solution(area_variable, species_variable);
    }

}
