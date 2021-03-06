package simpleGa;

import java.util.LinkedList;

public abstract class Individual {

    static int defaultGeneLength = 64;
    protected Object[] genes = new Object[defaultGeneLength];
    // Cache
    protected int fitness = 0;
    
    // Create a random individual
    public void generateIndividual() {
        for (int i = 0; i < size(); i++) {
            byte gene = (byte) Math.round(Math.random());
            genes[i] = gene;
        }
    }

    /* Getters and setters */
    // Use this if you want to create individuals with different gene lengths
    public static void setDefaultGeneLength(int length) {
        defaultGeneLength = length;
    }
    
    public Object getGene(int index) {
        return genes[index];
    }

    public void setGene(int index, Object value) {
        genes[index] = value;
        fitness = 0;
    }

    /* Public methods */
    public int size() {
        return genes.length;
    }

    public int getFitness() {
        if (fitness == 0) {
            fitness = FitnessCalc.getFitness(this);
        }
        return fitness;
    }

    @Override
    public String toString() {
        String geneString = "";
        for (int i = 0; i < size(); i++) {
            geneString += getGene(i) + ", ";
        }
        return geneString;
    }
}