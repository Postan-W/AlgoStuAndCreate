import jdk.internal.cmm.SystemResourcePressureImpl;
import jdk.nashorn.tools.Shell;
import util.*;

import java.time.LocalDate;
import java.util.Arrays;

import static java.lang.System.*;
public class PublicClass implements Demo{

    public static void main(String []args){
      char [] data = {'a','b','c','d'};
      int [][] weight = {{0,1,0,1},{1,0,1,1},{0,1,0,0},{1,1,0,0}};
      Graph graph = new Graph(data,weight);
      graph.BFS(0);
    }
}

