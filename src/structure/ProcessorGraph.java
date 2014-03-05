package structure;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessorGraph implements Serializable {
    private Map<String, Processor> processors;
    private Map<String, List<Link>> links;

    public ProcessorGraph() {
        processors = new HashMap<>();
        links = new HashMap<>();
    }

    public void addProcessor(Processor processor) {
        processors.put(processor.name, processor);
    }

    public void linkProcessors(Processor first, Processor second) {
        boolean simplex = first.isSimplex() || second.isSimplex();
        Link link = simplex ? new SimplexLink(first, second) : new DuplexLink(first, second);
        addLink(first, link);
        addLink(second, link);
    }

    private void addLink(Processor processor, Link link) {
        List<Link> linkList = links.get(processor.name);
        if (linkList == null)
            linkList = new ArrayList<>();
        linkList.add(link);
        links.put(processor.name, linkList);
    }

    public boolean isValid(){
        for (String name : processors.keySet())
            if (!links.containsKey(name))
                return false;
        return true;
    }

}
