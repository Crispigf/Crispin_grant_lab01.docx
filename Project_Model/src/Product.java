public class Product
{
    private String ID;
    private String Name;
    private String Description;
    private Double Cost = 0.0;

    public Product(String ID, String name, String description, Double cost) {
        this.ID = ID;
        Name = name;
        Description = description;
        Cost = cost;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public Double getCost() {
        return Cost;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setCost(Double cost) {
        Cost = cost;
    }

    public String toCSVDataRecord(){
        return ID + ", " + Name + ", " + Description + ", " + Cost;
    }
}
