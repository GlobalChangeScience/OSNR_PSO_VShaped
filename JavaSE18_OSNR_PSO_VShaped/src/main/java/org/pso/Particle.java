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

import org.model.osnr.OSNR_Solution;
import org.model.osnr.OSNR_Velocity;

/**
 * This class represents a one Particle.
 */
public class Particle implements Cloneable
{
    private OSNR_Solution current_solution;
    private OSNR_Velocity velocity;
    private OSNR_Solution pbest;

    /**
     * The fitness value of the current_solution.
     */
    private int fitness;

    /**
     * The fitness value for the pbest solution.
     */
    private int fitness_pbest;

    /**
     * A simple constructor.
     */
    public Particle()
    {
        this.current_solution = null;
        this.velocity = null;
        this.pbest = null;
    }

    /**
     * Constructor
     * @param solution
     * @param velocity
     * @param pbest
     * @param fitness
     * @param fitness_pbest
     */
    public Particle(OSNR_Solution solution,
                    OSNR_Velocity velocity,
                    OSNR_Solution pbest,
                    int fitness,
                    int fitness_pbest)
    {
        this.current_solution = solution;
        this.velocity = velocity;
        this.pbest = pbest;
        this.fitness = fitness;
        this.fitness_pbest = fitness_pbest;
    }


    /**
     * Get the fitness value.
     * @return The fitness value of the solution.
     */
    public int getFitness()
    {
        return fitness;
    }

    /**
     * Set a new fitness in the Andean Condor.
     * @param fitness The fitness value of the solution.
     */
    public void setFitness(int fitness)
    {
        this.fitness = fitness;
    }

    /**
     * Get the fitness value from pbest.
     * @return The fitness value of the pbest solution.
     */
    public int getFitnessPBest()
    {
        return fitness_pbest;
    }

    /**
     * Set a new fitness in the pbest.
     * @param fitness_pbest The fitness value of the pbest solution.
     */
    public void setFitnessPBest(int fitness_pbest)
    {
        this.fitness_pbest = fitness_pbest;
    }

    /**
     * Get the Current Solution.
     * @return A OSNR solution.
     */
    public OSNR_Solution getCurrentSolution()
    {
        return current_solution;
    }

    /**
     * Set a new OSNR solution.
     * @param solution A OSNR solution.
     */
    public void setCurrentSolution(OSNR_Solution solution)
    {
        this.current_solution = solution;
    }


    /**
     * Get the Current Velocity.
     * @return A velocity.
     */
    public OSNR_Velocity getCurrentVelocity()
    {
        return velocity;
    }

    /**
     * Set a new velocity.
     * @param velocity A velocity.
     */
    public void setCurrentVelocity(OSNR_Velocity velocity)
    {
        this.velocity = velocity;
    }


    /**
     * Get the Current Solution.
     * @return A OSNR solution.
     */
    public OSNR_Solution getPBest()
    {
        return pbest;
    }

    /**
     * Set a new OSNR solution.
     * @param pbest A OSNR solution.
     */
    public void setPBest(OSNR_Solution pbest)
    {
        this.pbest = pbest;
    }



    /**
     * Get a string with all values of Andean Condor.
     * @return
     */
    @Override
    public String toString()
    {
        return "Particle \n{" +
                "currentSolution=" + current_solution.toString() +
                "fitness=" + fitness +
                '}';
    }

    /**
     * https://howtodoinjava.com/java/cloning/a-guide-to-object-cloning-in-java/
     * @return
     */
    @Override
    protected Particle clone()
    {
        OSNR_Solution solution = this.current_solution.clone();
        OSNR_Velocity velocity = this.velocity.clone();
        OSNR_Solution pbest = this.pbest.clone();
        int fitness = this.fitness;
        int fitness_pbest = this.fitness_pbest;

        return new Particle(solution, velocity, pbest, fitness, fitness_pbest);
    }
}
