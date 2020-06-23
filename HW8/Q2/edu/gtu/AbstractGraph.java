package edu.gtu;

import java.util.Scanner;


/** Abstract base class for graphs. A graph is a set of vertices and
 a set of edges. Vertices are represented by integers
 from 0 to n minus 1. Edges are ordered pairs of vertices.
 */
public abstract class AbstractGraph implements Graph {

    // Data Fields


    /**
     * Flag to indicate whether this is a directed graph
     */
    private boolean directed;

    // Constructor

    /**
     * Construct a graph with the specified number of vertices and the directed
     * flag. If the directed flag is true, this is a directed graph.
     * @param directed The directed flag
     */
    public AbstractGraph( boolean directed ) {
        this.directed = directed;
    }

    // Accessor Methods

    /**
     * Return whether this is a directed graph.
     * @return true if this is a directed graph
     */
    @Override
    public boolean isDirected() {
        return directed;
    }

    // Other Methods
    /** Load the edges of a graph from the data in an input file. The file
     should contain a series of lines, each line with two or
     three data values. The first is the source, the second is
     the destination, and the optional third is the weight.
     @param scan The Scanner connected to the data file
     */
    public void loadEdgesFromFile(Scanner scan) {
        throw new UnsupportedOperationException();
    }

    /** Factory method to create a graph and load the data from an input
     file. The first line of the input file should contain the number
     of vertices. The remaining lines should contain the edge data as
     described under loadEdgesFromFile.
     @param scan The Scanner connected to the data file
     @param isDirected true if this is a directed graph,
     false otherwise
     @param type The string "Matrix" if an adjacency matrix is to be
     created, and the string "List" if an adjacency list
     is to be created
     @throws IllegalArgumentException if type is neither "Matrix"
     nor "List"
     */
    public static Graph createGraph(Scanner scan, boolean isDirected,
                                    String type) {
        throw new UnsupportedOperationException();
    }

}

