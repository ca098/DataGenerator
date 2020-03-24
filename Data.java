package CANetworks;

public class Data {

    private int taskNumber;
    private int arrivalTime;
    private int processingTime;
    private int utilisation;


    public Data(int taskNumber, int arrivalTime, int processingTime, int utilisation) {
        this.taskNumber = taskNumber;
        this.arrivalTime = arrivalTime;
        this.processingTime = processingTime;
        this.utilisation = utilisation;

    }


    public int getTaskNumber() {return taskNumber;}

    public int getArrivalTime() {return arrivalTime;}

    public int getProcessingTime() {return processingTime;}

    public int getUtilisation() {return utilisation;}

    @Override
    public String toString()
    {
        return String.format("%d,%d,%d,%d", taskNumber, arrivalTime, processingTime, utilisation);
    }
}
