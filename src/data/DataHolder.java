package data;

import structure.ProcessorGraph;

import java.io.Serializable;

/**
 * Created by Nightingale on 05.03.14.
 */
public class DataHolder implements Serializable{
    private ProcessorGraph processorGraph;

    public DataHolder() {
        processorGraph = new ProcessorGraph();
    }

    public ProcessorGraph getProcessorGraph() {
        return processorGraph;
    }

    public void reset() {
        processorGraph = new ProcessorGraph();
    }

    public void reset(DataHolder dataHolder) {
        this.processorGraph = dataHolder.processorGraph;
    }

}
