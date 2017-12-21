package com.fem;

import java.util.LinkedList;
import java.util.List;

public class FEMBar {
    Double length;
    Double meshSize;
    Material material;
    public FEMBar(){
        material = new Steel();
        length = 2.2;
        meshSize = .1;
    }
    public List<FEMElement> getMesh(){
        return new LinkedList<>();
    }
}
