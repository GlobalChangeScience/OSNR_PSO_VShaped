# Resolving the Optimal Selection of a Natural Reserve using the Particle Swarm Optimisation by Applying Transfer Functions

The optimal selection of a natural reserve (OSNR) is an optimisation problem
with a binary domain. To solve this problem, the metaheuristic algorithm called
Particle Swarm Optimization (PSO) has been chosen. The PSO algorithm has been
designed to solve problems in real domains. Therefore, a transfer method has
been applied that converts the equations with real domains of the PSO algorithm
into binary results that are compatible with the OSNR problem. Four transfer
functions have been tested in four case studies to solve the OSNR problem.
According to the tests carried out, it is concluded that two of the four
transfer functions are apt to solve the problem of optimal selection of a
natural reserve.



Dataset Citation:
----------------
@Misc{almonacid_2018_dataset,
title={Dataset for: Resolving the Optimal Selection of a Natural Reserve using the Particle Swarm Optimisation by Applying Transfer Functions},
howpublished = "[Online]. Available from: https://doi.org/10.6084/m9.figshare.6279149.v2",
url={https://figshare.com/articles/Dataset/6279149/2},
DOI={10.6084/m9.figshare.6279149.v2}, abstractNote={Provide the data set to be able to reproduce the experiment.},
publisher={figshare},
author={Almonacid, Boris},
year={2018},
month={May}}


Result Citation:
---------------
@misc{almonacid_2018_results, title={Results for: Resolving the Optimal Selection of a Natural Reserve using the Particle Swarm Optimisation by Applying Transfer Functions},
howpublished = "[Online]. Available from: https://doi.org/10.6084/m9.figshare.6279137.v2",
url={https://figshare.com/articles/Results/6279137/2}, DOI={10.6084/m9.figshare.6279137.v2},
abstractNote={It provides the results as raw data of the experiment.},
publisher={figshare},
author={Almonacid, Boris},
year={2018},
month={May}}


How to run
-----------

To be able to execute the different configurations of the experiment, one of the following configurations must be added in the run name file. Subsequently, the "Playible Run" button must be pressed.

The run file has as an example the configuration number 1, which uses the function VShaped V1.

The arguments that the .jar file supports are:
- args [0] = VShaped type (interger value):
             - 1 for V1
             - 2 for V2
             - 3 for V3
             - 4 for V4.
- args [1] = Number of iterations (integer value).
- args [2] = Path of the data file (String value).

## FOR V1 VShaped

java -jar /code/JavaSE18_OSNR_PSO_VShaped/target/PSO_OSNR-1.0-SNAPSHOT-jar-with-dependencies.jar 1 100 "../data/A1-20x100.json"
java -jar /code/JavaSE18_OSNR_PSO_VShaped/target/PSO_OSNR-1.0-SNAPSHOT-jar-with-dependencies.jar 1 100 "../data/A2-20x100.json"
java -jar /code/JavaSE18_OSNR_PSO_VShaped/target/PSO_OSNR-1.0-SNAPSHOT-jar-with-dependencies.jar 1 100 "../data/A3-20x200.json"
java -jar /code/JavaSE18_OSNR_PSO_VShaped/target/PSO_OSNR-1.0-SNAPSHOT-jar-with-dependencies.jar 1 100 "../data/A4-20x200.json"

## FOR V2 VShaped

java -jar /code/JavaSE18_OSNR_PSO_VShaped/target/PSO_OSNR-1.0-SNAPSHOT-jar-with-dependencies.jar 2 100 "../data/A1-20x100.json"
java -jar /code/JavaSE18_OSNR_PSO_VShaped/target/PSO_OSNR-1.0-SNAPSHOT-jar-with-dependencies.jar 2 100 "../data/A2-20x100.json"
java -jar /code/JavaSE18_OSNR_PSO_VShaped/target/PSO_OSNR-1.0-SNAPSHOT-jar-with-dependencies.jar 2 100 "../data/A3-20x200.json"
java -jar /code/JavaSE18_OSNR_PSO_VShaped/target/PSO_OSNR-1.0-SNAPSHOT-jar-with-dependencies.jar 2 100 "../data/A4-20x200.json"

## FOR V3 VShaped

java -jar /code/JavaSE18_OSNR_PSO_VShaped/target/PSO_OSNR-1.0-SNAPSHOT-jar-with-dependencies.jar 3 1000 "../data/A1-20x100.json"
java -jar /code/JavaSE18_OSNR_PSO_VShaped/target/PSO_OSNR-1.0-SNAPSHOT-jar-with-dependencies.jar 3 1000 "../data/A2-20x100.json"
java -jar /code/JavaSE18_OSNR_PSO_VShaped/target/PSO_OSNR-1.0-SNAPSHOT-jar-with-dependencies.jar 3 1000 "../data/A3-20x200.json"
java -jar /code/JavaSE18_OSNR_PSO_VShaped/target/PSO_OSNR-1.0-SNAPSHOT-jar-with-dependencies.jar 3 1000 "../data/A4-20x200.json"

## FOR V4 VShaped

java -jar /code/JavaSE18_OSNR_PSO_VShaped/target/PSO_OSNR-1.0-SNAPSHOT-jar-with-dependencies.jar 4 1000 "../data/A1-20x100.json"
java -jar /code/JavaSE18_OSNR_PSO_VShaped/target/PSO_OSNR-1.0-SNAPSHOT-jar-with-dependencies.jar 4 1000 "../data/A2-20x100.json"
java -jar /code/JavaSE18_OSNR_PSO_VShaped/target/PSO_OSNR-1.0-SNAPSHOT-jar-with-dependencies.jar 4 1000 "../data/A3-20x200.json"
java -jar /code/JavaSE18_OSNR_PSO_VShaped/target/PSO_OSNR-1.0-SNAPSHOT-jar-with-dependencies.jar 4 1000 "../data/A4-20x200.json"

