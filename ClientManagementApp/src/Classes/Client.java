package Classes;

public class Client {
    private int id;
    private String name;
    private String industry;
    private String contactPerson;
    private double revenue;
    private boolean isActive;

    public Client(int id,String name, String industry, String contactPerson, double revenue){
        this.id = id;
        this.name = name;
        this.industry = industry;
        this.contactPerson = contactPerson;
        this.revenue = revenue;
        this.isActive = true;
    }
    public Client(int id,String name, String industry, String contactPerson, double revenue, boolean iA){
        this.id = id;
        this.name = name;
        this.industry = industry;
        this.contactPerson = contactPerson;
        this.revenue = revenue;
        this.setActive(iA);
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean getIsActive() {
        return isActive;
    }
    public double getRevenue() {
        return revenue;
    }

    public int getId() {
        return id;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public String getIndustry() {
        return industry;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString(){
        return this.id + "," + this.name + "," + this.industry + "," + this.contactPerson +
                "," + this.revenue + "," + this.isActive;
    }
}
