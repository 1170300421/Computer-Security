package callmanagement;


public class Bill {
    private long id;
    private long client_id;
    private String name;
    private int money; 
    
    public long getId() {
        return id;
    }
    public void setId(long ID) {
        this.id =ID;
    }
    
    public long getClient_id() {
        return client_id;
    }
    public void setClient_id(long Client_id) {
        this.client_id=Client_id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String Name) {
        this.name=Name;
    }
    
    public int getMoney() {
        return money;
    }
    public void setMoney(int Money) {
        this.money=Money;
    }
}
