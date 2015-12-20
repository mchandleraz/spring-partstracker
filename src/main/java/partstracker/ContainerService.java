package partstracker;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("containerService")
public class ContainerService {

    private ArrayList<String> containers = new ArrayList<>(Arrays.asList("{id:1,label:1}", "{id:2,label:2}"));

    public List findAllContainers() {
        return containers;
    }

    public List addContainer(String label) {

        int id = containers.size() + 1;
        String json = "{label:" + label + "}";

        containers.add(json);

        return containers;
    }

    public boolean containerExists(Container container) {

        return containers.contains(container);

    }
}