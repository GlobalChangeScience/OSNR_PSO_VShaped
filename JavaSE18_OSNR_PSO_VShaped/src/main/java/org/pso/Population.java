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


package org.pso;

import org.implementation.pso_osnr.PSO_OSNR_Position;
import org.implementation.pso_osnr.PSO_OSNR_Random_Position;
import org.implementation.pso_osnr.PSO_OSNR_Velocity;
import org.model.osnr.OSNR_Model;

import java.util.ArrayList;

import org.apache.commons.math3.random.RandomDataGenerator;
import org.model.osnr.OSNR_Solution;
import org.model.osnr.OSNR_Velocity;

/**
 *
 */
public class Population
{

    // Population of andean condors.
    private ArrayList<Particle> particles;

    // This variable correspond to the number of the andean condors in the particles
    private static int number_of_particles;

    // This variable is the global particle in the particles.
    private Particle gBest;

    // This is the OSNR Model.
    private static OSNR_Model osnr_model;


    /**
     * Constructor.
     * @param number_of_particles Corresponds to the number of Andean condors in
     *                                 the population of condors.
     * @param osnr_model A OSNR model.
     */
    public Population(int number_of_particles,
                      OSNR_Model osnr_model)
    {
        this.number_of_particles = number_of_particles;
        this.osnr_model = osnr_model;

        this.particles = new ArrayList<Particle>();
        this.gBest = new Particle();
    }



    /**
     * PSO is initialized with a group of random particles (solutions) and then searches
     * for optima by updating generations.
     */
    public void createRandomPopulation(double vmin, double vmax)
    {
        // Create initial solutions
        for (int i = 0; i < number_of_particles; i++)
        {
            Particle particle = new Particle();

            // Create a random solution.
            PSO_OSNR_Random_Position random_solution = new PSO_OSNR_Random_Position();

            // Add the new solution into the Particle.
            particle.setCurrentSolution(random_solution.create(osnr_model));

            // Calculate current fitness.
            int fitness = this.osnr_model.calculate_fitness(particle.getCurrentSolution().getSpecies_variable());

            // Set the current fitness.
            particle.setFitness(fitness);

            // Create a random velocity
            PSO_OSNR_Velocity velocity = new PSO_OSNR_Velocity();

            // Add the new velocity into the Particle
            particle.setCurrentVelocity(velocity.randomVelocity(osnr_model, vmin, vmax));

            // Add pbest, it's the solution, only in this first moment
            particle.setPBest(particle.getCurrentSolution().clone());

            // Add the particle into the particles.
            this.particles.add(particle);
        }

    }



    /**
     * Get the best particles of the population
     * @return SolutionType
     */
    public Particle getBestGlobalParticle()
    {
        return this.gBest;
    }



    /**
     * Find and set Gbest particle
     */
    public void findAndSetGBestParticle()
    {
        Particle best_solution = particles.get(0);


        if (osnr_model.isMinimization() == true)
        {
            for (int i = 1; i < particles.size(); i++)
            {
                if (particles.get(i).getFitness() < best_solution.getFitness())
                {
                    best_solution = particles.get(i);
                }
            }
        }
        else
        {
            for (int i = 1; i < particles.size(); i++)
            {
                if (particles.get(i).getFitness() > best_solution.getFitness())
                {
                    //System.out.println("p_i: " + particles.get(i).getFitness() + " bp: " + best_solution.getFitness());
                    best_solution = particles.get(i);
                }
            }
        }

        // Make a Hard Copy.
        if (osnr_model.isMinimization() == true)
        {
            if (best_solution.getFitness() < this.gBest.getFitness())
            {
                this.gBest = best_solution.clone();
            }
        }
        else
        {
            if (best_solution.getFitness() > this.gBest.getFitness())
            {
                this.gBest = best_solution.clone();
            }
        }
    }


    /**
     * If the fitness value is better than the best fitness value (pBest) in history
     * set current value as the new pBest
     * Compare with pBest, X(i) it is greater pBest(i)
     * @param index index
     */
    public void comparePresentWithPbest(int index)
    {
        // Depends for the type f.o. minimization or maximization
        if (osnr_model.isMinimization() == true)
        {
            if (particles.get(index).getFitness() < particles.get(index).getFitnessPBest())
            {
                particles.get(index).setPBest(particles.get(index).getCurrentSolution().clone());
                particles.get(index).setFitnessPBest(particles.get(index).getFitness());
            }
        }
        else
        {
            if (particles.get(index).getFitness() > particles.get(index).getFitnessPBest())
            {
                particles.get(index).setPBest(particles.get(index).getCurrentSolution().clone());
                particles.get(index).setFitnessPBest(particles.get(index).getFitness());
            }
        }
    }


    // Compare with pBest, pBest(i) > gBest
    public void comparePresentWithGbest(int index)
    {
        // Depends for the type f.o. minimization or maximization
        if (osnr_model.isMinimization() == true)
        {
            if (particles.get(index).getFitnessPBest() < this.gBest.getFitness())
            {
                this.gBest.setCurrentSolution(particles.get(index).getPBest().clone());
                this.gBest.setFitness(particles.get(index).getFitnessPBest());
            }
        }
        else
        {
            if (particles.get(index).getFitnessPBest() > this.gBest.getFitness())
            {
                this.gBest.setCurrentSolution(particles.get(index).getPBest().clone());
                this.gBest.setFitness(particles.get(index).getFitnessPBest());
            }
        }
    }



    /**
     * Calculate particle velocity
     * @param index index of particle
     * @return boolean
     */
    public boolean calculateParticleVelocity(int index, double c1, double c2)
    {
        // Generate 2 random numbers in a uniform distribution [0,1]
        RandomDataGenerator random = new RandomDataGenerator();
        random.reSeedSecure(osnr_model.getSeed());

        // Generate two random values in a uniform distribution.
        double r1 = random.nextUniform(0, 1);
        double r2 = random.nextUniform(0, 1);

        // velocity move
        OSNR_Velocity velocity = PSO_OSNR_Velocity.velocity(osnr_model,
                particles.get(index).getCurrentVelocity(),
                particles.get(index).getPBest(),
                particles.get(index).getCurrentSolution(),
                getBestGlobalParticle().getCurrentSolution(),
                c1, c2, r1, r2);

        // Set new velocity for the i particle.
        particles.get(index).setCurrentVelocity(velocity);

        return true;
    }


    /**
     * Update particle position
     * @param index index of particle
     * @return boolean
     */
    public boolean updateParticlePosition(int index, PSO_OSNR_Position position_move)
    {

        OSNR_Solution solution = position_move.position_shaped(osnr_model,
                                            this.particles.get(index).getCurrentSolution(),
                                            this.particles.get(index).getCurrentVelocity());


        boolean improvement = OSNR_Model.check_constraint(solution.getArea_variable(),
                solution.getSpecies_variable());

        if (improvement == true)
        {
            particles.get(index).setCurrentSolution(solution);

            // Calculate current fitness.
            int fitness = this.osnr_model.calculate_fitness(solution.getSpecies_variable());

            // Set the current fitness.
            particles.get(index).setFitness(fitness);

            return true;
        }
        else
        {
            return false;
        }

    }


    /*
    @Override
    public String toString()
    {
        String string_i = "1";
        String string_f = "" + this.particles.get(0).getFitness();
        String string_s = "";

        if (this.particles.get(0).getStatus() == false)
        {
            string_s = string_s + "I";
        }
        else
        {
            string_s = string_s + "E";
        }

        for (int i = 1; i < this.number_of_particles; i++)
        {
            string_i = string_i + ", " + (i + 1);
            string_f = string_f + ", " + this.particles.get(i).getFitness();

            if (this.particles.get(i).getStatus() == false)
            {
                string_s = string_s + ", " + "I";
            }
            else
            {
                string_s = string_s + ", " + "E";
            }
        }

        return  "Index:\t\t" + string_i + "\n" +
                "Fitness:\t" + string_f + "\n" +
                "Status:\t\t" + string_s;
    }
    */


}
