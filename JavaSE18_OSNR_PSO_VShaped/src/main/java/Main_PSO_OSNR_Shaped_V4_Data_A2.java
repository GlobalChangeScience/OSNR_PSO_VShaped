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


import benchmark.OSNR_Data;
import benchmark.OSNR_FileReader;
import org.implementation.pso_osnr.PSO_OSNR_Position;
import org.implementation.pso_osnr.PSO_OSNR_Position_V4;
import org.model.osnr.OSNR_Model;


public class Main_PSO_OSNR_Shaped_V4_Data_A2
{

    public static void main(String[] args)
    {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("" +
                           "  Resolving the Optimal Selection of a Natural Reserve\n" +
                           "  using the Particle Swarm Optimisation by\n" +
                           "  Applying Transfer Functions\n" +
                           "  Copyright (C) 2019  Boris L. Almonacid, Global Change Science\n" +
                           "  This program comes with ABSOLUTELY NO WARRANTY;.\n" +
                           "  This is free software, and you are welcome to redistribute it\n" +
                           "  under certain conditions; See the GNU General Public License \n" +
                           "  for more details.");
        System.out.println("-----------------------------------------------------------------");


        // Create a reader for the dataset
        OSNR_FileReader reader = new OSNR_FileReader();

        // Read and create the benchmark data (read one file), in a OSNR_Data class.
        OSNR_Data data = reader.read("A2-20x100.json");


        // Create a Optimal Selection of a Natural Reserve Model
        OSNR_Model osnr_model = new OSNR_Model(data);

        // Set a seed for the OSNR metaheuristic
        osnr_model.setSeed(1000);

        System.out.println("-------------------------------------------");
        System.out.println("-------READ DATA---------------------------");
        System.out.println( data.toString());

        // Create a movement with a one VShaped.
        PSO_OSNR_Position position_move = new PSO_OSNR_Position_V4();

        org.pso.ParticleSwarmOptimization pso =
                new org.pso.ParticleSwarmOptimization(
                        25,
                        1,
                        2,
                        1,
                        10,
                        osnr_model,
                        position_move);


        // Run the PSO metaheuristic.
        pso.run(1000);

    }
}
