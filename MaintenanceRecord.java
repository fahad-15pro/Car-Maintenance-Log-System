public class MaintenanceRecord {
    private int id;
    private String ownerName;
    private String vehicleModel;
    private String serviceType;
    private String serviceDate;
    private float cost;

    public MaintenanceRecord() {}

    public MaintenanceRecord(int id, String ownerName, String vehicleModel, String serviceType, String serviceDate, float cost) {
        this.id = id;
        this.ownerName = ownerName;
        this.vehicleModel = vehicleModel;
        this.serviceType = serviceType;
        this.serviceDate = serviceDate;
        this.cost = cost;
    }

    public MaintenanceRecord(String id, String ownerName, String vehicleModel, String serviceType, String serviceDate, String cost) {
        this.id = Integer.parseInt(id);
        this.ownerName = ownerName;
        this.vehicleModel = vehicleModel;
        this.serviceType = serviceType;
        this.serviceDate = serviceDate;
        this.cost = Float.parseFloat(cost);
    }

    public MaintenanceRecord(String stringData) {
        String[] data = stringData.split(",");
        this.id = Integer.parseInt(data[0]);
        this.ownerName = data[1];
        this.vehicleModel = data[2];
        this.serviceType = data[3];
        this.serviceDate = data[4];
        this.cost = Float.parseFloat(data[5]);
    }

    public String toString() {
        String output =  id + "," + ownerName + "," + vehicleModel + "," + serviceType + "," + serviceDate + "," + cost + "\n";
        return output;
    }

    public String showInfoGUI() {
        String output = "Car ID: " + id + "\n" +
                "Owner name: " + ownerName + "\n" +
                "Car Model: " + vehicleModel + "\n" +
                "Service Type: " + serviceType + "\n" +
                "Service Date: " + serviceDate + "\n" +
                "Cost: $" + cost + "\n\n";
        return output;
    }
    public void showInfo(){

        System.out.println("Id: "+ id);
        System.out.println("Owner: "+ ownerName);
        System.out.println("Model: "+ vehicleModel);
        System.out.println("Service: "+ serviceType );
        System.out.println("Date: "+ serviceDate);
        System.out.println("Cost: $" + cost);
    }
}