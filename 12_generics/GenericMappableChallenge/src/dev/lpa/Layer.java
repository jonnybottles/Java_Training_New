package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Layer<T extends Mappable> {
    private List<T> layerElements = new ArrayList<>();

    public Layer(List<T> layerElements) {
        this.layerElements = layerElements;
    }

    public void addElement(T element) {
        if (!layerElements.contains(element)) {
            layerElements.add(element);
        } else {
            System.out.println(element + " already exists.");
        }
    }

    public void addElements(List<T> elements) {
        for (T element : elements) {
            addElement(element);
        }
    }

    public void renderLayer() {
        for (T element : layerElements) {
            element.render();
        }
    }

}
