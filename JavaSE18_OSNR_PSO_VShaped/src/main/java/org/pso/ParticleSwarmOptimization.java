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
import org.model.osnr.OSNR_Model;


/**
 * Particle Swarm Optimization
 */
public class ParticleSwarmOptimization
{
    /**
     * Corresponds to the number of particles in the population (swarm).
     */
    private static int number_of_particles;

    /**
     * It represents the population of particles.
     */
    private Population population;

    private static double c1;
    private static double c2;

    private static double vmin;
    private static double vmax;

    private PSO_OSNR_Position position_move;


    /**
     * Constructor
     * @param number_of_particles
     * @param c1
     * @param c2
     * @param vmin
     * @param vmax
     * @param osnr_model
     * @param position_move
     */
    public ParticleSwarmOptimization(int number_of_particles,
                                     double c1,
                                     double c2,
                                     double vmin,
                                     double vmax,
                                     OSNR_Model osnr_model,
                                     PSO_OSNR_Position position_move)
    {
        this.number_of_particles = number_of_particles;
        this.c1 = c1;
        this.c2 = c2;
        this.vmin = vmin;
        this.vmax = vmax;
        this.population = new Population(number_of_particles, osnr_model);
        this.position_move = position_move;
    }

    /**
     *
     * @param iteration
     */
    public void run(int iteration)
    {
        int i = 0;
        searchStarted();

        System.out.println("-------------------------------------------");
        System.out.println("-------SEARCH STARTED----------------------");
        while (i < iteration)
        {
            System.out.println( "-------------------------------------------");
            System.out.print( "Iteration = " + (i + 1));
            searchStep();
            System.out.println(" \t\t Fitness = " + population.getBestGlobalParticle().getFitness());
            i = i + 1;
        }

        System.out.println("-------------------------------------------");
        System.out.println("-------SEARCH END--------------------------");
        searchEnd();
    }

    /**
     *
     */
    protected void searchStarted()
    {

        // Exploration
        // Create the initial solutions.
        population.createRandomPopulation(this.vmin, this.vmax);

        // Choose the particle with the best fitness value of all the particles as the gBest
        population.findAndSetGBestParticle();
    }


    /**
     *
     */
    protected void searchStep()
    {
        // From: http://www.swarmintelligence.org/tutorials.php
        // PSO is initialized with a group of random particles (solutions) and then searches
        // for optima by updating generations.

        // In every iteration, each particle is updated by following two "best" values.
        // The first one is the best solution (fitness) it has achieved so far.
        // (The fitness value is also stored.) This value is called pbest.

        // Another "best" value that is tracked by the particle swarm optimizer is the best value,
        // obtained so far by any particle in the population. This best value is a global best
        // and called gbest. When a particle takes part of the population as its topological neighbors,
        // the best value is a local best and is called lbest.

        // For each particle: Calculate fitness value
        for (int i = 0; i < this.number_of_particles; i++)
        {
            //If the fitness value is better than the best fitness value (pBest) in history
            //set current value as the new pBest

            // Compare with pBest, X(i) > pBest(i)
            population.comparePresentWithPbest(i);

            // Compare with pBest, pBest(i) > gBest
            population.comparePresentWithGbest(i);
        }

        // Choose the particle with the best fitness value of all the particles as the gBest
        population.findAndSetGBestParticle();

        // After finding the two best values, the particle updates its velocity and positions
        // with following equation (a) and (b).
        // (a)   v[] = v[] + C1 * rand() * (pbest[] - present[]) + C2 * rand() * (gbest[] - present[]) (a)
        // (b)   present[] = persent[] + v[] (b)
        // For each particle:
        for (int i = 0; i < this.number_of_particles; i++)
        {
            // Calculate particle velocity according equation (a)
            //System.out.println("calculateParticleVelocity");
            population.calculateParticleVelocity(i, c1, c2);

            // Update particle position according equation (b)
            population.updateParticlePosition(i, this.position_move);
        }
    }

    /**
     * Search End
     */
    protected void searchEnd()
    {

        Particle best_particle = population.getBestGlobalParticle();

        System.out.println("The final solution is: ");
        System.out.println("- Best Particle (Fitness) : " + best_particle.getFitness());
        System.out.println("- Solution (Variables) : \n" + best_particle.getCurrentSolution());
    }

    /**
     *
     * @return
     */
    @Override
    public String toString()
    {
        return "PSO {" +
                "number_of_particles=" + this.number_of_particles +
                ", c1=" + this.c1 +
                ", c2=" + this.c2 +
                ", vmin=" + this.vmin +
                ", vmax=" + this.vmax +
                " }";
    }
}
